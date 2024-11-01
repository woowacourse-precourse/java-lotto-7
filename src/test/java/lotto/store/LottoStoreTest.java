package lotto.store;

import lotto.basic.NumbersGeneratorStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void beforeEach() {
        NumbersGeneratorStub validNumbersGeneratorStub = new NumbersGeneratorStub();
        validNumbersGeneratorStub.setTestRandomNumbers(List.of(1, 2, 3, 4, 5, 6));

        lottoStore = new LottoStore(validNumbersGeneratorStub);
    }


    @Test
    @DisplayName("1000원 단위로 로또를 판매")
    void test1() {
        List<Lotto> result = lottoStore.sale(5000);

        assertEquals(result.size(), 5);
    }

    @Test
    @DisplayName("거스름돈이 생긴다면 판매하지 않음")
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> lottoStore.sale(1234));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1234, -1})
    @DisplayName("돈은 양수만 가능함")
    void test3(int money) {
        assertThrows(IllegalArgumentException.class, () -> lottoStore.sale(money));
    }
}