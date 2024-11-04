/*
 * 클래스 이름 OutputView
 *
 * 버전 정보 V1
 *
 * 날짜 10월 30일
 *
 * 저작권 주의
 */
package lotto.view;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.domain.Rank;

public class OutputView {
    public void printReadPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottoState(String lottosState) {
        System.out.println(lottosState);
    }

    public void printReadWinningNumber() {
        System.out.println(Message.WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printReadBonusNumber() {
        System.out.println();
        System.out.println(Message.BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printWinningResult(int[] winningResult) {
        System.out.println();
        System.out.println(Message.WINNING_STATISTICS_MESSAGE);
        System.out.println(Message.DIVIDER_MESSAGE);
        printWinningStatistics(winningResult);
    }

    private void printWinningStatistics(int[] winningResult) {
        System.out.println(Message.FIFTH_MESSAGE + winningResult[Rank.FIFTH.getRank()- Constant.POSITION_CORRELATION] + Message.COUNT_UNIT_MESSAGE);
        System.out.println(Message.FOURTH_MESSAGE + winningResult[Rank.FOURTH.getRank()-Constant.POSITION_CORRELATION] + Message.COUNT_UNIT_MESSAGE);
        System.out.println(Message.THIRD_MESSAGE + winningResult[Rank.THIRD.getRank()-Constant.POSITION_CORRELATION] + Message.COUNT_UNIT_MESSAGE);
        System.out.println(Message.SECOND_MESSAGE + winningResult[Rank.SECOND.getRank()-Constant.POSITION_CORRELATION] + Message.COUNT_UNIT_MESSAGE);
        System.out.println(Message.FIRST_MESSAGE + winningResult[Rank.FIRST.getRank()-Constant.POSITION_CORRELATION] + Message.COUNT_UNIT_MESSAGE);
    }

    public void printRateOfReturn(double rateOfReturn) {
        String format = String.format("%.1f", rateOfReturn);
        System.out.println(Message.RATE_OF_RETURN_START_MESSAGE + format + Message.RATE_OF_RETURN_END_MESSAGE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + Message.PURCHASE_RESULT_MESSAGE);
    }
}
