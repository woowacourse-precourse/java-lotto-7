package lotto.constant;

public enum Rank {
    FIFTH(3, "5,000원"),
    FOURTH(4, "50,000원"),
    THIRD(5, "1,500,000원"),
    SECOND(5, "30,000,000원"),
    FIRST(6, "2,000,000,000원");

    private final Integer count;
    private final String prize;

    Rank(Integer count, String prize) {
        this.count = count;
        this.prize = prize;
    }

    public Integer getCount() {
        return count;
    }

    public String getPrize() {
        return prize;
    }

    public static Integer convertPrize(Rank rank) {
        String prize = rank.getPrize();
        String numericPart = prize.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericPart);
    }
}
