package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 유저_생성_테스트() {
        String purchaseAmount = "10000";
        int expectedPurchaseAmount = 10000;

        User user = new User(new PurchaseAmount(purchaseAmount));

        assertEquals(user.getPurchaseAmount(), expectedPurchaseAmount);
    }

    @Test
    void 유저_로또_구매_수량_테스트() {
        String purchaseAmount = "10000";
        int expectedQuantityTickets = 10;

        User user = new User(new PurchaseAmount(purchaseAmount));

        assertEquals(user.getQuantityTickets(), expectedQuantityTickets);
    }

}