package lotto;

import lotto.generator.Generator;
import lotto.generator.WoowaGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static LottoFactory instance = null;

    public static LottoFactory getInstance() {
        if (instance == null ){
            instance = new LottoFactory(new WoowaGenerator());
        }
        return instance;
    }

    private final Generator generator;
    private LottoFactory(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> buyLotto(int amountOfMoney) {
        int lottoNums = amountOfMoney / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0 ; i < lottoNums ; i++) {
            List<Integer> numbers = generator.generateUniqueNumbers(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }
}
