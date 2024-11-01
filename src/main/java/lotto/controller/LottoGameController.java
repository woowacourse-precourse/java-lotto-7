package lotto.controller;

import lotto.dto.LottosDto;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
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
        while (true) {
            try{
                String rawPurchaseAmount =  consoleInputView.inputPurchaseAmount();
                lottoPurchaseServiceImpl.purchaseLottos(rawPurchaseAmount);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }

        LottosDto lottosDto = lottoPurchaseServiceImpl.getLottosDto();
        consoleOutputView.outputPurchaseLottoList(lottosDto);

        while (true){
            try {
                String rawWinningNumbers =  consoleInputView.inputWinningNumbers();
                lottoResultServiceImpl.receiveWinningLottoNumbers(rawWinningNumbers);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }

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
