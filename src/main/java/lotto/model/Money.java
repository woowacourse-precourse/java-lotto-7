package lotto.model;

import lotto.constants.MoneyConstants;
import lotto.utilities.Parser;
import lotto.validation.MoneyValidator;

public class Money {
  private final Integer money;

  public Money(String money) {
    Integer intMoney = parseToInt(money);
    validate(intMoney);
    this.money = intMoney;
  }

  private Integer parseToInt(String money) {
    return Parser.parseNumberToInt(money);
  }

  private void validate(Integer money) {
    MoneyValidator.validateMoney(money);
  }

  public int boughtLottosQuantity() {
    return money / MoneyConstants.LOTTO_PRICE;
  }

  public Integer getMoney() {
    return this.money;
  }
}
