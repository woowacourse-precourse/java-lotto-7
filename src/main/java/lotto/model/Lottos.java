package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.List;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    private int getPrice() {
        return getLottosCount() * LOTTO_PRICE;
    }

    public double calculateProfit(WinningLotto winningLotto) {
        double sum = lottos.stream()
                .map(winningLotto::calculateRank)
                .mapToLong(Rank::getPrice)
                .sum();
        return sum / getPrice();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
