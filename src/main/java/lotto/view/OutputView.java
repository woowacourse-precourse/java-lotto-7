package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.constants.IOMessageConstants;
import lotto.dto.GeneratedNumbers;

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

}
