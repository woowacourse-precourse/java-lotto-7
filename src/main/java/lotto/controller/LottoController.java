package lotto.controller;

import static lotto.utils.InputParser.bonusNumParse;
import static lotto.utils.InputParser.purchaseNumParse;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ProfitCalculator;
import lotto.view.OutputView;

public class LottoController {
    int purchaseNum, bonusNum;
    float profitRate;
    Map<Integer,Integer> matches;
    List<Lotto> lottos;
    Lotto win;

    OutputView outputView = new OutputView();
    LottoGenerator lottoGenerator = new LottoGenerator();
    ProfitCalculator profitCalculator = new ProfitCalculator();

    public void startLotto(){
        purchaseNum = purchaseNumParse();
        lottos= lottoGenerator.lottosGenerate(purchaseNum);
        outputView.printNumberOfPurchase(purchaseNum, lottos);

        win = lottoGenerator.winLottoGenerate();

        bonusNum = bonusNumParse();
        matches=profitCalculator.calculateMatches(lottos,win,bonusNum);
        profitRate=profitCalculator.calculateProfit(matches, purchaseNum);
        outputView.printStatistics(matches,profitRate);
    }


}
