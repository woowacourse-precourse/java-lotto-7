package lotto.controller;

import lotto.model.domain.*;
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
    private Rate rate;

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
        money = createMoney();
        lottos = createLottos();
        printLottos();
        winningNumbers = createWinningNumbers();
        bonus = createBonusNumber();
        rate = calculateRateStatus(lottos, winningNumbers, bonus);
        printRateStatus(rate, money);
    }

    private Money createMoney() {
        while (true) {
            try {
                String inputAmount = inputView.readPurchaseAmount();
                InputValidator.validateInputValue(inputAmount);
                int amount = InputParser.parseNumber(inputAmount);
                return new Money(amount);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private Lottos createLottos() {
        return lottoCreationService.createLottos(money.getAmount());

    }

    private void printLottos() {
        int lottoCount = lottoCreationService.calculateLottoCount(money.getAmount());
        lottoView.printTotalLottoCount(lottoCount);
        lottoView.printCreatedLotto(lottos);
    }

    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                InputValidator.validateInputLottoValue(inputWinningNumbers);
                return InputParser.parseWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                String inputBonus = inputView.readBonusNumber();
                InputValidator.validateInputValue(inputBonus);
                int bounusNumber = InputParser.parseNumber(inputBonus);
                return new BonusNumber(bounusNumber, winningNumbers);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private Rate calculateRateStatus(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonus) {
        return lottoRateService.calculateRate(lottos, winningNumbers, bonus);
    }

    private void printRateStatus(Rate rate, Money money) {
        lottoView.printRateStatus(rate);
        double returnPrize = lottoRateService.caculateRateReturn(rate, money);
        lottoView.printRateReturn(returnPrize);
    }

}
