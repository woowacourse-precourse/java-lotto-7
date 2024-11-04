package lotto.model;

public enum Rank {
    FIRST(2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(50_000L, "4개 일치 (50,000원)"),
    FIFTH(5_000L, "3개 일치 (5,000원)"),
    NO_LUCK(0L, ""),
    ;

    private long price;
    private String description;

    Rank(long price, String description) {
        this.price = price;
        this.description = description;
    }

    /**
     * 로또 상금 반환
     *
     * @return 로또 상금
     */
    public long getPrice() {
        return price;
    }

    /**
     * 로또 결과 설명 반환
     *
     * @return 로또 결과 설명
     */
    public String getDescription() {
        return description;
    }
}
