package lotto.input;

import static lotto.input.Validator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ",";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = readInput();
        notEmpty(input);
        isNumber(input);
        return Parser.toInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = readInput();
        notEmpty(input);
        String[] splitNumbers = split(input);
        isNumber(splitNumbers);
        return Parser.toInts(splitNumbers);
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = readInput();
        notEmpty(input);
        isNumber(input);
        return Parser.toInt(input);
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static String[] split(String input) {
        return input.split(SPLIT_DELIMITER);
    }

}
