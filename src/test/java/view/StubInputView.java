package view;

import camp.nextstep.edu.missionutils.Console;
import validation.Validation;

public class StubInputView extends InputView {

    public StubInputView() {
        super();
    }

    @Override
    public int purchaseAmount() {
        String input = Console.readLine().strip();
        try {
            validateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(input);
    }

    @Override
    public String winingNumber() {
        return super.winingNumber();
    }

    @Override
    public String bonusNum() {
        return super.bonusNum();
    }

    private static void validateInput(String str) {
        Validation.blankInput(str);
        Validation.numberInput(str);
        Validation.overInput(Integer.parseInt(str));
        Validation.divideByLottoValue(Integer.parseInt(str));
    }
}
