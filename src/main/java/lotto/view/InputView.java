package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.SystemMessage;

public class InputView {
    public int inputPrice() {
        while (true) {
            System.out.println(SystemMessage.INPUT_PRICE.getMessage());
            try {
                return Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println(SystemMessage.INPUT_WINNING_NUMBERS.getMessage());
            String inputNumbers = Console.readLine();

            List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            try {
                if (winningNumbers.size() > 6) {
                    throw new IllegalArgumentException(ErrorMessage.NUMBER_LENGTH.getMessage());
                }
                Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
                if (uniqueNumbers.size() < winningNumbers.size()) {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
                }

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            System.out.println(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
            try {
                return Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }
}
