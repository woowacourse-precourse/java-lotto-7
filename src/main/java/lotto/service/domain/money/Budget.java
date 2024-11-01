package lotto.service.domain.money;

public class Budget implements Money{
    private final int userMoney;
    private static final int THOUSAND_WON = 1_000;
    private static final int DEVIDED = 0;

    public Budget(int userMoney) {
        validateThousand(userMoney);
        this.userMoney = userMoney;
    }

    private void validateThousand(long userMoney) {
        if(userMoney % THOUSAND_WON != DEVIDED) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위만 허용합니다.");
        }
    }

    @Override
    public int getBudget() {
        return this.userMoney;
    }
}
