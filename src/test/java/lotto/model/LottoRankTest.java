package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("1등 결과 출력 테스트")
    void 일등_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(6, false);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(2_000_000_000);
        assertThat(lottoRank.getDescription()).isEqualTo("6개 일치 (2,000,000,000원)");
    }

    @Test
    @DisplayName("2등 결과 출력 테스트")
    void 이등_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(5, true);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(30_000_000);
        assertThat(lottoRank.getDescription()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
    }

    @Test
    @DisplayName("3등 결과 출력 테스트")
    void 삼등_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(5, false);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(1_500_000);
        assertThat(lottoRank.getDescription()).isEqualTo("5개 일치 (1,500,000원)");
    }

    @Test
    @DisplayName("4등 결과 출력 테스트")
    void 사등_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(4, false);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(50_000);
        assertThat(lottoRank.getDescription()).isEqualTo("4개 일치 (50,000원)");
    }

    @Test
    @DisplayName("5등 결과 출력 테스트")
    void 오등_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(3, false);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(5_000);
        assertThat(lottoRank.getDescription()).isEqualTo("3개 일치 (5,000원)");
    }

    @Test
    @DisplayName("탈락 결과 출력 테스트")
    void 탈락_결과() {
        //given
        LottoRank lottoRank = LottoRank.valueOf(-1, true);

        //expected
        assertThat(lottoRank.getPrize()).isEqualTo(0);
        assertThat(lottoRank.getDescription()).isEqualTo("당첨되지 않음");
    }

}