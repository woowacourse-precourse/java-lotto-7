package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.enums.IOMessage;
import lotto.enums.WinningType;

public class OutputView {
    public void printQuantityOfLottos(int boughtLottosQuantity) {
        System.out.println(
            System.lineSeparator()
            + boughtLottosQuantity
            + IOMessage.PRINT_QUANTITY_OF_LOTTOS.getMessage());
    }

    public void printAllLottos(String allLottos) {
        System.out.println(allLottos);
    }

    public void printStatistic(List<WinningType> winningStatistic) {
        System.out.println(
            System.lineSeparator()
            + IOMessage.PRINT_WINNING_STATISTIC.getMessage()
            + System.lineSeparator()
            + IOMessage.PRINT_WINNING_STATISTIC_SEPARATER.getMessage());
        printFifthPlaceResult(winningStatistic);
        printFourthPlaceResult(winningStatistic);
        printThirdPlaceResult(winningStatistic);
        printSecondPlaceResult(winningStatistic);
        printFirstPlaceResult(winningStatistic);
    }

    private void printFifthPlaceResult(List<WinningType> winningStatistic) {
        System.out.print(IOMessage.PRINT_THREE_MATCHING_QUANTITY.getMessage());
        int countOfResult = Collections.frequency(winningStatistic, WinningType.FIFTH_PLACE);
        System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
    }

    private void printFourthPlaceResult(List<WinningType> winningStatistic) {
        System.out.print(IOMessage.PRINT_FOUR_MATCHING_QUANTITY.getMessage());
        int countOfResult = Collections.frequency(winningStatistic, WinningType.FOURTH_PLACE);
        System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
    }

    private void printThirdPlaceResult(List<WinningType> winningStatistic) {
        System.out.print(IOMessage.PRINT_FIVE_MATCHING_QUANTITY.getMessage());
        int countOfResult = Collections.frequency(winningStatistic, WinningType.THIRD_PLACE);
        System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
    }

    private void printSecondPlaceResult(List<WinningType> winningStatistic) {
        System.out.print(IOMessage.PRINT_FIVE_MATCHING_QUANTITY_AND_BONUS.getMessage());
        int countOfResult = Collections.frequency(winningStatistic, WinningType.SECOND_PLACE);
        System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
    }

    private void printFirstPlaceResult(List<WinningType> winningStatistic) {
        System.out.print(IOMessage.PRINT_SIX_MATCHING_QUANTITY.getMessage());
        int countOfResult = Collections.frequency(winningStatistic, WinningType.FIRST_PLACE);
        System.out.println(countOfResult + IOMessage.PRINT_UNIT_OF_QUANTITY.getMessage());
    }

    public void printReturnRate(double returnRate, List<WinningType> winningStatistic) {
        if (winningStatistic.isEmpty()) {
            System.out.println(String.format(IOMessage.PRINT_NO_MONEY_EARNED.getMessage()));
            return;
        }
        System.out.println(String.format(IOMessage.PRINT_TOTAL_RETURN_RATE.getMessage(), returnRate));
    }
}


