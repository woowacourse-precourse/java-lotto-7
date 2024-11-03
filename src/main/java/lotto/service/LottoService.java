package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
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
