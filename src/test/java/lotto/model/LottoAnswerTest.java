package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    @Test
    @DisplayName("보너스 번호와 당첨 번호가 중복되는 경우")
    void bonusNumberDuplicatedErrorTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 6;

        //when && then
        assertThatThrownBy(() -> new LottoAnswer(numbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LottoErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 범위가 1부터 45 사이가 아닌 경우")
    void bonusNumberRangeErrorTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 46;

        //when && then
        assertThatThrownBy(() -> new LottoAnswer(numbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LottoErrorMessage.LOTTO_BONUS_NUMBER_RANGE_ERROR.getMessage());
    }
}