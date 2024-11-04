package lotto;

import lotto.dto.request.LottoMatchRequest;
import lotto.dto.response.LottoMatchResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 5개 이하면 예외가 발생한다.")
    void 로또_번호가_5개_이하면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 입력이 0개면 예외가 발생한다.")
    void 로또_번호가_입력이_0개면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외_발생() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        int duplicateBonusNumber = 3;
        assertThatThrownBy(() -> lotto.bonusNumberValidate(duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 숫자는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("matchNumberCount 메서드가 정확한 일치 개수와 보너스 일치 여부를 반환하는지 확인한다.")
    void 일치_개수와_보너스_번호_일치_여부() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);

        List<Integer> userNumbers = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 6;

        LottoMatchRequest request = new LottoMatchRequest(userNumbers, bonusNumber);
        LottoMatchResponse response = lotto.matchNumberCount(request);

        assertThat(response.matchCount()).isEqualTo(3);
        assertThat(response.isBonusMatch()).isTrue();
    }

    @Test
    @DisplayName("matchNumberCount 메서드가 보너스 번호가 일치하지 않는 경우를 정확하게 반환하는지 확인한다.")
    void 일치_개수와_보너스_번호_불일치_여부() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);

        List<Integer> userNumbers = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10; // 보너스 번호 불일치
        LottoMatchRequest request = new LottoMatchRequest(userNumbers, bonusNumber);

        LottoMatchResponse response = lotto.matchNumberCount(request);

        assertThat(response.matchCount()).isEqualTo(3); // 일치하는 숫자는 3개
        assertThat(response.isBonusMatch()).isFalse(); // 보너스 번호 불일치
    }
}
