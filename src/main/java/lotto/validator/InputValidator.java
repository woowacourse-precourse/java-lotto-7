package lotto.validator;

public class InputValidator {

    /*
    TODO 입력값을 검증한다
    1. String input을 int로 변환 시도(숫자가 아니면 안됨)
    2. int 중 1000 단위로 나눠떨어지는 지 확인(금액은 1000원 단위로 입력해야 함)

    * */
    public void validateInputAmount(String input) {
        // null 이나 0을 입력하면?
        validateNullAndEmptyValue(input);
        // 숫자만 입력받기
        validateOnlyNumber(input);
        // 1000 단위로 나눠떨어지나? 체크
        validateIsDivisibleByThousand(input);
    }

    private void validateOnlyNumber(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validateNullAndEmptyValue(String input) {
        if (input == null || input.isEmpty() || input.equals("0")) {
            throw new IllegalArgumentException("빈 값 혹은 0은 입력할 수 없습니다.");
        }
    }

    private void validateIsDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number <= 0 || number % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나눠지는 값만 입력할 수 있습니다.");
        }
    }
}
