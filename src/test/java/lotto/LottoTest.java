package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("1~45 범위의 수가 아니라면 예외발생")
    @Test
    void 비정상_범위의_로또번호라면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또번호가 포매팅될때 오름차순으로 정렬된다.")
    @Test
    void 로또번호가_포매팅될때_오름차순으로_정렬된다() {
        // given
        Lotto lotto = new Lotto(List.of(3, 2, 1, 4, 6, 5));
        String expectedLottoNumbers = "[1, 2, 3, 4, 5, 6]\n";

        // when
        String actualLottoNumbers = lotto.getLottoNumbers();

        // then
        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }
}
