package lotto.io.output;

import java.text.DecimalFormat;
import java.util.Map;

public class WinningResultStatisticsOutputConsoleHandler {
    private final DecimalFormat df = new DecimalFormat("#.0%");

    public void showWinningResultStatistics(Map<String, Long> matchingCounts, double revenue) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Long nunOfFirst = matchingCounts.get("1등");
        Long numOfSecond = matchingCounts.get("2등");
        Long numOfThird = matchingCounts.get("3등");
        Long numOfFourth = matchingCounts.get("4등");
        Long numOfFIFTH = matchingCounts.get("5등");

        String resultView = String.format("3개 일치 (5,000원) - %d개" + System.lineSeparator()
                        + "4개 일치 (50,000원) - %d개" + System.lineSeparator()
                        + "5개 일치 (1,500,000원) - %d개" + System.lineSeparator()
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" + System.lineSeparator()
                        + "6개 일치 (2,000,000,000원) - %d개"
                , nunOfFirst, numOfSecond, numOfThird, numOfFourth, numOfFIFTH
        );

        System.out.println(resultView);
    }


}
