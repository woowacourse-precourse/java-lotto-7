package lotto.model;

import java.util.List;

public class UserLotto {

    private List<Lotto> Lottos;
    private List<Integer> defaultLottoNumbers;
    private int bonusNumber;

    public UserLotto(List<Lotto> lottos, List<Integer> defaultLottoNumbers, int bonusNumber) {
        this.Lottos = lottos;
        this.defaultLottoNumbers = defaultLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }

    public List<Integer> getDefaultLottoNumbers() {
        return defaultLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
