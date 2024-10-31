package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoArgumentException;

import java.util.Arrays;
import java.util.List;

public class UserView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static int printAndGetAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return getAmount();
    }

    private static int getAmount() {
        while (true) {
            try {
                return checkAmount(Console.readLine());
            } catch (LottoArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int checkAmount(String inputAmount) {
        if (inputAmount == null || inputAmount.equals("\n") || inputAmount.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            int amount = Integer.parseInt(inputAmount);

            if (amount < 1000) {
                throw new LottoArgumentException(LottoErrorMessage.LESS_MIN_AMOUNT_ERROR);
            }

            if (amount % 1000 != 0) {
                throw new LottoArgumentException(LottoErrorMessage.DIV_1_000_AMOUNT_ERROR);
            }

            return amount;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    public static List<Integer> printAndGetWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        return getWinNumbers();
    }

    private static List<Integer> getWinNumbers() {
        while (true) {
            try {
                return checkWinNumbers(Console.readLine());
            } catch (LottoArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> checkWinNumbers(String inputWinNumbers) {
        if (inputWinNumbers == null || inputWinNumbers.equals("\n") || inputWinNumbers.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            List<Integer> winNumbers = Arrays
                    .stream(inputWinNumbers.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();

            if(winNumbers.size() != 6) {
                throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_COUNT_ERROR);
            }

            if(!checkValidRangeNumbers(winNumbers)) {
                throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
            }

            return winNumbers;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_CONTAINS_LETTER_ERROR);
        }
    }

    private static boolean checkValidRangeNumbers(List<Integer> winNumbers) {
        return winNumbers.stream().allMatch(number -> 1 <= number && number <= 45);
    }

    public static int printAndGetBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return getBonusNumber();
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                return checkBonusNumbers(Console.readLine());
            } catch (LottoArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int checkBonusNumbers(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.equals("\n") || inputBonusNumber.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);

            if(bonusNumber < 1 || 45 < bonusNumber) {
                throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR);
        }
    }
}
