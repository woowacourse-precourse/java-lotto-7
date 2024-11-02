package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @Test
    void 발행_횟수_만큼_로또_발행_되는지_테스트() {
        User user = new User(8000);
        user.moneyToTicket(user.money);

        int actual = user.lotteryTickets.size();

        Assertions.assertThat(actual).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 1234, 18009})
    void 구입_금액이_음수일때와_1000원_으로_나누어_떨어지지_않으면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> new User(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_점수_1_부터_45_까지의_정수가_아닐_때_예외가_발생한다() {
        User user = new User(1000);
        assertThatThrownBy(() -> user.specifyBonusNumber(47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률() {
        User user = new User(8000); // 8장 발행 한다고 치고
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(8, 9, 10, 11, 12, 13));
        user.lotteryTickets.add(List.of(1, 2, 3, 11, 12, 13));      //이거 5등 당첨 = 5000원

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        user.bonusNumber = 7;

        // 일치 확인
        lotto.matcheNumber(user.lotteryTickets, user.bonusNumber);
        double expected = 62.5;

        Assertions.assertThat(user.lateOfReturn()).isEqualTo(expected);
    }
}
