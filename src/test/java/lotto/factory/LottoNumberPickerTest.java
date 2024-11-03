package lotto.factory;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberPickerTest {

    @DisplayName("번호를 무작위로 선택하여 정렬된 Lotto 객체로 반환한다.")
    @Test
    void 번호를_무작위로_선택하여_정렬된_리스트로_반환() {
        Lotto lotto = LottoNumberPicker.pickSortedRandomNumbers();

        assertThat(lotto.numbers()).hasSize(6);
        assertThat(lotto.numbers()).isSorted();
        assertThat(lotto.numbers()).allMatch(number -> number >= 1 && number <= 45);
    }
}
