package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); // 수정 가능한 리스트로 복사
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        checkNumberRange(numbers);
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }




}
