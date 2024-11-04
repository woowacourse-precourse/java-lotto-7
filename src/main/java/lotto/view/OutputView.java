package lotto.view;

public class OutputView {
    private static final String INPUT_CASH_MESSAGE = "구입금액을 입력해주세요.";
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public OutputView() {
    }

    public void printInputCashMessage() {
        System.out.println(INPUT_CASH_MESSAGE);
    }

    public void printLottoAmount(Integer lottoAmount) {
        System.out.println(lottoAmount + LOTTO_AMOUNT_MESSAGE);
    }
}
