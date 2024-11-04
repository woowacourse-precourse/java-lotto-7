package lotto.model;

import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoCollection;

    public LottoCollection(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoCollection) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
