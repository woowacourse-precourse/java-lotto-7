package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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
