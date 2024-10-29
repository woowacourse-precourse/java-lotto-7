package lotto.view;

public class LottoView {
    private static final String INSERT_PAY = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY = "개를 구매했습니다.";
    private static final String INSERT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void getInsertPay() {
        System.out.println(INSERT_PAY);
    }

    public void getHowManyBuy() {
        System.out.println(HOW_MANY_BUY);
    }

    public void getInsertWinningNumber() {
        System.out.println(INSERT_WINNING_NUMBER);
    }

    public void getInsertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
    }
}
