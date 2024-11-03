package lotto.view;

public class LottoView {
    private static final String INSERT_PAY = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY = "개를 구매했습니다.";
    private static final String INSERT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INSERT_MANUAL_AMOUNT_START = "수동번호로 구매할 갯수를 입력해주세요. (최대 ";
    private static final String INSERT_MANUAL_AMOUNT_END = "개 입력 가능)";

    public void printInsertPay() {
        System.out.println(INSERT_PAY);
    }

    public void printHowManyBuy() {
        System.out.println(HOW_MANY_BUY);
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
