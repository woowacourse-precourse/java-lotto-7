package lotto.view;

public class OutputView {
    private static final String LINE_BREAK = "\n";
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다." + LINE_BREAK;
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE_FORMAT, lottoCount);
    }

    public void printLottoInformation(String lottoInformation) {
        System.out.print(lottoInformation);
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
    }
}
