package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService {
    private static LottoServiceImpl lottoService;

    public static LottoServiceImpl getInstance() {
        if (lottoService == null) {
            lottoService = new LottoServiceImpl();
        }
        return lottoService;
    }

    @Override
    public List<Lotto> buyLotto(Integer lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            LottoRepository.lottos.add(lotto);
        }
        return LottoRepository.lottos;
    }

    public void saveWinningNumber(List<Integer> winningNumbers) {
        LottoRepository.winningNumbers.addAll(winningNumbers);
    }

    @Override
    public void calWinning() {

    }

    @Override
    public Float revenue() {
        return 0f;
    }
}
