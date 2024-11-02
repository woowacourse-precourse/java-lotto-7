package lotto.model;

import java.util.List;

public class LottoCommittee {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoCommittee(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int size = numbers.size();

        int matchingCount = 0;
        boolean isBonusNumberMatching = false;
        for (int i = 0; i < size; i++) {
            if (numbers.get(i).equals(winningNumber.get(i))) {
                matchingCount++;
            }
            if (numbers.get(i).equals(bonusNumber)) {
                isBonusNumberMatching = true;
            }
        }

        return Ranking.of(matchingCount, isBonusNumberMatching);
    }
}
