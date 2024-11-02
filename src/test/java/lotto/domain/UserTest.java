package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("정상적인 유저 생성 검증")
    void 정상_유저_생성_검증() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        //when
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        //then
        assertThat(user.getLottos().getLottos()).isEqualTo(lottos.getLottos());
        assertThat(user.getMoney().getMoney()).isEqualTo(money.getMoney());
    }
}
