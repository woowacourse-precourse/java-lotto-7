package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryRoundManager {
    private final int UNIT_COST = 1000;
    private final String ERROR_MESSAGE = "[ERROR] ";

    private int cost;
    private List<Integer> winningNumber;
    private int bonusNumber;


    public PurchasedLotto purchaseLotto(int cost) {
        if (cost < 0 || cost > 200000000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 0원 이상 20억원 이하로 입력되어야 합니다.");
        }
        if (cost % UNIT_COST != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 1000원 단위로 입력되어야 합니다.");
        }
        this.cost = cost;
        return PurchasedLotto.generateLottos(cost / UNIT_COST, () -> Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void setWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        validateWinningNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (!winningNumber.stream().filter(n -> (n < 1 || n > 45)).toList().isEmpty())
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 당첨 번호는 1 이상 45 이하여야 합니다.");
        if (winningNumber.stream().distinct().count() != winningNumber.size())
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 당첨 번호는 겹치지 않아야 합니다.");
        if (winningNumber.size() != 6)
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 당첨 번호는 6개여야 합니다.");
        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호는 1 이상 45 이하여야 합니다.");
        if (winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호는 당첨 번호와 겹치지 않아야 합니다.");
    }

    public double calculateBenefit(Map<Prize, Integer> result) {
        long prizeMoney = 0;
        for (Prize prize : Prize.values()) {
            prizeMoney += prize.calculateTotalPrizeMoney(result.getOrDefault(prize, 0));
        }
        return Math.round((double) prizeMoney / cost * 1000) / 10.0;
    }

    public Map<Prize, Integer> checkWon(PurchasedLotto purchasedLotto) {
        return purchasedLotto.checkWin(winningNumber, bonusNumber);
    }
}
