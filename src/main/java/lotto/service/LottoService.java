package lotto.service;

public class LottoService {
    private final int lottoCost = 1_000;

    public int getLottoCost() {
        return lottoCost;
    }

    public int issueRottoCount(int cost) throws IllegalArgumentException {
        if (cost % lottoCost > 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 " + lottoCost + "원 단위이어야 합니다.");
        }

        return cost / lottoCost;
    }
}
