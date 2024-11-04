package global.view;

import static global.constant.GlobalStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoInfoMsg.PROFIT_RATE_PRINT_FORM;
import static lotto.constant.LottoInfoMsg.START_PRINT_LOTTO_NUMBERS;
import static lotto.constant.LottoInfoMsg.START_PRINT_MATCHED_RESULT;

import global.exception.ErrorCode;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoInfoMsg;
import lotto.constant.LottoRank;
import lotto.model.Lotto;

public class OutputView {

    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(START_PRINT_LOTTO_NUMBERS.getMsg().formatted(lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printFinalResult(Map<LottoRank, Integer> matchedResult, double profitRate) {
        printMatchedResult(matchedResult);
        printProfitRate(profitRate);
    }

    public static void printErrorMsgWithReason(ErrorCode errorCode, String reason) {
        System.out.println(ERROR_MSG_PREFIX + errorCode.getMsg() + " => " + reason);
    }

    private static void printMatchedResult(Map<LottoRank, Integer> matchedResult) {
        StringBuilder sb = new StringBuilder();

        sb.append(START_PRINT_MATCHED_RESULT.getMsg());
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE_RANK) {
                continue;
            }
            Integer count = matchedResult.get(rank);
            sb.append(LottoInfoMsg.getMatchedResultMsgByForm(rank, count));
        }

        System.out.print(sb);
    }

    private static void printProfitRate(double profitRate) {
        System.out.print(PROFIT_RATE_PRINT_FORM.getMsg().formatted(profitRate));
    }
}