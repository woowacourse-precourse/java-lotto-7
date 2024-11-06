package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.*;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private CustomLotto customLotto;
    private List<Integer> rank = new ArrayList<>(5);
    private Integer seedMoney;

    public static LottoGame of(int money) {
        return new LottoGame(money);
    }

    private LottoGame(int money) {
        this.seedMoney = money;
        drawNewLottoNumber(money / 1000);
        for (int i = 0; i < 5; i++) {
            rank.add(0);
        }
    }

    public void setCustomLotto(CustomLotto customLotto) {
        this.customLotto = customLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public CustomLotto getCustomLotto() {
        return customLotto;
    }

    public List<Integer> getRank() {
        return rank;
    }

    public Integer getSeedMoney() {
        return seedMoney;
    }

    private void drawNewLottoNumber(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = RandomNumberGenerator.makeRandomNumber();
            lottos.add(new Lotto(numbers));
        }
    }
}
