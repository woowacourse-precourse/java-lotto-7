package lotto;

public enum RankPrice {
    FIRST("2,000,000,000원", 2000000000),
    SECOND("30,000,000원", 30000000),
    THIRD("1,500,000원", 1500000),
    FOURTH("50,000원", 50000),
    FIFTH("5,000원", 5000);

    private String viewName;
    private int price;

    RankPrice(String viewName, int price) {
        this.viewName = viewName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getViewName() {
        return viewName;
    }
}
