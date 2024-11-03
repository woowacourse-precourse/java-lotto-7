package lotto.view;

import static lotto.util.PrintVariable.BUY_STATUS_FORMAT;
import static lotto.util.PrintVariable.EARNING_RESULT_FORMAT;
import static lotto.util.PrintVariable.LOTTO_RESULT_FORMAT;
import static lotto.util.PrintVariable.LOTTO_RESULT_WITH_BONUS_FORMAT;
import static lotto.util.PrintVariable.OUTPUT_START;
import static lotto.util.PrintVariable.RESULT_START_FORMAT;

import lotto.domain.Lottoes;
import lotto.domain.type.LottoRank;
import lotto.dto.response.LottoCalculateResponse;

public class OutputView {

    public void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public void printLottoesStatus(Lottoes lottoes) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(BUY_STATUS_FORMAT.value(), lottoes.getLottoes().size()));
        lottoes.getLottoes().forEach(lotto -> sb.append(lotto.toString()).append("\n"));

        System.out.println(sb);
    }

    public void printLottoResult(LottoCalculateResponse result) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RESULT_START_FORMAT.value(), OUTPUT_START.value()));

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = result.prizeCounts().getOrDefault(rank, 0);
                sb.append(makePerLottoResult(rank, count));
            }
        }

        sb.append(String.format(EARNING_RESULT_FORMAT.value(), result.earningRate()));
        System.out.print(sb);
    }

    private String makePerLottoResult(LottoRank rank, int count) {
        if (rank == LottoRank.FIVE_WITH_BONUS) {
            return String.format(LOTTO_RESULT_WITH_BONUS_FORMAT.value(),
                    rank.getMatchCount(),
                    rank.getFormattedPrize(),
                    count);
        }

        return String.format(LOTTO_RESULT_FORMAT.value(),
                rank.getMatchCount(),
                rank.getFormattedPrize(),
                count);
    }
}
