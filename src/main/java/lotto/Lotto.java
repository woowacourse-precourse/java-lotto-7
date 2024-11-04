package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.Validator;

public class Lotto {

    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    public static final int TOTAL_LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
        }
        if (Validator.hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WIN_NUMBERS.getMessage());
        }
        for (int num : numbers) {
            if (!Validator.isBetween(MIN_LOTTO_NUM, num, MAX_LOTTO_NUM)) {
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
        switch (numOfMatch) { // TODO: map에 당첨 개수별 등수를 저장해두어 리턴하면 라인수 줄일 수 있음
            case 6:
                return LottoRank.GRADE_1TH;
            case 5:
                if (numbers.contains(bonus)) {
                    return LottoRank.GRADE_2TH;
                }
                return LottoRank.GRADE_3TH;
            case 4:
                return LottoRank.GRADE_4TH;
            case 3:
                return LottoRank.GRADE_5TH;
            default:
                return LottoRank.NONE;
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
