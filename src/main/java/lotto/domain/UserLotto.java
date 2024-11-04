package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class UserLotto {
    private List<Lotto> randomLottoNumbers;
    private Integer LottoMoneyCount;

    public UserLotto( List<Lotto> randomLottoNumbers, Integer LottoMoneyCount) {
        this.randomLottoNumbers = randomLottoNumbers;
        this.LottoMoneyCount = LottoMoneyCount;
    }

    public List<Lotto> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }

    public Integer getPurchasedLottoCount() {
        return LottoMoneyCount;
    }

}
