package domain;

import message.Prize;
import view.Output;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    public final int LOTTO_AMOUNT = 1000;

    public void results(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {

        Output output = new Output();

        Map<Prize, Integer> result = calculateResult(lottos, winningNumbers, bonusNumber);
        int lottoTotalNum = lottos.size();

        output.printResult(result);
        output.printProfitRate(result, lottoTotalNum * LOTTO_AMOUNT);
    }

    public static Map<Prize, Integer> calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {

        Map<Prize, Integer> result = new EnumMap<>(Prize.class);

        for(Prize prize : Prize.values()) {

            result.put(prize, 0);
        }

        for(Lotto lotto : lottos) {

            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            Prize prize = getPrizeByMatch(matchCount, matchBonus);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }

        return result;
    }

    public static Prize getPrizeByMatch(int matchCount, boolean matchBonus) {

        if(matchCount == 6) return Prize.ALL_MATCHES;
        if(matchCount == 5 && matchBonus) return Prize.FIVE_BONUS_MATCHES;
        if(matchCount == 5) return Prize.FIVE_MATCHES;
        if(matchCount == 4) return Prize.FOUR_MATCHES;
        if(matchCount == 3) return Prize.THREE_MATCHES;
        return Prize.MISS;
    }
}
