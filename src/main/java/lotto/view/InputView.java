package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int budget(){
        int initialCapital = Integer.parseInt(Console.readLine());
        validateThousandUnit(initialCapital);
        return initialCapital;
    }

    private static void validateThousandUnit(long initialCapital) {
        if(initialCapital % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원단위의 구입금액을 입력해야 합니다. ");
        }
    }

    public static List<Integer> winningNumbers(){
        return stringToIntegerList(Console.readLine());
    }

    private static List<Integer> stringToIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
