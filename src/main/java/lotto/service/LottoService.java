package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.domain.WinningResult;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_CNT = 6;

    public int calculateLottoCount(int amount) {
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 음수일 수 없습니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private Lotto generateLotto() {
        List<LottoNumber> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER,
                        NUMBER_CNT)
                .stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    public Map<Prize, Integer> cacluateReults(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        Map<Prize, Integer> results = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            results.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto::contains)
                    .count();
            boolean matchBonus = lotto.contains(bonusNumber);
            Prize prize = new WinningResult(matchCount, matchBonus).calculatePrize();
            results.put(prize, results.get(prize) + 1);
        }
        return results;
    }
}
