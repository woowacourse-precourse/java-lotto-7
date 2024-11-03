package lotto.core.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void create_Lotto_should_be_pass() {
        // given
        // when
        List<Integer> numbers = List.of(1, 2, 3, 45, 5, 6);
        Lotto lotto = new Lotto(numbers);
        // then
        List<Integer> expected = List.of(1, 2, 3, 5, 6, 45);
        Assertions.assertEquals(expected, lotto.getNumbers());
    }

    @Test
    void create_Lotto_when_duplicated_number_in_numbers_should_be_fail() {
        // given
        // when
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        Assertions.assertEquals("로또 번호는 중복될 수 없습니다.", ex.getMessage());
    }

    @Test
    void create_Lotto_when_0_in_numbers_should_be_fail() {
        // given
        // when
        List<Integer> numbers = List.of(1, 2, 3, 0, 5, 6);
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        Assertions.assertEquals("로또 번호는 1부터 45 사이의 숫자만 가능합니다.", ex.getMessage());
    }

    @Test
    void create_Lotto_when_46_in_numbers_should_be_fail() {
        // given
        // when
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        Assertions.assertEquals("로또 번호는 1부터 45 사이의 숫자만 가능합니다.", ex.getMessage());
    }

    @Test
    void getMatchCount_given_all_match_lotto_should_be_pass() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        int count = lotto.getMatchCount(winningLotto);
        // then
        Assertions.assertEquals(6, count);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @Test
    void getMatchCount_given_3_match_lotto_should_be_pass() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 4, 6, 10, 12, 45));
        // when
        int count = lotto.getMatchCount(winningLotto);
        // then
        Assertions.assertEquals(3, count);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @Test
    void getMatchCount_given_none_match_lotto_should_be_pass() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        // when
        int count = lotto.getMatchCount(winningLotto);
        // then
        Assertions.assertEquals(0, count);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @Test
    void containsBonusNumber_given_contains_should_be_pass() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(5);
        // when
        boolean contains = lotto.containsBonusNumber(bonusNumber);
        // then
        Assertions.assertTrue(contains);
    }

    @Test
    void containsBonusNumber_given_not_contains_should_be_pass() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(40);
        // when
        boolean contains = lotto.containsBonusNumber(bonusNumber);
        // then
        Assertions.assertFalse(contains);
    }
}
