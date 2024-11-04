package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public interface InputValidator<T, U> {


    T validateInput(String input, U context);
    void displayPrompt();

    default String getInput(){
        return Console.readLine();
    }

    default void displayError(Exception e){
        System.err.println(e.getMessage());
    }

    default T promptAndGetValidatedInput(U context) {
        displayPrompt();
        while (true) {
            try {
                return validateInput(getInput(), context);
            } catch (IllegalArgumentException e) {
                displayError(e);
            }
        }
    }

    default T promptAndGetValidatedInput(){
        return promptAndGetValidatedInput(null);
    }
}
