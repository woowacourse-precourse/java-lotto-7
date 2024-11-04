package lotto.week3.dto;

public class PurchaseRequestDto {

    private final int money;
    private final int counts;

    public  PurchaseRequestDto(int money) {
        this.counts = count(money);
        this.money = money;
    }

    private static int count(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원  단워로 입력 해주세요. ");
        }
        return cost / 1000;
    }

    public int getMoney() {
        return money;
    }

    public int getCounts() {
        return counts;
    }
}
