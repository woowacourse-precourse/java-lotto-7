package lotto;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("입력값(당첨번호, 보너스번호)이 주어진 범위(1~45) 내에 존재하지 않으면 예외가 발생한다.")
    @Test
    void 입력값이_주어진_범위_내에_존재하지_않으면_예외가_발생한다() {
        assertThat(InputValidation.NOT_IN_RANGE_1_TO_45.validate("100")).isFalse();
    }

    @Test
    void 로또_객체_내_numbers_필드를_리턴한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}
