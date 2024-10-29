package lotto.global.util;

import static lotto.global.util.ErrorMessage.*;

public abstract class Parser {
    public static Integer toIntWinningNumber(String value) {
        try{
            return Integer.valueOf(value.trim());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
