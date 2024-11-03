package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.dto.PrizeResponse;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<PrizeResponse> findWinningResult(Lotto winningLotto, int bonusNumber) {
        List<Lotto> purchasedLottos = lottoRepository.findAll();
        Map<Prize, Integer> winningCounts = Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> 0));

        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers(); // 발행된 각 로또의 번호들
            boolean containsBonusNumber = numbers.contains(bonusNumber);

            Prize prize = calculatePrize(winningLotto, containsBonusNumber, numbers);

            // 당첨금 0인 애는 뺴고 시작
            // Map<Prize, Integer> 하나 만들어서 등수 별로 몇 개 있는지 세기
            if (prize != Prize.NONE) { // 당첨금이 있다면 결과에 추가
                winningCounts.put(prize, winningCounts.getOrDefault(prize, 0) + 1);
            }
        }

        return mapToPrizeResponses(winningCounts);
    }

    private Prize calculatePrize(Lotto winningLotto, boolean containsBonusNumber, List<Integer> numbers) {
        int matchingNumberCount = (int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();

        if (containsBonusNumber) {
            matchingNumberCount++;
        }

        return Prize.of(matchingNumberCount, containsBonusNumber);
    }

    private List<PrizeResponse> mapToPrizeResponses(Map<Prize, Integer> winningCounts) {
        List<PrizeResponse> prizeResponses = new ArrayList<>();

        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> {
                    int count = winningCounts.getOrDefault(prize, 0);
                    prizeResponses.add(new PrizeResponse(prize, count));
                });

        return prizeResponses;
    }

    public void generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        lottoRepository.saveAll(lottos);
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(lottoNumbers);
    }
}
