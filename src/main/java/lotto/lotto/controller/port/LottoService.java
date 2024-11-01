package lotto.lotto.controller.port;

import java.util.List;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.LottoWinning;

public interface LottoService {

    LottoResults createLottos(long count);

    LottoWinning createWinningLotto(List<Integer> numbers, int bonusNumber);

    LottoResults updateLottoRanks(LottoResults lottoResults, LottoWinning lottoWinning);
}






