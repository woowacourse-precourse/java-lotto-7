package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkInputValidity(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    // 입력 유효성 검사
    private void checkInputValidity(List<Integer> numbers) {
        validate(numbers);
        duplicateLottoNumbers(numbers);
        checkLottoNumbersRange(numbers);
    }

    private void duplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> duplicates = new HashSet<>(numbers);

        if (numbers.size() != duplicates.size()){
            ExceptionMessage.duplicateLottoNumberException();
            throw new IllegalArgumentException();
        }
    }

    private void checkLottoNumbersRange(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                ExceptionMessage.outOfRangeException();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumbers(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            ExceptionMessage.bonusNumberException();
            throw new IllegalArgumentException();
        }
        if(bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            ExceptionMessage.outOfRangeException();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
