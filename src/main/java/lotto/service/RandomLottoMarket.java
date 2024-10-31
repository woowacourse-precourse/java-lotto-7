package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Wallet;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.number.NumbersMaker;

public class RandomLottoMarket {
    private final NumbersMaker numbersMaker;
    private final Wallet wallet;

    public RandomLottoMarket(NumbersMaker randomNumberMaker, Wallet wallet) {
        this.numbersMaker = randomNumberMaker;
        this.wallet = wallet;
    }

    public RandomLottos createRandomLottos() {
        wallet.buyTicket();
        List<Lotto> lottos = makeLottos();
        
        return new RandomLottos(lottos);
    }

    public List<Lotto> makeLottos() {
        List<Lotto> resultRandomLottos = new ArrayList<>();

        while (!wallet.isRunOutTicket()) {
            resultRandomLottos.add(makeLotto());
            wallet.decreaseTicket();
        }
        return resultRandomLottos;
    }

    private Lotto makeLotto() {
        List<Integer> randomNumbers = numbersMaker.make();
        return new Lotto(randomNumbers);
    }

}
