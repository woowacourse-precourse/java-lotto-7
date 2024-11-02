package lotto.model;

public class Buy {

    private final Integer money;
    static final Integer moneyUnit = 1000;

    public Buy(Integer money) {
        this.money = money;
    }

    public Integer getMoney(){
        return money;
    }

    private void validateUserMoneyUnit(Integer userMoney){
        if(userMoney % moneyUnit != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액 단위는 1000원 단위 입니다.");
        }
    }


}
