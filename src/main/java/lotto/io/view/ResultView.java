package lotto.io.view;

import lotto.dto.PrizeRankInfoDto;
import lotto.dto.ResultDto;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final ResultView INSTANCE = new ResultView();
    private static final String FORMAT = " (%,d원) - %d개";
    private static final String START = """
            
            당첨 통계
            ---
            """;
    private static final String PROFIT_FORMAT = "\n총 수익률은 %.1f%%입니다.";

    private ResultView() {
    }

    public static ResultView getInstance() {
        return INSTANCE;
    }

    public void show(ResultDto resultDto) {
        Map<PrizeRankInfoDto, Integer> prizeRankCounts = resultDto.prizeRankCounts();
        String statisticMessage = generateStatisticMessage(prizeRankCounts);
        String profitMessage = String.format(PROFIT_FORMAT, resultDto.profitRatio() * 100);
        System.out.print(START + statisticMessage + profitMessage);
    }

    private String generateStatisticMessage(Map<PrizeRankInfoDto, Integer> prizeRankCounts) {
        return prizeRankCounts.entrySet()
                .stream()
                .filter(entry -> entry.getKey().prize() > 0)
                .sorted(Comparator.comparing((Map.Entry<PrizeRankInfoDto, Integer> entry) -> entry.getKey().prize()).reversed())
                .map(this::generateDisplayMessage)
                .collect(Collectors.joining("\n"));
    }

    private String generateDisplayMessage(Map.Entry<PrizeRankInfoDto, Integer> entry) {
        return entry.getKey().description() + String.format(FORMAT, entry.getKey().prize(), entry.getValue());
    }
}
