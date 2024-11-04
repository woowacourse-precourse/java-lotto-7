package lotto.model;

import static lotto.util.Constants.LINE_SEPARATOR;

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
                    .append(LINE_SEPARATOR);
        }

        return lottoNumbers.toString();
    }

    public Result matchWinningLotto(WinningLotto winningLotto) {
        Result result = new Result();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compareLotto(lotto);
            result.updateResult(rank);
        }

        return result;
    }
}
