package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoProcessor;
import lotto.model.LottoType;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConfiguration {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoProcessor lottoProcessor() {
        Map<LottoType, Integer> lottoStorage = new HashMap<>();

        lottoStorage.put(LottoType.FIRST_PLACE, 0);
        lottoStorage.put(LottoType.SECOND_PLACE, 0);
        lottoStorage.put(LottoType.THIRD_PLACE, 0);
        lottoStorage.put(LottoType.FOURTH_PLACE, 0);
        lottoStorage.put(LottoType.FIFTH_PLACE, 0);

        return new LottoProcessor(lottoStorage);
    }

    public LottoController lottoController() {
        return new LottoController(lottoProcessor(), inputView(), outputView());
    }
}
