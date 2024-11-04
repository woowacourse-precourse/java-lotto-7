package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.DTO.BonusNumberDTO;
import lotto.DTO.PaymentPriceDTO;
import lotto.DTO.WinningNumberDTO;
import lotto.Util.Constant.IOMessage;
import lotto.Util.Splitter.InputSplitter;
import lotto.Validation.InputNumberValidator;

public class InputView {
    public PaymentPriceDTO inputPaymentPrice() {
        while (true) {
            System.out.println(IOMessage.INPUT_PAYMENT_PRICE.getMessage());
            String paymentPriceInput = Console.readLine();

            try {
                InputNumberValidator.validatePaymentPriceType(paymentPriceInput);
                InputNumberValidator.validatePaymentPriceValue(paymentPriceInput);
                return new PaymentPriceDTO(paymentPriceInput);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumberDTO inputWinningNumber() {
        while (true) {
            System.out.println(IOMessage.INPUT_WINNING_NUMBER.getMessage());
            String winnigNumberInput = Console.readLine();

            try {
                InputNumberValidator.validateWinnigNumberType(winnigNumberInput);
                InputNumberValidator.validateWinnigNumberValue(winnigNumberInput);

                List<Integer> winningNumber = InputSplitter.splitByDelimiter(winnigNumberInput);
                return new WinningNumberDTO(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumberDTO inputBonusNumber(WinningNumberDTO winningNumberDTO) {
        while (true) {
            System.out.println(IOMessage.INPUT_BONUS_NUMBER.getMessage());
            String bonusNumberInput = Console.readLine();

            try {
                InputNumberValidator.validateBonusNumberType(bonusNumberInput);
                InputNumberValidator.validateBonusNumberValue(bonusNumberInput, winningNumberDTO.getWinningNumber());
                return new BonusNumberDTO(Integer.parseInt(bonusNumberInput));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}