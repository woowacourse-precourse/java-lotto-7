package lotto;

import java.util.Arrays;
import java.util.HashSet;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.service.LottoService.getRandomLottoNumber;
import static lotto.service.LottoService.sortAscending;
import static lotto.validate.LottosValidate.isAscendingNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
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
