package lotto;

import constant.ErrorMessage;
import constant.LottoNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        checkDuplicationNumber(numbers);
        checkLottoNumberScope(numbers);
    }

    // TODO: 추가 기능 구현
    public void show() {
        System.out.println(numbers.toString());
    }

    public void checkDuplicationNumber(List<Integer> numbers) {
        Set<Integer> lottoNumber = new HashSet<>(numbers);
        if (lottoNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_NUMBER.show());
        }
    }

    public void checkLottoNumberScope(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > LottoNumber.LOTTO_NUMBER_MAX.getLottoNumber()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_FIT_LOTTO_NUMBER_SCOPE.show());
            }
            if (number < LottoNumber.LOTTO_NUMBER_MIN.getLottoNumber()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_FIT_LOTTO_NUMBER_SCOPE.show());
            }
        }
    }
}
