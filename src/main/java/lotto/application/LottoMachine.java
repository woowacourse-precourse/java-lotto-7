package lotto.application;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoPrize;
import lotto.UserLottoRepository;
import lotto.dto.WinningLotto;

import java.util.*;

public class LottoMachine {
    private final UserLottoRepository userLottoRepository;
    private final LottoWinningEvaluator lottoWinningEvaluator;
    private final LottoFactory lottoFactory;


    public LottoMachine(UserLottoRepository userLottoRepository, LottoWinningEvaluator lottoWinningEvaluator, LottoFactory LottoFactory) {
        this.userLottoRepository = userLottoRepository;
        this.lottoWinningEvaluator = lottoWinningEvaluator;
        this.lottoFactory = LottoFactory;
    }

    public void buyLotto() {
        Lotto lotto = lottoFactory.createRandomLotto();
        userLottoRepository.save(lotto);
    }

    public List<Lotto> getBuyingLottos() {
        return userLottoRepository.getAll();
    }


    public Map<LottoPrize, Integer> calculatePrize(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> prizeResult = new HashMap<>();

        List<Lotto> userLottos = userLottoRepository.getAll();
        for (Lotto lotto : userLottos) {
            Optional<LottoPrize> lottoPrize = lottoWinningEvaluator.calculatePrize(lotto, winningLotto);

            lottoPrize.ifPresent(prize ->
                prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1)
            );
        }
        return prizeResult;
    }

}
