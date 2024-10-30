package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {

    private List<Integer> lottoNumbers;

    public PlayerLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
