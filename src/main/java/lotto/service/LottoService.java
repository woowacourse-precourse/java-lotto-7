package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.Prize;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import lotto.model.WinningNumbers;

public class LottoService {
    public LottoTickets generateLottoTickets(final PurchasePrice purchasePrice) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int quantity = purchasePrice.calculateQuantity();
        for (int count = 0; count < quantity; count++) {
            lottoTickets.add(Lotto.generateRandomly());
        }

        return new LottoTickets(lottoTickets);
    }

    public WinningNumbers createWinningNumbers(final String numbersInput, final int bonusNumber) {
        List<Integer> numbers = parseNumbers(numbersInput);
        Lotto winningNumbers = new Lotto(numbers);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> parseNumbers(final String input) {
        List<String> numbers = List.of(input.split(","));
        // validateNumberFormat
        // validateIntegerRange
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public double calculateRateOfReturn(final Map<Prize, Integer> result, final PurchasePrice purchasePrice) {
        int totalPrizeMoney = calculateTotalPrizeMoney(result);
        return ((double) totalPrizeMoney / purchasePrice.value()) * 100;
    }

    private int calculateTotalPrizeMoney(final Map<Prize, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }
}
