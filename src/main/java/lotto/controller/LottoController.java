package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoResultPrinter;
import lotto.view.LottoView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private final LottoResultPrinter lottoResultPrinter;
    private final LottoView lottoView;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.lottoResultService = new LottoResultService();
        this.lottoResultPrinter = new LottoResultPrinter();
        this.lottoView = new LottoView();
    }


    public void run() {
        // 1. 구입 금액 입력 및 로또 발행
        long purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = getLottos(purchaseAmount);

        // 2. 발행된 로또 번호 출력
        PrintPurchasedLottos(lottos);

        // 3. 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        // 4. 당첨 결과 계산
        Map<Rank, Integer> resultCount = getResultCount(lottos, winningNumbers, bonusNumber);
        int totalPrize = getTotalPrize(resultCount);

        // 5. 결과 출력
        getPrintResult(resultCount, totalPrize, purchaseAmount);
    }

    private long getPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    private List<Lotto> getLottos(long purchaseAmount) {
        return lottoService.generateLottos(purchaseAmount);
    }

    private void PrintPurchasedLottos(List<Lotto> lottos) {
        lottoView.printPurchasedLottos(lottos);
    }

    private List<Integer> getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        return inputView.getBonusNumber(winningNumbers);
    }

    private Map<Rank, Integer> getResultCount(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottoResultService.calculateWinningResults(lottos, winningNumbers, bonusNumber);
    }

    private int getTotalPrize(Map<Rank, Integer> resultCount) {
        return lottoResultService.calculateTotalPrize(resultCount);
    }

    private void getPrintResult(Map<Rank, Integer> resultCount, int totalPrize, long purchaseAmount) {
        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
    }
}
