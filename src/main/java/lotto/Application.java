package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoFacade;
import lotto.service.LottoFacadeImpl;
import lotto.service.issuing.LottoIssuingService;
import lotto.service.issuing.LottoIssuingServiceImpl;
import lotto.service.prize.TotalPrizeCalculatorService;
import lotto.service.prize.TotalPrizeCalculatorServiceImpl;
import lotto.service.winningCheck.WinningCheckService;
import lotto.service.winningCheck.WinningCheckServiceImpl;
import lotto.service.winningStatistic.WinningStatisticService;
import lotto.service.winningStatistic.WinningStatisticServiceImpl;
import lotto.strategy.number.LottoNumberGeneratorStrategy;
import lotto.strategy.number.RandomLottoNumberGenerator;
import lotto.validator.BonusNumberInputValidator;
import lotto.validator.CostInputValidator;
import lotto.validator.CostValidator;
import lotto.validator.NumbersInputValidator;
import lotto.validator.Validator;
import lotto.validator.ValidatorFacade;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ViewFacade;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ViewFacade viewFacade = createViewFacade();
        LottoFacade lottoFacade = createLottoFacade();
        ValidatorFacade validatorFacade = createValidatorFacade();

        LottoController lottoController = new LottoController(viewFacade, lottoFacade, validatorFacade);
        lottoController.run();
    }

    private static ViewFacade createViewFacade() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new ViewFacade(inputView, outputView);
    }

    private static LottoFacade createLottoFacade() {
        LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy = new RandomLottoNumberGenerator();
        LottoIssuingService lottoIssuingService = new LottoIssuingServiceImpl(lottoNumberGeneratorStrategy);

        WinningCheckService winningCheckService = new WinningCheckServiceImpl();
        TotalPrizeCalculatorService totalPrizeCalculatorService = new TotalPrizeCalculatorServiceImpl(
                winningCheckService);
        WinningStatisticService winningStatisticService = new WinningStatisticServiceImpl(totalPrizeCalculatorService);

        return new LottoFacadeImpl(lottoIssuingService, winningStatisticService);
    }

    private static ValidatorFacade createValidatorFacade() {
        Validator<String> bonusNumberInputValidator = new BonusNumberInputValidator();
        Validator<String> costInputValidator = new CostInputValidator();
        Validator<Integer> costValidator = new CostValidator();
        Validator<String> numberInputValidator = new NumbersInputValidator();

        return new ValidatorFacade(bonusNumberInputValidator, costInputValidator, costValidator, numberInputValidator);
    }
}
