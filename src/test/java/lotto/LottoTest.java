package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void 번호_일치_개수(){

        // 주어진 로또 번호
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        // 당첨 번호
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

        // 구매 로또 번호와 당첨 번호가 일치하는 개수
        int matchedSize = lotto.getMatchedSize(winningNumbers);

        // 예상 결과 (1, 2, 3 일치 => 예상 결과 3)
        assertEquals(3, matchedSize);
    }
    @Test
    void 보너스_번호_있음(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        int bonusNumber = 7;
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        assertFalse(hasBonusNumber);
    }
    @Test
    void 보너스_번호_없음(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        int bonusNumber = 6;
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        assertTrue(hasBonusNumber);
    }
}
