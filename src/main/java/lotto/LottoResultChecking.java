package lotto;

import java.math.*;
import java.util.*;


public class LottoResultChecking {

    private final List<Lotto> lottos;
    private final List<Integer> lottoWinningNumbers;
    private final Integer lottoBonusNumber;
    private final Integer lottoPurchaseAmount;

    public LottoResultChecking(List<Lotto> lottos, List<Integer> lottoWinningNumbers, Integer lottoBonusNumber, Integer lottoPurchaseAmount) {
        this.lottos = lottos;
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public void checkLottos() {
        Map<Reward, Integer> rewardMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            Reward reward = checkLotto(lotto);
            rewardMap.put(reward, rewardMap.getOrDefault(reward, 0) + 1);
        }
        printResult(rewardMap);
    }

    private Reward checkLotto(Lotto lotto) {
        int count = 0;
        boolean isBonusNumber = false;
        for (Integer number : lotto.getNumbers()) {
            if (lottoWinningNumbers.contains(number)) {
                count++;
            }
            if (lottoBonusNumber.equals(number)) {
                isBonusNumber = true;
            }
        }
        return Reward.valueOf(count, isBonusNumber);
    }

    private void printResult(Map<Reward, Integer> rewardMap) {
        String bonusText = "";
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Reward reward : Reward.values()) {
            if (reward == Reward.NONE) {
                continue;
            }
            if (reward != Reward.NONE) {
                bonusText = "";
            }
            if (reward.isMatchBonus()) {
                bonusText = ", 보너스 볼 일치";
            }
            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    reward.getMatchCount(),
                    bonusText,
                    reward.getPrize(),
                    rewardMap.getOrDefault(reward, 0));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", CalculateRatio(rewardMap, lottoPurchaseAmount));
    }



    private float CalculateRatio(Map<Reward, Integer> rewardMap, int purchaseAmount) {
        int totalPrize = rewardMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        float ratio = (float) totalPrize / purchaseAmount * 100;
        return Math.round(ratio * 10) / 10.0f;
    }

}
