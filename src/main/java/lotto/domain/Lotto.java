package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorConstants;

import java.util.Collection;
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

    public static Lotto lottoNumberGenerator(){
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_LOTTO_COUNT.getMessage());
        }

        if(numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NOT_ALLOWED.getMessage());
        }
    }
}
