package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> getWinningResult(List<Lotto> playerLottos) {

        Map<String, Integer> winningResult = initResult();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Lotto playerLotto : playerLottos) {
            List<Integer> numbers = playerLotto.getNumbers();
            long count = numbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonusNumber = numbers.contains(bonusNumber);

            switch ((int) count) {
                case 3 -> winningResult.put("MATCH_3", winningResult.getOrDefault("MATCH_3", 0) + 1);
                case 4 -> winningResult.put("MATCH_4", winningResult.getOrDefault("MATCH_4", 0) + 1);
                case 5 -> {
                    if (hasBonusNumber) {
                        winningResult.put("MATCH_5_BONUS", winningResult.getOrDefault("MATCH_5_BONUS", 0) + 1);
                    } else {
                        winningResult.put("MATCH_5", winningResult.getOrDefault("MATCH_5", 0) + 1);
                    }
                }
                case 6 -> winningResult.put("MATCH_6", winningResult.getOrDefault("MATCH_6", 0) + 1);
            }
        }


        return winningResult;
    }

    private Map<String, Integer> initResult() {
        Map<String, Integer> winningResult = new HashMap<>();
        winningResult.put("MATCH_3", 0);
        winningResult.put("MATCH_4", 0);
        winningResult.put("MATCH_5", 0);
        winningResult.put("MATCH_5_BONUS", 0);
        winningResult.put("MATCH_6", 0);
        return winningResult;
    }

}
