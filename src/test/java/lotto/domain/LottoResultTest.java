package lotto.domain;

import org.junit.jupiter.api.BeforeEach;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    LottoResult lottoResult;
    PaymentInput paymentInput;

    @BeforeEach
    void setUp() {
        Map<Rank, Integer> expected = new EnumMap<>(Rank.class);

        expected.put(Rank.UNDER_TWO_HIT, 1);
        expected.put(Rank.THREE_HIT, 1);
        expected.put(Rank.FOUR_HIT, 0);
        expected.put(Rank.FIVE_HIT_WITHOUT_BONUS, 0);
        expected.put(Rank.FIVE_HIT_WITH_BONUS, 0);
        expected.put(Rank.SIX_HIT, 0);

        paymentInput = new PaymentInput(8000);
        lottoResult=new LottoResult(expected);
    }

    @Test
    void 수익률을_구한다() {
        assertThat(lottoResult.calculateInvestment(paymentInput)).isEqualTo(62.5);
        }
    }
