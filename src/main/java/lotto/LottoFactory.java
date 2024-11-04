package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static LottoFactory instance = null;
    private LottoGenerator lottoGenerator = null;

    private LottoFactory(LottoGenerator generator) {
        this.lottoGenerator = generator;
    }

    public static LottoFactory getInstance() {
        if (instance == null ){
            instance = new LottoFactory(new LottoGenerator());
        }
        return instance;
    }

    public List<Lotto> createLotto(int price){
        validateGenerator();
        int count = price / 1000;
        List<Lotto> lotto = new ArrayList<Lotto>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoGenerator.drawLots();
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }

    private void validateGenerator(){
        if (lottoGenerator == null){
            throw new IllegalStateException();
        }
    }
}
