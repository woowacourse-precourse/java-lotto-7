package lotto.model;

import static lotto.validation.LottoNumberValidator.validateLottoNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> lottoGenerator() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
