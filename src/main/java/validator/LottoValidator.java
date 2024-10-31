package validator;

public class LottoValidator {
    public static Integer isNumber(String targetString) {
        try{
            return Integer.parseInt(targetString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static Integer isDivisibleByThousand(Integer targetInteger) {
        if (targetInteger % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지지 않습니다.");
        }
        return targetInteger;
    }
}
