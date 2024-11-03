package lotto.validator;

import java.util.Collections;
import java.util.List;

public class LottoNumberValidator {
    private static final Integer MIN = 1;
    private static final Integer MAX = 45;
    private LottoNumberValidator() {
    }

    public static void validateIntegers(List<String> tokens) {
        for (String token : tokens) {
            validateInteger(token);
        }
    }

    public static void validateInteger(String token) {
        try {
            Integer.parseInt(token);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수 형태의 번호가 아닙니다.");
        }
    }

    public static void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 번호가 아닙니다.");
        }
    }

    public static void validateDuplicatedBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}