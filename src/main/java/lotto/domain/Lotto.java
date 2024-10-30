package lotto.domain;

import lotto.domain.generator.RandomNumber;
import lotto.domain.generator.RandomNumbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (isDuplicateNumber(numbers, numberSet)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers, HashSet<Integer> numberSet) {
        return numberSet.size() != numbers.size();
    }

    public void checkWinning(HashMap<Integer, Integer> winningCount, RandomNumbers randomNumbers) {
        List<RandomNumber> totalRandomNumberList = randomNumbers.randomNumbers();

        for (RandomNumber randomNumberList : totalRandomNumberList) {
            List<Integer> randomNumber = randomNumberList.randomNumber();
            int count = calculateMatchCount(randomNumber);
            winningCount.put(count, winningCount.getOrDefault(count, 0) + 1);
        }
    }

    private int calculateMatchCount(List<Integer> randomNumber) {
        return Math.toIntExact(
                randomNumber.stream()
                .filter(numbers::contains)
                .count()
        );
    }

    // TODO: 추가 기능 구현
}
