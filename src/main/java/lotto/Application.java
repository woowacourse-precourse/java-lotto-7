package lotto;

import lotto.store.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.open();
    }
}
