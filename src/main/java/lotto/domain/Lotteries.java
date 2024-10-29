package lotto.domain;

import java.util.List;

public class Lotteries {
    private final StringBuilder stringBuilder = new StringBuilder();

    List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries of(List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    public int getCount() {
        return lotteries.size();
    }

    public String getLottoNumbers() {
        lotteries.stream()
                .forEach(lotto -> stringBuilder.append(lotto.sortNumbers()));
    }
}
