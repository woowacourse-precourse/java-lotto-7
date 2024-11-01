package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<WinningCriteria, Integer> winningDetails = new HashMap<>();

    public Result() {
        for(WinningCriteria winningCriteria : WinningCriteria.values()) {
            winningDetails.put(winningCriteria, 0);
        }
    }

    public Map<WinningCriteria, Integer> getFormatWinningDetails() {
        Map<WinningCriteria, Integer> formatWinningDetails = new LinkedHashMap<>();
        formatWinningDetails.put(WinningCriteria.FIFTH, winningDetails.get(WinningCriteria.FIFTH));
        formatWinningDetails.put(WinningCriteria.FOURTH, winningDetails.get(WinningCriteria.FOURTH));
        formatWinningDetails.put(WinningCriteria.THIRD, winningDetails.get(WinningCriteria.THIRD));
        formatWinningDetails.put(WinningCriteria.SECOND, winningDetails.get(WinningCriteria.SECOND));
        formatWinningDetails.put(WinningCriteria.FIRST, winningDetails.get(WinningCriteria.FIRST));
        return Collections.unmodifiableMap(formatWinningDetails);
    }

    public void calculate(WinningNumber winning, BonusNumber bonus, LottoIssuer issuer) {
        List<Integer> winningNumbers = winning.getNumbers();
        int bonusNumber = bonus.getValue();
        Lotto[] lottos = issuer.getLottos();

        // 로또 하나 꺼내서
        for(Lotto lotto : lottos) {
            List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
            boolean isBonusContained = lottoNumbers.contains(bonusNumber);

            lottoNumbers.retainAll(winningNumbers);
            int matchingCount = lottoNumbers.size();

            WinningCriteria satisfiedWinningCriteria = getSatisfiedWinningCriteria(matchingCount, isBonusContained);
            if(satisfiedWinningCriteria != null) {
                winningDetails.put(satisfiedWinningCriteria, winningDetails.get(satisfiedWinningCriteria) + 1);
            }
        }
    }

    private WinningCriteria getSatisfiedWinningCriteria(int matchingCount, boolean isBonusContained) {
        if (matchingCount == 6) {
            return WinningCriteria.FIRST;
        }
        if (matchingCount == 5 && isBonusContained) {
            return WinningCriteria.SECOND;
        }
        if (matchingCount == 5) {
            return WinningCriteria.THIRD;
        }
        if (matchingCount == 4) {
            return WinningCriteria.FOURTH;
        }
        if (matchingCount == 3) {
            return WinningCriteria.FIFTH;
        }
        return null;
    }
}
