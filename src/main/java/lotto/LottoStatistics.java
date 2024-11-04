package lotto;

public class LottoStatistics {
    private int match3_count = 0;
    private int match4_count = 0;
    private int match5_count = 0;
    private int match5_bonus_count = 0;
    private int match6_count = 0;
    private double returnRate = 0;

    public LottoStatistics(int match3_count, int match4_count, int match5_count, int match5_bonus_count, int match6_count, double returnRate) {
        this.match3_count = match3_count;
        this.match4_count = match4_count;
        this.match5_count = match5_count;
        this.match5_bonus_count = match5_bonus_count;
        this.match6_count = match6_count;
        this.returnRate = returnRate;
    }

    public int getMatch3_count() {
        return match3_count;
    }
    public int getMatch4_count() {
        return match4_count;
    }
    public int getMatch5_count() {
        return match5_count;
    }
    public int getMatch5_bonus_count() {
        return match5_bonus_count;
    }
    public int getMatch6_count() {
        return match6_count;
    }
    public double getReturnRate() {
        return returnRate;
    }
}
