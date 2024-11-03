package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    private LottoStore store;
    private final int PURCHASE_AMOUNT = 8000;

    @BeforeEach
    void setUp() {
        store = new LottoStore(PURCHASE_AMOUNT);
    }

    @DisplayName("로또 구매 장수 체크")
    @Test
    void 금액만큼의_로또_구매_장수_체크() {

        List<Lotto> purchasedLotto = store.getPurchasedLotto();

        assertEquals(8, purchasedLotto.size());
    }

    @Test
    void 로또_번호_범위_확인() {

        List<Lotto> purchasedLotto = store.getPurchasedLotto();
        for (Lotto lotto : purchasedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            // 번호가 유효 범위 내에 있는지 확인
            numbers.forEach(number -> assertTrue(
                    number >= LottoNumberGenerator.MIN_NUMBER && number <= LottoNumberGenerator.MAX_NUMBER));
        }

    }

    @Test
    void 생성된_로또_번호_테스트() {
        List<Lotto> purchasedLotto = store.getPurchasedLotto();

        for (Lotto lotto : purchasedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
        }
    }

    @Test
    void 생성된_로또_중복확인() {

        List<Lotto> purchasedLotto = store.getPurchasedLotto();
        for (Lotto lotto : purchasedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(numbers.size(), numbers.stream().distinct().count());
        }

    }

}
