package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public int readPurchaseAmount(String input_text) {
        int result_num = 0;

        for (char c : input_text.toCharArray()) {
            if (Character.isDigit(c)) {
                result_num *= 10;
                result_num += c - '0';
                continue;
            }
            throw new IllegalArgumentException(ExceptionMessage.NUM_NOT_NUM.getMessage());
        }

        return result_num / 1000;
    }

    public List<Integer> readWinningNumbers(String input_text) {
        List<Integer> winning_nums = new ArrayList<Integer>();
        int result_num = 0;

        for (char c : input_text.toCharArray()) {
            if (Character.isDigit(c)) {
                result_num *= 10;
                result_num += c - '0';
                continue;
            }
            if (c == ',') {
                winning_nums.add(result_num);
                result_num = 0;
                continue;
            }
            throw new IllegalArgumentException(ExceptionMessage.NUM_NOT_NUM.getMessage());
        }
        winning_nums.add(result_num);

        return winning_nums;
    }

    public int readBonusNumber(String input_text) {
        int result_num = 0;

        for (char c : input_text.toCharArray()) {
            if (Character.isDigit(c)) {
                result_num *= 10;
                result_num += c - '0';
                continue;
            }
            throw new IllegalArgumentException(ExceptionMessage.NUM_NOT_NUM.getMessage());
        }

        return result_num;
    }

    private void checkBlankString(String input_text) {
        if (input_text.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }
    }
}
