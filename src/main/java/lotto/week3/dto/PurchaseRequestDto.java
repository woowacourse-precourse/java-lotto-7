package lotto.week3.dto;

public class PurchaseRequestDto {

    private final int money;

    public  PurchaseRequestDto(int money) {
        int count = count(money);
        this.money = count;
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
}
