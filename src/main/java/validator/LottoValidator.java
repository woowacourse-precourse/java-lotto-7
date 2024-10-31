package validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static exception.LottoException.*;

public class LottoValidator {
    public static Integer isNumber(String targetString) {
        try{
            return Integer.parseInt(targetString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

    public static Integer isDivisibleByThousand(Integer targetInteger) {
        if (targetInteger % 1000 != 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_BY_1000.getMessage());
        }
        return targetInteger;
    }

    public static Integer isInLottoRange(Integer targetInteger) {
        if (targetInteger >= 1 && targetInteger <= 45) {
            return targetInteger;
        }
        throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
    }

    public static List<Integer> isParseableString(String targetString) {
        return Arrays.stream(targetString.split(","))
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .map(LottoValidator::isNumber)
                .map(LottoValidator::isInLottoRange)
                .collect(Collectors.toList());
    }

    public static List<Integer> hasSixElements(List<Integer> targetList) {
        if (targetList.size() == 6) {
            return targetList;
        }
        throw new IllegalArgumentException(LENGTH_IS_NOT_SIX.getMessage());
    }

}
