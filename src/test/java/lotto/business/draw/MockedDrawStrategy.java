package lotto.business.draw;

import java.util.List;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoResult;
import lotto.lotto.WinningNumbers;

public class MockedDrawStrategy implements DrawStrategy {
    public List<Integer> drawnNumbers;
    public int bonusNumber;

    public int drawCallCount = 0;

    @Override
    public LottoResult draw() {
        drawCallCount++;

        WinningNumbers winningNumbers = new WinningNumbers(drawnNumbers.stream().map(LottoNumber::new).toList());
        return new LottoResult(winningNumbers, new LottoNumber(bonusNumber));
    }
}
