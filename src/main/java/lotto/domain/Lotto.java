package lotto.domain;

import java.util.List;
import lotto.constants.InputError;
import lotto.constants.WinRank;
import lotto.view.ErrorPrinter;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] !");
        }
        if (numbers.stream().distinct().count()!=numbers.size()) {
            throw new IllegalArgumentException("[ERROR] !");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinRank matchWinLotto(WinLotto winLotto) {
        int matchCount = (int) winLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean matchBonus = numbers.contains(winLotto.getBonusNumber());
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
