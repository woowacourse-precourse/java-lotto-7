package lotto.domain;

import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.VALID_LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.validator.LottoValidator;

public class PublishLotto {

    private final List<Integer> numbers;

    private PublishLotto(final LottoValidator validator) {
        numbers = new ArrayList<>(getRandomNumbers());
        sortNumbers();
        validate(numbers, validator);
    }

    public PublishLotto(final List<Integer> numbers, final LottoValidator validator) {
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
        validator.validate(this.numbers);
    }

    public static PublishLotto from(final LottoValidator validator) {
        return new PublishLotto(validator);
    }

    private void validate(final List<Integer> numbers, final LottoValidator validator) {
        validator.validate(numbers);
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
            VALID_LOTTO_NUMBER_COUNT);
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getPublishLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishLotto)) {
            return false;
        }
        PublishLotto other = (PublishLotto) obj;
        return this.numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
