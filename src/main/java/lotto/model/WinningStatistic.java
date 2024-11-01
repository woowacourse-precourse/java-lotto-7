package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.enums.WinningType;

public class WinningStatistic {
  private final List<WinningType> winningStatistic;

  private WinningStatistic(List<WinningType> winningStatistic) {
    this.winningStatistic = winningStatistic;
  }

  public static WinningStatistic createWinningStatistic(WinningNumbers winningNumbers, Lottos lottos) {
    List<WinningType> statistics =
        lottos.getLottos().stream()
            .map(lotto -> determineWinningType(lotto, winningNumbers))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    return new WinningStatistic(statistics);
  }

  private static WinningType determineWinningType(Lotto lotto, WinningNumbers winningNumbers) { //*이 메서드 길이 고민해보기 */
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
    return quantityOfSameNumbers == 6;
  }

  private static boolean isSecondPlace(
      int quantityOfSameNumbers, Lotto lotto, WinningNumbers winningNumbers) {
    return quantityOfSameNumbers == 5 && lotto.compareBonusNumber(winningNumbers.getBonusNumber());
  }

  private static boolean isThirdPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == 5;
  }

  private static boolean isFourthPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == 4;
  }

  private static boolean isFifthPlace(int quantityOfSameNumbers) {
    return quantityOfSameNumbers == 3;
  }

  public List<WinningType> getWinningStatistic(){
    return this.winningStatistic;
  }
}
