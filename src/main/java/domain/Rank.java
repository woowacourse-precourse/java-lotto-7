package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private Map<Prize, Integer> winnings = new HashMap<>();

    public Rank() {
        for (Prize prize : Prize.values()) {
            winnings.put(prize, 0);
        }
    }

    public List<Lotto> purchaseLotto(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
        return purchasedLottos;
    }

    public void checkWinning(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);
            updateWinnings(matchCount, bonusMatched);
        }
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void updateWinnings(int matchCount, boolean bonusMatched) {
        if (matchCount == Prize.FIRST.getMatchCount()) {
            winnings.put(Prize.FIRST, winnings.get(Prize.FIRST) + 1);
            return;
        }
        if (matchCount == Prize.SECOND.getMatchCount() && bonusMatched) {
            winnings.put(Prize.SECOND, winnings.get(Prize.SECOND) + 1);
            return;
        }
        if (matchCount == Prize.THIRD.getMatchCount() && !bonusMatched) {
            winnings.put(Prize.THIRD, winnings.get(Prize.THIRD) + 1);
            return;
        }
        if (matchCount == Prize.FOURTH.getMatchCount()) {
            winnings.put(Prize.FOURTH, winnings.get(Prize.FOURTH) + 1);
            return;
        }
        if (matchCount == Prize.FIFTH.getMatchCount()) {
            winnings.put(Prize.FIFTH, winnings.get(Prize.FIFTH) + 1);
        }
    }

    public Map<Prize, Integer> getWinnings() {
        return winnings;
    }

    public int calculateTotalWinnings() {
        int total = 0;
        for (Prize prize : Prize.values()) {
            total += winnings.get(prize) * prize.getPrizeAmount();
        }
        return total;
    }
}
