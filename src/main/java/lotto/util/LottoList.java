package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.mvc.model.Lotto;

public class LottoList {
    private List<Lotto> bunchOfLottoes;

    public LottoList() {
        bunchOfLottoes = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        bunchOfLottoes.add(lotto);
    }

    public int size() {
        return bunchOfLottoes.size();
    }

    public List<Lotto> getBunchofLottoes() {
        return bunchOfLottoes;
    }
}
