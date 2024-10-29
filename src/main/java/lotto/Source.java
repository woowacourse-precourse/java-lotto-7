package lotto;

import java.util.List;
import java.util.stream.Stream;

public class Source {

    public static int inputAmountOrBonusNumber(String amount){
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    public static String[] inputWinningNumber(String winningNumber){
        return winningNumber.split(",");
    }

    public static List<Integer> parseNumbers(String[] winningNumber){
        try{
            return Stream.of(winningNumber)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }
}
