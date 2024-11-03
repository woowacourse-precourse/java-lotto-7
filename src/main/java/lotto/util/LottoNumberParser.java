package lotto.util;

import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class LottoNumberParser {

    public static final int SPLIT_LIMIT = -1;

    public static List<Integer> parseLottoNumbers(String numbers){
        try{
            return Arrays.stream(numbers.split(",", SPLIT_LIMIT))
                    .map(Integer::parseInt).toList();
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
