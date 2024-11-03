package lotto.view;

import lotto.constants.IOMessageConstants;

public class OutputView {

    public void printNumberOfTickets(int numberOfTickets) {
        System.out.println();
        System.out.println(numberOfTickets + IOMessageConstants.PURCHASED_QUANTITY);
    }

}
