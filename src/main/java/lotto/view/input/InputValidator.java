package lotto.view.input;

import static lotto.config.LottoConfig.PRICE;

import lotto.config.ErrorMessage;

public class InputValidator {
    //구입 금액 입력 시 정해진 형식이 아니거나 1000으로 나누어 떠어지지 않을 시 에러 발생
    public static int validatePurchaseAmount(String input){
        try{
            int amount = Integer.parseInt(input);
            if(amount < PRICE || amount % PRICE != 0){
                //입력 금액이 정수로 들어왔지만 1000보다 작거나 나누어 떨어지지 않을 때 에러 발생
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
            return amount;
        }catch (NumberFormatException e){ //입력 금액이 정수로 들어오지 않았을 때
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
