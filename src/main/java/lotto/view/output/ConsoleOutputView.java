package lotto.view.output;

import java.math.BigDecimal;
import java.text.NumberFormat;
import lotto.dto.LottoNumberDto;

public class ConsoleOutputView implements OutputView {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

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
    public void showCommentForMatchingCount(final int matchingCount) {
        System.out.print(matchingCount + "개 일치");
    }

    @Override
    public void showLottoResultForSecond(final BigDecimal award, final BigDecimal count) {
        System.out.println(", 보너스 볼 일치 (" + numberFormat.format(award) + "원) - " + count + "개");
    }

    @Override
    public void showLottoResult(final BigDecimal award, final BigDecimal count) {
        System.out.println(" (" + numberFormat.format(award) + "원) - " + count + "개");
    }

    @Override
    public void showProfitRate(final BigDecimal profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    @Override
    public void showLotto(final LottoNumberDto numbers) {
        System.out.println(numbers.numbers());
    }
}
