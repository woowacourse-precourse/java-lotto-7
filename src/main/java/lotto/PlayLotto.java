package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PlayLotto {
    public static Map<Rank, Integer> getHitDetails(TotalLotto lottos,HitLotto hitLotto) {
        Map<Rank, Integer> hitDetails = generateHitDetails();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = compareNumbersWithHitNumbers(lotto, hitLotto);
            boolean containsBonusNumber = compareNumbersWithBonusNumber(lotto, hitLotto, matchingCount);
            Rank hitRank = Rank.findHitRank(matchingCount, containsBonusNumber);
            hitDetails.replace(hitRank, hitDetails.get(hitRank) + 1);
        }
        return hitDetails;
    }

    public static Map<Rank, Integer> generateHitDetails() {
        Map<Rank, Integer> winningDetails = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(winningRank -> winningDetails.put(winningRank, 0));
        return winningDetails;
    }

    private static int compareNumbersWithHitNumbers(Lotto lotto, HitLotto hitLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> hitNumbers = hitLotto.getHitNumbers();
        return (int) numbers.stream()
                .filter(hitNumbers::contains)
                .count();
    }

    private static boolean compareNumbersWithBonusNumber(Lotto lotto, HitLotto hitLotto, int matchingCount) {
        if (matchingCount != 5) {
            return false;
        }
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = hitLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
