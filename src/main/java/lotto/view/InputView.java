package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.PaymentInput;
import lotto.domain.DrawNumbers;
import lotto.domain.WinningNumbers;
import lotto.validator.BonusNumberValidator;
import lotto.validator.WinningNumbersValidator;

import java.util.List;

public class InputView {
    private static final String PAYMENT_INPUT_COMMAND="구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_COMMAND ="\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_COMMAND="\n보너스 번호를 입력해 주세요.";

    public static PaymentInput enterPaymentInput(){
        try{
            System.out.println(PAYMENT_INPUT_COMMAND);
            PaymentInput paymentInput=new PaymentInput(Console.readLine());
            return paymentInput;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return enterPaymentInput();
        }
    }

    public static DrawNumbers enterWinningNumbers() {

        try{
            System.out.println(WINNING_NUMBER_COMMAND);
            List<Integer> parsedWinningNumbers= WinningNumbersValidator.validateWinningNumbers(Console.readLine());
            WinningNumbers winningNumbers=new WinningNumbers(parsedWinningNumbers);

            DrawNumbers drawNumbers=enterBonusInput(winningNumbers);
            return drawNumbers;

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return enterWinningNumbers();
        }

    }

    public static DrawNumbers enterBonusInput(WinningNumbers winningNumbers) {
        try{
            System.out.println(BONUS_NUMBER_COMMAND);
            int parseNumber=BonusNumberValidator.validateBonusNumber(Console.readLine());
            BonusNumber bonusNumber=new BonusNumber(parseNumber);
            return new DrawNumbers(winningNumbers,bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

            return enterBonusInput(winningNumbers);
        }

    }
}
