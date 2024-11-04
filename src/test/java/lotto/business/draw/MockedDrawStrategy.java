package lotto.business.draw;

import java.util.List;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoResult;
import lotto.lotto.WinningNumbers;

/**
 * Implementation of <code>DrawStrategy</code> that can be used for testing.
 * <p>
 * <ul>
 *   <li>Set <code>drawnNumbers</code> and <code>bonusNumber</code> to the desired return value before calling the <code>draw</code>.</li>
 * </ul>
 * <p>
 * The method call history is stored in the corresponding field.
 * <ul>
 *   <li>Method call count is stored in <code>methodCallCount</code>.</li>
 * </ul>
 *
 * @see DrawStrategy
 */
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
