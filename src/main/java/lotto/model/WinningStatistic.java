package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.Lotto;
import lotto.enums.WinningType;

public class WinningStatistic {
    private static final int THREE_SAME_NUMBERS = 3;
    private static final int FOUR_SAME_NUMBERS = 4;
    private static final int FIVE_SAME_NUMBERS = 5;
    private static final int SIX_SAME_NUMBERS = 6;

    private final List<WinningType> winningStatistic;

    private WinningStatistic(List<WinningType> winningStatistic) {
        this.winningStatistic = winningStatistic;
    }

    public static WinningStatistic createWinningStatistic(
        WinningNumbers winningNumbers, Lottos lottos) {
            List<WinningType> statistics =
                lottos.getLottos().stream()
                    .map(lotto -> determineWinningType(lotto, winningNumbers))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            return new WinningStatistic(statistics);
    }

    private static WinningType determineWinningType(Lotto lotto, WinningNumbers winningNumbers) {
        int quantityOfSameNumbers = lotto.compareWinningNumbers(winningNumbers.getWinningNumbers());
        boolean bonusMatch = lotto.compareBonusNumber(winningNumbers.getBonusNumber());

        WinningType winningType = getTopWinningType(quantityOfSameNumbers, bonusMatch);
        if (winningType != null) {
            return winningType;
        }
        return getLowerWinningType(quantityOfSameNumbers);
    }

    private static WinningType getTopWinningType(int quantityOfSameNumbers, boolean bonusMatch) {
        if (quantityOfSameNumbers == SIX_SAME_NUMBERS) {
            return WinningType.FIRST_PLACE;
        }
        if (quantityOfSameNumbers == FIVE_SAME_NUMBERS && bonusMatch) {
            return WinningType.SECOND_PLACE;
        }
        if (quantityOfSameNumbers == FIVE_SAME_NUMBERS) {
            return WinningType.THIRD_PLACE;
        }
        return null;
    }

    private static WinningType getLowerWinningType(int quantityOfSameNumbers) {
        if (quantityOfSameNumbers == FOUR_SAME_NUMBERS) {
            return WinningType.FOURTH_PLACE;
        }
        if (quantityOfSameNumbers == THREE_SAME_NUMBERS) {
            return WinningType.FIFTH_PLACE;
        }
        return null;
    }

    public List<WinningType> getWinningStatistic() {
        return this.winningStatistic;
    }
}
