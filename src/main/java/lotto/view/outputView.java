package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.enums.IOMessage;
import lotto.enums.WinningType;

public class outputView {
  public void printQuantityOfLottos(int buyedLottosQuantity) {
    System.out.println(buyedLottosQuantity + IOMessage.PRINT_QUANTITY_OF_LOTTOS.getMessage());
  }

  public void printAllLottos(String allLottos) {
    System.out.println(allLottos);
  }

  public void printStatistic(List<WinningType> winningStatistic) {
    System.out.println(
        IOMessage.PRINT_WINNING_STATISTIC.getMessage()
            + System.lineSeparator()
            + IOMessage.PRINT_WINNING_STATISTIC_SEPARATER.getMessage());
    printFifthPlaceResult(winningStatistic);
    printFourthPlaceResult(winningStatistic);
    printThirdPlaceResult(winningStatistic);
    printSecondPlaceResult(winningStatistic);
    printFirstPlaceResult(winningStatistic);
  }

  private void printFifthPlaceResult(List<WinningType> winningStatistic) {
    System.out.println(IOMessage.PRINT_THREE_MATCHING_QUANTITY.getMessage());
    int countOfResult = Collections.frequency(winningStatistic, WinningType.FIFTH_PLACE);
    System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
  }

  private void printFourthPlaceResult(List<WinningType> winningStatistic) {
    System.out.println(IOMessage.PRINT_FOUR_MATCHING_QUANTITY.getMessage());
    int countOfResult = Collections.frequency(winningStatistic, WinningType.FOURTH_PLACE);
    System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
  }

  private void printThirdPlaceResult(List<WinningType> winningStatistic) {
    System.out.println(IOMessage.PRINT_FIVE_MATCHING_QUANTITY.getMessage());
    int countOfResult = Collections.frequency(winningStatistic, WinningType.THIRD_PLACE);
    System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
  }

  private void printSecondPlaceResult(List<WinningType> winningStatistic) {
    System.out.println(IOMessage.PRINT_FIVE_MATCHING_QUANTITY_AND_BONUS.getMessage());
    int countOfResult = Collections.frequency(winningStatistic, WinningType.SECOND_PLACE);
    System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
  }

  private void printFirstPlaceResult(List<WinningType> winningStatistic) {
    System.out.println(IOMessage.PRINT_SIX_MATCHING_QUANTITY.getMessage());
    int countOfResult = Collections.frequency(winningStatistic, WinningType.FIRST_PLACE);
    System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
  }

  public void printReturnRate(double returnRate) {
    System.out.println(String.format(IOMessage.PRINT_TOTAL_RETURN_RATE.getMessage(), returnRate));
  }
}
