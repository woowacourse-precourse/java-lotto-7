package lotto.output;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public interface OutputHandler {

    void printLottos(List<Lotto> lottos);

    void printResult(LottoResult result);
}
