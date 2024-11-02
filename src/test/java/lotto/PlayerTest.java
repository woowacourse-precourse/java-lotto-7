package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * UserTest
 */
public class PlayerTest {

    @Test
    void buy_lotto_and_calculate_result() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Player player = new Player();
            player.buyLottos(2000);
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;
            player.evalutateLottos(winningNumbers, bonusNumber);
            assertThat(player.getRateOfReturn())
                .isEqualTo(((float)LottoRule.WINNING_PRIZE_TABLE[1] / 2000) * 100);
        },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(6, 7, 8, 9, 10, 11)
        );
    }

    @Test
    void throw_when_evaluate_before_buy_lotto() {
        Player player = new Player();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Throwable throwable = catchThrowable(
            () -> player.evalutateLottos(winningNumbers, bonusNumber)
        );

        assertThat(throwable)
            .isInstanceOf(IllegalStateException.class)
            .message().contains("[ERROR]");
    }
}
