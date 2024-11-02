package lotto.model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public String getLottos() {
        StringBuilder lottoNumbers = new StringBuilder();

        for (Lotto lotto : lottos) {
            lottoNumbers.append(lotto.getLottoNumbers())
                    .append("\n");
        }

        return lottoNumbers.toString();
    }
}
