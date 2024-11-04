package lotto;

import java.util.stream.Stream;

public enum Winning {
    FIFTH(3, false, 5000, "5,000"),
    FOURTH(4, false, 50000, "50,000"),
    THIRD(5, false, 1500000, "1,500,000"),
    SECOND(5, true, 30000000, "30,000,000"),
    FIRST(6, false, 2000000000, "2,000,000,000");

    private final int match;
    private final boolean bonus;
    private final int money;
    private final String commaMoney;
    private int count;

    Winning(int match, boolean bonus, int money, String commaMoney) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
        this.commaMoney = commaMoney;
    }

    public void count() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public static int getTotalMoney() {
        return FIFTH.count * FIFTH.money + FOURTH.count * FOURTH.money + THIRD.count * THIRD.money
                + SECOND.count * SECOND.money + FIRST.count * FIRST.money;
    }

    public static void printWinningToTal() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.match + "개 일치 (" + FIFTH.commaMoney + "원) - " + FIFTH.count + "개");
        System.out.println(FOURTH.match + "개 일치 (" + FOURTH.commaMoney + "원) - " + FOURTH.count + "개");
        System.out.println(THIRD.match + "개 일치 (" + THIRD.commaMoney + "원) - " + THIRD.count + "개");
        System.out.println(SECOND.match + "개 일치, 보너스 볼 일치 (" + SECOND.commaMoney + "원) - " + SECOND.count + "개");
        System.out.println(FIRST.match + "개 일치 (" + FIRST.commaMoney + "원) - " + FIRST.count + "개");
    }

    public static Winning findByMatch(int match) {
        return Stream.of(values())
                .filter(winning -> winning.match == match)
                .findFirst()
                .orElseThrow();
    }
}
