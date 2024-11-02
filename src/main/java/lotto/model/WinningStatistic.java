package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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

  private static WinningType determineWinningType(
      Lotto lotto, WinningNumbers winningNumbers) { // *이 메서드 길이 고민해보기 */
    int quantityOfSameNumbers = lotto.compareWinningNumbers(winningNumbers.getWinningNumbers());

    if (isFirstPlace(quantityOfSameNumbers)) {
      return WinningType.FIRST_PLACE;
    }
    if (isSecondPlace(quantityOfSameNumbers, lotto, winningNumbers)) {
      return WinningType.SECOND_PLACE;
    }
    if (isThirdPlace(quantityOfSameNumbers)) {
      return WinningType.THIRD_PLACE;
    }
    if (isFourthPlace(quantityOfSameNumbers)) {
      return WinningType.FOURTH_PLACE;
    }
    if (isFifthPlace(quantityOfSameNumbers)) {
      return WinningType.FIFTH_PLACE;
    }
    return null;
  }

  private static boolean isFirstPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == SIX_SAME_NUMBERS;
  }

  private static boolean isSecondPlace(
      int quantityOfSameNumbers, Lotto lotto, WinningNumbers winningNumbers) {
    return quantityOfSameNumbers == FIVE_SAME_NUMBERS
        && lotto.compareBonusNumber(winningNumbers.getBonusNumber());
  }

  private static boolean isThirdPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == FIVE_SAME_NUMBERS;
  }

  private static boolean isFourthPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == FOUR_SAME_NUMBERS;
  }

  private static boolean isFifthPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == THREE_SAME_NUMBERS;
  }

  public List<WinningType> getWinningStatistic() {
    return this.winningStatistic;
  }
}
