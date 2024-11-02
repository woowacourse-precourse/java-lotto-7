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

    public Integer getUserPurcharsePrice(String userInput) {
        userInput = userInput.trim();
        return parseMoney(userInput);
    }

    private int splitNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private int parseMoney(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액 입력은 숫자여야 합니다.");
        }
    }

}
