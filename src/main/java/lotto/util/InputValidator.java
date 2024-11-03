package lotto.util;

import lotto.util.message.Messages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.util.message.Messages.*;

public class InputValidator {
    private final static int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;


    public int validatePrice(String str) {
        checkBlank(str);
        int price = convertStrToInt(str);

        checkCanDivide(price);
        return price;
    }

    private void checkCanDivide(int price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    private void checkBlank(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public int convertStrToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public List<Integer> validateWinningNumbers(List<String> winningString) {
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningString) {
            checkBlank(number);
            int converted = convertStrToInt(number);
            checkRange(converted);
            winningNumbers.add(converted);
        }
        checkSize(winningNumbers);
        checkDuplicated(winningNumbers);

        return winningNumbers;
    }

    private static void checkDuplicated(List<Integer> winningNumbers) {
        if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자가 포함될 수 없습니다.");
        }
    }

    private static void checkSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
