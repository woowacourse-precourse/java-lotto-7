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

    @Test
    public void 당첨_번호_일치_개수_확인() throws Exception {
    	//given
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> testWinningNumber = List.of(1, 2, 3, 4, 5, 6);
        int testBonusNumber = 7;

        WinningLotto testWinningLotto = WinningLotto.of(testWinningNumber, testBonusNumber);

        int expectedMatchCount = 6;
        //when
        int actualMatchCount = testLotto.getMatchCount(testWinningLotto);

        //then
        assertEquals(expectedMatchCount, actualMatchCount);
    }

    @Test
    public void 보너스_번호_일치_여부_확인() throws Exception {
    	//given
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> testWinningNumber = List.of(1, 2, 3, 4, 5, 6);
        int testBonusNumber = 7;

        WinningLotto testWinningLotto = WinningLotto.of(testWinningNumber, testBonusNumber);

        int expectedMatchCount = 6;
    	//when
        int actualMatchCount = testLotto.getMatchCount(testWinningLotto);

        //then
        assertEquals(expectedMatchCount, actualMatchCount);

    }
}
