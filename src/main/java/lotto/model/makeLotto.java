package lotto.model;

public class makeLotto {
    private final int amount;

    public int splitAmount(int amount){
        if (amount%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.");
        }
        return amount / 1000;
    }

}