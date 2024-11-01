package lotto.controller.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final Validator validator;
    private final String INPUT_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";

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

}
