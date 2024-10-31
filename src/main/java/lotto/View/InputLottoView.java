package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Enum.PrintConstants;
import lotto.Model.Lotto;
import lotto.Utils.Validator;


public class InputLottoView {
    static final Validator validator = new Validator();

    public int inputPrice() {
        int price = 0;
        while (true) {
            System.out.println(PrintConstants.INPUT_PRICE.getMessage());
            String priceInput = Console.readLine();
            try {
                validator.validateEmptyInput(priceInput);
                price = validator.validateInteger(priceInput);
                validator.validatePrice1000(price);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public Lotto inputWinningNumbers() {
        Lotto winningLotto;
        while (true) {
            System.out.println(PrintConstants.INPUT_WINNING_NUMBERS.getMessage());
            String lottoInput = Console.readLine();
            try {
                validator.validateEmptyInput(lottoInput);
                winningLotto = new Lotto(validator.validateNumbersInput(lottoInput));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }
}
