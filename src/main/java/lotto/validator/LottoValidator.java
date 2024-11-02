package lotto.validator;

import java.util.List;

public class LottoValidator {

    // 로또 번호 개수 검증
    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 범위 검증
    public static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 로또 번호 중복 검증
    public static void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    /*// 숫자 형식인지 검증.....................안해.
    public static void validateNumberIsNumeric(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) { // null 값 검증
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
            // 숫자 형식이 맞는지 검증을 위해 toString()을 호출하고 parseInt로 변환
            try {
                Integer.parseInt(String.valueOf(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
    }*/

    // 로또 구입 금액 유효성 검증
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}

