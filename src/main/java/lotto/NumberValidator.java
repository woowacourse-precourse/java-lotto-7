package lotto;

public class NumberValidator {
    public static void validatePrice(String inputSequence) {
        validateNumber(inputSequence);

        int lottoPrice = Integer.parseInt(inputSequence);
        if (lottoPrice <= 0 || lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 양수를 입력해 주세요.");
        }
    }
    private static void validateNumber(String inputSequence) {
        try {
            Integer.parseInt(inputSequence);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }



}
