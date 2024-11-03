package lotto.io.impl;

import lotto.domain.Lotto;
import lotto.domain.ResultCount;
import lotto.io.Output;
import lotto.domain.enums.WinningStatistics;

import java.util.Map;

public class ConsoleOutput implements Output {

    private static ConsoleOutput output;

    private ConsoleOutput() {

    }

    public static ConsoleOutput getInstance(){
        if(output == null)
            output = new ConsoleOutput();

        return output;
    }

    @Override
    public void completePurchase(int num) {
        System.out.println(num+ "개를 구매했습니다.");
    }

    @Override
    public void printLotto(Lotto lotto) {

        String[] intToStr = lotto.getNumbers().stream().map(String::valueOf)
                .toArray(String[]::new);

        String printLotto = String.join(", ", intToStr);

        System.out.print("[");
        System.out.print(printLotto);
        System.out.println("]");
    }

    @Override
    public void printWinningStatistics(ResultCount resultCount, int lottoPrize) {

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<WinningStatistics, Integer> resultMap = resultCount.getResults();
        WinningStatistics[] grades = WinningStatistics.values();
        for(WinningStatistics grade : grades) {
            if(grade == WinningStatistics.FIVE_MATCHES_WITH_BONUS)
                System.out.print(grade.getCnt() + "개 일치, 보너스 볼 일치 (" + grade.getFormatPrizeMoney() +"원)");
            if(grade != WinningStatistics.FIVE_MATCHES_WITH_BONUS)
                System.out.print(grade.getCnt() + "개 일치 (" + grade.getFormatPrizeMoney() +"원)");
            System.out.println(" - " + resultMap.get(grade) + "개");
        }
        float returnRate = resultCount.getReturnRate(lottoPrize) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");
    }

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
