package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.constants.IOMessageConstants;
import lotto.dto.GeneratedNumbers;
import lotto.dto.WinningNumbersStatics;
import lotto.dto.WinningResultStatics;

public class OutputView {

    public void printNumberOfTickets(int numberOfTickets) {
        System.out.println();
        System.out.println(numberOfTickets + IOMessageConstants.PURCHASED_QUANTITY);
    }

    public void printGeneratedNumbersPair(GeneratedNumbers generatedNumbers) {
        List<Lotto> lottoNumbers = generatedNumbers.getGeneratedNumbers();
        for (Lotto lotto : lottoNumbers) {
            System.out.print(IOMessageConstants.OPENING_PARENTHESIS);
            printGeneratedNumbersSingle(lotto);
            System.out.print(IOMessageConstants.CLOSING_PARENTHESIS);
            System.out.println();
        }
        System.out.println();
    }

    private void printGeneratedNumbersSingle(Lotto lotto) {
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (i != lotto.getNumbers().size() - 1) {
                System.out.print(lotto.getNumbers().get(i) + IOMessageConstants.COMMA);
            }
            if (i == lotto.getNumbers().size() - 1) {
                System.out.print(lotto.getNumbers().get(i));
            }
        }
    }

    public void printWinningStatics(WinningResultStatics winningResultStatics) {
        List<WinningNumbersStatics> winningNumbersStatic = winningResultStatics.getWinningNumbersStatics();
        System.out.println(IOMessageConstants.WINNING_STATICS);
        System.out.println(IOMessageConstants.DASH);
        for (int i = 0; i < winningNumbersStatic.size(); i++) {
            String winningMessage = getWinningMessage(i);
            System.out.println(
                    winningMessage + winningNumbersStatic.get(i).getMatchNumbers() + IOMessageConstants.QUANTITY);
        }
        System.out.println(IOMessageConstants.TOTAL_PROFIT_RATE + winningResultStatics.getWinningPrizeStatics()
                + IOMessageConstants.CLOSE_SENTENCE);
    }

    private String getWinningMessage(int index) {
        return switch (index) {
            case 0 -> IOMessageConstants.WINNING_FIFTH;
            case 1 -> IOMessageConstants.WINNING_FOURTH;
            case 2 -> IOMessageConstants.WINNING_THIRD;
            case 3 -> IOMessageConstants.WINNING_SECOND;
            case 4 -> IOMessageConstants.WINNING_FIRST;
            default -> "";
        };
    }

}
