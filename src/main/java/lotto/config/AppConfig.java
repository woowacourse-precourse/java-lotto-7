package lotto.config;

import lotto.controller.LottoController;
import lotto.model.generator.NumberGenerator;
import lotto.model.generator.RandomNumberGenerator;
import lotto.model.lotto.LottoService;
import lotto.model.lotto.LottosGenerator;
import lotto.model.money.MoneyService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.convertor.Convertor;
import lotto.view.convertor.LottoConvertor;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(
                input(), output(), lottoService()
        );
    }

    public Input input() {
        return new Input();
    }

    public Output output() {
        return new Output(convertor());
    }

    public Convertor convertor() {
        return new LottoConvertor();
    }

    public LottoService lottoService() {
        return new LottoService(lottosGenerator(), moneyService());
    }

    public MoneyService moneyService() {
        return new MoneyService();
    }

    public LottosGenerator lottosGenerator() {
        return new LottosGenerator(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
