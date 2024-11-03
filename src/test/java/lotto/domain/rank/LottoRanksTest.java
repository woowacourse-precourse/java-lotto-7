package lotto.domain.rank;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.money.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoRanksTest {

    @CsvSource(textBlock = """
        8000,FIFTH,62.5
        0,FIFTH,0
        1000,FIFTH,500
        """)
    @ParameterizedTest
    void 금액을_전달하여_수익률을_계산할_수_있다(int amount, LottoRank rank, double expected) {
        // given
        LottoRanks lottoRanks = new LottoRanks();
        lottoRanks.add(rank);
        Money money = new Money(amount);

        // when
        double totalReturnRate = lottoRanks.calculateTotalReturnRate(money);

        // then
        assertThat(totalReturnRate).isEqualTo(expected);
    }

}
