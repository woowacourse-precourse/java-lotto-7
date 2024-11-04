package lotto.config;

import lotto.controller.LottoController;
import lotto.converter.StringToIntConverter;
import lotto.service.LottoMachine;
import lotto.service.LottoWinMather;
import lotto.util.LottoGenerator;
import lotto.util.NumberGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public NumberGenerate numberGenerate() {
        return new LottoGenerator();
    }

    public StringToIntConverter stringToIntConverter() {
        return new StringToIntConverter();
    }

    public LottoWinMather lottoWinMather() {
        return new LottoWinMather();
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine(numberGenerate());
    }

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoMachine(), stringToIntConverter(), lottoWinMather());
    }
}
