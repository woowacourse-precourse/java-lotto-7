package lotto.factory;


import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public static LottoController createLottoController() {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new LottoController(lottoService, inputView, outputView);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static LottoCollection createLottoCollection() {
        return new LottoCollection();
    }
}
