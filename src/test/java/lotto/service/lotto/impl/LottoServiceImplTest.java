package lotto.service.lotto.impl;

import lotto.domain.Lotto;
import lotto.service.lotto.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceImplTest {

    private LottoService lottoService;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @Test
    @DisplayName("로또 묶음 생성 시 올바른 개수의 로또 생성")
    void 로또_묶음_생성_시_올바른_개수의_로또를_생성하는지_테스트() {
        int purchaseCount = 5;
        List<Lotto> lottoBundle = lottoService.createLottoBundle(purchaseCount);

        assertEquals(purchaseCount, lottoBundle.size());
        lottoBundle.forEach(lotto -> {
            assertEquals(LOTTO_TOTAL_COUNT, lotto.getNumbers().size());
        });
    }

    @Test
    @DisplayName("로또 묶음 생성 시 올바른 범위의 로또 생성")
    void 로또_묶음_생성_시_올바른_범위의_로또_숫자를_생성하는지_테스트() {
        int purchaseCount = 5;
        List<Lotto> lottoBundle = lottoService.createLottoBundle(purchaseCount);

        assertEquals(purchaseCount, lottoBundle.size());
        lottoBundle.forEach(lotto -> {
            assertTrue((lotto.getNumbers().stream().allMatch(num -> num >= LOTTO_START && num <= LOTTO_END)));
        });
    }

    @Test
    @DisplayName("숫자 리스트와 일치하는 로또가 생성되는지 테스트")
    void 파라미터의_숫자_배열과_일치하는_로또가_생성되는지_테스트() {
        List<Integer> numbers = List.of(3, 12, 25, 33, 41, 45);

        Lotto lotto = lottoService.createLotto(numbers);

        assertNotNull(lotto);
        assertEquals(new HashSet<>(numbers), new HashSet<>(lotto.getNumbers()));
    }

}