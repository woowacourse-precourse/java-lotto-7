package lotto.model;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MAX_PRICE = 100000; //실제 복권과 동일하도록 1회 구입 10만원 제한
    private final int lottoCount;
    private final int amount;

    public PurchaseAmount(int amount) {
        validateAmount(amount);
        this. amount = amount;
        this.lottoCount = calculateLottoCount(amount);
    }

    private void validateAmount(int amount) {
        validateMinPrice(amount);
        validateMaxPrice(amount);
        validateDivisibility(amount);
    }

    private void validateMinPrice(int amount){
        if(amount < LOTTO_PRICE)
            throw new IllegalArgumentException();
    }

    private void validateMaxPrice(int amount){
        if(amount > LOTTO_MAX_PRICE)
            throw new IllegalArgumentException();
    }

    private void validateDivisibility(int amount){
        if(amount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException();
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getAmount(){
        return amount;
    }
}
