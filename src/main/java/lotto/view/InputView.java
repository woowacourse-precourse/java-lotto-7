package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.List;

public class InputView {

    private Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public int readPriceInput(){
        String input = Console.readLine();
        while (!validator.validatePrice(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumberInput(){
        String input = Console.readLine();
        while (!validator.validateWinningNumber(input)) {
            input = Console.readLine();
        }
        return null;
    }

}
