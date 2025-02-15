package lotto.domain.prize;

import java.util.List;

public interface WinningStrategy {

    public WinningStatus checkPrize(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers,
                                    Integer winningLottoBonusNumber);

}
