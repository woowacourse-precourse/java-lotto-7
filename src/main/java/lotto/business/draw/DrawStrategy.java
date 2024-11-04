package lotto.business.draw;

import lotto.lotto.LottoResult;

/**
 * <code>DrawStrategy</code> is an interface that provides the strategy to draw the <code>LottoResult</code>.
 *
 * @see lotto.lotto.LottoResult
 */
public interface DrawStrategy {
    /**
     * Draw the <code>LottoResult</code>.
     *
     * @return the drawn <code>LottoResult</code>
     */
    LottoResult draw();
}
