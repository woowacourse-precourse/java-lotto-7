package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = List.copyOf(lotteries);
    }

    public static Lotteries newInstance(List<Lottery> lotteries){
        return new Lotteries(lotteries);
    }

    public List<Lottery> getLottery() {
        return new ArrayList<>(lotteries);
    }
}
