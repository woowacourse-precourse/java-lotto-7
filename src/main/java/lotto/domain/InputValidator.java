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


}
