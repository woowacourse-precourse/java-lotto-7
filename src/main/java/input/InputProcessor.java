package input;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import constant.InputNotice;

public interface InputProcessor<T> {

    T putValue();

    default Integer changeInteger(String input) {
        try {
            Integer number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_CHANGE.show());
        }
    }

    default String receiveInput(InputNotice inputNotice) {
        System.out.println(inputNotice.show());
        return Console.readLine();
    }
}
