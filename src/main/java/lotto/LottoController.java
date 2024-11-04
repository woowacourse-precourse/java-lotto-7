package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {

    public View view;
    public LottoService lottoService;

    public StringParser stringParser;

    LottoController(View view, LottoService lottoService, StringParser stringParser) {
        this.view = view;
        this.lottoService = lottoService;
        this.stringParser = stringParser;
    }

    public void run() {

        String purchaseAmount = view.printAndgetPurchaseAmount();
        int amount = lottoService.calCulateLottoAmount(stringParser.convertStringToInt(purchaseAmount));

        view.printNumberOfLotto(amount);

        List<List<Integer>> lottos = lottoService.publishLotto(amount);
        view.printLottos(lottos);

        String winningNumber = view.getLottoNumber();
        Lotto lotto = new Lotto(stringParser.convertStringToIntegerList(winningNumber));

        String bonusNumber = view.getBonusNumber();

        Map<LottoRank, Integer> lottoRankMap = lottoService.calculateStatistic(lotto.getNumbers(), Integer.parseInt(bonusNumber), lottos);
        view.printStaticsOfWinning(lottoRankMap.get(LottoRank.Fifth), lottoRankMap.get(LottoRank.Fourth), lottoRankMap.get(LottoRank.Third), lottoRankMap.get(LottoRank.Second), lottoRankMap.get(LottoRank.First));

        double rateOfReturnMoney = lottoService.calculateRateOfReturnMoney(lottoRankMap, amount * 1000);
        view.printRateOfReturnMoney(rateOfReturnMoney);

    }


}
