package lotto;

import lotto.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
            List<Integer> randomNumbers = Randomizer.getRandomValues();
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

    public void getResults(String winningNumberInput, String bonusNumberInput) {
        LottoResults lottoResults = new LottoResults();
        List<Integer> winningNumbers = Stream.of(winningNumberInput.split(",")).map(Integer::parseInt).toList();
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        for (Lotto lotto : this.lottos) {
            int matches = lotto.getMatches(winningNumbers, bonusNumber);
            lottoResults.recordResult(matches);
        }
        lottoResults.calculateRewards();
    }
}
