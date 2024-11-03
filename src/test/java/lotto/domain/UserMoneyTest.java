package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.MonetaryUnit.A_LOTTO_PRICE;
import static lotto.domain.DefaultUserMoney.USER_MONEY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMoneyTest {
    @DisplayName("사용자가 지불한 돈을 바탕으로 발행해야되는 로또갯수를 계산")
    @Test
    void 사용자가_지불한_돈을_바탕으로_발행해야되는_로또갯수를_계산() {
        UserMoney userMoney = new UserMoney(USER_MONEY.getUnit());
        int count = userMoney.calculateNumberOfLotto();

        assertEquals(count, USER_MONEY.getUnit()/ A_LOTTO_PRICE.getUnit());
    }
}