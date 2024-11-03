package lotto.validator;

import java.util.Collections;
import java.util.List;

public class LottoNumberValidator {
    private static final Integer MIN = 1;
    private static final Integer MAX = 45;
    private LottoNumberValidator() {
    }

//    public static void validateNumberCount(List<String> tokens) {
//        if (tokens.size() != 6) {
//            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
//        }
//    }

//    public static void validateDuplicatedNumber(List<Integer> numbers) {
//        boolean hasDuplicates = numbers.stream()
//                .anyMatch(number -> Collections.frequency(numbers, number) > 1);
//
//        if (hasDuplicates) {
//            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 존재합니다.");
//        }
//    }

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

//    public static void validateRanges(List<Integer> numbers) {
//        for (Integer number : numbers) {
//            validateNumberRange(number);
//        }
//    }

    public static void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 번호가 아닙니다.");
        }
    }
}