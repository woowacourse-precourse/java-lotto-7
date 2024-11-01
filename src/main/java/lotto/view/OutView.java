package lotto.view;

import java.util.List;

public class OutView {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNIG_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + " : " + errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println();
        System.out.println(WINNIG_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
}
