package lotto.view;

import static lotto.utils.Constants.*;

import java.util.List;

public class OutputView {
    public void printBuyResult(int count) {
        System.out.printf(OUTPUT_BUYING_COUNT_MESSAGE, count);
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottoTicket(List<Integer> numbers) {
        System.out.println(convertTicketToFormat(numbers));
    }

    public void printWinningResultHeader() {
        System.out.printf(OUTPUT_RESULT_PRIZE_STATISTICS);
    }

    public void printWinningResult(int matchCount, boolean isBonusNumberMatch, int prizeMoney, int count) {
        System.out.printf(OUTPUT_RESULT_MATCH_MESSAGE, matchCount, checkBonusBallMatch(isBonusNumberMatch), prizeMoney, count);
    }

    private String checkBonusBallMatch(boolean isBonusNumberMatch) {
        String bonusMatchMessage = "";

        if (isBonusNumberMatch) {
            bonusMatchMessage = OUTPUT_RESULT_BONUS_MATCH_MESSAGE;
        }

        return bonusMatchMessage;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(OUTPUT_RESULT_ROR_MESSAGE, rateOfReturn);
    }

    private String convertTicketToFormat(List<Integer> numbers) {
        return "[" + convertNumbersToString(numbers) + "]";
    }

    private String convertNumbersToString(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        numbers.forEach(number -> result.append(number).append(", "));

        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
