package lotto;

public class LottoGameAppConfig {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final LottoService lottoService = new LottoService();
    private static final LottoController lottoController = new LottoController(lottoService,outputView,inputView);

    private LottoGameAppConfig() {
    }

    public static LottoController getLottoController() {
        return lottoController;
    }
}
