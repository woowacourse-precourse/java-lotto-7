package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorConstants;
import static lotto.constant.UtilConstants.LOTTO_NUMBER_COUNT;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_LOTTO_COUNT.getMessage());
        }

        if(numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NOT_ALLOWED.getMessage());
        }
    }
}
