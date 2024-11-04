package lotto.controller;

import lotto.model.*;
import lotto.service.*;
import lotto.validation.LottoAmountValidator;
import lotto.validation.LottoNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private final ProfitCalculatorService profitCalculatorService;

    public LottoController() {
       this.outputView = new OutputView();
       this.inputView = new InputView();
       this.lottoService = new LottoService();
       this.lottoResultService = new LottoResultService();
       this.profitCalculatorService = new ProfitCalculatorService();
    }

    public void start(){
        // 로또 금액
        int lottoAmount = inputAmount();
        List<Integer> lottoNumberList = inputLottoNumberList();
        int lottoBonusNumber = inputBonusNumber(lottoNumberList);

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumberList, lottoBonusNumber);
        LottoBundle lottoBundle = new LottoBundle(lottoService.responseLottoTicket(lottoAmount));
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, lottoBundle);

        printLottoStatus(lottoAmount,lottoBundle);

        LottoResult result = new LottoResult();
        lottoResultService.countMatchingNumbers(lottoMachine.getLottoBundle().getPurchasedLottos(),
        lottoMachine.getWinningNumbers(),result);

        printLottoResults(result, lottoAmount);

    }

    private void printLottoStatus(int lottoAmount, LottoBundle lottoBundle) {
        outputView.printLottoCountPurchased(lottoAmount);
        outputView.printLottoBundle(lottoBundle);
    }

    private void printLottoResults(LottoResult result, int lottoAmount){
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

    private void inputLottoAmount(){
        inputView.inputLottoAmount();
    }

}
