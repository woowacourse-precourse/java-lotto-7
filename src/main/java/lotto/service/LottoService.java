package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.dto.LottoResponse;
import lotto.dto.PrizeResponse;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    private PrizeResponse calculatePrize(Lotto winningLotto, int bonusNumber, List<Integer> numbers) {
        int matchingNumberCount = (int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean containsBonusNumber = numbers.contains(bonusNumber);

        if (containsBonusNumber) {
            matchingNumberCount++;
        }
        Prize prize = Prize.findBy(matchingNumberCount, containsBonusNumber);

        return new PrizeResponse(prize, containsBonusNumber);
    }

    public void saveLottos(List<Lotto> lottos) {
        lottoRepository.saveAll(lottos);
    }

    public List<LottoResponse> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }

        return lottos.stream()
                .map(LottoResponse::new)
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(lottoNumbers);
    }
}
