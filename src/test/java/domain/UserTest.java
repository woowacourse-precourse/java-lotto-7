package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("구입 금액을 통해 구입 가능한 개수를 가져온다.")
    @Test
    void getPurchaseCount() {
        // given
        User user = new User(8_000);
        int expectedCount = 8;

        // when
        int purchaseCount = user.getPurchaseCount();

        // then
        assertEquals(expectedCount, purchaseCount);
    }
}
