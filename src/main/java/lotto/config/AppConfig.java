package lotto.config;


import lotto.domain.DefaultLottoFactory;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;
import lotto.service.DtoMapper;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoPurchaseServiceImpl;
import lotto.utils.validator.Validator;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class AppConfig implements Config{
    private final ValidatorConfig validatorConfig = new ValidatorConfig();
    private final DtoMapperConfig dtoMapperConfig = new DtoMapperConfig();


    public LottoNumbersGenerator lottoNumbersGenerator() {
        return new LottoNumbersGenerator();
    }

    public LottoFactory lottoFactory() {
        return new DefaultLottoFactory(lottoNumbersGenerator());
    }

    public OutputView outputView(){
        return new ConsoleOutputView();
    }

    public InputView inputView(){
        return new ConsoleInputView();
    }

    public LottoPurchaseService lottoPurchaseService() {
        DtoMapper<Lottos, LottosDto> lottosDtoMapper = dtoMapperConfig.lottosDtoMapper();
        Validator<String> purchaseAmountValidator = validatorConfig.purchaseAmountValidator();
        return new LottoPurchaseServiceImpl(lottoFactory(),lottosDtoMapper,purchaseAmountValidator);
    }

}
