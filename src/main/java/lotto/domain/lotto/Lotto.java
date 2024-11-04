package lotto.domain.lotto;

import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_COUNT;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.GlobalException.LottoException;
import lotto.ui.dto.LottoNumbersResponse;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }

        validateNumberCount(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validateNumberCount(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoException(INVALID_NUMBER_COUNT);
        }
    }

    public int match(Lotto otherLotto) {
        int count = 0;
        for (LottoNumber number: otherLotto.numbers) {
            count += increaseCount(number);
        }
        return count;
    }

    private int increaseCount(LottoNumber number) {
        if (contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public LottoNumbersResponse toResponse() {
        return LottoNumbersResponse.from(numbers);
    }

}
