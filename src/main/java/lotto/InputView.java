package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput(InputType inputType) {
        printMessage(inputType);
        return Console.readLine();
    }

    private void printMessage(InputType inputType) {
        System.out.println(inputType.getMessage());
    }
}
