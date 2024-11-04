package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.ExceptionHandler;
import lotto.message.error.ErrorMessage;
import lotto.message.info.InfoMessage;

import java.util.List;

public class InputView implements Input {

    private final ExceptionHandler exceptionHandler;
    public InputView(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public int requestPurchaseAmount() {
        int purchaseAmount = -1;
        while (true) {
            try {
                System.out.println(InfoMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
                purchaseAmount = Integer.parseInt(Console.readLine());
                exceptionHandler.validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
        }
        return purchaseAmount;
    }

    @Override
    public String requestLottoNumbers() {
        String str = "";
        while(true) {
            try {
                System.out.println(InfoMessage.REQUEST_WINNING_NUMBERS);
                str = Console.readLine();
                exceptionHandler.validateWinningNumbers(str);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_WINNING_NUMBERS);
            }
        }
        return str;
    }

    @Override
    public int requestBonusNumber() {
        int bonusNumber = 0;
        while(true) {
            try {
                System.out.println(InfoMessage.REQUEST_BONUS_NUMBER);
                bonusNumber = Integer.parseInt(Console.readLine());
                exceptionHandler.validateBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_WINNING_NUMBERS);
            }
        }
        return bonusNumber;
    }
}
