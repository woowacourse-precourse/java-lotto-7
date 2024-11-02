package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> generateLotto(int purchaseAmount) {
        validate(purchaseAmount);
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>(numberOfLottos);

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_BEGIN, LOTTO_NUMBER_END,
                    LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(generatedNumbers));
        }
        return lottos;
    }

    private static void validate(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원 단위여야 합니다.");
        }
    }

    public static LottoResult match(WinningNumbers winningNumbers, List<Lotto> lottos) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            long matchCount = lotto.getMatchCount(winningNumbers.lotto());
            boolean isBonusBallMatched = lotto.contains(winningNumbers.bonusBall());

            Optional<LottoPrize> prize = LottoPrize.of(matchCount, isBonusBallMatched);
            prize.ifPresent(prizes::add);
        }
        return new LottoResult(prizes);
    }
}
