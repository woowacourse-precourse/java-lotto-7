package lotto.service;

public class LottoService {

    public void purchaseLotto(int buyPrice){
        validateBuyPrice(buyPrice);
        
    }

    public void validateBuyPrice(int buyPrice) {
        if (buyPrice <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if (buyPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
