package lotto.dto;

import lotto.vo.Money;

public class UserMoneyDTO {
    private final Money userMoney;

    public UserMoneyDTO(Money userMoney) {
        this.userMoney = userMoney;
    }

    public Money getUserMoney() {
        return userMoney;
    }
}
