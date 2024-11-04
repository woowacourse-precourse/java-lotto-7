package lotto.model;

import lotto.controller.LottoController;
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
    void toString_양식() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = lotto.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void validate_생성자_List_길이가_6이_아니면_예외_5개() {
        assertThatThrownBy(() -> {
            // given
            new Lotto(List.of(1, 2, 3, 4, 5));

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void validate_생성자_List_길이가_6이_아니면_예외_7개() {
        assertThatThrownBy(() -> {
            // given
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void validateIsElementInRange_로또_번호가_1부터_45사이가_아니면_예외_46() {
        assertThatThrownBy(() -> {
            // given
            new Lotto(List.of(1, 2, 3, 4, 5, 46));

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
    }

    @Test
    void validateIsElementInRange_로또_번호가_1부터_45사이가_아니면_예외_음수() {
        assertThatThrownBy(() -> {
            // given
            new Lotto(List.of(-1, 2, 3, 4, 5, 45));

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
    }

    @Test
    void validateIsUnique_로또_번호가_중복되면_예외() {
        assertThatThrownBy(() -> {
            // given
            new Lotto(List.of(1, 2, 3, 4, 5, 5));

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

}
