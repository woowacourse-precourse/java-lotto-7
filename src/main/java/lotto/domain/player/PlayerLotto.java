package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {

    private List<Integer> lottoNumbers;

    public PlayerLotto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void updateLottoNumbers(List<Integer> lottoNumbers) {
    }
}
