package lotto.manager;

import lotto.domain.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoSellerTest {
    private static LottoSeller lottoSeller;

    @BeforeAll
    static void setUpTrueSeller() {
        lottoSeller = new LottoSeller(() -> List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 5, 1001, 4023})
    void 구입_금액이_1000원_단위_양의_정수가_아니면_예외가_발생한다(int money) {
        assertThatThrownBy(() -> lottoSeller.sell(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "5000,5", "8000,8", "10000,10"})
    void 구입_금액에_맞는_로또_개수만큼_로또를_판매한다(String money, String count) {
        int givenMoney = Integer.parseInt(money);

        Player player = lottoSeller.sell(givenMoney);

        assertAll(
                () -> assertEquals(player.getMoney(), givenMoney),
                () -> assertEquals(player.getLottos().size(), Integer.parseInt(count))
        );
    }
}
