package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    private static final String INSERT_PAY = "구입금액을 입력해 주세요.";
    private static final String NOTICE_BUY_AMOUNT_START = "개를 구매했습니다. (잔돈 : ";
    private static final String NOTICE_BUY_AMOUNT_END = "원)";
    private static final String INSERT_MANUAL_AMOUNT_START = "수동 번호로 구매할 갯수를 입력해주세요. (최대 ";
    private static final String INSERT_MANUAL_AMOUNT_END = "개 입력 가능)";
    private static final String INSERT_MANUAL_NUMBERS_START = """
            수동으로 구매할 1~45 사이의 겹치지 않는 6개의 번호를 쉼표로 구분해 입력해주세요. (수동 구매 갯수가 [ 
            """;
    private static final String INSERT_MANUAL_NUMBERS_END = " ]개 남았습니다. Enter를 누르면 자동으로 번호를 입력합니다.)";
    private static final String TOTAL_BUY_AMOUNT = "[구입 번호 목록]";
    private static final String INSERT_WINNING_NUMBER = """
            6개의 당첨 번호를 입력해 주세요. (1~45 사이의 겹치지 않는 6개의 숫자를 쉼표로 구분해 입력, Enter를 누르면 자동으로 번호를 입력합니다.)
            """;
    private static final String INSERT_BONUS_NUMBER = """
            보너스 번호를 입력해 주세요. (입력된 당첨번호를 제외한 1개의 번호를 입력해주세요. Enter를 누르면 자동으로 번호를 입력합니다.)
            """;
    private static final String WINNER_NUMBERS = "[당첨 번호] : ";
    private static final String BONUS_NUMBER = "[보너스 번호] : ";

    public void printInsertPay() {
        System.out.println(INSERT_PAY);
    }

    public void printNoticeBuyAmount(int amount, int change) {
        System.out.println(amount + NOTICE_BUY_AMOUNT_START + change + NOTICE_BUY_AMOUNT_END);
    }

    public void printInsertWinningNumber() {
        System.out.println(INSERT_WINNING_NUMBER);
    }

    public void printInsertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
    }

    public void printInsertManualAmount(int amount) {
        System.out.println(INSERT_MANUAL_AMOUNT_START + amount + INSERT_MANUAL_AMOUNT_END);
    }

    private LottoView() {

    }

    public static LottoView createLottoView() {
        return new LottoView();
    }
}
