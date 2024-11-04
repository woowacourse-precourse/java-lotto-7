package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.ValidationUtils;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBERS_PER_LOTTO = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> generateLottos(long purchaseAmount) {
        long lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            try {
                lottos.add(generateSingleLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // 재시도
            }
        }

        return lottos;
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_LOTTO);
        return new Lotto(numbers);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
