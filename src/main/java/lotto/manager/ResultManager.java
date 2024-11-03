package lotto.manager;

import lotto.domain.*;
import java.util.Map;
import java.util.stream.Collectors;


public class ResultManager {
    private WinningLotto winningLotto;

    public void changeWinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public Result getResult(Player player) {
        if (winningLotto == null) {
            throw new RuntimeException("[ERROR] 아직 당첨 로또를 설정하지 않았습니다.");
        }

        Map<Prize, Integer> prizeCount = getPrizeCountFrom(player);
        float returnRate = getReturnRate(player, prizeCount);

        return new Result(prizeCount, returnRate);
    }

    private Map<Prize, Integer> getPrizeCountFrom(Player player) {

        return player.getLottos().stream()
                .map(this::getPrizeOf)
                .collect(Collectors.groupingBy(
                        prize -> prize,
                        Collectors.summingInt(prize -> 1)
                ));
    }

    private Prize getPrizeOf(Lotto lotto) {

        int matchCount = countMatchNumberWith(lotto);
        boolean bonusFlag = matchBonusNumberWith(lotto);

        return Prize.getMatchPrize(matchCount, bonusFlag);
    }

    private int countMatchNumberWith(Lotto lotto) {
        int count = 0;

        for (Integer number : lotto.getImmutableNumbers()) {
            if (winningLotto.getImmutableWinningNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean matchBonusNumberWith(Lotto lotto) {

        return lotto.getImmutableNumbers().contains(winningLotto.getImmutableBonusNumber().getNumber());
    }

    private float getReturnRate(Player player, Map<Prize, Integer> prizeCount) {

        int prizeMoneySum = prizeCount.entrySet().stream()
                .mapToInt((e) -> e.getKey().getMoney() * e.getValue())
                .sum();

        return (float) prizeMoneySum / player.getMoney();
    }
}
