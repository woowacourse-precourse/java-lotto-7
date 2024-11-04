package lotto.common.config;

import lotto.presentation.input.Input;
import lotto.presentation.input.InputHandler;
import lotto.presentation.controller.LottoController;
import lotto.presentation.view.View;
import lotto.service.LottoGenerator;
import lotto.service.LottoService;
import lotto.service.RevenueCalculator;
import lotto.service.strategy.DrawStrategy;
import lotto.service.strategy.RandomStrategy;

public class LottoFactory {
    private static InputHandler inputHandler() {
        return new InputHandler(input());
    }

    private static Input input() {
        return new Input(view());
    }

    private static DrawStrategy drawStrategy() {
        return new RandomStrategy();
    }

    private static RevenueCalculator revenueCalculator() {
        return new RevenueCalculator();
    }

    private static LottoGenerator lottoGenerator() {
        return new LottoGenerator(drawStrategy());
    }

    private static LottoService lottoService() {
        return new LottoService(lottoGenerator(), revenueCalculator());
    }

    private static View view() {
        return new View();
    }

    public static LottoController createLottoController() {
        return new LottoController(inputHandler(), lottoService(), view());
    }
}
