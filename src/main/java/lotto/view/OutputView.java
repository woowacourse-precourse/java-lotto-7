package lotto.view;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String SUCCESS_LOTTO_PURCHASE_MESSAGE = NEW_LINE + "%d개를 구매했습니다.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(int lottoCount) {
        System.out.printf(SUCCESS_LOTTO_PURCHASE_MESSAGE, lottoCount);
    }
}
