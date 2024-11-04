package lotto.model;

import static lotto.ErrorConstants.ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED;
import static lotto.ErrorConstants.ERROR_LOTTO_NUMBERS_SIZE;
import static lotto.ErrorConstants.ERROR_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호를 오름차순으로 정렬하여 저장한다. ")
    void testGetSortedLottoNumbersCase() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("예외: 로또 번호의 개수가 6개가 넘어가면 예외")
    void errorCase1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("예외: 로또 번호에 중복된 숫자가 있으면 예외")
    void errorCase2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED);
    }

    @Test
    @DisplayName("예외: 로또 번호가 1-45사이가 아니라면 예외")
    void errorCase3() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 90)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_NUMBER_RANGE);
    }
}
