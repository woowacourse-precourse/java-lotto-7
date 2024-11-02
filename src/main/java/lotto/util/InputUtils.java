package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.RetryInputException;
import lotto.view.Input;

import java.util.function.Predicate;

public class InputUtils {

    public static String retryRequest(String input, Predicate<String> validator) {
        String request = input;
        while (true) {
            try {
                validator.test(request);
                return request;

            } catch (RetryInputException e) {
                System.err.println(e.getMessage());
                request = Input.request(e.getViewMessage());

            } finally {
                Console.close();
            }
        }
    }
}
