package lotto.prize;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;

public class KoreaPrizeChecker implements WinningStrategy {

    @Override
    public WinningStatus checkPrize(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers,
                                    Integer winningLottoBonusNumber) {

        long matchCount = lottoNumbers.stream().filter(winningLottoNumbers::contains).count();

        boolean bonusMatch = lottoNumbers.contains(winningLottoBonusNumber);

        if (matchCount == 6) {
            return WinningStatus.first;
        }
        if ((matchCount == 5 && bonusMatch)) {
            return WinningStatus.second;
        }
        if (matchCount == 5) {
            return WinningStatus.third;
        }
        if (matchCount == 4) {
            return WinningStatus.fourth;
        }
        if (matchCount == 3) {
            return WinningStatus.fifth;
        }
        return WinningStatus.blank;
    }
}
