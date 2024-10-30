package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Enum.PrintConstants;
import lotto.Utils.Validator;


public class InputLottoView {
    static final Validator validator = new Validator();

    public int inputPrice() {
        int price = 0;
        while (true) {
            System.out.println(PrintConstants.INPUT_PRICE.getMessage());
            String priceInput = Console.readLine();
            try {
                price = validator.validateInteger(priceInput);
                validator.validatePrice1000(price);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }
}
