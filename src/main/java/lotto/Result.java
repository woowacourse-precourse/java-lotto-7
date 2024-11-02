package lotto;

public enum Result {
    Three(5000),
    Four(50000),
    Five(1500000),
    Bonus(30000000),
    Six(2000000000);
    public static int threeCnt = 0;
    public static int fourCnt = 0;
    public static int fiveCnt = 0;
    public static int bonusCnt = 0;
    public static int sixCnt = 0;
    private final int price;
    Result(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void incrementCount() {
        if (this == Three) {
            threeCnt++;
        }
        if (this == Four) {
            fourCnt++;
        }
        if (this == Five) {
            fiveCnt++;
        }
        if (this == Bonus) {
            bonusCnt++;
        }
        if (this == Six) {
            sixCnt++;
        }
    }
}