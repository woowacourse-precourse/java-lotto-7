package lotto.controller;


import java.util.List;
import lotto.domain.LottoResult;
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
        setWinningLotto();
        getLottoResult();
    }

    private void purchaseLotto(){
        readPurchaseAmount();

        Integer lottoCount = purchaseAmount/ LOTTO_PRICE;
        outputView.printPurchaseLottoMessage(lottoCount);

        for(int i=ZERO_NUMBER; i<lottoCount; i++) {
            List<Integer> numbers = lottoService.publishLotto();
            outputView.printLottoNumber(numbers);
        }
    }

    private void readPurchaseAmount(){
        while(true){
            try {
                purchaseAmount = Parser.convertStringToInteger(inputView.readPurchaseAmount());
                Validator.validatePurchaseAmount(purchaseAmount);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void setWinningLotto(){
        List<Integer> winningNumbers = readWinningNumber();
        Integer bonusNumber = readBonusNumber();

        Validator.validateBonusNumberInWinningNumber(winningNumbers, bonusNumber);
        lottoService.setNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumber(){
        List<Integer> winningNumbers;

        while(true) {
            try {
                winningNumbers = Parser.convertStringToList(inputView.readWinningNumber());
                Validator.validateWinningNumber(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private Integer readBonusNumber(){
        Integer bonusNumber;

        while(true) {
            try {
                bonusNumber = Parser.convertStringToInteger(inputView.readBonusNumber());
                Validator.validateBonusNumber(bonusNumber);
                return bonusNumber;

            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void getLottoResult(){
        List<LottoResult> results = lottoService.calcLottoResults();
        double profitSum = (double) lottoService.getSumLottoProfits(results);
        double profitRatio = (profitSum / purchaseAmount) * 100;

        outputView.printLottoResults(results);
        outputView.printRateOfReturn(String.format("%.1f", profitRatio));
    }


}
