package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {

    @DisplayName("구입 수량의 출력 형식을 포맷팅할 수 있다.")
    @Test
    void formatingQuantity() {
        //given
        int quantity = 8;

        //when
        String formatingQuantity = OutputFormatter.formatingQuantity(quantity);

        //then
        assertThat(formatingQuantity).isEqualTo("\n8개를 구매했습니다.");
    }

    @DisplayName("당첨 내역의 출력 형식을 포맷팅 할 수 있다.")
    @Test
    void formatingWinningResult() {
        //given
        Map<LottoRank, Integer> winningResult = Map.of(
                LottoRank.FIRST, 2,
                LottoRank.FIFTH, 1
        );

        //when
        String formatingWinningResult = OutputFormatter.formatingWinningResult(winningResult);

        //then
        assertThat(formatingWinningResult).isEqualTo(
                """
                        3개 일치 (5,000원) - 1개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 2개"""
        );
    }

    @DisplayName("총 수익률의 출력 형식을 소수점 둘째 자리에서 올림하여 포맷팅 할 수 있다.")
    @Test
    void formatingRateOfReturnWithDecimals() {
        //given
        double rateOfReturn = 62.5000;

        //when
        String formatingRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);

        //then
        assertThat(formatingRateOfReturn).isEqualTo("총 수익률은 62.5%입니다.");
    }

    @DisplayName("총 수익률의 출력 형식을 천단위로 구분하여 포맷팅 할 수 있다.")
    @Test
    void formatingRateOfReturnWithComma() {
        //given
        double rateOfReturn = 1000000.0;

        //when
        String formatingRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);

        //then
        assertThat(formatingRateOfReturn).isEqualTo("총 수익률은 1,000,000.0%입니다.");
    }
}
