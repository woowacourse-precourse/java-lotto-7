package module;

public class PrizeInfo {
    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;
    private final Integer prizeAmount;

    public PrizeInfo(Integer count, Integer prizeAmount) {
        this.count = count;
        this.prizeAmount = prizeAmount;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }
}
