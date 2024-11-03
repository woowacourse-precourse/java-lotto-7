package lotto.controller;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lottos;
import lotto.model.domain.Money;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottoService;
import lotto.util.parser.InputParser;
import lotto.view.InputView;
import lotto.view.LottoView;

public class LottoController {
    private InputView inputView;
    private LottoView lottoView;
    private LottoService lottoService;
    private Money money;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonus;

    public LottoController(
            InputView inputView,
            LottoView lottoView,
            LottoService lottoService) {
        this.inputView = inputView;
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void run() {
        createMoney();
        createAndPrintLottos();
        createWinningNumbers();
        createBonusNumber();
    }

    private void createMoney() {
        while (true) {
            try {
                String inputAmount = inputView.readPurchaseAmount();
                int amount = InputParser.parseNumber(inputAmount);
                money = new Money(amount);
                break;
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
            }
        }
    }

    private void createAndPrintLottos() {
        lottos = lottoService.createLottos(money.getAmount());
        int lottoCount = lottoService.calculateLottoCount(money.getAmount());
        lottoView.printTotalLottoCount(lottoCount);
        lottoView.printCreatedLotto(lottos);
    }

    private void createWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                winningNumbers = InputParser.parseWinningNumbers(inputWinningNumbers);
                break;
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
            }
        }
    }

    private void createBonusNumber() {
        while (true) {
            try {
                String inputBonus = inputView.readBonusNumber();
                int bounusNumber = InputParser.parseNumber(inputBonus);
                bonus = new BonusNumber(bounusNumber, winningNumbers);
                break;
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
            }
        }
    }
}
