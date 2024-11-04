package lotto.common;

import static lotto.common.Consts.ERROR_PREFIX;

public class Errors {

    private static final String PREFIX = ERROR_PREFIX;

    public static void IllegalArgumentException(String message){
        System.out.println(PREFIX + message);
        throw new IllegalArgumentException(ERROR_PREFIX + message);
    }

    public static void ClassCastException(String message){
        System.out.println(PREFIX + "애플리케이션 오류(" + message+")");
        throw new ClassCastException(ERROR_PREFIX + message);
    }

}
