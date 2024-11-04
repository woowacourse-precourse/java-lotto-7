package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputViewConstants;

public class InputService {
    public int getPurchaseAmount() {
        System.out.println(InputViewConstants.PURCHASE_AMOUNT_INSTRUCTION);
        String enteredPurchasePrice = Console.readLine();
        try {
            return ConverterService.convertPurchasePrice(enteredPurchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.getPurchaseAmount();
    }

    public int[] getWinningNumbers() {
        System.out.println(InputViewConstants.WINNING_NUMBER_INSTRUCTION);
        String enteredWinningNumber = Console.readLine();
        try {
            String[] splitWinningNumber = ConverterService.splitWinningNumber(enteredWinningNumber);
            return ConverterService.convertWinningNumber(splitWinningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.getWinningNumbers();
    }
}
