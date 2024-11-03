package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Machine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MachineTest {

    @Test
    void 발행_횟수_만큼_로또_발행_되는지_테스트() {
        Machine machine = new Machine("8000");
        machine.publishLotto(machine.getMoney());

        int actual = machine.getLotteryTickets().size();

        Assertions.assertThat(actual).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1234", " ", "천만원", " 1000 "})
    void 공백없이_0원_이상의_1000원_단위로_나누어_떨어지는_숫자가_아니라면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> new Machine(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률() {
        Machine machine = new Machine("9000"); // 8장 발행 한다고 치고
        machine.lotteryTickets = new ArrayList<>();
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        machine.getLotteryTickets().add(List.of(1, 2, 3, 11, 12, 13));      //이거 5등 당첨 = 5000원

        Lotto lotto = new Lotto("1,2,3,4,5,6");
        String bonusNumber = "7";
        // 일치 확인
        lotto.matcheNumber(machine.getLotteryTickets(), bonusNumber);
        double expected = 55.6;

        Assertions.assertThat(machine.lateOfReturn()).isEqualTo(expected);
    }
}
