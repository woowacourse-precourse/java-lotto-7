package lotto;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
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
        return switch (numOfMatch) {
            case 6:
                yield LottoRank.GRADE_1TH;
            case 5:
                if (numbers.contains(bonus)) {
                    yield LottoRank.GRADE_2TH;
                }

                yield LottoRank.GRADE_3TH;
            case 4:
                yield LottoRank.GRADE_4TH;
            case 3:
                yield LottoRank.GRADE_5TH;
            default:
                yield LottoRank.NONE;
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(numbers.getLast());
        sb.append("]");

        return sb.toString();
    }
}
