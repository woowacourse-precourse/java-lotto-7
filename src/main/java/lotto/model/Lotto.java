package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.LottoExceptionStatus.*;
import static lotto.properties.LottoProperties.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isGeneratedSixNumbers(numbers);
        isDuplicate(numbers);
        isOutOfRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void isOutOfRange(List<Integer> winningLottery){
        winningLottery.forEach(number -> {
            if(number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END)
                throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        });
    }

    private void isGeneratedSixNumbers(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException(INVALID_GENERATED_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if(checkDuplicate.size() != 6){
            throw new IllegalArgumentException(INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public static Lotto generate(){
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START,
                LOTTO_NUMBER_END,
                LOTTO_NUMBER_QUANTITY
        );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
