package lotto.controller;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public List<Integer> getUserNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        String [] splitResult = userInput.split(",");
        for (String number : splitResult) {
            number = number.trim();
            userNumbers.add(splitNumber(number));
        }
        return userNumbers;
    }

    private int splitNumber(String userInput) {
        System.out.println("userInput = " + userInput);
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

}
