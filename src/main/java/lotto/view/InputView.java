package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputType;

public class InputView {

    public String getInput(InputType inputType) {
        printMessage(inputType);
        return Console.readLine();
    }

    private void printMessage(InputType inputType) {
        System.out.println(inputType.getMessage());
    }
}
