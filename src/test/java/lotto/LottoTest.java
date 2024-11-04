package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Machine;
import lotto.model.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1부터_45까지의_정수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,-2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2,3,4,5,5", " ", ",1,2,3,4,5"})
    void 로또_번호_입력에_공백만_있거나_공백이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1, 2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"-7", "50", " ", "칠", " 50 "})
    void 공백없이_1부터_45까지의_숫자가_아니라면_예외가_발생한다(String value) {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Machine machine = new Machine("8000");

        assertThatThrownBy(
                () -> lotto.matcheNumber(machine.getLotteryTickets(), value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_중복_되는_보너스_번호일_경우_예외가_발생한다() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Machine machine = new Machine("8000");

        assertThatThrownBy(
                () -> lotto.matcheNumber(machine.getLotteryTickets(), "4"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 티켓_당_당첨_갯수_증가_테스트() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<List<Integer>> lotteryTickets = new ArrayList<>();
        lotteryTickets.add(List.of(1, 2, 3, 4, 5, 6));      // 1등
        lotteryTickets.add(List.of(1, 2, 3, 4, 5, 7));      // 2등
        lotteryTickets.add(List.of(1, 2, 3, 4, 5, 30));     // 3등
        lotteryTickets.add(List.of(1, 2, 3, 4, 31, 30));    // 4등
        lotteryTickets.add(List.of(1, 2, 3, 32, 31, 30));   // 5등

        String bonusNumberString = "7";

        lotto.matcheNumber(lotteryTickets, bonusNumberString);

        // 1등 ~ 5등 카운트
        List<Integer> actual = new ArrayList<>();
        for (Result result : Result.values()) {
            actual.add(result.getCount());
        }

        List<Integer> expect = new ArrayList<>(List.of(1, 1, 1, 1, 1));

        Assertions.assertThat(actual).isEqualTo(expect);
    }
}
