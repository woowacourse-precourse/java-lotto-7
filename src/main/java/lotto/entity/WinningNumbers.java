package lotto.entity;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

import java.util.List;
import lotto.enums.NotificationMessage;

public class WinningNumbers {
    private final List<Integer> mainNumbers;
    private final int bonusNumber;
    private static final String DELIMITER = ",";

    public WinningNumbers() {
        this.mainNumbers = inputMainNumbers();
        this.bonusNumber = inputBonusNumber();
    }

    private List<Integer> inputMainNumbers() {
        while (true) {
            try {
                System.out.println(NotificationMessage.WINNING_NUMBERS.getMessage());

                String[] inputs = Console.readLine().trim().split(DELIMITER);
                validateNumbersCount(inputs);

                List<Integer> mainNumbers = Arrays.stream(inputs)
                        .map(input -> Integer.parseInt(input.trim()))
                        .collect(Collectors.toList());
                
                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return mainNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                System.out.println(NotificationMessage.BONUS_NUMBER.getMessage());

                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                validateBonusNumber(bonusNumber);

                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateNumbersCount(String[] inputs) {
        if (inputs.length != LottoConstants.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstants.MIN_LOTTO_NUMBER.getValue() || bonusNumber > LottoConstants.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }

        if (mainNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
