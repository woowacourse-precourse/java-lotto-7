package lotto.model;
import java.util.List;

public record LottoGameState(Lotto userLotto, List<Lotto> randomLotteries, int bonusNumber,
                             LottoStatistics statistics) {
}
