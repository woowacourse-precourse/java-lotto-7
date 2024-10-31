package lotto.domain;

public class Rank {

    private final int rank;

    public Rank(int rank) {
        this.rank = rank;
    }

    public int get() {
        return rank;
    }

    public int getPrice() {
        if (rank == 1) {
            return 2_000_000_000;
        }
        if (rank == 2) {
            return 30_000_000;
        }
        if (rank == 3) {
            return 1_500_000;
        }
        if (rank == 4) {
            return 50_000;
        }
        if (rank == 5) {
            return 5_000;
        }
        throw new IllegalStateException("[ERROR] 잘못된 등수입니다.");
    }
}
