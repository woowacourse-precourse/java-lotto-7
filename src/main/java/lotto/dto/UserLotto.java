package lotto.dto;

import lotto.model.lotto.Lottos;
import lotto.model.money.Money;

public record UserLotto(Lottos lottos, Money money) {
}
