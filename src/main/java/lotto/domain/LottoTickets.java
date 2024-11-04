package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Map<LottoPrize, Integer> getLottoPrizesMap(WinningLotto winningLotto) {
        // EnumMap 초기화
        Map<LottoPrize, Integer> lottoPrizes = getLottoPrizeIntegerMap();

        // lottos의 각 로또에 대해 당첨 번호를 계산하고, 결과를 lottoPrizes에 저장
        lottos.stream()
                .map(winningLotto::getLottoPrize)
                .forEach(lottoPrize ->
                        lottoPrizes.put(lottoPrize, lottoPrizes.get(lottoPrize) + 1) // 카운트 증가
                );

        return lottoPrizes;
    }

    private Map<LottoPrize, Integer> getLottoPrizeIntegerMap() {
        Map<LottoPrize, Integer> lottoPrizes = new EnumMap<>(LottoPrize.class);

        // 모든 LottoPrize에 대해 0으로 초기화
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoPrizes.put(lottoPrize, 0);
        }

        return lottoPrizes;
    }
}
