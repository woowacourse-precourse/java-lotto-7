package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    List<LottoRank> lottoRanks;

    @BeforeEach
    void set_up() {
        lottoRanks = List.of(
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.FIFTH,
                LottoRank.FIFTH
        );
    }

    @Test
    @DisplayName("로또 결과 취합 기능")
    void 로또_결과_취합_기능() {
        //when
        LottoResult lottoResult = new LottoResult(lottoRanks);

        //expected
        assertThat(lottoResult.getLottoResults(LottoRank.NONE)).isEqualTo(6);
        assertThat(lottoResult.getLottoResults(LottoRank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 총 수입 알려준다 기능")
    void 로또_총_수입_알려준다_기능() {
        //when
        LottoResult lottoResult = new LottoResult(lottoRanks);

        //expected
        assertThat(lottoResult.calculateTotalIncome()).isEqualTo(10000);
    }

}