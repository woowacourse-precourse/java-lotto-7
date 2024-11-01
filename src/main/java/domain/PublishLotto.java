package domain;

import static constant.LottoConstant.MAX_LOTTO_NUMBER;
import static constant.LottoConstant.MIN_LOTTO_NUMBER;
import static constant.LottoConstant.VALID_LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.validator.LottoValidator;

public class PublishLotto {

    private final List<Integer> numbers;

    private PublishLotto(LottoValidator validator) {
        numbers = getRandomNumbers();
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

    public List<Integer> getPublishLottoNumbers() {
        return numbers;
    }
}
