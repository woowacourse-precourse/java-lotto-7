package lotto.service.winning;

import java.util.List;
import lotto.domain.LottoPurchase;
import lotto.domain.Winning;

public interface WinningService {

    Winning createWinning(List<Integer> numbers, int bonusNumber);

    LottoStatistics getStatistics(LottoPurchase purchase, Winning winning);
}
