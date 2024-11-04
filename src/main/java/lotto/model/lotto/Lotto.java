package lotto.model.lotto;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConst;
import lotto.error.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateOverLap(numbers);
        validateNumberCountNotSix(numbers);
        this.numbers = numbers;
    }

    private void validateOverLap(List<Integer> lottoNumbers) {
        boolean[] overlap = new boolean[46];

        //중복 테스트

        for (int lottoNum : lottoNumbers) {
            if (overlap[lottoNum]) {
                throw new IllegalArgumentException(ErrorMessage.OVERLAPLOTTONUMBER.getMessage());
            } else {
                overlap[lottoNum] = true;
            }
        }

        return;
    }

    private void validateNumberCountNotSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTONUMBERCOUNTNOTSIX.getMessage());
        }
    }

    protected void numbersSort() {
        numbers.stream().sorted();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
