package lotto.controller.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final Validator validator;
    public static final String INPUT_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_GUIDE = "당첨번호를 입력해주세요";
    public static final String INPUT_BONUS_NUMBER_GUIDE = "보너스번호를 입력해주세요";

    public InputView(Validator validator) {
        this.validator = validator;
    }


    public int inputAmount(){
        //구입금액 받기
        //구입 금액이 잘못되었으면 재시도
        boolean isStop = true;
        while (isStop){
            try {
                System.out.println(INPUT_AMOUNT_GUIDE);
                String amountInput = Console.readLine();
                validator.validateAmountInput(amountInput);
                isStop = false;
                return Integer.parseInt(amountInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    public List<Integer> inputWinningNumber() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isStop = true;
        while (isStop){
            try {
                System.out.println(INPUT_WINNING_NUMBER_GUIDE);
                String winningNumberInput = Console.readLine();
                winningNumbers = validator.validateWinningNumberInput(winningNumberInput);
                isStop = false;
                return winningNumbers;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        boolean isStop = true;
        while (isStop){
            try {
                System.out.println(INPUT_BONUS_NUMBER_GUIDE);
                String bonusNumber = Console.readLine();
                int verifiedBonusNumber = validator.validateBonusNumberInput(winningNumbers,bonusNumber);
                isStop = false;
                return verifiedBonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
