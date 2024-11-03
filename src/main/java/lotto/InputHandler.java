package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        return Console.readLine();
    }

    public boolean isValidInt(String inputSequence) {
            try {
                NumberValidator.validatePrice(inputSequence);
                return true;        
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.out.println("");
                return false;
            }
        }
}
