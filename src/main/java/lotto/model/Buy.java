package lotto.model;

public class Buy {

    private final Integer money;
    private final Integer purchaseCount;
    public static final int MONEY_UNIT = 1000;

    public Buy(Integer money) {
        validateUserMoneyUnit(money);
        validateUserMoneyNegative(money);
        this.money = money;
        this.purchaseCount = getUserPurchaseCount(money);
    }

    public Integer getMoney(){
        return money;
    }

    public Integer getPurchaseCount(){
        return purchaseCount;
    }

    private Integer getUserPurchaseCount(Integer userMoney){
        return userMoney / MONEY_UNIT;
    }

    private void validateUserMoneyUnit(Integer userMoney){
        if(userMoney % MONEY_UNIT != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액 단위는 1000원 단위 입니다.");
        }
    }

    private void validateUserMoneyNegative(Integer userMoney){
        if(userMoney < 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 양수만 입력해 주세요.");
        }
    }

}
