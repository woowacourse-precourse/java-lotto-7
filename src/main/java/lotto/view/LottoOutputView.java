package lotto.view;

import static lotto.constant.LottoInfoMsg.PROFIT_RATE_PRINT_FORM;
import static lotto.constant.LottoInfoMsg.START_PRINT_LOTTO_NUMBERS;
import static lotto.constant.LottoInfoMsg.START_PRINT_MATCHED_RESULT;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoInfoMsg;
import lotto.constant.LottoRanking;
import lotto.model.Lotto;

public class LottoOutputView {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(START_PRINT_LOTTO_NUMBERS.getMsg().formatted(lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printFinalResult(Map<LottoRanking, Integer> matchedResult, double profitRate) {
        printMatchedResult(matchedResult);
        printProfitRate(profitRate);
    }

    private void printMatchedResult(Map<LottoRanking, Integer> matchedResult) {
        StringBuilder sb = new StringBuilder();

        sb.append(START_PRINT_MATCHED_RESULT.getMsg());
        for (LottoRanking rank : LottoRanking.values()) {
            if (rank == LottoRanking.NONE_RANK) {
                continue;
            }
            Integer count = matchedResult.get(rank);
            sb.append(LottoInfoMsg.getMatchedResultMsgByForm(rank, count));
        }

        System.out.print(sb);
    }

    private void printProfitRate(double profitRate) {
        System.out.print(PROFIT_RATE_PRINT_FORM.getMsg().formatted(profitRate));
    }
}
