package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public abstract class InputView {
    protected Validator validator;
    protected String inputValue;

    public String input(){
        printInputMessage();

        this.inputValue = removeWhiteSpace(Console.readLine());

        return inputValue;
    }

    private String removeWhiteSpace(String inputValue) {
        return inputValue.trim();
    }

    protected abstract void printInputMessage();
}
