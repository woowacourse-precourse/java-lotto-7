package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.MessageContainer.COUNT_OF_LOTTO_NUMBERS_ERROR;
import static lotto.MessageContainer.DUPLICATE_NUMBER_ERROR;
import static lotto.MessageContainer.ERROR_LABEL;
import static lotto.MessageContainer.OUT_OF_RANGE_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_LABEL)
                .hasMessage(COUNT_OF_LOTTO_NUMBERS_ERROR);
    }

    @DisplayName("로또 번호의 개수가 6개보다 모자라면 예외가 발생한다.")
    @Test
    void throwIllegalArgumentExceptionIfParameterSizeIsLessThan6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_LABEL)
                .hasMessage(COUNT_OF_LOTTO_NUMBERS_ERROR);
    }

    @DisplayName("로또 번호의 개수가 6개면 Lotto 인스턴스를 생성한다.")
    @Test
    void createLottoIfParameterSizeIs6() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(Lotto.class)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_LABEL)
                .hasMessage(DUPLICATE_NUMBER_ERROR);
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 Lotto 인스턴스를 생성한다.")
    @Test
    void createLottoIfLottoNumbersHaveNoDuplicates() {
        assertThat(new Lotto(List.of(7, 8, 9, 10, 11, 12)))
                .isInstanceOf(Lotto.class)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void throwIllegalArgumentExceptionIfAnyNumberIsOutOfRange(int outOfRangeNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, outOfRangeNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_LABEL)
                .hasMessage(OUT_OF_RANGE_NUMBER_ERROR);
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 없으면 Lotto 인스턴스를 생성한다.")
    @Test
    void createLottoIfAllNumbersAreInRange() {
        assertThat(new Lotto(List.of(1, 2, 20, 39, 44, 45)))
                .isInstanceOf(Lotto.class)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }
}
