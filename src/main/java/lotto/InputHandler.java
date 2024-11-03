package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        return Console.readLine();
    }

    public List<Integer> parseToList(String inputWinningNumber) {
        final List<Integer> winningNumber = new ArrayList<>();

        String[] splittedWinningNumber = inputWinningNumber.split(",");
        for (String number : splittedWinningNumber) {
            if (!NumberValidator.isValidNumber(number)) {
                return null; // 문제 발생 -> NFE
            }
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }
}
