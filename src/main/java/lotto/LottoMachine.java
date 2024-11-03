package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    static final int PRICE = 1000;

    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;
    private Map<Winning, Integer> winningResult;

    public LottoMachine() {
        lottos = new ArrayList<>();
        winningLotto = null;
        bonusNumber = 0;
        winningResult = new EnumMap<>(Winning.class);
        winningResult.put(Winning.FIRST, 0);
        winningResult.put(Winning.SECOND, 0);
        winningResult.put(Winning.THIRD, 0);
        winningResult.put(Winning.FOURTH, 0);
        winningResult.put(Winning.FIFTH, 0);
    }

    public void buy(int cost) {
        validateCostIsPositive(cost);
        validateCostIsDivisibleByPrice(cost);

        for (int i = 0; i < (cost / PRICE); i++) {
            lottos.add(new Lotto());
        }
    }

    private void validateCostIsPositive(int cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    private void validateCostIsDivisibleByPrice(int cost) {
        if (cost % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningLotto(Lotto winningLotto) {
        if (bonusNumber != 0) {
            validateBonusNumber(winningLotto, bonusNumber);
        }
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        if (winningLotto != null) {
            validateBonusNumber(winningLotto, bonusNumber);
        }
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public Map<Winning, Integer> getWinningResult() {
        if (winningLotto == null || bonusNumber == 0) {
            throw new IllegalStateException("[ERROR] 당첨 결과를 확인하기 전에 당첨 번호와 보너스 번호를 입력해야 합니다.");
        }
        lottos.forEach(lotto -> check(lotto, winningLotto, bonusNumber));
        return winningResult;
    }

    private void check(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers()
                .stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        boolean isMatchBonusNumber = lotto.getNumbers().contains(bonusNumber);
        incrementWinningResult(matchCount, isMatchBonusNumber);
    }

    private void incrementWinningResult(int matchCount, boolean isMatchBonusNumber) {
        if (matchCount == 6) {
            winningResult.put(Winning.FIRST, winningResult.get(Winning.FIRST) + 1);
        }
        if (matchCount == 5 && isMatchBonusNumber) {
            winningResult.put(Winning.SECOND, winningResult.get(Winning.SECOND) + 1);
        }
        if (matchCount == 5 && !isMatchBonusNumber) {
            winningResult.put(Winning.THIRD, winningResult.get(Winning.THIRD) + 1);
        }
        if (matchCount == 4) {
            winningResult.put(Winning.FOURTH, winningResult.get(Winning.FOURTH) + 1);
        }
        if (matchCount == 3) {
            winningResult.put(Winning.FIFTH, winningResult.get(Winning.FIFTH) + 1);
        }
    }

    public double calculateRate() {
        int total = 0;
        for (Map.Entry<Winning, Integer> e : winningResult.entrySet()) {
            total += e.getKey().getAmount() * e.getValue();
        }
        return (double) total / (lottos.size() * PRICE);
    }
}
