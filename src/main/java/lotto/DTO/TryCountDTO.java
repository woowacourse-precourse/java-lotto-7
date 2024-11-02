package lotto.DTO;

public class TryCountDTO {
    private final int tryCount;
    private final int buyPrice;

    public TryCountDTO(int tryCount, int buyPrice) {
        this.tryCount = tryCount;
        this.buyPrice = buyPrice;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
