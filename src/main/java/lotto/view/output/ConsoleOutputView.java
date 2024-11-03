package lotto.view.output;

import java.math.BigDecimal;
import lotto.domain.lotto.LottoRank;
import lotto.dto.LottoNumberDto;

public class ConsoleOutputView implements OutputView {

    @Override
    public void showCommentForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void showQuantity(final BigDecimal quantity) {
        System.out.println(System.lineSeparator() + quantity + "개를 구매했습니다.");
    }

    @Override
    public void showCommentForWinningLotto() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    @Override
    public void showCommentForBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }

    @Override
    public void showCommentForLottoResult() {
        System.out.println(System.lineSeparator() + "당첨 통계");
    }

    @Override
    public void showLottoResult(final LottoRank lottoRank, final BigDecimal count) {
        System.out.printf(lottoRank.getFormat() + System.lineSeparator(), lottoRank.getMatchCount(),
                lottoRank.getAward(), count);
    }

    @Override
    public void showProfitRate(final BigDecimal profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    @Override
    public void showLotto(final LottoNumberDto numbers) {
        System.out.println(numbers.numbers());
    }

    @Override
    public void showException(final RuntimeException exception) {
        System.out.println(exception.getMessage());
    }
}
