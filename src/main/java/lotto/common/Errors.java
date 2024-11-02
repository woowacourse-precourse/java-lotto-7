package lotto.common;

import static lotto.common.Consts.ERROR_PREFIX;

public class Errors {

    private static final String PREFIX = ERROR_PREFIX;

    public static void IllegalArgumentException(String message){
        throw new IllegalArgumentException(ERROR_PREFIX + message);
    }

}
