package lotto.domain;

public class LottoResult {
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double profitRate = 0;

    public void add(int rank, boolean bonus) {
        if (rank == 6) {
            first++;
        } else if (rank == 5 && bonus) {
            second++;
        } else if (rank == 5) {
            third++;
        } else if (rank == 4) {
            fourth++;
        } else if (rank == 3) {
            fifth++;
        }
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public double getProfitRate(int money) {
        int prize = first * 2_000_000_000 + second * 30_000_000 + third * 1_500_000 + fourth * 50_000 + fifth * 5_000;
        profitRate = prize /  (double)money;
        return profitRate *100;
    }
}
