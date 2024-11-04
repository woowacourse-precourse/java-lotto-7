package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class SoldLotto {
    private static final String LINE_SEPARATOR = "\n";
    private final List<List<Integer>> soldLotto;

    public SoldLotto() {
        this.soldLotto = new ArrayList<>();
    }

    public void addLottoSold(List<Integer> soldLotto) {
        Lotto lotto = new Lotto(soldLotto);
        this.soldLotto.add(lotto.getLottoDetails());
    }

    public List<List<Integer>> getSoldLotto() {
        return new ArrayList<>(soldLotto);
    }

    public StringBuilder getLottoDetails() {
        StringBuilder lottoDetails = new StringBuilder();
        for (List<Integer> lotto : soldLotto) {
            lottoDetails.append(lotto).append(LINE_SEPARATOR);
        }
        return lottoDetails;
    }

}
