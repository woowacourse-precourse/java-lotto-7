package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.User;
import lotto.domain.UserLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculatorService {

    private Map<LottoRanking, Integer> winningCount = new HashMap<>();

    // 당첨번호 카운팅 (당첨결과 확인)
    public void calculateWinningResult(User user, Lotto lotto) {
        List<UserLotto> userLotto = user.getUserLotto();
        List<Integer> winningLotto = lotto.getNumbers();

        for (UserLotto userLottoNumber : userLotto) {
            int duplicateNumber = 0;
            for (int i = 0; i < 6; i++) {
                if (userLottoNumber.getLottoNumber().contains(winningLotto.get(i))) {
                    duplicateNumber++;
                }
            }

            for (LottoRanking ranking : LottoRanking.values()) {

                if (duplicateNumber < 3 || duplicateNumber != ranking.getMatchNumber()) {
                    continue;
                }

                if (duplicateNumber == 5 && userLottoNumber.getLottoNumber().contains(winningLotto.get(6)) == ranking.isBonusMatch()) {
                    winningCount.put(ranking, winningCount.getOrDefault(ranking, 0) + 1);
                    continue;
                }
                
                if (duplicateNumber != 5) {
                    winningCount.put(ranking, winningCount.getOrDefault(ranking, 0) + 1);
                }
            }
        }
    }
}
