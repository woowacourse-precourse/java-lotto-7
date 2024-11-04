package lotto.domain;

import static lotto.constant.LottoErrorConstant.ERROR_LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoErrorConstant.ERROR_LOTTO_NUMBER_NO_DUPLICATES;
import static lotto.constant.LottoErrorConstant.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.constant.LottoValueConstant.MAX_NUMBER_LOTTO;
import static lotto.constant.LottoValueConstant.MIN_NUMBER_LOTTO;
import static lotto.constant.LottoValueConstant.NUMBER_OF_LOTTO;

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
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_COUNT);
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
        if (hasDuplicatesEachNumber(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_NO_DUPLICATES);
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= MIN_NUMBER_LOTTO && num <= MAX_NUMBER_LOTTO);
    }

    private boolean hasDuplicatesEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public boolean hasDuplicatedBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public Integer matching(List<Integer> userLotto) {
        Set<Integer> numbers = new HashSet<>(this.numbers);
        Set<Integer> userNumbers = new HashSet<>(userLotto);
        numbers.retainAll(userNumbers);
        int matchCount = numbers.size();
        return matchCount;
    }
}
