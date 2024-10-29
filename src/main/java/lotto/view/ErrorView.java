package lotto.view;

public class ErrorView {
    private static final String ERROR_UNIT = "[ERROR] ";
    private static final String NUMBER_RANGE_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_ERROR = "로또 번호로 입력한 번호는 보너스 번호로 등록할 수 없습니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "중복된 번호가 있습니다.";
    private static final String WINNING_NUMBER_ERROR = "쉼표로 구분된 6개의 숫자만 입력할 수 있습니다.";

    public void getNumberRangeError() {
        System.out.println(ERROR_UNIT + NUMBER_RANGE_ERROR);
    }

    public void getBonusNumberError() {
        System.out.println(ERROR_UNIT + BONUS_NUMBER_ERROR);
    }

    public void getDuplicatedNumberError() {
        System.out.println(ERROR_UNIT + DUPLICATED_NUMBER_ERROR);
    }

    public void getWinningNumberError() {
        System.out.println(ERROR_UNIT + WINNING_NUMBER_ERROR);
    }
}
