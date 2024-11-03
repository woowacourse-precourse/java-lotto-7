package lotto;

import lotto.money.Money;
import lotto.store.LottoStoreStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {
    private LottoBuyer buyer;
    private LottoStoreStub storeStub;

    @BeforeEach
    void beforeEach() {
        storeStub = new LottoStoreStub();
    }


    @DisplayName("로또를 살 수 없다면 예외가 발생한다.")
    @Test
    void test1() {
        storeStub.setSoldLottos(Collections.EMPTY_LIST);

        assertThrows(IllegalArgumentException.class,
                () -> new LottoBuyer(storeStub, money(0))
        );
    }

    private static Money money(int amonut) {
        return new Money(amonut);
    }


}