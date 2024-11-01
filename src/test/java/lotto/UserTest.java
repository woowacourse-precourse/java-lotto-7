package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 발행_횟수_만큼_로또_발행_되는지_테스트() {
        User user = new User(8000);
        user.moneyToTicket(user.money);

        int actual = user.lotteryTickets.size();

        Assertions.assertThat(actual).isEqualTo(8);
    }

    @Test
    void 구입_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new User(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
