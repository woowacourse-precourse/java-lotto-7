package lotto;

import java.text.DecimalFormat;

public enum Rank {

    FIRST(1,6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FORTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private int serial;
    private int match;
    private int amount;

    static DecimalFormat formatter = new DecimalFormat("###,###");

    public static Rank[] ranks = {
            FIRST,SECOND,THIRD, FORTH, FIFTH
    };

    private Rank(int serial, int match, int amount) {
        this.serial = serial;
        this.match =  match;
        this.amount = amount;
    }

    public int getSerial() {
        return serial;
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    public static void print(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");
        for (int i = 4; i >=0 ; i--) {
            sb.append(Rank.ranks[i].getMatch());
            sb.append("개 일치");
            if(i == 1) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (");
            sb.append(formatter.format(Rank.ranks[i].getAmount()));
            sb.append("원) - ");
            sb.append(result[i]);
            sb.append("개\n");
        }
        System.out.println(sb);
    }
}
