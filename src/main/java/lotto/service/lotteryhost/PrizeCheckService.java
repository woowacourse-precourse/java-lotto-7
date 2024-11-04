package lotto.service.lotteryhost;

import java.util.Optional;
import lotto.service.constant.prize.PrizeCondition;

public interface PrizeCheckService {
    Optional<PrizeCondition> result();
}
