package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;

    private WinningResult() {
        this.winningResult = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> winningResult.put(rank, 0));
    }

    public static WinningResult create() {
        return new WinningResult();
    }

    public void calculateWinningResult(Lottos lottos, WinningLotto winningLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.of(winningLotto.getMatchedNumberCount(lotto), bonusNumber.matchesBonusNumber(lotto));
            updateResult(rank);
        }
    }

    private void updateResult(Rank rank) {
        winningResult.put(rank, winningResult.get(rank) + 1);
    }

    public String getWinningResultString() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningMoney() > Rank.MISS.getWinningMoney())
                .map(rank -> rank.getMessage() + winningResult.get(rank) + "개")
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public int getWinningMoney() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningMoney() * winningResult.get(rank)).sum();
    }
}
