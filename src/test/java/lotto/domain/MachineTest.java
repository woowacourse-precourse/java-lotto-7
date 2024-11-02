package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MachineTest {

    @Test
    void 입력된_돈으로_티켓을_구매합니다() {
        //given
        int moneyIn = 3000;

        //when
        Machine machine = new Machine(moneyIn);
        int ticketCount = machine.getTicketCount();

        //then
        Assertions.assertThat(ticketCount).isEqualTo(3);
    }

    @Test
    void 주어진_갯수만큼_로또를_발행합니다() {
        //given
        int moneyIn = 3000;

        //when
        Machine machine = new Machine(moneyIn);
        int ticketCount = machine.getTicketCount();
        List<Lotto> tickets = machine.makeTickets();

        //then
        Assertions.assertThat(machine.getTickets().size()).isEqualTo(3);
    }

    @Test
    void 당첨_번호를_로또_번호와_대조합니다() {
        //given
        int moneyIn = 3000;

        //when
        Machine machine = new Machine(moneyIn);
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prizeNumber = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        int matchCount = machine.checkPrizeNumberMatch(ticket, prizeNumber);

        //then
        Assertions.assertThat(matchCount).isEqualTo(4);
    }

    @Test
    void 당첨_번호를_보너스_번호와_대조합니다() {
        //given
        int moneyIn = 3000;

        //when
        Machine machine = new Machine(moneyIn);
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;
        boolean isBonusNumberMatch = machine.checkBonusNumberMatch(bonusNumber, ticket);

        //then
        Assertions.assertThat(isBonusNumberMatch).isEqualTo(true);
    }
}