package lotto.component;

import lotto.constant.LottoConstants;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(int number: numbers){
            if(number < LottoConstants.MIN_RANGE_NUMBER || number > LottoConstants.MAX_RANGE_NUMBER ){
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        HashSet<Integer> duplicate = new HashSet<>(numbers);
        if(duplicate.size() != LottoConstants.LOTTO_NUMBERS_COUNT){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 할 수 없습니다");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

}
