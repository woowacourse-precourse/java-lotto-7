package lotto;

import lotto.model.Cash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CashTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000","2000","4000"})
    public void 로또_구입_금액은_1000단위의_자연수이어야_한다(String input){
        Assertions.assertDoesNotThrow(() -> {
            Cash cash = new Cash(input);
        });
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0","-1","-1000",""," "})
    public void 로또_구입_금액이_자연수가_아니면_실패한다(String input){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cash cash = new Cash(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001","1","3999"})
    public void 로또_구입_금액은_1000원_단위로_구성되어있지_않으면_실패한다(String input){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cash cash = new Cash(input);
        });
    }
}
