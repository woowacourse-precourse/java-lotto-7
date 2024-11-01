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

    public int checkInputMoney(String input) throws IllegalArgumentException {

        int money;
        try {
            money = Integer.parseInt(input);
            if(money % 1000 != 0)
                throw new Exception();

        } catch (Exception e){
            output.printErrorMsg(LottoErrorMessage.MONEY_EXCEPTION);
            throw new IllegalArgumentException(LottoErrorMessage.MONEY_EXCEPTION.getMsg());
        }

        return money;
    }
}
