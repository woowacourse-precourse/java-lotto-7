package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMatcherTest {
    private Lotto winningLotto;
    private int bonusNumber;
    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 5, 10, 15, 20, 25));
        bonusNumber = 7;
        lottoMatcher = new LottoMatcher(winningLotto, bonusNumber);
    }

    @Test
    @DisplayName("번호가 6개 일치할 때 1등이 반환된다.")
    void 번호가_6개_일치할_때_1등이_반환된다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 5, 10, 15, 20, 25));
        // when
        LottoRank rank = lottoMatcher.determineRank(lotto);
        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("번호가 5개와 보너스 번호가 일치할 때 2등이 반환된다.")
    void 번호가_5개와_보너스_번호가_일치할_때_2등이_반환된다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 5, 7, 15, 20, 25));
        // when
        LottoRank rank = lottoMatcher.determineRank(lotto);
        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("번호가 5개 일치할 때 3등이 반환된다.")
    void 번호가_5개_일치할_때_3등이_반환된다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 5, 10, 15, 20, 40));
        // when
        LottoRank rank = lottoMatcher.determineRank(lotto);
        // then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("번호가 아무것도 일치하지 않을 때 낙첨이 반환된다.")
    void 번호가_아무것도_일치하지_않을때_낙첨이_반환된다() {
        // given
        Lotto lotto = new Lotto(List.of(22, 24, 26, 28, 30, 32));
        // when
        LottoRank rank = lottoMatcher.determineRank(lotto);
        // then
        assertThat(rank).isEqualTo(LottoRank.MISS);
    }
}
