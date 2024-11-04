package lotto.view;

import lotto.config.LottoSettings;
import lotto.error.Error;

public class PurchaseView extends InputView{
    private static final int TICKET_PRICE = LottoSettings.TICKET_PRICE.getValue();

    @Override
    public void validate(String input) {
        try {
            int amount = Integer.parseInt(input);
            int remainder = amount % TICKET_PRICE;
            if (remainder != 0) {
                throw new IllegalArgumentException(Error.NOT_IN_1000_UNITS.getMessage());
            }

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
        }
    }
}
