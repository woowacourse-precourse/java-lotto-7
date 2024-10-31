package validator;

public class LottoValidator {
    public static Integer isNumber(String targetString) {
        try{
            return Integer.parseInt(targetString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
