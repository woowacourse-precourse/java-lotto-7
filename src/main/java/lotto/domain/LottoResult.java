package lotto.domain;
import java.util.List;

public class LottoResult {
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoRank campareLotto(Lotto userLotto){
        List<Integer> userLottoNumbers=userLotto.getNumbers();

        int matchCount= (int)userLottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();

        boolean isBonus=userLottoNumbers.contains(bonusNumber);
        return LottoRank.searchRank(matchCount,isBonus);
    }
}
