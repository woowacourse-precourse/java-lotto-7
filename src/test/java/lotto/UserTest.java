package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 발행_횟수_만큼_로또_발행_되는지_테스트() {
        User user = new User();

        user.publishLotto(8);
        int actual = user.lotteryTickets.size();

        Assertions.assertThat(actual).isEqualTo(8);
    }

}
