package lotto.utility;

import lotto.enumerate.ExceptionEnum;

public class ExceptionThrower {
    public static void throwing(ExceptionEnum message) {
        System.out.println(message.getMessage());
        throw new IllegalArgumentException(message.getMessage());
    }
}
