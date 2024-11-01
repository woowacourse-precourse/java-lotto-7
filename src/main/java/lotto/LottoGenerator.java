package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoGenerator {
    private final Integer price;
    private final Supplier<List<Integer>> randomNumbers;

    public LottoGenerator(Integer price) {
        this(price, ()-> Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public LottoGenerator(Integer price, Supplier<List<Integer>> randomNumbers) {
        this.price = price;
        this.randomNumbers = randomNumbers;
    }

    private Lotto generateLotto(){
        List<Integer> numbers = randomNumbers.get();
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos(){
        List<Lotto> lottos = new ArrayList<>();
        int count = price / 1000;
        for(int i = 0; i < count; i++){
            lottos.add(generateLotto());
        }
        return lottos;
    }

}
