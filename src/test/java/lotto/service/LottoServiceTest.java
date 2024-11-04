package lotto.service;

import static global.constant.GlobalStatic.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import global.exception.ErrorCode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
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
        BigInteger purchaseAmount = new BigInteger(input);

        lottoService.tryGenerateByPurchaseAmount(input);

        BigInteger count = BigInteger.valueOf(lottoService.count());
        BigInteger expectedCount = purchaseAmount.divide(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT));
        assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("로또를 생성을 시도할 때, 중복된 숫자가 있다면 생성이 불가능하다.")
    void t002() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));

        assertThatThrownBy(() -> lottoService.generate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
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
    @DisplayName("로또를 생성할 때 정해진 숫자와 일치하지 않으면 오류가 발생한다")
    void t005() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assertThatThrownBy(() -> lottoService.generate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_COUNT_MISMATCH.getMsg());
    }

    @Test
    @DisplayName("소수점 둘째 자리에서 반올림 한 수익률을 받을 수 있다")
    void t006() {
        double expectedRate = 500.0;
        lottoService.generate(List.of(1,2,3,4,5,6));
        Map<LottoRank, Integer> rank = LottoRank.getDefaultRankingStates();
        rank.put(LottoRank.FIFTH_RANK, 1);

        double result = lottoService.calculateProfitRate(rank);

        assertThat(result).isEqualTo(expectedRate);
    }

    @Test
    @DisplayName("당첨 통계를 기반으로 총 수익을 얻을 수 있다")
    void t007() {
        double expectedValue = 5000.0;
        lottoService.generate(List.of(1,2,3,4,5,6));
        Map<LottoRank, Integer> rank = LottoRank.getDefaultRankingStates();
        rank.put(LottoRank.FIFTH_RANK, 1);

        double result = lottoService.calculateTotalProfit(rank);

        assertThat(expectedValue).isEqualTo(result);
    }
}