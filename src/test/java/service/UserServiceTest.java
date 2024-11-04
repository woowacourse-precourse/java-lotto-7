package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Rank;
import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoGenerator;

public class UserServiceTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final UserService userService = new UserService(lottoGenerator);

    @DisplayName("회원의 구입 금액에 해당하는 만큼 로또를 발급한다.")
    @Test
    void issueLotto() {
        // given
        User user = new User(8_000);

        // when
        userService.issueLotto(user);

        // then
        assertEquals(user.getPurchaseCount(), user.getLottos().size());
    }

    @DisplayName("당첨 결과에 따른 수익률을 업데이트한다.")
    @Test
    void updateRateOfReturn() {
        // given
        User user = new User(8_000);
        user.addRank(Rank.FIFTH);
        double expectedRateOfReturn = 62.5;

        // when
        userService.updateRateOfReturn(user);

        // then
        assertEquals(expectedRateOfReturn, user.getRateOfReturn());
    }
}

