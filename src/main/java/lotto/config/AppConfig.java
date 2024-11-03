package lotto.config;


import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.ticket.DefaultLottoFactory;
import lotto.domain.ticket.LottoFactory;
import lotto.domain.ticket.LottoNumbersGenerator;
import lotto.domain.ticket.Lottos;
import lotto.dto.LottosDto;
import lotto.service.mapper.DtoMapper;
import lotto.service.puchase.LottoPurchaseService;
import lotto.service.puchase.LottoPurchaseServiceImpl;
import lotto.service.result.LottoResultService;
import lotto.service.result.LottoResultServiceImpl;
import lotto.utils.parser.Parser;
import lotto.utils.parser.StringToIntListParser;
import lotto.utils.parser.StringToIntParser;
import lotto.utils.inputValidator.comparison.ComparisonValidator;
import lotto.utils.inputValidator.InputValidator;
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
