package lotto.viewHandler.api.dto.input;

public class MoneyDto {
    private final Integer money;

    public MoneyDto(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }
}
