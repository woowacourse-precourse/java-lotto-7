package lotto.domain;

public class InputValidator {

    /**
     * 문자열을 정수형 숫자로 변환
     */
    public static int convertInteger(String input) {
        try {
            int convertedNumber = Integer.parseInt(input);
            return convertedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.");
        }
    }

    /**
     * 구입 금액이 1000원 단위인지 검사
     */
    public static void isValidUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력하셔야 합니다.");
        }
    }
}
