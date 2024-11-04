package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.utils.RandomNumberGenerator;

public class LottoPaper {
    private final List<Lotto> lottos;


    private LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoPaper makeLottoPaper(int lottoCount){

        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.generateOrderedNumbers()))
                .toList();

        return new LottoPaper(lottos);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public int getLottoCount(){
        return lottos.size();
    }
}
