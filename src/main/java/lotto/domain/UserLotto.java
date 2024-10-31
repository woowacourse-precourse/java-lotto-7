package lotto.domain;

import java.util.List;

public class UserLotto {
    private List<Lotto> lottos;
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        firstPrizeCount = 0;
        secondPrizeCount = 0;
        thirdPrizeCount = 0;
        fourthPrizeCount = 0;
        fifthPrizeCount = 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getFifthPrizeCount() {
        return fifthPrizeCount;
    }

}
