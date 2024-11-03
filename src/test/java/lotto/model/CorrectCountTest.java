package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CorrectCountTest {

    @Test
    void 보너스가_있음을_전달받으면_상태를_갱신한다() {
        //given
        int count = 5;
        CorrectCount correctCount = CorrectCount.from(count);

        //when
        correctCount.updateBonus();

        //then
        Assertions.assertThat(correctCount.hasBonus()).isTrue();
    }
}
