package lotto;

import lotto.lotto.Announcer;
import lotto.lotto.value.Lotto;
import lotto.lotto.value.Prize;
import lotto.lotto.value.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호와 당첨 번호를 비교하여 상금을 구한다.")
    @Test
    void compareNumberTest() {
        // given
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(list);

        Announcer announcer = new Announcer(winningNumber, 7);

        // when
        List<Prize> prizes = announcer.compareLottoResult(List.of(ticket));

        // then
        Assertions.assertThat(prizes).containsExactly(Prize.FIRST);
    }

    @DisplayName("로또 번호들과 당첨 번호를 비교하여 상금을 구한다.")
    @Test
    void compareManyNumbersTest() {
        // given
        Lotto ticket1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto ticket2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto ticket3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(list);

        Announcer announcer = new Announcer(winningNumber, 7);

        // when
        List<Prize> prizes = announcer.compareLottoResult(List.of(ticket1, ticket2, ticket3));

        // then
        Assertions.assertThat(prizes).containsExactly(Prize.FIRST, Prize.SECOND, Prize.FIRST);
    }

    @DisplayName("로또 번호 8개를 비교한다")
    @Test
    void compare() {
        // given
        Lotto ticket1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto ticket2 =new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto ticket3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto ticket4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto ticket5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto ticket6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto ticket7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto ticket8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        List<Lotto> tickets = List.of(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8);

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(list);

        Announcer announcer = new Announcer(winningNumber, 7);

        // when
        List<Prize> prizes = announcer.compareLottoResult(tickets);

        // then
        Assertions.assertThat(prizes).contains(Prize.FIFTH);
    }
}
