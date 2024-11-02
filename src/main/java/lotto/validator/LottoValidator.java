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

    /*// 숫자 형식 검증 (List<Integer>를 받아 체크)
    public static void validateNumberIsNumeric(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) { // null 체크
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
    }*/

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


    /*// 보너스 번호 검증 (WinningNumbers에만 적용)
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
        }
    }*/

    /*// 1부터 45 사이의 숫자인지 검증
    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 당첨 번호와 중복되지 않는지 검증
    public static void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    // 숫자 형식인지 검증 (InputView에서 수행 가능)
    public static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }*/

    // 로또 구입 금액 유효성 검증
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    /*// 보너스 번호 유효성 검증
    public static void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }*/
}

