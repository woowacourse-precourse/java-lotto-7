package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos of(int lottoQuantity) {
        List<Lotto> lottoList = purchaseLotto(lottoQuantity);
        return new Lottos(lottoList);
    }

    private static List<Lotto> purchaseLotto(int lottoQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        int i = 0;
        while (i < lottoQuantity) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottoList.add(new Lotto(numbers));
            i++;
        }
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
