package lotto.domain;

import lotto.staticenum.ErrorStatic;

import java.util.HashSet;
import java.util.List;

/**
 * 로또 클래스
 * 로또 번호 검증
 * 로또 번호 출력
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public void showLottoNumbers() {
        System.out.println(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatic.LOTTO_NUMBER_SIZE_ERROR);
        }
        var set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(ErrorStatic.LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }


}
