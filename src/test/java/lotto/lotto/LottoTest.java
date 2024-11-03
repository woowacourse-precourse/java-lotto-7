package lotto.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("구입금액으로 구매할 수 있는 로또 갯수를 출력한다.")
    public void testPurchasableQuantityBasedOnMoney() {
        // given
        User user = new User();
        Lottos lottos = new Lottos();
        user.setMoney("10000");
        user.setNumOfLottos();

        // when
        LottoService.makeLottoNumber(user, lottos);
        int lottoCount = lottos.getLottosSize();

        // then
        assertEquals(lottoCount, 10);
    }

    @Test
    @DisplayName("1 ~ 45사이의 중복되지 않는 정수 6개를 Lotto 객체에 저장한다.")
    public void testIsNotDuplicatedSixNumber() {
        // given
        List<Integer> Lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // when
        HashSet<Integer> LottoSet = new HashSet<>(Lotto);

        // then
        assertEquals(Lotto.size(), LottoSet.size());
    }

    @Test
    @DisplayName("1 ~ 45사이의 중복되지 않는 정수 6개를 Lotto 객체에 저장한다.")
    public void testIsDuplicatedSixNumber() {
        // given
        List<Integer> Lotto = Arrays.asList(1, 1, 2, 5, 27, 9);

        // when
        HashSet<Integer> LottoSet = new HashSet<>(Lotto);

        // then
        assertNotEquals(Lotto.size(), LottoSet.size());
    }
}
