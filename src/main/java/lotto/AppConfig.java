package lotto;

import lotto.controller.LottoController;
import lotto.domain.Exchanger;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final int MINIMUM_LOTTO_NUMBER;
    private final int MAXIMUM_LOTTO_NUMBER;
    private final Long LOTTO_PRICE;

    private InputView inputView;
    private OutputView outputView;
    private LottoGenerator lottoGenerator;
    private RandomNumberGenerator randomNumberGenerator;
    private Exchanger exchanger;
    private LottoService lottoService;
    private LottoController lottoController;

    public AppConfig(int MINIMUM_LOTTO_NUMBER, int MAXIMUM_LOTTO_NUMBER, Long LOTTO_PRICE) {
        this.MINIMUM_LOTTO_NUMBER = MINIMUM_LOTTO_NUMBER;
        this.MAXIMUM_LOTTO_NUMBER = MAXIMUM_LOTTO_NUMBER;
        this.LOTTO_PRICE = LOTTO_PRICE;
    }

    public static AppConfig getInstance(int MINIMUM_LOTTO_NUMBER, int MAXIMUM_LOTTO_NUMBER, Long LOTTO_PRICE) {
        return new AppConfig(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_PRICE);
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public RandomNumberGenerator randomNumberGenerator() {
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new RandomNumberGenerator(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
        }
        return randomNumberGenerator;
    }

    public LottoGenerator lottoGenerator() {
        if (lottoGenerator == null) {
            lottoGenerator = new LottoGenerator(randomNumberGenerator(), LOTTO_PRICE);
        }
        return lottoGenerator;
    }

    public Exchanger exchanger() {
        if (exchanger == null) {
            exchanger = new Exchanger();
        }
        return exchanger;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            lottoService = new LottoService(lottoGenerator(), exchanger());
        }
        return lottoService;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoService());
        }
        return lottoController;
    }

}
