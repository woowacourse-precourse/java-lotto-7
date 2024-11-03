package lotto.view.output;

import java.math.BigDecimal;
import java.util.List;

public interface OutputView {
    void showCommentForPurchasePrice();

    void showQuantity(final BigDecimal quantity);

    void showCommentForWinningLotto();

    void showCommentForBonusNumber();

    void showCommentForWinningResult();

    void showCommentForMatchingCount(int matchingCount);

    void showWinningResultForSecond(BigDecimal award, BigDecimal count);

    void showWinningResult(BigDecimal award, BigDecimal count);

    void showProfitRate(BigDecimal profitRate);

    void showLotto(List<Integer> numbers);
}
