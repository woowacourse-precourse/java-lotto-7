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
                Arrays.stream(inputs).forEach(this::validateInteger);

                validateMainNumber(inputs);

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

                String bonusInput = Console.readLine().trim();
                validateInteger(bonusInput); // 보너스 번호에 대해 유효성 검사
                int bonusNumber = Integer.parseInt(bonusInput);

                validateBonusNumber(bonusNumber);

                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMainNumber(String[] inputs) {
        validateMainNumbersCount(inputs);

        for (String input : inputs) {
            int number = Integer.parseInt(input.trim());
            validatePositiveInteger(number);
            validateNumberInRange(number);
        }
    }

    private void validateMainNumbersCount(String[] inputs) {
        if (inputs.length != LottoConstants.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        validatePositiveInteger(bonusNumber);
        validateNumberInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateBonusNumberDuplication(int bonusNumber) {
        if (mainNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateInteger(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    private void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
