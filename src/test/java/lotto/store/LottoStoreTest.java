package lotto.store;

import lotto.basic.NumbersGeneratorStub;
import lotto.money.Money;
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
        List<Lotto> result = lottoStore.sale(toMoney(5000));

        assertEquals(result.size(), 5);
    }

    @Test
    @DisplayName("거스름돈이 생긴다면 판매하지 않음")
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> lottoStore.sale(toMoney(1234)));
    }



    private static Money toMoney(int amount) {
        return new Money(amount);
    }
}