package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.config.LottoConfig;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 구입_금액에_해당하는_수량의_로또_발행() {
        int purchaseAmount = 3000;
        User user = new User(purchaseAmount);

        int expectedQuantity = purchaseAmount / LottoConfig.PRICE.getNumber();

        assertEquals(expectedQuantity, user.getLotto().size());
    }
}