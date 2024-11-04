package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.policy.LottoPolicy;
import lotto.validator.CommonValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
        }
        if (CommonValidator.hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WIN_NUMBERS.getMessage());
        }
        for (int num : numbers) {
            if (!CommonValidator.isBetween(LottoPolicy.MIN_LOTTO_NUM, num, LottoPolicy.MAX_LOTTO_NUM)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
            }
        }
    }

    public LottoRank checkRank(List<Integer> winnerNumbers, int bonus) {
        int numOfMatch = (int) numbers.stream()
                .filter(winnerNumbers::contains)
                .count();

        return determineRank(numOfMatch, bonus);
    }

    private LottoRank determineRank(int numOfMatch, int bonus) {
        if (numOfMatch == 6) {
            return LottoRank.GRADE_1TH;
        } else if (numOfMatch == 5) {
            if (numbers.contains(bonus)) {
                return LottoRank.GRADE_2TH;
            }
            return LottoRank.GRADE_3TH;
        } else if (numOfMatch == 4) {
            return LottoRank.GRADE_4TH;
        } else if (numOfMatch == 3) {
            return LottoRank.GRADE_5TH;
        }

        return LottoRank.NONE;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
