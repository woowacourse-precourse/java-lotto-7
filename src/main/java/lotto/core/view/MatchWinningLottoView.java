package lotto.core.view;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.core.dto.LottoResultDto;
import lotto.core.model.WinningRank;

public class MatchWinningLottoView implements View<LottoResultDto> {

    @Override
    public void display(LottoResultDto content) {
        displayHeader();
        displayWinningResult(content);
        displayRateOfReturn(content);
    }

    private void displayHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private void displayWinningResult(LottoResultDto content) {
        List<WinningRank> winningRanks = content.winningRanks();
        Map<WinningRank, Integer> winningRankCountMap = new LinkedHashMap<>();
        for (WinningRank winningRank: winningRanks) {
            winningRankCountMap.put(winningRank, 0);
        }
        for (WinningRank winningRank : winningRanks) {
            winningRankCountMap.computeIfPresent(winningRank, (key, value) -> value + 1);
        }

        List<WinningRank> sortedRanks = Arrays.stream(WinningRank.values())
                .sorted((a, b) -> b.getRank() - a.getRank())
                .toList();
        StringBuilder builder = new StringBuilder();
        for (WinningRank rank : sortedRanks) {
            String format = rank.formatDisplay();
            builder.append(format);
            builder.append(" - ");
            builder.append(winningRankCountMap.getOrDefault(rank, 0));
            builder.append("개");
            builder.append("\n");
        }
        System.out.print(builder);
    }

    private void displayRateOfReturn(LottoResultDto content) {
        String combinedContent = "총 수익률은 " + content.rateOfReturn() + "%입니다.";
        System.out.println(combinedContent);
    }
}
