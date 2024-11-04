package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    void 로또_번호에_따른_정답_판단(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> answers_six = List.of(1, 2, 3, 4, 5, 6);
        Grade grade_six = lotto.judgeLotto(answers_six,7);
        assertEquals(grade_six, Grade.MATCH6);

        List<Integer> answers_five = List.of(1, 2, 3, 4, 5, 9);
        Grade grade_five = lotto.judgeLotto(answers_five,7);
        assertEquals(grade_five, Grade.MATCH5);

        List<Integer> answers_bonus = List.of(1, 2, 3, 4, 5, 7);
        Grade grade_bonus = lotto.judgeLotto(answers_bonus,6);
        assertEquals(grade_bonus, Grade.MATCH5_BONUS);
    }

}
