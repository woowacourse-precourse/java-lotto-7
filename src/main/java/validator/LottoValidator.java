package validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Integer isInLottoRange(Integer targetInteger) {
        if (targetInteger >= 1 && targetInteger <= 45) {
            return targetInteger;
        }
        throw new IllegalArgumentException("로또 번호 범위를 벗어났습니다.");
    }

}
