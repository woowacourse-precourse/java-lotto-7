package lotto;

import java.util.List;

public class LottoMatcher {
    // 사용자입력번호랑 구매목록이랑 비교
    public int countMatches(List<Integer> winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 보너스 번호 매칭 유무비교
    public boolean bonusMatch(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
