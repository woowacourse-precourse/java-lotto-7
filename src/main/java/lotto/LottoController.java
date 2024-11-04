package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.exception.LottoExceptionMessage;
import lotto.service.LottoResultAnalysisService;
import lotto.service.LottoSalesService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoSalesService salesService;
    private LottoResultAnalysisService resultAnalysisService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.salesService = new LottoSalesService();
        this.resultAnalysisService = null;
    }

    public void run() {
        List<Lotto> lottos = runLottoSalesService();
        runResultAnalysisService(lottos);
        terminateController();
    }

    private List<Lotto> runLottoSalesService() {
        List<Lotto> lottos;
        while (true) {
            int payment = getPayment();
            try {
                lottos = getLotto(payment);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            } catch (Exception e) {
                OutputView.printExceptionMessage(LottoExceptionMessage.THROWING_UNEXPECTED_EXCEPTION);
            }
        }
        return lottos;
    }

    private void runResultAnalysisService(List<Lotto> lottos) {
        int payment = salesService.getPayment();
        while (true) {
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            try {
                showWinningResult(winningNumbers, bonusNumber, lottos, payment);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            } catch (Exception e) {
                OutputView.printExceptionMessage(LottoExceptionMessage.THROWING_UNEXPECTED_EXCEPTION);
            }
        }
    }

    private void terminateController() {
        inputView.closeConsole();
    }

    private int getPayment() {
        outputView.printPaymentRequestMessage();
        return inputView.readPayment();
    }

    private List<Lotto> getLotto(int payment) {
        List<Lotto> lottos;

        int quantity = salesService.getAvailableLottoQuantity(payment);
        lottos = salesService.createLottos(quantity);
        outputView.printLottoDetails(lottos);

        return lottos;
    }


    private List<Integer> getWinningNumbers() {
        outputView.printWinningNumbersRequestMessage();
        return inputView.readWinningNumbers();
    }

    private int getBonusNumber() {
        outputView.printBonusNumberRequestMessage();
        return inputView.readBonusNumber();
    }

    private void showWinningResult(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos, int payment) {
        setLottoResultAnalysisService(winningNumbers, bonusNumber);

        List<Rank> winningResults = resultAnalysisService.generateWinningResults(lottos);
        List<Integer> winningStatistics = resultAnalysisService.getWinningStatistics(winningResults);
        String lottoProfitRate = resultAnalysisService.getLottoProfitRate(winningResults, payment);

        outputView.printWinningResults(winningStatistics, lottoProfitRate);
    }

    private void setLottoResultAnalysisService(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (resultAnalysisService == null) {
            resultAnalysisService = new LottoResultAnalysisService(winningLottoNumbers, bonusNumber);
        }
    }
}
