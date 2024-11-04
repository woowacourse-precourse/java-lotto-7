package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Messages.ErrorMessage;
import lotto.Utils.LottoConstants;
import lotto.Utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicateNumbers(numbers);
        checkNumberRange(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto create() {
        List<Integer> numbers = generateNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_START_NUMBER,
                LottoConstants.LOTTO_END_NUMBER,
                LottoConstants.LOTTO_NUMBER_COUNT
        );
        lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void checkForDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!Validator.inRange(number, LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER)) {
                String message = String.format(ErrorMessage.RANGE_OUT_NUMBERS.getMessage(),
                        LottoConstants.LOTTO_START_NUMBER,
                        LottoConstants.LOTTO_END_NUMBER);
                throw new IllegalArgumentException(message);
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
