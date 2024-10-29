package lotto;

import java.util.function.LongToDoubleFunction;
import lotto.controller.LottoController;
import lotto.model.LottoCompany;
import lotto.model.LottoGenerator;
import lotto.model.LottoShop;
import lotto.util.Validator;
import lotto.view.InputHandler;

public class LottoContainer {
    private static LottoContainer lottoContainer;

    private LottoContainer() {
    }

    public static LottoContainer getInstance() {
        if (lottoContainer == null) {
            lottoContainer = new LottoContainer();
        }
        return lottoContainer;
    }

    public LottoController lottoController() {
        return new LottoController(inputHandler(), lottoShop(), lottoGenerator(), lottoCompany());
    }

    private InputHandler inputHandler() {
        return new InputHandler(new Validator());
    }

    private LottoShop lottoShop() {
        return new LottoShop();
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private LottoCompany lottoCompany() {
        return new LottoCompany();
    }
}
