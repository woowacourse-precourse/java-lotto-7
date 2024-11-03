package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.IOMessageConstants;
import lotto.exception.InputViewException;

public class InputView {

    private final InputViewException inputViewException;

    public InputView(){
        inputViewException = new InputViewException();
    }

    public String inputMoney() {
        String inputMoney;
        while(true){
            try{
                System.out.println(IOMessageConstants.INPUT_PURCHASE_AMOUNT);
                inputMoney = Console.readLine();
                inputViewException.validateInputMoney(inputMoney);
                break;
            }catch(IllegalArgumentException | ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
        return inputMoney;
    }
}
