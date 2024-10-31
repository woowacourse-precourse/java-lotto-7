package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.Request;

public class LottoService {

    private final int LOTTO_NUM_COUNT = 6;

    private final Request request = new Request();
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> buyLotto(int amount) {
        String input = request.inputAmount();
        int lottoCount = amount/1000;
        for(int count = 0; count < lottoCount; count++) {
            createLottoNum();
        }
        return lottos;
    }

    private void createLottoNum() {
        for(int numCount = 0; numCount < LOTTO_NUM_COUNT; numCount++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }
}
