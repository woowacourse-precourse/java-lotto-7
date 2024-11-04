package lotto;

import java.util.List;
import lotto.enums.LottoPrizes;

public class LottoResult {

    public void checkLottoIsWinner(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getLotto()) {
            List<Integer> userNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

            // 사용자 번호와 당첨 번호 간의 일치 개수 확인
            long matchingCount = userNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

            checkRank(matchingCount);
        }
    }

    private void checkRank(long matchingCount) {
        LottoPrizes.checkLottoRank(matchingCount);
    }
}
