package lotto;

public class LottoGameValidator {

    /**
     * 숫자로 구성된 문자열인지 확인
     *
     * @throws IllegalArgumentException 숫자가 아닌 문자가 문자열에 포함되어 있을 때
     */
    public static boolean checkIsNumeric(String str) {
        if (!Validator.isNumeric(str)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
        }

        return true;
    }
}
