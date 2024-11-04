package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoComparator;
import lotto.service.LottoGenerator;
import lotto.service.LottoStatisticsCalculator;
import lotto.util.LottoConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 1. 구입 금액 입력받기
        outputView.printPurchaseMessage();
        int purchaseAmount = inputView.readPurchasePrice();

        // 2. 구입 금액을 로또 개수로 변환하기
        int lottoCount = LottoConverter.convertPriceToLotto(purchaseAmount);

        // 3. 로또 발행하기
        List<Lotto> lottos = LottoGenerator.getRandomLottos(lottoCount);
        outputView.printLottoResult(lottos);

        // 4. 당첨 번호를 입력받기
        outputView.printPickNumberInputMessage();
        Lotto pickNumbers = inputView.readPickNumbers();

        // 5. 보너스 번호 입력 받기
        outputView.printBonusInputMessage();
        int bonusNumber = inputView.readBonusNumber();

        // 6. 당첨여부 확인하기
        List<LottoResult> results = LottoComparator.getLottoResults(lottos, pickNumbers, bonusNumber);

        // 7. 통계 계산 및 출력
        Map<LottoRank, Long> ranks = LottoStatisticsCalculator.calculateRankCounts(results);
        outputView.printLottoCounts(ranks);

        // 8. 수익률 출력
        double profit = LottoStatisticsCalculator.calculateProfitRate(ranks, purchaseAmount);
        outputView.printProfitRate(profit);
    }

}
