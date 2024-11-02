package lotto.controller;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Integer> getUserNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        String [] splitResult = userInput.split(",");
        for (String number : splitResult) {
            userNumbers.add(splitNumber(number));
        }
        return userNumbers;
    }

    private int splitNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

}
