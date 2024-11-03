package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    final int LOTTO_COST = 1000;
    final UserService userService = new UserService();

    @Test
    void 구입_금액을_입력받아_구매_갯수를_반환한다() {
        // given
        String input = "10000";

        // when
        int actual = userService.calculateLottoQuantity(input);

        Money money = new Money("10000");
        int expected = money.getPrice() / LOTTO_COST;

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 당첨_번호를_입력받아_Lotto_객체를_생성한다() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Lotto winningLotto = userService.createWinningLotto(input);

        List<Integer> actual = winningLotto.getNumbers();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 보너스_번호를_입력받아_BonusNumber_객체를_생성한다() {
        // given
        String input = "7";
        Lotto winningLotto = userService.createWinningLotto("1,2,3,4,5,6");

        // when
        BonusNumber bonusNumber = userService.createBonusNumber(winningLotto, input);

        int actual = bonusNumber.getNumber();
        int expected = 7;

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
