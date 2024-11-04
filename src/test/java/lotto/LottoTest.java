package lotto;

import org.junit.jupiter.api.Assertions;
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
    @DisplayName("로또 번호와 보너스 번호 사이 중복을 확인한다.")
    void 로또_번호와_보너스_번호_사이_중복을_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsBonusNumber(5)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 번호 숫자의 범위는 1 ~ 45 사이이며, 아닐경우 예외가 발생한다")
    void 로또_번호_범위_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 50));
        Validator validator = new Validator();
        assertThatThrownBy(
                () -> validator.validateLottoNumbers(lotto.getIssuedLottoNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
