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

        int purchaseAmount = view.printAndgetPurchaseAmount();
        view.printNumberOfLotto(purchaseAmount);

        List<List<Integer>> lottos = lottoService.publishLotto(purchaseAmount);
        view.printLottos(lottos);


        Lotto lotto = new Lotto(view.getLottoNumber());

        String bonusNumber = view.getBonusNumber();

        Map<LottoRank, Integer> lottoRankMap = lottoService.calculateStatistic(lotto.getNumbers(), Integer.parseInt(bonusNumber), lottos);
        view.printStaticsOfWinning(lottoRankMap.get(LottoRank.Fifth), lottoRankMap.get(LottoRank.Fourth), lottoRankMap.get(LottoRank.Third), lottoRankMap.get(LottoRank.Second), lottoRankMap.get(LottoRank.First));

        double rateOfReturnMoney = lottoService.calculateRateOfReturnMoney(lottoRankMap, purchaseAmount);
        view.printRateOfReturnMoney(rateOfReturnMoney);

    }


}
