package lotto.prize;

import java.util.function.BiPredicate;

public enum Prize {
    FIRST((match, bonus) -> match == 6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND((match, bonus) -> match == 5 && bonus, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD((match, bonus) -> match == 5 && bonus, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH((match, bonus) -> match == 4, 50000, "4개 일치 (50,000원) - %d개"),
    FIFTH((match, bonus) -> match == 3, 5000, "3개 일치 (5,000원) - %d개"),
    NONE((match, bonus) -> false, 0, "꽝");

    private final BiPredicate<Integer, Boolean> result;
    private final int money;
    private final String message;

    Prize(BiPredicate<Integer, Boolean> result, int money, String message){
        this.result = result;
        this.money = money;
        this.message = message;
    }
    public static Prize calculatePrize(int match, boolean bonus){
        for (Prize prize : Prize.values()){
            if (prize.result.test(match, bonus)){
                return prize;
            }
        }
        return NONE;
    }
    public String getMessage(){
        return message;
    }
    public int getMoney(){
        return money;
    }
}