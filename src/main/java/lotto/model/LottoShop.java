package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoShop {

    private Set<Integer> winNumbers;
    private int bonusNumber;

    public List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = createSingleLotto();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private static List<Integer> createSingleLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoType.MIN_NUMBER.getNumber(), LottoType.MAX_NUMBER.getNumber(),
                LottoType.COUNT.getNumber());
    }

    public WinType findWinLotto(Lotto lotto) {
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        winNumbers.add(bonusNumber);
        lottoNumbers.retainAll(winNumbers);
        return findWinType(lottoNumbers.size(), containBonus(lottoNumbers));
    }

    private boolean containBonus(Set<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private WinType findWinType(int count, boolean containBonus) {
        if (count == 6) {
            return WinType.SIX;
        }
        if (count == 5 && containBonus) {
            return WinType.FIVE_WITH_BONUS;
        }
        if (count == 5 && !containBonus) {
            return WinType.FIVE_WITHOUT_BONUS;
        }
        if (count == 4) {
            return WinType.FOUR;
        }
        if (count == 3) {
            return WinType.THREE;
        }
        return WinType.ZERO;
    }

    public void setWinNumbers(Set<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
