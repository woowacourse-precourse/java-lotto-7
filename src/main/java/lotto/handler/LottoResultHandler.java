package lotto.handler;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;
import lotto.view.ResultView;

public class LottoResultHandler {

    public void printLottoSetCount(int lottoSetCount) {
        ResultView.printLottoSetCount(lottoSetCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        ResultView.printLottoNumbers(lottoNumbers);
    }

    public void printMatchResult(Map<LottoRank, Integer> matchResults) {
        ResultView.printMatchResult(matchResults);
    }

    public void printProfitRate(double profitRate){
        ResultView.printProfitRate(profitRate);
    }
}
