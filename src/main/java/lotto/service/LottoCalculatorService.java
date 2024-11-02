package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRanking.*;

public class LottoCalculatorService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int BONUS_NUMBER_INDEX = 6;
    private static final int THREE_MATHE_NUMBER = THREE_MATCH.getMatchNumber();
    private static final int FIVE_MATHE_NUMBER = FIVE_MATCH.getMatchNumber();

    private final Map<LottoRanking, Integer> winningCount = new HashMap<>();

    public LottoCalculatorService() {
        for (LottoRanking lottoRanking : values()) {
            winningCount.put(lottoRanking, 0);
        }
    }

    public void calculateWinningResult(User user, Lotto lotto) {
        List<UserLotto> userLotto = user.getUserLotto();
        List<Integer> winningLotto = lotto.getNumbers();

        for (UserLotto userLottoNumber : userLotto) {
            int duplicateNumber = 0;
            duplicateNumber = getDuplicateNumber(userLottoNumber, duplicateNumber, winningLotto);

            duplicateLottoNumberCalculate(userLottoNumber, duplicateNumber, winningLotto);
        }

        OutputView.printWinningHistory(winningCount);
    }

    private int getDuplicateNumber(UserLotto userLottoNumber, int duplicateNumber, List<Integer> winningLotto) {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            duplicateNumber = addDuplicateNumber(userLottoNumber, winningLotto, i, duplicateNumber);
        }
        return duplicateNumber;
    }

    private int addDuplicateNumber(UserLotto userLottoNumber, List<Integer> winningLotto, int i, int duplicateNumber) {
        if (userLottoNumber.getLottoNumber().contains(winningLotto.get(i))) {
            duplicateNumber++;
        }
        return duplicateNumber;
    }

    private void duplicateLottoNumberCalculate(UserLotto userLottoNumber, int duplicateNumber, List<Integer> winningLotto) {
        for (LottoRanking ranking : values()) {
            countDuplicateLottoNumber(userLottoNumber, ranking, duplicateNumber, winningLotto);
        }
    }

    private void countDuplicateLottoNumber(UserLotto userLottoNumber, LottoRanking ranking, int duplicateNumber, List<Integer> winningLotto) {
        if (duplicateNumber < THREE_MATHE_NUMBER || duplicateNumber != ranking.getMatchNumber()) {
            return;
        }

        if (duplicateNumber == FIVE_MATHE_NUMBER && matchesBonusNumberCondition(userLottoNumber, ranking, winningLotto)) {
            addWinningCount(ranking);
            return;
        }

        if (duplicateNumber != FIVE_MATHE_NUMBER) {
            addWinningCount(ranking);
        }
    }

    private boolean matchesBonusNumberCondition(UserLotto userLottoNumber, LottoRanking ranking, List<Integer> winningLotto) {
        return userLottoNumber.getLottoNumber().contains(winningLotto.get(BONUS_NUMBER_INDEX)) == ranking.isBonusMatch();
    }

    private void addWinningCount(LottoRanking ranking) {
        winningCount.put(ranking, winningCount.getOrDefault(ranking, 0) + 1);
    }

    public void profitCalculate(User user) {
        for (LottoRanking lottoRanking : winningCount.keySet()) {
            addWinningPrice(user, lottoRanking);
        }

        OutputView.printProfit(user.getProfit());
    }

    private void addWinningPrice(User user, LottoRanking lottoRanking) {
        if (winningCount.get(lottoRanking) != 0) {
            user.addWinningPrice(lottoRanking.getPrice());
        }
    }
}
