package lotto;

import lotto.model.Lotto;
import lotto.service.LottoProvideService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final LottoProvideService lottoProvideService = new LottoProvideService();
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

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1,2,3,4,5,3000", "0,1,2,3,4,5", "-1,1,2,3,4,5"})
    void 로또_번호는_1과_45_사이의_숫자가_아니면_실패한다(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoProvideService.publishWinningLotto(input);
        });
    }
}
