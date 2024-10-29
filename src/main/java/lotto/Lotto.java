package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            //[ERROR]를 상수 문자열로 만들어서 바꿀 것
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        validateDuplicate(numbers);

    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
