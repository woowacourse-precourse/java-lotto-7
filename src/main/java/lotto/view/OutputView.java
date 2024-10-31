package lotto.view;

public class OutputView {
    private static final String QUESTION_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_AMOUNT = "개를 구매했습니다.";

    public void printInputMoney() {
        System.out.println(QUESTION_LOTTO_AMOUNT);
    }

    public void printLottoAmount(int count) {
        System.out.println("\n" + count + PRINT_LOTTO_AMOUNT);
    }
}
