package lotto.view.output;

import java.util.HashMap;
import lotto.model.LottoRank;

public class LottoWinningStatsPrinter {

    public void output(HashMap<String, String> winningResults) {
        OutputMessageEnum.WINNING_STATISTICS.print();
        OutputMessageEnum.STATISTICS_SEPARATOR.print();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                OutputMessageEnum valueOf = OutputMessageEnum.valueOf(rank.name());
                valueOf.printf(winningResults.get(rank.name()), rank.getPrize());
            }
        }
        OutputMessageEnum.TOTAL_RETURN_RATE.printf(winningResults.get("TOTAL_RETURN_RATE"));
    }
}