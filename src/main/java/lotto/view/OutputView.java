package lotto.view;

import static lotto.util.PrintVariable.BUY_STATUS_STRING;
import static lotto.util.PrintVariable.OUTPUT_START;

import lotto.domain.Lottoes;
import lotto.domain.type.LottoRank;
import lotto.dto.response.LottoCalculateResponse;

public class OutputView {

    public void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public void printLottoesStatus(Lottoes lottoes) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n".concat(String.valueOf(lottoes.getLottoes().size()))).append(BUY_STATUS_STRING.value()).append("\n");

        lottoes.getLottoes().forEach(lotto -> sb.append(lotto.toString()).append("\n"));

        System.out.println(sb);
    }

    public void printLottoResult(LottoCalculateResponse result) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(OUTPUT_START.value()).append("\n---\n");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = result.prizeCounts().getOrDefault(rank, 0);
                sb.append(makePerLottoResult(rank, count));
            }
        }

        sb.append("총 수익률은 ").append(result.earningRate()).append("%입니다.");
        System.out.print(sb);
    }

    private String makePerLottoResult(LottoRank rank, int count) {
        if (rank == LottoRank.FIVE_WITH_BONUS) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s) - %d개\n",
                    rank.getMatchCount(),
                    rank.getFormattedPrize(),
                    count);
        }

        return String.format("%d개 일치 (%s) - %d개\n",
                rank.getMatchCount(),
                rank.getFormattedPrize(),
                count);
    }
}
