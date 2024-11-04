package lotto.controller;

import lotto.model.domain.*;
import lotto.model.service.LottoCreationService;
import lotto.model.service.LottoResultService;
import lotto.utils.InputParser;
import lotto.utils.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView lottoView;
    private LottoCreationService lottoCreationService;
    private LottoResultService lottoResultService;

    private Money money;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonus;
    private LottoResult lottoResult;

    public LottoController(
            InputView inputView,
            OutputView lottoView,
            LottoCreationService lottoCreationService,
            LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.lottoView = lottoView;
        this.lottoCreationService = lottoCreationService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        money = createMoney();
        lottos = createLottos();
        printLottos();
        winningNumbers = createWinningNumbers();
        bonus = createBonusNumber();
        lottoResult = calculateRateStatus(lottos, winningNumbers, bonus);
        printRateStatus(lottoResult, money);
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

    private LottoResult calculateRateStatus(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonus) {
        return lottoResultService.calculateRate(lottos, winningNumbers, bonus);
    }

    private void printRateStatus(LottoResult lottoResult, Money money) {
        lottoView.printRateStatus(lottoResult);
        double returnPrize = lottoResultService.caculateRateReturn(lottoResult, money);
        lottoView.printRateReturn(returnPrize);
    }
}
