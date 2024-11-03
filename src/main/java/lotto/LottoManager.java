package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoValidator;

public class LottoManager {

    private int purchaseAmount;

    public void setPurchaseAmount(){
        while(true){
            //올바른 값을 입력할때까지 진행
            if (getPurchaseAmount()) break;
        }
        //Console.close();

    }

    private boolean getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine().trim();
        try{
            int convertAmount = LottoValidator.stringToInt(userInput);
            if (validateInput(convertAmount)) return true;

        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
        return false;
    }

    private boolean validateInput(int convertAmount) {
        if(LottoValidator.unitValidator(convertAmount)){
            purchaseAmount = convertAmount;
            return true;
        }
        return false;
    }

}
