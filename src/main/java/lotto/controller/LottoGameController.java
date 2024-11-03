package lotto.controller;

import lotto.dto.FinalResultsDto;
import lotto.dto.LottosDto;
import lotto.service.puchase.LottoPurchaseService;
import lotto.service.result.LottoResultService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private final LottoPurchaseService lottoPurchaseServiceImpl;
    private final LottoResultService lottoResultServiceImpl;
    private final InputView consoleInputView;
    private final OutputView consoleOutputView;

    public LottoGameController(OutputView consoleOutputView
            , InputView consoleInputView
            , LottoPurchaseService lottoPurchaseServiceImpl
            , LottoResultService lottoResultServiceImpl) {

        this.lottoPurchaseServiceImpl = lottoPurchaseServiceImpl;
        this.lottoResultServiceImpl = lottoResultServiceImpl;
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;

    }

    public void run (){

        LottosDto lottosDto = executeLottoPurchase();
        consoleOutputView.outputPurchaseLottoList(lottosDto);

        handleWinningNumbersInput();
        handleBonusNumberInput();

        FinalResultsDto finalResultsDto =  lottoResultServiceImpl.getFinalResultsDto(lottosDto);
        consoleOutputView.outputFinalResult(finalResultsDto);

    }

    private LottosDto executeLottoPurchase(){
        while (true) {
            try{
                String rawPurchaseAmount =  consoleInputView.inputPurchaseAmount();
                lottoPurchaseServiceImpl.purchaseLottos(rawPurchaseAmount);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }
        return lottoPurchaseServiceImpl.getLottosDto();
    }

    private void handleWinningNumbersInput(){
        while (true){
            try {
                String rawWinningNumbers =  consoleInputView.inputWinningNumbers();
                lottoResultServiceImpl.receiveWinningLottoNumbers(rawWinningNumbers);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }
    }

    private void handleBonusNumberInput(){
        while (true){
            try{
                String rawBonusNumber =  consoleInputView.inputBonusNumber();
                lottoResultServiceImpl.receiveBonusNumber(rawBonusNumber);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }
    }
}
