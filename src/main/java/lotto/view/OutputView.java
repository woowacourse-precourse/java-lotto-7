package lotto.view;

public class OutputView {
    private static final String QUESTION_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public void printInputMoney() {
        System.out.println(QUESTION_LOTTO_AMOUNT);
    }

    public void printLottoAmount(int count) {
        System.out.println();
        System.out.println(count + PRINT_LOTTO_AMOUNT);
    }

    public void printWinningNumbers() {
        System.out.println();
        System.out.println(QUESTION_WINNING_NUMBERS);
    }
}
