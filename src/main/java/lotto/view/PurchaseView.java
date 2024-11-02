package lotto.view;

import lotto.error.Error;

public class PurchaseView extends InputView{
    private static final int ticketPrice = 1000;

    @Override
    public void validate(String input) {
        try {
            int amount = Integer.parseInt(input);
            int remainder = amount % ticketPrice;
            if (remainder != 0) {
                throw new IllegalArgumentException(Error.NOT_IN_1000_UNITS.getMessage());
            }

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
        }
    }
}
