package lotto.service;

import lotto.config.*;
import lotto.validator.LottoInputValidator;
import lotto.io.*;

public class LottoService {

    private static LottoService service;

    private final Input input;
    private final Output output;
    private final LottoInputValidator lottoInputValidator;

    private LottoService(LottoConfig config) {
        this.input = config.input();
        this.output = config.output();
        this.lottoInputValidator = config.lottoInputValidator();
    }

    public static LottoService getInstance(LottoConfig config) {
        if(service== null)
            service = new LottoService(config);

        return service;
    }

    public int inputMoney() {
        int money = -1;

        while(money == -1) {
            try {
                money = lottoInputValidator.checkInputMoney(input.inputMoney());
            } catch(IllegalArgumentException e) {
                continue;
            }
        }

        return money;
    }
}
