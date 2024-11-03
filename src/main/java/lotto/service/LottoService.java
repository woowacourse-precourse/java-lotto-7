package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.Lottos;
import lotto.enums.LottoConfig;
import lotto.model.Lotto;
import lotto.validator.AmountValidator;

public class LottoService {
    private final int LOTTO_NUM_SIZE = LottoConfig.LOTTO_NUM_SIZE.getValue();
    private final int LOTTO_PRICE = LottoConfig.LOTTO_PRICE.getValue();
    private final int LOTTO_NUM_START = LottoConfig.LOTTO_NUM_START.getValue();
    private final int LOTTO_NUM_END = LottoConfig.LOTTO_NUM_END.getValue();

    private final Lottos lottos;

    public LottoService(Lottos lottos) {
        this.lottos = lottos;
    }

    public void buyLotto(int amount) {
        int lottoCount = amount / LOTTO_PRICE;

        AmountValidator.amountDivide(amount);
        AmountValidator.amountMinus(amount);
        for (int count = 0; count < lottoCount; count++) {
            createLottoNum();
        }
    }

    private void createLottoNum() {
        List<Integer> numbers =
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_NUM_SIZE));
        numbers.sort(Comparator.naturalOrder());
        lottos.addLottos(new Lotto(numbers));
    }

    public List<List<Integer>> getLottosNum() {
        return lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

}
