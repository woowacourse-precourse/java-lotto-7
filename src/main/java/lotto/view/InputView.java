package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;
import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.LottoController.winningLotto;

public class InputView {

    public static int inputMoney() {
        return validateInteger(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            String input = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            try {
                Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .forEach(numbers::add);
                validateWinningNumbers(numbers);
                return numbers;
            } catch (NumberFormatException exception) {
                System.out.println(ErrorMessage.NOT_INTEGER);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SIZE);
        }
        LottoNumber.validateLottoRange(numbers);
        LottoNumber.validateLottoDuplicated(numbers);
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                LottoNumber.validateNumberRange(bonusNumber);
                LottoNumber.validateDuplicated(winningLotto.getNumbers(), bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException exception) {
                System.out.println(ErrorMessage.NOT_INTEGER);
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.BONUS_NUMBER_INVALID);
            }
        }
    }

    public static int validateInteger(String input) {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println(ErrorMessage.NOT_INTEGER);
                input = Console.readLine();
            }
        }
    }
}