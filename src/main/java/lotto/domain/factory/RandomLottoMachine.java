package lotto.domain.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottos.Lotto;
import lotto.domain.Wallet;
import lotto.domain.number.NumbersMaker;

/**
 * 랜덤 로또 생성
 * Wallet 받아서 만듦
 * 리스트 로또 반환
 */
public class RandomLottoMachine {
    private final NumbersMaker numbersMaker;
    private final Wallet wallet;

    public RandomLottoMachine(NumbersMaker numbersMaker, Wallet wallet) {
        this.numbersMaker = numbersMaker;
        this.wallet = wallet;
    }

    public List<Lotto> makeLottos() {
        List<Lotto> resultRandomLottos = new ArrayList<>();

        int count = wallet.getTicket();

        for (int i = 0; i < count; i++) {
            resultRandomLottos.add(makeLotto());
        }

        return resultRandomLottos;
    }

    private Lotto makeLotto(){
        List<Integer> randomNumbers = numbersMaker.make();
        return new Lotto(randomNumbers);
    }


}
