package lotto.lotto.object;

import java.util.List;

public class MyLotto extends Lotto {
    private int rank;

    public MyLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
