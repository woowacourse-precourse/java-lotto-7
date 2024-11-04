package lotto.model;

import static lotto.model.LotteryRank.getRank;
import static lotto.model.LotteryRank.values;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LotteryDrawer extends WinnerDrawer {

    private final List<Lotto> issuedLotto;
    private final Set<Integer> winningNumber;
    private final int bonusNumber;
    private final Map<LotteryRank, Integer> drawResult = new HashMap<>(5);

    public LotteryDrawer(List<Lotto> issuedLotto, Set<Integer> winningNumbers, int bonusNumber) {
        initializeDrawResult();
        this.issuedLotto = issuedLotto;
        this.winningNumber = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void initializeDrawResult() {
        for (LotteryRank rank : values()) {
            drawResult.put(rank, 0);
        }
    }

    @Override
    public void draw() {
        for (Lotto lotto : issuedLotto) {
            Set<Integer> numbers = new HashSet<>(lotto.getNumbers());
            numbers.retainAll(winningNumber); // 당첨 번호와 일치하는 숫자만 남기고 제거

            int hitCount = numbers.size(); // 당첨 번호와 일치하는 숫자 개수
            boolean bonusMatched = (hitCount == 5 && lotto.getNumbers().contains(bonusNumber));
            LotteryRank rank = getRank(hitCount, bonusMatched);
            if (rank == null) { // 당첨되지 않은 경우
                continue;
            }

            drawResult.put(rank, drawResult.get(rank) + 1);
        }
    }

    public static void validateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 없습니다.");
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야합니다.");
        }
        if (winningNumbers.stream().toList().stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public Map<LotteryRank, Integer> getDrawResult() {
        return drawResult;
    }

}
