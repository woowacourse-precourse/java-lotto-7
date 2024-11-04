package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoComparatorTest {

    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final int bonusNumber = 7;
    private final List<Lotto> userLottos = List.of(
            new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 3개 일치, 보너스 번호 일치
            new Lotto(List.of(10, 11, 12, 13, 14, 15)), // 일치하는 번호 없음
            new Lotto(List.of(1, 2, 3, 4, 5, 6)) // 6개 일치, 보너스 번호 미일치
    );

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외_발생() {
        // when & then
        assertThatThrownBy(() -> LottoComparator.validateBonusNumber(winningLotto, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("각 로또 결과를 올바르게 반환하는지 확인")
    void 각_로또_결과를_올바르게_변환하는지_확인() {
        // when
        List<LottoResult> results = LottoComparator.getLottoResults(userLottos, winningLotto, bonusNumber);

        // then
        // 1. 결과 개수 확인
        assertThat(results).hasSize(userLottos.size());

        // 2. 첫 번째 로또 결과 검증 - 3개 일치, 보너스 번호 일치
        assertThat(results.get(0).getMatchCount()).isEqualTo(3);
        assertThat(results.get(0).isBonusMatched()).isTrue();

        // 3. 두 번째 로또 결과 검증 - 일치 없음
        assertThat(results.get(1).getMatchCount()).isEqualTo(0);
        assertThat(results.get(1).isBonusMatched()).isFalse();

        // 4. 세 번째 로또 결과 검증 - 6개 일치, 보너스 번호 미일치
        assertThat(results.get(2).getMatchCount()).isEqualTo(6);
        assertThat(results.get(2).isBonusMatched()).isFalse();
    }
}
