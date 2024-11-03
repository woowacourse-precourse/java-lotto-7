package lotto.view.output;

import java.math.BigDecimal;
import lotto.domain.lotto.LottoRank;
import lotto.dto.LottoNumberDto;

public interface OutputView {
    void showCommentForPurchasePrice();

    void showQuantity(final BigDecimal quantity);

    void showCommentForWinningLotto();

    void showCommentForBonusNumber();

    void showCommentForLottoResult();

    void showLottoResult(LottoRank award, BigDecimal count);

    void showProfitRate(BigDecimal profitRate);

    void showLotto(LottoNumberDto numbers);

    void showException(RuntimeException exception);
}
