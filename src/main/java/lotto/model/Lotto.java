package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoExceptionStatus;
import lotto.properties.LottoProperties;

import java.util.Collections;
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
        if (isGeneratedSixNumbers(numbers) || isDuplicate(numbers)) {
            throw new IllegalArgumentException(
                    LottoExceptionStatus.INVALID_GENERATED_LOTTO_NUMBERS_SIZE.getMessage()
            );
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isGeneratedSixNumbers(List<Integer> numbers){
        return numbers.size() != 6;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        return checkDuplicate.size() != 6;
    }

    public static Lotto generate(){
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(
                LottoProperties.LOTTO_NUMBER_START,
                LottoProperties.LOTTO_NUMBER_END,
                LottoProperties.LOTTO_NUMBER_QUANTITY
        );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
