package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.WinningNumbersDto;
import lotto.domain.MonetaryUnit;

import java.util.Arrays;
import java.util.List;

import static lotto.view.ErrorMessages.*;
import static lotto.view.LottoMessageFormats.*;

public class InputView {
    private static final String WINNING_LOTTO_DELIMITER = ",";
    private static final int MULTIPLES_OF_THOUSAND = 0;

    private InputView() {
    }

    public static int readUserMoneyWithRetry() {
        int userMoney;
        while (true) {
            try {
                userMoney = readUserMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return userMoney;
    }

    public static WinningNumbersDto readWinningNumbersWithRetry() {
        WinningNumbersDto winningNumbersDto;
        while (true) {
            try {
                winningNumbersDto = readWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbersDto;
    }

    private static int readUserMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT_PROMPT_MESSAGE.getMessage());
        String userInput = Console.readLine();
        int userMoney = validateNumberFormat(userInput);
        validateDivisibilityByThousand(userMoney);

        return userMoney;
    }

    private static int validateNumberFormat(String userInput) {
        int parsedUserInput;
        try {
            parsedUserInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }

        return parsedUserInput;
    }

    private static WinningNumbersDto readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_PROMPT_MESSAGE.getMessage());
        List<Integer> winningLottoNumbers = Arrays.stream(Console.readLine().split(WINNING_LOTTO_DELIMITER))
                .map(InputView::validateNumberFormat)
                .toList();

        System.out.println(INPUT_BONUS_NUMBER_PROMPT_MESSAGE.getMessage());
        int bonusNumber = validateNumberFormat(Console.readLine());

        validateDuplicationOfLottoNumber(winningLottoNumbers, bonusNumber);

        return new WinningNumbersDto(winningLottoNumbers, bonusNumber);
    }

    private static void validateDivisibilityByThousand(int userMoney) {
        if (isMultiplesOfThousand(userMoney)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    private static boolean isMultiplesOfThousand(int userMoney) {
        return (userMoney % MonetaryUnit.A_LOTTO_PRICE.getUnit()) != MULTIPLES_OF_THOUSAND;
    }

    private static void validateDuplicationOfLottoNumber(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_IN_BASIC_AND_BONUS.getMessage());
        }
    }
}