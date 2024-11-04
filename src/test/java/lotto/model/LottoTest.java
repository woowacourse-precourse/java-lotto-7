package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.ExceptionMessage;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.enums.ExceptionMessage.INVALID_LOTTO_NUM_RANGE;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호는 오름차순으로 정렬된다")
    @Test
    void numberSortTest() {
        Lotto lotto = new Lotto(List.of(6, 7, 8, 1, 2, 3));
        List<Integer> expectNumbers = new ArrayList<>(List.of(1, 2, 3, 6, 7,8));
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(expectNumbers);
    }

    @DisplayName("로또 번호는 지정된 범위 안에서 포함되어야한다.")
    @Test
    void invalidRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5,46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUM_RANGE.getMessage());
    }
}
