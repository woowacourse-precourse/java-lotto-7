package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.enums.RankConstants;

public class DtoConverter {
    public LotteriesResponse toLotteriesResponse(List<Lotto> lotteries) {
        List<List<Integer>> response = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            response.add(lotto.getNumbers());
        }
        return new LotteriesResponse(response, lotteries.size());
    }

    public WinningResultResponse toWinningResultResponse(UserLotto userLotto, float profitRate) {
        return new WinningResultResponse(
                userLotto.getWinningCount(RankConstants.FIRST_PRIZE),
                userLotto.getWinningCount(RankConstants.SECOND_PRIZE),
                userLotto.getWinningCount(RankConstants.THIRD_PRIZE),
                userLotto.getWinningCount(RankConstants.FOURTH_PRIZE),
                userLotto.getWinningCount(RankConstants.FIFTH_PRIZE),
                profitRate);
    }
}
