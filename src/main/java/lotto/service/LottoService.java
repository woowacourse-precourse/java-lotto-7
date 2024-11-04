package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.ResultPrinter;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public void playLotto(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        validateAmount(purchaseAmount);
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);

        List<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        ResultPrinter.printLottoTickets(lottoTickets);

        Map<Rank, Integer> result = calculateResults(lottoTickets, winningNumbers, bonusNumber);
        ResultPrinter.printResults(result);

        int totalPrize = calculateTotalPrize(result);
        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        ResultPrinter.printProfitRate(profitRate);
    }

    private List<Lotto> generateLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(Lotto.generate());
        }
        return lottoTickets;
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        for (Lotto ticket : lottoTickets) {
            int matchCount = ticket.getMatchCount(winningNumbers);
            boolean matchBonus = ticket.containsBonus(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);

            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        return resultMap;
    }

    int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }

    // 금액 검증
    public void validateAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] The purchase amount should be a positive multiple of 1,000.");
        }
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("There must be exactly 6 winning numbers.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("Winning numbers must be unique.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("Winning numbers must be between 1 and 45.");
            }
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("The bonus number must be between 1 and 45.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("The bonus number must not be one of the winning numbers.");
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
