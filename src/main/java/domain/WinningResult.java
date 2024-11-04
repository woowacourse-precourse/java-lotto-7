package domain;

import message.Prize;
import view.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    public final int LOTTO_AMOUNT = 1000;

    public Map<Prize, Integer> calculateResult(List<Lotto> lottos, List<Integer> winning, int bonus) {

        Output output = new Output();

        Map<Prize, Integer> result = new HashMap<>();
        Prize prize;

        output.printStaticGuide();
        for (Lotto lotto : lottos) {
            prize = matches(lotto, winning, bonus);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }

        return result;
    }

    public double calculateRate(Map<Prize, Integer> result, int lottoAmount) {

        double rate = 0.0;
        long totalProfit = 0L;
        long totalConsume = (long)lottoAmount * LOTTO_AMOUNT;

        for(Prize prize : result.keySet()) {
            totalProfit += result.get(prize) * prize.getMoney();
        }
        rate = (double)(totalProfit / totalConsume) * 100.0 ;

        return rate;
    }

    private Prize matches(Lotto lotto, List<Integer> winning, int bonus) {

        int count = compareWinning(lotto, winning);
        boolean isBonus = compareBonus(lotto, bonus);

        return Ranking.valueOf(count, isBonus);
    }

    private int compareWinning(Lotto lotto, List<Integer> winning) {

        int matchCount = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();

        for(Integer number : lottoNumbers) {
            if(winning.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean compareBonus(Lotto lotto, int bonus) {


        boolean isBonus = false;
        List<Integer> lottoNumbers = lotto.getNumbers();

        for(Integer number : lottoNumbers) {
            if(number == bonus) {
                isBonus = true;
            }
        }

        return isBonus;
    }
}
