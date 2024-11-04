package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;

public class OutputView {

    private final LottoService lottoService;

    public OutputView(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int lottoCount(int purchasePrice) {
        int lottoCount = lottoService.calculateLottoCount(purchasePrice);
        System.out.printf(Constant.LOTTO_PURCHASE_PRINT_MESSAGE, lottoCount);
        return lottoCount;
    }

    public void printLottos(int purchasePrice) {
        List<Lotto> lottos = lottoService.createLottos(purchasePrice);
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    public void printWinningResults(int purchasePrice) {
        System.out.println(Constant.WINNING_RESULT_MESSAGE);
        List<Lotto> lottos = lottoService.createLottos(purchasePrice);
        Map<LottoRank, Integer> resultCount = lottoService.calculateTotalWinnings(lottos);
        NumberFormat nf = NumberFormat.getInstance();
        for (LottoRank lottoRank : resultCount.keySet()) {
            if(lottoRank.name().equals("SECOND")) {
                System.out.printf(Constant.SECOND_RANK_COUNT + "\n", lottoRank.getSameNumberCount(), nf.format(lottoRank.getWinningPrice()),
                        resultCount.get(lottoRank));
                continue;
            }
            System.out.printf(Constant.EACH_RANK_COUNT + "\n", lottoRank.getSameNumberCount(), nf.format(lottoRank.getWinningPrice()),
                    resultCount.get(lottoRank));
        }
        System.out.printf(Constant.RATE_OF_RETURN_MESSAGE, lottoService.calculateRateOfReturn(resultCount, purchasePrice));
    }
}
