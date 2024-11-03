package lotto.view.output;

import java.math.BigDecimal;
import lotto.dto.LottoNumberDto;

public interface OutputView {
    void showCommentForPurchasePrice();

    void showQuantity(final BigDecimal quantity);

    void showCommentForWinningLotto();

    void showCommentForBonusNumber();

    void showCommentForLottoResult();

    void showCommentForMatchingCount(int matchingCount);

    void showLottoResultForSecond(BigDecimal award, BigDecimal count);

    void showLottoResult(BigDecimal award, BigDecimal count);

    void showProfitRate(BigDecimal profitRate);

    void showLotto(LottoNumberDto numbers);
}
