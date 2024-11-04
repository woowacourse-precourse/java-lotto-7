package lotto.validator;

import java.util.HashSet;
import java.util.List;

public class LottoNumbersValidator {
    public static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        checkForDuplicates(numbers);
        checkNumberRange(numbers);
    }
    // 로또번호 갯수가 6개인지 검증하는 메서드
    private static void validateNumberCount(List<Integer> numbers) {
        if(numbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // 로또번호 중복이 있는지 검증하는 메서드
    private static void checkForDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    // 로또번호가 1과 45 사이인지 검증하는 메서드
    private static void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
