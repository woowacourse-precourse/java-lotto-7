package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public int getPurchaseAmount() {
        String input_text;
        int purchaseAmount;

        while (true) {
            try {
                System.out.println(GuideMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                input_text = Console.readLine();
                purchaseAmount = readPurchaseAmount(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        String input_text;
        List<Integer> winningNums;

        while (true) {
            try {
                System.out.println(GuideMessage.INPUT_WINNING_NUMBERS.getMessage());
                input_text = Console.readLine();
                winningNums = readWinningNumbers(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNums;
    }

    public int getBonusNumber() {
        String input_text;
        int bonusNum;

        while (true) {
            try {
                System.out.println(GuideMessage.INPUT_WINNING_BONUS.getMessage());
                input_text = Console.readLine();
                bonusNum = readBonusNumber(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNum;
    }

    public int readPurchaseAmount(String input_text) {
        int result_num = 0;

        result_num = readSoloNumber(input_text);
        if (result_num % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_NOT_ROUND_THOUSAND.getMessage());
        }
        if (result_num < 1) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_UNDER_THOUSAND.getMessage());
        }

        return result_num / 1000;
    }

    public List<Integer> readWinningNumbers(String input_text) {
        List<Integer> winning_nums = new ArrayList<Integer>();

        readMultipleNumbers(input_text, winning_nums);
        validateWinningNumbers(winning_nums);

        return winning_nums;
    }

    public int readBonusNumber(String input_text) {
        int result_num = 0;

        result_num = readSoloNumber(input_text);
        checkNumberRange(result_num);

        return result_num;
    }

    private void checkBlankString(String input_text) {
        if (input_text.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }
    }

    private int readSoloNumber(String input_text) {
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

    private void readMultipleNumbers(String input_text, List<Integer> winning_nums) {
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
    }

    private void validateWinningNumbers(List<Integer> winningNums) {
        if (winningNums.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }
        for (int i = 0; i < winningNums.size(); i++) {
            checkNumberRange(winningNums.get(i));
            for (int j = 0; j < i; j++) {
                if (winningNums.get(i).equals(winningNums.get(j))) {  // 중복 검사
                    throw new IllegalArgumentException(ExceptionMessage.WINNING_DUPLICATED.getMessage());
                }
            }
        }
    }

    private void checkNumberRange(int i) {
        if (i < 1 || i > 45) {
            throw new IllegalArgumentException(ExceptionMessage.NUM_NOT_IN_RANGE.getMessage());
        }
    }
}
