package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Reward;
import lotto.model.WinningResult;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.console.ConsoleManager.*;

public class OutputView {
    public void displayCount(int count){
        println(count + "개를 구매했습니다.");
    }
    public void displayLotto(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Number> numbers = lotto.getNumbers();
            String line = getDecoratedLine(numbers);
            println(line);
        }
        println();
    }
    public void displayRank(WinningResult result){
        println("당첨 통계");
        println("---");
        HashMap<Reward, Integer> rankCount = result.getRankCount();
        for (Reward reward : rankCount.keySet()) {
            String line = getRankLine(reward, rankCount);
            println(line);
        }
    }

    public void displayProfit(double profitRate){
        String formattedRate = String.format("%.2f", profitRate);
        println("총 수익률은 " + formattedRate + "% 입니다.");
    }

    private static String getRankLine(Reward reward, HashMap<Reward, Integer> rankCount) {
        String line = reward.getCount()+"개 일치";
        if(reward.isBonus()){
            line += ", 보너스 볼 일치";
        }
        line += " ("+ reward.getFormatPrize()+"원)";
        line += " = "+ rankCount.get(reward)+"개";
        return line;
    }

    private static String getDecoratedLine(List<Number> numbers) {
        StringBuilder line = new StringBuilder("[");
        for (Number number : numbers) {
            line.append(number.get()).append(", ");
        }
        line = new StringBuilder(line.substring(0, line.length() - 2) + "]");
        return line.toString();
    }
}
