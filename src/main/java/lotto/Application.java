package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGameService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.viewHandler.ApiHandler;
import lotto.viewHandler.validator.ValidatorImpl;
import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.validator.validatorImpl.LottoNumberRangeValidator;
import lotto.viewHandler.validator.validatorImpl.LottoNumberSplit;
import lotto.viewHandler.validator.validatorImpl.LottoPurchaseUnitValidator;
import lotto.viewHandler.validator.validatorImpl.ParseInt;

public class Application {
    public static void main(String[] args) {
        UserRequest userRequest = createUserRequest();
        userRequest.runLotto();
    }

    private static UserRequest createUserRequest() {
        return new UserRequest(createLottoController(), createViewHandler());
    }

    private static LottoController createLottoController() {
        return new LottoController(new LottoGameService());
    }

    private static ViewHandler createViewHandler() {
        ApiHandler apiHandler = new ApiHandler(createValiator());
        return new ViewHandler(apiHandler, new Input(), new Output());
    }

    private static ValidatorImpl createValiator() {
        ParseInt parseInt = new ParseInt();
        LottoNumberRangeValidator lottoNumberRangeValidator = new LottoNumberRangeValidator();
        LottoPurchaseUnitValidator lottoPurchaseUnitValidator = new LottoPurchaseUnitValidator();
        LottoNumberSplit lottoNumberSplit = new LottoNumberSplit();
        return new ValidatorImpl(parseInt,
                lottoNumberRangeValidator,
                lottoPurchaseUnitValidator,
                lottoNumberSplit);
    }
}
