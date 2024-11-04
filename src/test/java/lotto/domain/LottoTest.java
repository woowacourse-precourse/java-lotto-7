package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_COUNT_NOT_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    void 정상_생성_테스트() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(validNumbers);

        assertNotNull(lotto);
        assertEquals(validNumbers, lotto.numbers());
    }

    @Test
    void 범위_검증_하한_테스트() {
        List<Integer> invalidNumbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_RANGE_NOT_MATCH.getMessage());
    }

    @Test
    void 범위_검증_상한_테스트() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_RANGE_NOT_MATCH.getMessage());
    }

    @Test
    void 두_로또_객체의_일치하는_번호_개수_반환_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 11, 22, 33));

        Set<Integer> matchingNumbers = lotto.numbers().stream()
                .filter(otherLotto.numbers()::contains)
                .collect(Collectors.toSet());

        assertEquals(matchingNumbers.size(), lotto.getMatchingCountWith(otherLotto));
    }

    @Test
    void 보너스_번호_포함_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(3);

        assertTrue(lotto.containsBonusNumber(bonusNumber));
    }

    @Test
    void 보너스_번호_불포함_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        assertFalse(lotto.containsBonusNumber(bonusNumber));
    }
}
