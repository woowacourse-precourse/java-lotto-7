package lotto;

public enum RankPrice {
    FIRST("6개 일치 (2,000,000,000원)", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    FOURTH("4개 일치 (50,000원)", 50000),
    FIFTH("3개 일치 (5,000원)", 5000);

    private String message;
    private int price;

    RankPrice(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
