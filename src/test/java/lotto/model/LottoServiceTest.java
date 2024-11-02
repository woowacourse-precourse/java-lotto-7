package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.model.util.TestRandomUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private TestRandomUtil testRandomUtil;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        List<Integer> fixedResults = Arrays.asList(7, 8, 9, 10, 11, 12);
        testRandomUtil = new TestRandomUtil(fixedResults);

        lottoService = new LottoService(testRandomUtil);
    }

    @Test
    @DisplayName("로또 구입 금액으로 로또 티켓 수량을 계산")
    void calculateLottoCount() {
        // given
        Integer lottoPurchaseAmount = 3000;

        // when
        Integer result = lottoService.calculateLottoCount(lottoPurchaseAmount);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 구입 금액으로 로또 티켓 수량을 계산: 최대 로또 구입 금액")
    void calculateLottoCount_largePurchaseAmount() {
        // given
        Integer lottoPurchaseAmount = 2147483000;

        // when
        Integer result = lottoService.calculateLottoCount(lottoPurchaseAmount);

        // then
        assertThat(result).isEqualTo(2147483);
    }
}
