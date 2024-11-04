package lotto.dto;

import lotto.vo.Money;

public class UserMoneyDTO {
    private final Money userMoney;

    private UserMoneyDTO(Money userMoney) {
        this.userMoney = userMoney;
    }

    public static UserMoneyDTO of(Money userMoney) {
        return new UserMoneyDTO(userMoney);
    }

    public Money getUserMoney() {
        return userMoney;
    }
}
