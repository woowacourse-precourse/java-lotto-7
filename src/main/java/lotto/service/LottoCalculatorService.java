package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.User;
import lotto.domain.UserLotto;

import java.util.*;

import static lotto.domain.LottoRanking.*;

public class LottoCalculatorService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int BONUS_NUMBER_INDEX = 6;

    private final Map<LottoRanking, Integer> winningCount = new EnumMap<>(LottoRanking.class);

    public LottoCalculatorService() {
        for (LottoRanking lottoRanking : values()) {
            winningCount.put(lottoRanking, 0);
        }
    }

    public Map<LottoRanking, Integer> calculateWinningResult(User user, Lotto WinningLotto) {
        for (UserLotto userLotto : user.getUserLotto()) {
            int duplicateNumber = getDuplicateNumber(userLotto, WinningLotto);

            duplicateLottoNumberCalculate(userLotto, duplicateNumber, WinningLotto);
        }
        return winningCount;
    }

    private int getDuplicateNumber(UserLotto userLotto, Lotto winningLotto) {
        return  (int) winningLotto.getNumbers().stream()
            .limit(LOTTO_NUMBER_COUNT)
            .filter(userLotto.getLottoNumber()::contains)
            .count();
    }

    private void duplicateLottoNumberCalculate(UserLotto userLottoNumber, int duplicateNumber, Lotto winningLotto) {
        LottoRanking lottoRanking = getLottoRanking(duplicateNumber, matchesBonusNumberCondition(userLottoNumber, winningLotto));
        addWinningCount(lottoRanking);
    }

    private boolean matchesBonusNumberCondition(UserLotto userLottoNumber, Lotto winningLotto) {
        return userLottoNumber.getLottoNumber().contains(winningLotto.getNumbers().get(BONUS_NUMBER_INDEX));
    }

    private void addWinningCount(LottoRanking ranking) {
        if (ranking != null) {
            winningCount.put(ranking, winningCount.getOrDefault(ranking, 0) + 1);
        }
    }

    public String profitCalculate(User user) {
        for (LottoRanking lottoRanking : winningCount.keySet()) {
            addWinningPrice(user, lottoRanking);
        }
        return user.getProfit();
    }

    private void addWinningPrice(User user, LottoRanking lottoRanking) {
        if (winningCount.get(lottoRanking) != 0) {
            user.addWinningPrice(lottoRanking.getPrice());
        }
    }
}