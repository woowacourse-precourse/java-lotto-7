package lotto.model;

import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRangeAndUniqueness(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.PICK_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.",
                    LottoConstants.PICK_COUNT));
        }
    }

    // TODO: 추가 기능 구현
    public void validateRangeAndUniqueness(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
                throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
                        LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER));
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(String.format("[ERROR] 중복된 로또 번호(%d)를 입력하였습니다.", number));
            }
        }
    }

    public void validateAddedNumber(int number) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.add(number);
        validateRangeAndUniqueness(copiedNumbers);
    }
}
