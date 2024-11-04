package lotto.handler;

import java.util.List;
import java.util.Map;
import lotto.view.ResultView;

public class LottoResultHandler {

    public void printLottoSetCount(int lottoSetCount) {
        ResultView.printLottoSetCount(lottoSetCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        ResultView.printLottoNumbers(lottoNumbers);
    }

    public void printMatchResult(Map<String, Integer> matchResults) {
        ResultView.printMatchResult(matchResults);
    }
}
