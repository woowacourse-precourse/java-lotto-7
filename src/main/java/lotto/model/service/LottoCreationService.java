package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.util.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoCreationService {
    private static final int LOTTO_PRICE = 1000;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int LOTTO_SIZE_COUNT = 6;

    public Lottos createLottos(int amount) {
        int lottosCount = calculateLottoCount(amount);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottosCount; i++) {
            List<Integer> numbers = RandomNumberGenerator.generateUniqueRandomNumbers(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE_COUNT);
            lottoList.add(new Lotto(numbers));
        }
        return new Lottos(lottoList);
    }

    public int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
