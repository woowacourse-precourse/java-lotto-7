package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import lotto.messages.ErrorMessage;
import lotto.messages.SystemMessage;

import java.util.Arrays;
import java.util.List;

public abstract class InputHandler {

    public static int getPrice() {
        while (true) {
            try {
                System.out.println(SystemMessage.INPUT_PRICE.getMessage());
                String input = Console.readLine();
                Validator.validateInput(input);
                Validator.validateLottoPrice(input);
                return convertToInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.PRICE_NOT_NUMBER.getMessage());
            }
        }
    }

    public static List<Integer> getWinningLottoNumber() {
        while (true) {
            try {
                System.out.println(SystemMessage.INPUT_WINNING_NUMBER.getMessage());
                String input = Console.readLine();
                List<Integer> winningNumber = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .toList();
                Validator.validateInput(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.WINNING_NUMBER_DUPLICATION.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                System.out.println(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                Validator.validateInput(input);
                return Validator.checkBonusNumberDuplication(convertToInt(input), winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.BONUS_NUMBER_DUPLICATION);
            }
        }
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
