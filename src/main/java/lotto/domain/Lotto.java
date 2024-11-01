package lotto.domain;

import java.util.List;
import lotto.constants.WinRank;

public class Lotto {
    private final List<Integer> numbers;
    private WinRank rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void matchWinLotto(WinLotto winLotto) {
        int matchCount = (int) winLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean matchBonus = numbers.contains(winLotto.getBonusNumber());
        setRank(matchCount, matchBonus);
    }

    private void setRank(int matchCount, boolean matchBonus) {
        switch (matchCount) {
            case 6:
                rank = WinRank.FIRST;
                break;
            case 5:
                rank = WinRank.SECOND;
                if(!matchBonus)
                    rank = WinRank.THIRD;
                break;
            case 4:
                rank = WinRank.FOURTH;
                break;
            case 3:
                rank = WinRank.FIFTH;
                break;
        }
    }

    public WinRank getRank() {
        return rank;
    }
}
