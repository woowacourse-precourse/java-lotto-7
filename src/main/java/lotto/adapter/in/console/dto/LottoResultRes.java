package lotto.adapter.in.console.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.NotNull;
import lotto.domain.core.Lotto;
import lotto.domain.core.LottoRank;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

/**
 * 로또의 결과를 출력하는 DTO 클래스
 */
public class LottoResultRes extends FieldValidation {

    @NotNull
    private final LottoRoundResult result;
    private final NumberFormat numberFormater;

    private LottoResultRes(LottoRoundResult result) {
        this.result = result;
        this.numberFormater = NumberFormat.getNumberInstance(Locale.KOREA);

        super.valid();
    }

    public static LottoResultRes of(LottoRoundResult result) {
        return new LottoResultRes(result);
    }

    public LottoResultRes printEnter() {
        System.out.println();

        return this;
    }

    public LottoResultRes printPurchased(LottoRound round) {
        System.out.println(round.getLottoCount() + "개를 구매했습니다.");
        System.out.println(round);

        return this;
    }

    public LottoResultRes printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(LottoRank.values())
                .forEach(this::printRankResult);

        return this;
    }

    public LottoResultRes printProfit() {
        System.out.printf("총 수익률은 %s%%입니다.\n", calculateProfit());

        return this;
    }

    private void printRankResult(LottoRank rank) {
        String price = numberFormater.format(rank.getPrice());
        int count = result.getRankCount(rank);

        if (rank.hasBonus() != null && rank.hasBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", rank.getMatchCount(), price, count);
            return;
        }

        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchCount(), price, count);
    }

    private BigDecimal calculateProfit() {
        int totalPrice = Arrays.stream(LottoRank.values())
                .mapToInt(it -> it.getPrice() * result.getRankCount(it))
                .sum();
        int buyPrice = result.size() * Lotto.PRICE;

        return BigDecimal.valueOf(totalPrice * 100L)
                .divide(BigDecimal.valueOf(buyPrice), 1, RoundingMode.HALF_UP);
    }
}
