package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberInputHandler extends InputHandler{
    private String winningNumber;

    @Override
    public void validateInput() {

    }

    public String[] splitNumbers(String input) {
        return input.split(",");
    }

    public List<Integer> stringInputParseInteger(String input) {
        String[] numbers = splitNumbers(input);
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        for(String number:numbers) {
            lottoWinningNumbers.add(Integer.parseInt(number));
        }
        return lottoWinningNumbers;
    }
}
