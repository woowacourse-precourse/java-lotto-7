package lotto;

public class Selling {
    private static final int PRICE = 1000;

    public void validatePrice(int purchaseLotto) {
        if(purchaseLotto%PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

}
