package lotto.model;

import java.util.List;

public class LottoManagementSystem {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoManagementSystem() {

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void recordRanks(LottoResult lottoResult,MyWallet myWallet){
        List<Lotto> lottos = myWallet.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int rank = returnRank(numbers);

            lottoResult.addWin(rank);
        }
    }

    private int returnRank(List<Integer> numbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return checkRank(numbers, matchCount);
    }

    private int checkRank(List<Integer> numbers, int matchCount) {
        if (matchCount == 6) {
            return 1;
        }

        if (matchCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return 2;
            }
            return 3;
        }

        if (matchCount == 4) {
            return 4;
        }

        if (matchCount == 3) {
            return 5;
        }

        return 6;
    }

}
