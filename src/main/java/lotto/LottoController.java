package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {

    public View view;
    public LottoService lottoService;

    LottoController(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void run() {

        String purchaseAmount = view.printAndgetPurchaseAmount();
        int amount = lottoService.calCulateLottoAmount(purchaseAmount);

        view.printNumberOfLotto(amount);

        List<List<Integer>> lottos = lottoService.publishLotto(amount);
        view.printLottos(lottos);

        String winningNumber = view.getLottoNumber();
        String bonusNumber = view.getBonusNumber();

        Map<LottoRank, Integer> lottoRankMap = lottoService.calculateStatistic(winningNumber, Integer.parseInt(bonusNumber), lottos);
        view.printStaticsOfWinning(lottoRankMap.get(LottoRank.Fifth), lottoRankMap.get(LottoRank.Fourth), lottoRankMap.get(LottoRank.Third), lottoRankMap.get(LottoRank.Second), lottoRankMap.get(LottoRank.First));

        double rateOfReturnMoney = lottoService.calculateRateOfReturnMoney(lottoRankMap, amount * 1000);
        view.printRateOfReturnMoney(rateOfReturnMoney);

    }


}
