package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 로또_결과를_한개_저장한다() {
        assertSimpleTest(() -> {
            LottoResult lottoResult = new LottoResult();
            lottoResult.putResult(Rank._2TH);
            assertThat(lottoResult.getResult().get(Rank._1TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank._2TH)).isEqualTo(1);
            assertThat(lottoResult.getResult().get(Rank._3TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank._4TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank._5TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank.LAST)).isZero();
        });
    }

    @Test
    void 로또_결과를_여러개_저장한다() {
        assertSimpleTest(() -> {
            LottoResult lottoResult = new LottoResult();
            lottoResult.putResult(Rank._2TH);
            lottoResult.putResult(Rank._2TH);
            lottoResult.putResult(Rank._1TH);
            assertThat(lottoResult.getResult().get(Rank._1TH)).isEqualTo(1);
            assertThat(lottoResult.getResult().get(Rank._2TH)).isEqualTo(2);
            assertThat(lottoResult.getResult().get(Rank._3TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank._4TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank._5TH)).isZero();
            assertThat(lottoResult.getResult().get(Rank.LAST)).isZero();
        });
    }

    @Test
    void 로또_전체_당첨_금액을_계산한다() {
        assertSimpleTest(() -> {
            LottoResult lottoResult = new LottoResult();
            lottoResult.putResult(Rank._2TH);
            lottoResult.putResult(Rank._2TH);
            lottoResult.putResult(Rank._1TH);
            long expect = Rank._2TH.getPrice() * 2 + Rank._1TH.getPrice();
            assertThat(lottoResult.computeTotalPrice()).isEqualTo(expect);
        });
    }

    @Test
    void 로또_수익률을_계산한다() {
        assertSimpleTest(() -> {
            LottoResult lottoResult = new LottoResult();
            lottoResult.putResult(Rank._5TH);
            assertThat(lottoResult.computeProfit(2000)).isEqualTo(250.0);
        });
    }
}
