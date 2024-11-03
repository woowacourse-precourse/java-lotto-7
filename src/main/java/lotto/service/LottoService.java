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

    public List<PrizeResponse> findWinningResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        List<PrizeResponse> prizeResponses = new ArrayList<>();

        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers(); // 발행된 각 로또의 번호들

            PrizeResponse prizeResponse = calculatePrize(winningLotto, bonusNumber, numbers);
            if (prizeResponse.prizeMoney() != 0) { // 당첨금이 있다면 결과에 추가
                prizeResponses.add(prizeResponse);
            }
        }

        return prizeResponses;
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
