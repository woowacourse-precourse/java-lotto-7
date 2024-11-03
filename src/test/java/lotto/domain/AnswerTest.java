package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerTest {
    @Test
    void 보너스번호는_정답번호와_중복될_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Answer(List.of(1, 2, 3, 4, 5, 6), 4);
        });
    }

    @Test
    void 로또를_주면_당첨을_확인할_수_있다() {
        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningPrize prize = answer.match(lotto);

        assertThat(prize).isEqualTo(WinningPrize.FIRST);
    }
}