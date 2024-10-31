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

import lotto.constant.Message;

public class OutputView {
    public void printReadPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottoPurchaseResult(int numberOfLotto) {
        System.out.println();
        System.out.println(numberOfLotto + Message.PURCHASE_RESULT_MESSAGE);
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
}
