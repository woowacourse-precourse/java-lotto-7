package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 번호_문자열_변환_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        String string = lotto.toString();

        //then
        assertEquals(string, "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 보너스_번호_중복_검사_예외_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //then
        assertThrows(IllegalArgumentException.class,
            () ->lotto.checkBonusNumberDuplication(bonusNumber));
    }

    @Test
    void 같은_로또_번호_카운트_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        //when
        int count = lotto.countContainNumber(winningLotto);

        //then
        assertEquals(count, 5);
    }

    @Test
    void 테스트_번호_확인_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int countNumber = 5;
        int bonusNumber1 = 1;
        int bonusNumber2 = 45;

        //when & then
        assertTrue(lotto.needBonusNumber(countNumber, bonusNumber1));
        assertFalse(lotto.needBonusNumber(countNumber, bonusNumber2));
    }
}
