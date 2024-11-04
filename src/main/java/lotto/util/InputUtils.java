package lotto.util;

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
                System.out.println(e.getMessage());
                request = Input.request(e.getViewMessage());
            }
        }
    }
}
