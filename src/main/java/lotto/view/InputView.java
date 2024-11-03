package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getInput() {
        while (true) {
            try {
                return getPriceInput();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private int getPriceInput() {
        System.out.println("구매하실 금액을 입력해 주세요.");
        String str = Console.readLine();
        return inputValidator.validatePrice(str);
    }
}
