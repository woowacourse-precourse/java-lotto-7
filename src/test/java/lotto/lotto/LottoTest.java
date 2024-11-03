package lotto.lotto;

import static lotto.service.LottoService.getRandomLottoNumber;
import static lotto.service.LottoService.sortAscending;
import static lotto.validate.LottosValidate.isAscendingNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Integer> Lotto = getRandomLottoNumber();

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

    @Test
    @DisplayName("로또 번호를 오름차순 정렬한다.")
    public void testSortAscending() {
        // given
        List<Integer> Lotto = getRandomLottoNumber();

        // when
        sortAscending(Lotto);

        // then
        assertThat(Lotto).isSorted();
    }

    @Test
    @DisplayName("로또 번호를 오름차순 정렬되었는지 확인한다.")
    public void testIsSortAscending() {
        // given
        List<Integer> Lotto = getRandomLottoNumber();
        sortAscending(Lotto);

        // then
        assertTrue(isAscendingNumber(Lotto));
    }

    @Test
    @DisplayName("로또 번호를 오름차순 정렬되지 않는 상황은 불가능하다.")
    public void testIsNotSortAscending() {
        // given
        List<Integer> Lotto = getRandomLottoNumber();

        // then
        assertFalse(isAscendingNumber(Lotto));
    }
}
