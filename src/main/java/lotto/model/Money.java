package lotto.model;

public class Money {

    private final Integer money;

    public Money(Integer money) {
        if (money < 1000){
            throw new IllegalArgumentException("[ERROR] 로또 최소 구입 금액 1000원 입니다.");
        }
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
        this.money = money;
    }

    public Integer getMoney(){
        return money;
    }

    public Integer getBuyLottoCount(){
        return money / 1000;
    }
}
