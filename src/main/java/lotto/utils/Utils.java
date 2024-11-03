package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> splitWinningNumber(String winningNumber){

        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
