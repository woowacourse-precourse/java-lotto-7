package lotto;

import java.util.List;

import static lotto.LottoRank.*;

public class winningCount {
    static void calculatePrizes(List<Lotto> severalLottos, List<Integer> winningList, int bonusNumber) {
        for (Lotto lotto : severalLottos) {
            // 로또 번호와 당첨 번호의 중복된 값 찾기
            List<Integer> matchList = lotto.getNumbers().stream()
                    .filter(winningList::contains) // winningNumbers와 중복된 값 찾기
                    .toList();

            int matchCount = matchList.size(); // 일치하는 개수
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber); // 보너스 번호 일치 여부 확인

            //matchCount가 3일때 enum형 3등이 ++, 4일때 4등++ 5일때 5등이++ 6일때 6등이 ++
            if (matchCount == THREE_MATCH.getMatchCount()) {
                THREE_MATCH.incrementCount();
            }
            if (matchCount == FOUR_MATCH.getMatchCount()) {
                FOUR_MATCH.incrementCount();
            }
            if (matchCount == FIVE_MATCH_BONUS.getMatchCount() && bonusMatch) {
                FIVE_MATCH_BONUS.incrementCount();
            }
            if (matchCount == FIVE_MATCH.getMatchCount() && !bonusMatch) {
                LottoRank.FIVE_MATCH.incrementCount();
            }
            if (matchCount == SIX_MATCH.getMatchCount()) {
                LottoRank.SIX_MATCH.incrementCount();
            }
        }

    }
}


