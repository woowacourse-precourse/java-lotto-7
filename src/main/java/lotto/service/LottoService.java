package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Prize;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import lotto.util.NumberValidator;

public class LottoService {
    private static final String WINNING_NUMBERS_SEPARATOR = ",";

    public LottoTickets generateLottoTickets(final PurchasePrice purchasePrice) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int quantity = purchasePrice.calculateQuantity();
        for (int count = 0; count < quantity; count++) {
            lottoTickets.add(Lotto.generateRandomly());
        }

        return new LottoTickets(lottoTickets);
    }

    public Lotto createMainNumbers(final String mainNumbersInput) {
        List<Integer> mainNumbers = parseNumbers(mainNumbersInput);
        return new Lotto(mainNumbers);
    }

    private List<Integer> parseNumbers(final String input) {
        List<String> numbers = List.of(input.split(WINNING_NUMBERS_SEPARATOR));
        numbers.forEach(this::validateNumber);
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumber(final String input) {
        NumberValidator.validateNumberFormat(input);
        NumberValidator.validateIntegerRange(input);
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
