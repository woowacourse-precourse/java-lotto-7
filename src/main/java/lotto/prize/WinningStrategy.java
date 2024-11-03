package lotto.prize;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;

public interface WinningStrategy {

    public WinningStatus checkPrize(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers,
                                    Integer winningLottoBonusNumber);

}
