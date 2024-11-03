package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static int parsePrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }

    public static int[] getIntArray(String[] input) {
        int[] number = new int[input.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = parsePrice(input[i]);
        }
        return number;
    }

    public static String[] split(String input) {
        return input.replaceAll(" ","").split(",");
    }

    public static List<Integer> getWinningNumber(int[] numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (int number : numbers) {
            winningNumber.add(number);
        }
        return winningNumber;
    }

}