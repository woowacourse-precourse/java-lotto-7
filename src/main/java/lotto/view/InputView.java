package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {
    public String input(){
        printInputMessage();

        String input = removeWhiteSpace(Console.readLine());

        validate(input);

        return input;
    }

    private String removeWhiteSpace(String inputValue) {
        return inputValue.trim();
    }

    protected abstract void printInputMessage();
    protected abstract void validate(String input);
}
