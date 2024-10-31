package lotto.validator;

import lotto.error.LottoErrorMessage;

public class LottoInputValidator {

    private LottoInputValidator() {

    }

    public static int checkInputMoney(String input) {

        int money = -1;
        try {
            money = Integer.parseInt(input);
        } catch (Exception e){
            System.out.println(LottoErrorMessage.MONEY_EXCEPTION.getMsg());
        }

        if(money % 1000 != 0) {
            System.out.println(LottoErrorMessage.MONEY_EXCEPTION.getMsg());
            return -1;
        }

        return money;
    }
}
