package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.OutputMessage;
import lotto.dto.LottoNumbers;
import lotto.model.Prize;

public class OutputView {
    public void displayPurchasePriceRequest() {
        System.out.println(OutputMessage.PURCHASE_PRICE_REQUEST);
    }

    public void displayPurchaseQuantity(final int quantity) {
        System.out.printf(OutputMessage.PURCHASE_QUANTITY_FORMAT, quantity);
    }

    public void displayLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        System.out.println(OutputMessage.LINE_SEPARATOR + buildLottoNumbers(lottoNumbers));
    }

    private String buildLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumbers::numbers)
                .map(this::getSortedList)
                .collect(Collectors.joining(OutputMessage.LINE_SEPARATOR));
    }

    private String getSortedList(final List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }

    public void displayMainNumbersRequest() {
        System.out.println(OutputMessage.MAIN_NUMBERS_REQUEST);
    }

    public void displayBonusNumberRequest() {
        System.out.println(OutputMessage.BONUS_NUMBER_REQUEST);
    }

    public void displayWinningResult(final Map<Prize, Integer> result, final double rateOfReturn) {
        String output = OutputMessage.WINNING_RESULT_PREFIX + buildWinningStat(result) + formatRateOfReturn(rateOfReturn);
        System.out.println(output);
    }

    private String buildWinningStat(final Map<Prize, Integer> result) {
        return result.entrySet().stream()
                .map(entry -> String.format(entry.getKey().getResultMessage(), entry.getValue()))
                .collect(Collectors.joining(OutputMessage.LINE_SEPARATOR));
    }

    private String formatRateOfReturn(final double rateOfReturn) {
        return String.format(OutputMessage.RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    public void displayErrorMessage(final String message) {
        System.err.println(message);
    }
}
