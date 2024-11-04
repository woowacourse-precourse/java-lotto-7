package lotto.controller;

import lotto.model.LottoBundle;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.ProfitCalculator;
import lotto.model.WinningNumbers;

import lotto.service.LottoService;
import lotto.service.LottoResultService;
import lotto.service.ProfitCalculatorService;


import lotto.validation.LottoAmountValidator;
import lotto.validation.LottoNumberValidator;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private final ProfitCalculatorService profitCalculatorService;

    public LottoController(final InputView inputView, final OutputView outputView,
                           final LottoService lottoService, final LottoResultService lottoResultService,
                           final ProfitCalculatorService profitCalculatorService) {
       this.inputView = inputView;
        this.outputView = outputView;
       this.lottoService = lottoService;
       this.lottoResultService = lottoResultService;
       this.profitCalculatorService = profitCalculatorService;
    }

    public void start(){
        int lottoAmount = inputAmount();
        List<Integer> lottoNumberList = inputLottoNumberList();
        int lottoBonusNumber = inputBonusNumber(lottoNumberList);

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumberList, lottoBonusNumber);
        LottoBundle lottoBundle = new LottoBundle(lottoService.responseLottoTicket(lottoAmount));
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, lottoBundle);

        printLottoBundleDetails(lottoAmount,lottoBundle);

        LottoResult result = new LottoResult();
        lottoResultService.countMatchingNumbers(lottoMachine.getLottoBundle().getPurchasedLottos(),
        lottoMachine.getWinningNumbers(),result);

        printLottoResult(result, lottoAmount);

    }

    private void printLottoBundleDetails(int lottoAmount, LottoBundle lottoBundle) {
        outputView.printLottoCountPurchased(lottoAmount);
        outputView.printLottoBundle(lottoBundle);
    }

    private void printLottoResult(LottoResult result, int lottoAmount){
        ProfitCalculator profitCalculator = new ProfitCalculator(lottoAmount, result);
        double profit = profitCalculatorService.resultProfit(result, lottoAmount);
        outputView.printLottoResult(result);
        outputView.printLottoProfit(profit);
    }

    private Integer inputAmount(){
        String input = inputView.inputLottoAmount();
       return LottoAmountValidator.validateLottoAmount(input);

    }

    private List<Integer> inputLottoNumberList(){
        String input = inputView.inputLottoNumbers();
        return LottoNumberValidator.validateLottoNumbers(input);
    }

    private Integer inputBonusNumber(List<Integer> list){
        int bonusNumber = inputView.inputLottoBonusNumber();
        return LottoNumberValidator.validateBonusNumber(list,bonusNumber);
    }

}
