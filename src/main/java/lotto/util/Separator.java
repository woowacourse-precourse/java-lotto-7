package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Separator {

    private static final String DELIMITER = ",";

    public static List<String> separateLottoNumbers(String lottoNumber){
        String[] splitNumbers= lottoNumber.split(DELIMITER);
        return Arrays.stream(splitNumbers).toList();
    }
}