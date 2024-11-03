package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoValidator;

public class LottoManager {

    //구매할 로또 갯수
    private int purchaseAmount;

    public void setPurchaseAmount(){
        while(true){
            if (getPurchaseAmount()) {
                break;
            }
        }
        //Console.close();

    }

    private boolean getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return processInput(userInput);
    }

    private boolean processInput(String userInput){
        try {
            int convertAmount = LottoValidator.stringToInt(userInput);
            return validateInput(convertAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return false;
        }
    }

    private boolean validateInput(int convertAmount) {
        if (LottoValidator.unitValidator(convertAmount)) {
            purchaseAmount = convertAmount / 1000;
            return true;
        }
        return false;
    }

}
