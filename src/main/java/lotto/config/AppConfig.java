package lotto.config;


import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.DefaultLottoFactory;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;
import lotto.service.DtoMapper;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoPurchaseServiceImpl;
import lotto.service.LottoResultService;
import lotto.service.LottoResultServiceImpl;
import lotto.utils.parser.Parser;
import lotto.utils.parser.StringToIntListParser;
import lotto.utils.parser.StringToIntParser;
import lotto.utils.validator.ComparisonValidator;
import lotto.utils.validator.InputValidator;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class AppConfig {
    private final ValidatorConfig validatorConfig = new ValidatorConfig();
    private final DtoMapperConfig dtoMapperConfig = new DtoMapperConfig();


    public LottoNumbersGenerator lottoNumbersGenerator() {
        return new LottoNumbersGenerator();
    }

    public LottoFactory defaultlottoFactory() {
        return new DefaultLottoFactory(lottoNumbersGenerator());
    }


    public OutputView outputView(){
        return new ConsoleOutputView();
    }

    public InputView inputView(){
        return new ConsoleInputView();
    }

    public Parser<Integer> stringToIntparser(){
        return new StringToIntParser();
    }

    public Parser<List<Integer>> stringToIntListParser(){
        return new StringToIntListParser();
    }

    public LottoPurchaseService lottoPurchaseService() {
        DtoMapper<Lottos, LottosDto> lottosDtoMapper = dtoMapperConfig.lottosDtoMapper();
        InputValidator<String> purchaseAmountValidator = validatorConfig.purchaseAmountValidator();
        return new LottoPurchaseServiceImpl(defaultlottoFactory()
                ,lottosDtoMapper,
                purchaseAmountValidator
                ,stringToIntparser());
    }

    public LottoResultService lottoResultService() {
        InputValidator<String> winningNumbersValidator = validatorConfig.WinningNumbersValidator();
        ComparisonValidator bonusNumberValidator = validatorConfig.BonusNumberValidator();

        return new LottoResultServiceImpl(winningNumbersValidator
                ,bonusNumberValidator
                ,stringToIntListParser()
                ,stringToIntparser());
    }

    public LottoGameController lottoGameController() {
        return new LottoGameController(outputView(),inputView(),lottoPurchaseService(),lottoResultService());
    }

}
