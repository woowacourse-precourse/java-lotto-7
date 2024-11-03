package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public int getLottoCount() {
        return lottos.size();
    }

    private int getPrice() {
        return getLottoCount() * LOTTO_PRICE;
    }

    public double calculateProfit(WinningLotto winningLotto) {
        double sum = lottos.stream()
                .map(winningLotto::calculateRank)
                .mapToLong(Rank::getPrice)
                .sum();
        return sum / getPrice();
    }
}
