package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.Validation;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static int stringToInteger(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static List<Integer> generateRandomNumber(int start, int end, int pickNumber){
        return Randoms.pickUniqueNumbersInRange(start, end, pickNumber).stream()
                .sorted().collect(Collectors.toList());
    }

}
