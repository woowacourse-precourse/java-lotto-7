package lotto.model;

import lotto.constant.LottoNumberRange;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 정확히 6개일 경우 객체 생성이 성공한다.")
    void 로또_번호가_6개_일_경우_객체_생성_성공한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers().size()).isEqualTo(LottoNumberRange.LOTTO_NUMBER_SIZE.getValue());
    }

    @Test
    @DisplayName("로또 번호가 정확히 6개일 경우 객체 생성이 성공한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 보다 모자르면 예외가 발생한다")
    void 로또_번호의_개수가_6개_보다_모자르면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 정렬된 상태로 반환된다.")
    void 로또_번호가_정렬된_상태로_반환된다() {
        Lotto lotto = new Lotto(List.of(6, 3, 5, 1, 4, 2));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호가 특정 숫자를 포함하고 있는지 확인한다.")
    void 로또_번호가_특정_숫자를_포함하는지_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isContainsNumber(3)).isTrue();
        assertThat(lotto.isContainsNumber(7)).isFalse();
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 번호의 개수를 반환한다.")
    void 당첨_번호와_일치하는_번호의_개수를_반환한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(playerLotto.winningNumberCount(winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto 객체를 LottoDto 객체로 변환할 수 있다.")
    void 로또_객체를_Dto_객체로_변환할_수_있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDto lottoDto = lotto.toDto();

        assertThat(lottoDto).isNotNull();
    }
}
