package lotto.handler;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final String delimiter = ",";

    public int inputMoney(String input){
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers(String input){
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = input.split(delimiter);

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(Integer.parseInt(numbers[i].trim()));
        }

        return winningNumbers;
    }


    public int inputBonusNumber(String input){
        return Integer.parseInt(input);
    }
}
