package lotto;

import lotto.model.LottoRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @DisplayName("당첨된 경우 잘 처리하는지 확인")
    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6,  FIRST",
            "1,2,3,4,5,7,  SECOND",
            "1,2,3,4,5,8,  THIRD",
            "1,2,13,4,5,7, FOURTH",
            "11,12,3,4,5,7,FIFTH"
    })
    void 당첨_결과_확인_테스트(
            int n1, int n2, int n3, int n4, int n5, int n6,
            LottoRank expectedRank) {
        Lotto lotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertEquals(expectedRank, lotto.winningCheck(winningNumbers, bonusNumber));
    }

    @DisplayName("미당첨인 경우 null 반환 확인 테스트")
    @ParameterizedTest
    @CsvSource({
            "11,12,13,14,15,17",
            "11,12,13,14,3,1",
            "11,3,1,7,15,17",
    })
    void 미당첨_결과_확인_테스트(int n1,int n2, int n3, int n4, int n5,int n6) {
        Lotto lotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertNull(lotto.winningCheck(winningNumbers, bonusNumber));
    }
}
