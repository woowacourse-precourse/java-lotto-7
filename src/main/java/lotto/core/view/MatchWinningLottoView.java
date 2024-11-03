package lotto.core.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.core.dto.LottoResultDto;
import lotto.core.enums.WinningRank;

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
        Map<WinningRank, Integer> winningRankCountMap = groupByRank(content.winningRanks());
        List<WinningRank> sortedRanks = WinningRank.sortedListByRankDescending();
        String rankContent = buildContent(winningRankCountMap, sortedRanks);
        System.out.print(rankContent);
    }

    private Map<WinningRank, Integer> groupByRank(List<WinningRank> winningRanks) {
        Map<WinningRank, Integer> winningRankCountMap = new LinkedHashMap<>();
        for (WinningRank winningRank: winningRanks) {
            winningRankCountMap.merge(winningRank, 1, Integer::sum);
        }
        return winningRankCountMap;
    }

    private String buildContent(Map<WinningRank, Integer> winningRankCountMap, List<WinningRank> winningRanks) {
        StringBuilder builder = new StringBuilder();
        for (WinningRank rank : winningRanks) {
            String format = rank.formatDisplay();
            builder.append(format);
            builder.append(" - ");
            builder.append(winningRankCountMap.getOrDefault(rank, 0));
            builder.append("개");
            builder.append("\n");
        }
        return builder.toString();
    }

    private void displayRateOfReturn(LottoResultDto content) {
        String combinedContent = "총 수익률은 " + content.rateOfReturn() + "%입니다.";
        System.out.println(combinedContent);
    }
}
