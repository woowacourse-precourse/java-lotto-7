package lotto.validator;

import lotto.error.LottoErrorMessage;
import lotto.io.Output;

public class LottoInputValidator {

    private static LottoInputValidator lottoInputValidator;
    private final Output output;

    private LottoInputValidator(Output output) {
        this.output = output;
    }

    public static LottoInputValidator getInstance(Output output) {
        if(lottoInputValidator == null)
            lottoInputValidator = new LottoInputValidator(output);

        return lottoInputValidator;
    }

    public static int checkInputMoney(String input) {

        int money = -1;
        try {
            money = Integer.parseInt(input);
        } catch (Exception e){
            // System.out.println(LottoErrorMessage.MONEY_EXCEPTION.getMsg());

        }

        if(money % 1000 != 0) {
            System.out.println(LottoErrorMessage.MONEY_EXCEPTION.getMsg());
            return -1;
        }

        return money;
    }
}
