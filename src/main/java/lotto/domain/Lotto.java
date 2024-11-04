package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        List<Integer> duplicatedNumbers = numbers.stream()
                .filter(o -> Collections.frequency(numbers, o) > 1)
                .toList();

        if (!duplicatedNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현

    // LottoWinningNumbers와 비교하는 메서드 (일치하는 숫자의 개수를 리턴)
    public long compareResult(LottoWinningNumbers winningNumbers) {
        long countSameNumbers = numbers.stream()
                .filter(o -> winningNumbers.getWinningNumbers().stream()
                        .anyMatch(Predicate.isEqual(o)))
                .count();

        if (countSameNumbers == 6) {
            countSameNumbers++;
        }

        // 5개의 번호가 일치하는 경우, 보너스 번호 일치 여부 확인
        if (countSameNumbers == 5) {
            Optional<Integer> filterResult = numbers.stream()
                    .filter(o -> winningNumbers.getBonusNumber() == o)
                    .findAny();

            if (filterResult.isPresent()) {
                countSameNumbers++;
            }
        }
        return countSameNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // toString 메서드 재정의
    public String toString() {
        String collected = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "[" + collected + "]";
    }
}
