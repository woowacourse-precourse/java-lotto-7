package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private static final int NUMBER_CHECK = 1000;
    private static final String NUMBER_REGEX = ",";

    public int getInputPurchasePrice() {
        String inputPurchasePrice = "";
        while (true) {
            try {
                System.out.println(Message.PURCHASE_PRICE.getMessage());
                inputPurchasePrice = Console.readLine();
                validateNumberModulo(inputPurchasePrice);
                return Integer.parseInt(inputPurchasePrice);
            } catch (NumberFormatException e) {
                System.out.println(Message.INPUT_TYPE_NUMBER_ERROR.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(Message.INPUT_NUMBER_PRICE_PER_LOTTO_ERROR.getMessage());
            }
        }
    }

    public Lotto getUserLotto() {
        System.out.println(Message.WINNING_NUMBERS.getMessage());
        String inputWinningNumber = Console.readLine();
        List<Integer> winningNumberTokens = Arrays.stream(inputWinningNumber.split(NUMBER_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(winningNumberTokens);
    }

    public int getInputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER.getMessage());
        String inputBonusNumber = Console.readLine();
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateNumberModulo(String inputPurchasePrice) {
        if (Integer.parseInt(inputPurchasePrice) % NUMBER_CHECK != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUserLottoDuplication(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(Message.INPUT_NUMBER_DUPLICATION_ERROR.getMessage());
            }
        }
    }
}
