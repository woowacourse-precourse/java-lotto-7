package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ConstraintConstants;
import lotto.constants.ErrorViewConstants;
import lotto.constants.InputViewConstants;

import static lotto.service.ConverterService.stringArrayToIntegerArray;
import static lotto.service.ValidatorService.*;

public class InputService {
    public int getPurchaseAmount() {
        System.out.println(InputViewConstants.PURCHASE_AMOUNT_INSTRUCTION);
        String enteredPurchasePrice = Console.readLine();
        try {
            return ConverterService.convertPurchasePrice(enteredPurchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getPurchaseAmount();
    }

    public int[] getWinningNumbers() {
        System.out.println(InputViewConstants.WINNING_NUMBER_INSTRUCTION);
        String[] winningNumbers = Console.readLine().split(",");
        if (validateWinningNumbersFormat(winningNumbers)) {
            return stringArrayToIntegerArray(winningNumbers);
        }
        throw new IllegalArgumentException(ErrorViewConstants.INVALID_INPUT_TYPE);
    }
}
