package lotto.lotto.domain;

import java.util.List;
import lotto.lotto.domain.value.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }


    @Test
    @DisplayName("LottoResult 객체를 생성한다.")
    void createLottoResultTest() {
        // when
        LottoResult lottoResult = LottoResult.create(lotto);

        // then
        Assertions.assertThat(lottoResult.getLotto()).isEqualTo(lotto);
    }

    @Test
    @DisplayName("LottoResult 객체의 rank를 업데이트한다.")
    void updateLottoResultRankTest() {
        // given
        LottoResult lottoResult = LottoResult.create(lotto);

        // when
        LottoResult lottoResultMatched = lottoResult.updateLottoRank(LottoRank.MATCHED6);

        // then
        Assertions.assertThat(lottoResultMatched.getLottoRank()).isEqualTo(LottoRank.MATCHED6);
    }

    @Test
    @DisplayName("아직 match되지 않은 객체의 rank 정보에 접근하면 IllegalStateException을 던진다.")
    void undeterminedLottoRankExceptionTest() {
        // when
        LottoResult lottoResult = LottoResult.create(lotto);

        // then
        Assertions.assertThatThrownBy(lottoResult::getLottoRank)
                .isInstanceOf(IllegalStateException.class);
    }

}