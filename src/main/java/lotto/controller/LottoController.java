package lotto.controller;


import java.util.List;
import lotto.service.LottoService;
import lotto.utils.Parser;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final Integer LOTTO_PRICE = 1000;
    private final Integer ZERO_NUMBER = 0;
    private Integer purchaseAmount;


    public void run(){
        purchaseLotto();
        setWinningLotto(); // todo.
        getLottoResult(); // todo.
    }

    private void purchaseLotto(){
        purchaseAmount = Parser.convertStringToInteger(inputView.readPurchaseAmount());
        Validator.validatePurchaseAmount(purchaseAmount);

        Integer lottoCount = purchaseAmount/ LOTTO_PRICE;
        outputView.printPurchaseLottoMessage(lottoCount);

        for(int i=ZERO_NUMBER; i<lottoCount; i++) {
            List<Integer> numbers = lottoService.publishLotto();
            outputView.printLottoNumber(numbers);
        }
    }

}
