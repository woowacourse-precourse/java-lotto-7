package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static final Integer LOTTO_RANKS_SIZE = 6;

    @DisplayName("결과 목록 초기화 테스트")
    @Test
    void 결과_목록_초기화_테스트() {
        LottoResult lottoResult = new LottoResult(8000);
        assertThat(lottoResult.getLottoRankBoard().size()).isEqualTo(LOTTO_RANKS_SIZE);
    }

    @DisplayName("로또 등수 확인 테스트")
    @Test
    void 로또_등수_확인_테스트() {
        LottoResult lottoResult = new LottoResult(8000);
        lottoResult.checkLottoRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new MyLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7)
        );
        assertThat(lottoResult.getLottoRankBoard().get(LottoRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 수익률_계산_테스트() {
        LottoResult lottoResult = new LottoResult(5000);
        lottoResult.checkLottoRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new MyLotto(new Lotto(List.of(1, 2, 3, 4, 5, 10)), 7)
        );
        assertThat(lottoResult.calcRateOfReturn()).isEqualTo(30000.0);
    }
}
