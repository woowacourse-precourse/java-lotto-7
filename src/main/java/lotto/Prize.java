package lotto;

import java.text.DecimalFormat;

public enum Prize {
    First(0, 2000000000, "6개 일치"),
    Second(0, 30000000, "5개 일치, 보너스 볼 일치"),
    Third(0, 1500000, "5개 일치"),
    Fourth(0, 50000, "4개 일치"),
    Fifth(0, 5000, "3개 일치");

    private int prizeCount;
    private int amount;
    private String description;

    Prize(int initialCount, int initialMoney, String description) {
        this.prizeCount = initialCount;
        this.amount = initialMoney;
        this.description = description;
    }

    /// 당첨 복권의 갯수를 증가시킴
    public void increaseCount() {
        this.prizeCount++;
    }

    /// 복권 당첨 정보를 출력
    public void printPrizeInfo() {

        DecimalFormat formater = new DecimalFormat("###,###"); // 금액을 표현할때 세자리수 마다 ,를 표기하도록 포맷

        String prizeInfo = this.description + " (" + formater.format(this.amount)
                + "원) - " + this.prizeCount + "개";

        System.out.println(prizeInfo);

    }

    public long getPrizeMoney () {

        return (long) prizeCount * amount;

    }

}
