package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class UserLotto {
    private static List<Lotto> randomLottoNumbers;
    private static Integer LottoMoneyCount;

    public UserLotto( Integer LottoMoneyCount) {
        this.randomLottoNumbers = new ArrayList<>();
        this.LottoMoneyCount = LottoMoneyCount;
    }

    public static List<Lotto> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }

    public static Integer getLottoMoneyCount() {
        return LottoMoneyCount;
    }


}
