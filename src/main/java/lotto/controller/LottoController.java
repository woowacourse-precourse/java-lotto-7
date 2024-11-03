package lotto.controller;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lottos;
import lotto.model.domain.Money;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottoCreationService;
import lotto.model.service.LottoRateService;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.LottoView;

public class LottoController {
    private InputView inputView;
    private LottoView lottoView;
    private LottoCreationService lottoCreationService;
    private LottoRateService lottoRateService;
    private Money money;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonus;

    public LottoController(
            InputView inputView,
            LottoView lottoView,
            LottoCreationService lottoCreationService,
            LottoRateService lottoRateService) {
        this.inputView = inputView;
        this.lottoView = lottoView;
        this.lottoCreationService = lottoCreationService;
        this.lottoRateService = lottoRateService;
    }

    public void run() {
        createMoney();
        createAndPrintLottos();
        createWinningNumbers();
        createBonusNumber();
        calculateRateStatus(lottos,winningNumbers,bonus);
    }

    private void createMoney() {
        while (true) {
            try {
                String inputAmount = inputView.readPurchaseAmount();
                InputValidator.validateInputValue(inputAmount);
                int amount = InputParser.parseNumber(inputAmount);
                money = new Money(amount);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private void createAndPrintLottos() {
        lottos = lottoCreationService.createLottos(money.getAmount());
        int lottoCount = lottoCreationService.calculateLottoCount(money.getAmount());
        lottoView.printTotalLottoCount(lottoCount);
        lottoView.printCreatedLotto(lottos);
    }

    private void createWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                InputValidator.validateInputLottoValue(inputWinningNumbers);
                winningNumbers = InputParser.parseWinningNumbers(inputWinningNumbers);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private void createBonusNumber() {
        while (true) {
            try {
                String inputBonus = inputView.readBonusNumber();
                InputValidator.validateInputValue(inputBonus);
                int bounusNumber = InputParser.parseNumber(inputBonus);
                bonus = new BonusNumber(bounusNumber, winningNumbers);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private void calculateRateStatus(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonus) {
        lottoRateService.calculateRate(lottos, winningNumbers, bonus);
    }

}
