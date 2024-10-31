package lotto;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(LottoService lottoService, OutputView outputView, InputView inputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        payMoneyAndBuyLotto();
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        lottoService.findAnswer(winningNumbers,bonusNumber);
    }

    private void payMoneyAndBuyLotto() {
        long userInputMoney = inputView.getUserInputMoney();
        Lottos lottos = lottoService.buyLottos(userInputMoney);
        outputView.displayBuyResult(lottos);
    }

    private WinningNumbers getWinningNumbers() {
        String inputWinningNumbers = inputView.getWinningNumbers();
        return new WinningNumbers(inputWinningNumbers);
    }

    private BonusNumber getBonusNumber() {
        String inputBonusNumber = inputView.getBonusNumber();
        return new BonusNumber(inputBonusNumber);
    }
}
