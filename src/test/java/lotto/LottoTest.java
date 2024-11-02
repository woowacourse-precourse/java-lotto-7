package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void create_a_valid_lotto() {
        new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void calculate_winning_prize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto forth = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto none = new Lotto(List.of(1, 2, 10, 11, 12, 13));

        int firstPrize = first.getPlace(winningNumbers, bonus);
        int secondPrize = second.getPlace(winningNumbers, bonus);
        int thirdPrize = third.getPlace(winningNumbers, bonus);
        int forthPrize = forth.getPlace(winningNumbers, bonus);
        int fifthPrize = fifth.getPlace(winningNumbers, bonus);
        int nonePrize = none.getPlace(winningNumbers, bonus);

        assertThat(firstPrize).isEqualTo(1);
        assertThat(secondPrize).isEqualTo(2);
        assertThat(thirdPrize).isEqualTo(3);
        assertThat(forthPrize).isEqualTo(4);
        assertThat(fifthPrize).isEqualTo(5);
        assertThat(nonePrize).isEqualTo(0);
    }

    @Test
    void print_the_numbers_of_lottery_in_ascending_order() {
        List<Integer> numbers = List.of(35, 2, 9, 17, 23, 22);
        Lotto lotto = new Lotto(numbers);

        List<Integer> lottoNumbers = lotto.getSortedNumbers();

        assertThat(lottoNumbers)
            .hasSize(6)
            .containsAll(numbers)
            .isSorted();
    }
}
