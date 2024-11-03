package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoResultAnalysisService;
import lotto.service.LottoSalesService;

public class LottoController {

    private final LottoSalesService salesService;
    private LottoResultAnalysisService resultAnalysisService;

    public LottoController() {
        this.salesService = new LottoSalesService();
        this.resultAnalysisService = null;
    }

    public void run() {
        int payment = 8000; // TODO: InputView
        int quantity = salesService.getAvailableLottoQuantity(payment);
        List<Lotto> lottos = salesService.createLottos(quantity);

        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6); // TODO: InputView
        int bonusNumber = 7; // TODO: InputView

        // TODO: 개선 요망
        if(resultAnalysisService == null) {
            resultAnalysisService = new LottoResultAnalysisService(winningLottoNumbers, bonusNumber);
        }

        List<Rank> winningResults = resultAnalysisService.generateWinningResults(lottos);
        // TODO: 여기서 보너스 맞히지 못한 로또를 찾기
        String lottoProfitRate = resultAnalysisService.getLottoProfitRate(winningResults, payment);

        // TODO: OutputView
    }
}
