package lotto.service;

import static lotto.constant.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.validator.LottoValidator;

public class InMemoryLottoService implements LottoService {

    private final LottoValidator lottoValidator;
    private final LottoRepository lottoRepository;
    private static InMemoryLottoService instance;

    private InMemoryLottoService(LottoValidator lottoValidator, LottoRepository lottoRepository) {
        this.lottoValidator = lottoValidator;
        this.lottoRepository = lottoRepository;
    }
    public static InMemoryLottoService getInstance(LottoValidator lottoValidator, LottoRepository lottoRepository) {
        if (instance == null) {
            instance = new InMemoryLottoService(lottoValidator, lottoRepository);
        }
        return instance;
    }

    @Override
    public void buyLotto(String money) {

        lottoValidator.validateMoney(money);

        int purchasableLottoCount = Integer.parseInt(money) / LOTTO_PRICE;

        for (int i = 0; i < purchasableLottoCount; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            lottoValidator.validateGeneratedLottoNumbers(lottoNumbers);
            lottoRepository.save(new Lotto(lottoNumbers));
        }
    }

    @Override
    public void checkLotto(String winNumbers, String bonusNumber) {

        lottoValidator.validateWinnerLottoNumbers(winNumbers);
        lottoValidator.validateBonusNumber(bonusNumber);

        List<Integer> winnerNumbers = Arrays.stream(winNumbers.split(",")).map(Integer::parseInt).toList();
        int bonus = Integer.parseInt(bonusNumber);

        // Todo: 당첨 통계 계산
    }

    @Override
    public List<Lotto> getAllLottos() {
        return lottoRepository.findAll();
    }

    @Override
    public void deleteLottos() {
        lottoRepository.deleteAll();
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
