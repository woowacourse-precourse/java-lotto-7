package lotto.domain;

import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.VALID_LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class PublishLotto {

    private final List<Integer> numbers;

    private PublishLotto(LottoValidator validator) {
        numbers = getRandomNumbers();
        sortNumbers();
        validate(numbers, validator);
    }

    public static PublishLotto from(LottoValidator validator) {
        return new PublishLotto(validator);
    }

    private void validate(List<Integer> numbers, LottoValidator validator) {
        validator.validate(numbers);
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, VALID_LOTTO_NUMBER_COUNT);
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getPublishLottoNumbers() {
        return numbers;
    }
}
