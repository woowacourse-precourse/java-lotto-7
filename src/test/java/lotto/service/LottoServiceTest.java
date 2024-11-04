package lotto.service;

import static global.constant.GlobalStatic.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.repository.LottoRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import store.repository.StoreRepositoryImpl;
import store.service.StoreService;

class LottoServiceTest {

    private final StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();
    private final StoreService storeService = new StoreService(storeRepository);
    private final LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl();
    private final LottoService lottoService = new LottoService(storeService, lottoRepository);

    @ParameterizedTest
    @ValueSource(strings = {"2000", "5000", "10000"})
    @DisplayName("입력한 구매 금액을 unit으로 나눈만큼 로또가 생성된다.")
    void t001(String input) {
        //given
        BigInteger purchaseAmount = new BigInteger(input);

        //when
        lottoService.generateByPurchaseAmount(input);

        //then
        BigInteger count = BigInteger.valueOf(lottoService.count());
        BigInteger expectedCount = purchaseAmount.divide(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT));
        assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("로또를 생성을 시도할 때, 중복된 숫자가 있다면 생성이 불가능하다.")
    void t002() {
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));

        //when, then
        assertThatThrownBy(() -> lottoService.create(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되지 않는 랜덤한 숫자 6개를 발급받을 수 있다")
    void t003() {
        List<Integer> randomNumbers = lottoService.generateRandomNumbers();

        while (!randomNumbers.isEmpty()) {
            int num = randomNumbers.getFirst();
            randomNumbers.removeFirst();
            assertThat(randomNumbers).doesNotContain(num);
        }
    }

    @Test
    @DisplayName("발급한 랜덤한 숫자들의 범위는 1이상 45 이하여야 한다.")
    void t004() {
        List<Integer> randomNumbers = lottoService.generateRandomNumbers();

        for (int num : randomNumbers) {
            assertThat(num).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("로또를 생성할 때에 필요한 숫자는 6개이다.")
    void t005() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assertThatThrownBy(() -> lottoService.create(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}