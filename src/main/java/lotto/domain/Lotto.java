package lotto.domain;

import java.util.List;
import lotto.constants.WinRank;

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
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 당첨 번호와 비교하여 순위를 반환함.
     *
     * @param winNumber 당첨 번호가 적힌 로또
     * @return 로또 당첨 순위
     */
    public WinRank compareWinNumber(WinNumber winNumber) {
        int matchCount = (int) winNumber.numbers().stream()
                .filter(numbers::contains)
                .count();
        boolean matchBonus = numbers.contains(winNumber.bonusNumber());
        return getRank(matchCount, matchBonus);
    }

    private WinRank getRank(int matchCount, boolean matchBonus) {
        WinRank rank = WinRank.ETC;
        switch (matchCount) {
            case 6:
                rank = WinRank.FIRST;
                break;
            case 5:
                rank = WinRank.SECOND;
                if (!matchBonus) {
                    rank = WinRank.THIRD;
                }
                break;
            case 4:
                rank = WinRank.FOURTH;
                break;
            case 3:
                rank = WinRank.FIFTH;
                break;
        }
        return rank;
    }
}
