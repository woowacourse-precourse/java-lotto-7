package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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

    public String inputNumbers() {
        String inputNumbers;
        while(true){
            try {
                System.out.println(IOMessageConstants.INPUT_LOTTO_NUMBERS);
                inputNumbers = Console.readLine();
                inputViewException.validateInputNumbers(inputNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputNumbers;
    }

    public String inputBonusNumber(List<Integer> parsedInputNumbers) {
        String inputBonusNumber;
        System.out.println();
        while(true){
            try{
                System.out.println(IOMessageConstants.INPUT_BONUS_NUMBER);
                inputBonusNumber = Console.readLine();
                inputViewException.validateInputBonusNumber(inputBonusNumber, parsedInputNumbers);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return inputBonusNumber;
    }
}
