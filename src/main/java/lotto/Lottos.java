package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos implements Observable {
    private static final int LOTTO_PRICE = 1000;
    private Observer observer;
    private int lottoCount;
    private ArrayList<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        getLottoCount(purchaseAmount);
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        this.observer.update(lottoCount);
    }

    public void generateLottos() {
        for (int i = 0; i < this.lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(randomNumbers);
            newLotto.registerObserver(this.observer);
            newLotto.notifyObserver();
            this.lottos.add(newLotto);
        }
    }

    private void getLottoCount(int purchaseAmount) {
        this.lottoCount = purchaseAmount / LOTTO_PRICE;
        this.lottos = new ArrayList<>(this.lottoCount);
    }
}
