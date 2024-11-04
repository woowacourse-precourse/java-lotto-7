package lotto.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.service.LottoBowl;
import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBowlTest {

    @DisplayName("티켓 숫자와 알맞는 사이즈의 로또 묶음을 반환하는지 테스트합니다.")
    @Test
    void 로또_갯수_테스트() {
        Money testMoney = new Money(6000);
        Ticket testTicket = Ticket.of(testMoney);

        LottoBowl testLottoBowl = LottoBowl.from(testTicket);
        List<Lotto> testLotties = testLottoBowl.publishLotties().getLotties();

        assertThat(testLotties.size()).isEqualTo(6);
    }
}
