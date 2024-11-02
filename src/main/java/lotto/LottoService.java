package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomLottoNumberGenerator;

public class LottoService {
    private final int LOOP_START = 0;

    private final RandomLottoNumberGenerator randomLottoNumberGenerator;
    private final LottoRepository lottoRepository;

    public LottoService(RandomLottoNumberGenerator randomLottoNumberGenerator, LottoRepository lottoRepository) {
        this.randomLottoNumberGenerator = randomLottoNumberGenerator;
        this.lottoRepository = lottoRepository;
    }

    public String generateRandomNumberLottos(int purchaseAmount) {
        List<Lotto> randomNumberLottos = new ArrayList<>();
        for (int i = LOOP_START; i < purchaseAmount; i++) {
            randomNumberLottos.add(new Lotto(randomLottoNumberGenerator.generateLottoNumbers()));
        }

        lottoRepository.saveRandomLottos(randomNumberLottos);
        return lottoRepository.loadRandomLottos().printLottosNumbers();
    }

    public LottoResult calculateResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottoRepository.loadRandomLottos().calculateGameResult(winningNumbers, bonusNumber);
    }
}
