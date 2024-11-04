package lotto.service;

import lotto.Exception.ExceptionType;
import lotto.model.Lotto;
import lotto.utils.LottoRules;
import lotto.utils.LottoRules.Winning;

import java.util.*;

import static lotto.utils.LottoRules.*;
import static lotto.utils.LottoRules.determineWinningRank;

public class LottoService {
    private static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스번호는 당첨번호 6개와 중복될 수 없습니다.";

    public Lotto generateLotto() {
        return new Lotto(LottoRules.pickRandomNumbers());
    }

    public List<Lotto> purchaseLottoTickets(int price) {
        List<Lotto> lottoTickets = new ArrayList<>();

        int ticketCount = price / LOTTO_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(generateLotto());
        }

        return lottoTickets;
    }

    public List<List<Integer>> convertLottoTicketsToNumbers(List<Lotto> myLottoTickets) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (Lotto lotto : myLottoTickets) {
            allLottoNumbers.add(lotto.getLottoNumbers());
        }
        return allLottoNumbers;
    }

    public void checkBonusNumberDuplication(Set<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionType.PREFIX_ERROR_MESSAGE + BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public Map<Winning, Integer> calculateWinningStatistics(
            List<Lotto> myLottoTickets,
            Set<Integer> winningNumbers,
            Integer bonusNumber
    ) {
        Map<Winning, Integer> winningRankCount = initWinningRankCount();

        for (Lotto lotto : myLottoTickets) {
            Winning rank = getRank(lotto, winningNumbers, bonusNumber);
            winningRankCount.put(rank, winningRankCount.get(rank) + 1);
        }
        return winningRankCount;
    }

    private Map<Winning, Integer> initWinningRankCount() {
        Map<Winning, Integer> winningRankCount = new HashMap<>();

        for (Winning winning : Winning.values()) {
            winningRankCount.put(winning, 0);
        }

        return winningRankCount;
    }

    private Winning getRank(Lotto lotto, Set<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        int matchNumberCount = countMatchNumbers(lottoNumbers, winningNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);

        return determineWinningRank(matchNumberCount, bonusMatch);
    }

    private int countMatchNumbers(List<Integer> numbers, Set<Integer> targetNumbers) {
        return (int) numbers.stream().filter(targetNumbers::contains).count();
    }


    public Double calculateYieldRate(int purchasePrice, Map<Winning, Integer> winningRankCount) {
        int yield = calculateTotalWinningMoney(winningRankCount);

        double yieldRate = (double) yield / (double) purchasePrice * 100;
        return Math.round(yieldRate * 100) / 100.0;
    }

    private int calculateTotalWinningMoney(Map<Winning, Integer> winningRankCount) {
        int output = 0;
        for (Map.Entry<Winning, Integer> entry : winningRankCount.entrySet()) {
            Winning winning = entry.getKey();
            int count = entry.getValue();
            output += winning.getMoney() * count;
        }
        return output;
    }
}
