package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinLotto;
import lotto.util.Parser;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;

public class LottoFixture {

    public LottoFixture() {
    }

    public static final String INPUT_AMOUNT = "8000";
    public static final String INPUT_NUMBERS = "1,5,20,25,40,45";
    public static final String INPUT_BONUS_NUMBER = "7";
    public static final List<String> CORRECT_ANSWER = List.of("8개를 구매했습니다.",
            "[1, 5, 20, 25, 40, 45]",
            "[1, 5, 20, 25, 40, 44]",
            "[1, 5, 20, 25, 43, 44]",
            "[1, 5, 20, 24, 43, 44]",
            "[1, 5, 23, 24, 43, 44]",
            "[1, 4, 23, 24, 43, 44]",
            "[2, 4, 23, 24, 43, 44]",
            "[1, 5, 20, 25, 40, 7]",
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 1개",
            "5개 일치 (1,500,000원) - 1개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
            "6개 일치 (2,000,000,000원) - 1개",
            "총 수익률은 25394437.5%입니다.");
    public static final List<Integer> zeroMatchNumbers = List.of(2, 4, 23, 24, 43, 44);
    public static final List<Integer> oneMatchNumbers = List.of(1, 4, 23, 24, 43, 44);
    public static final List<Integer> twoMatchNumbers = List.of(1, 5, 23, 24, 43, 44);
    public static final List<Integer> threeMatchNumbers = List.of(1, 5, 20, 24, 43, 44);
    public static final List<Integer> fourMatchNumbers = List.of(1, 5, 20, 25, 43, 44);
    public static final List<Integer> fiveMatchNumbers = List.of(1, 5, 20, 25, 40, 44);
    public static final List<Integer> fiveBonusMatchNumbers = List.of(1, 5, 20, 25, 40, 7);
    public static final List<Integer> sixMatchNumbers = List.of(1, 5, 20, 25, 40, 45);

    public static WinLotto getWinLotto() {
        WinLotto winLotto = new WinLotto(Parser.parseDelimitersInteger(INPUT_NUMBERS));
        winLotto.setBonusNumber(Parser.parseStringToInt(INPUT_BONUS_NUMBER));

        return winLotto;
    }

    public static List<Lotto> getLottos() {
        return List.of(
                new Lotto(zeroMatchNumbers),
                new Lotto(oneMatchNumbers),
                new Lotto(twoMatchNumbers),
                new Lotto(threeMatchNumbers),
                new Lotto(fourMatchNumbers),
                new Lotto(fiveMatchNumbers),
                new Lotto(fiveBonusMatchNumbers),
                new Lotto(sixMatchNumbers)
        );
    }

    public static Map<LottoRank, Integer> getLottoResult() {
        return Map.of(
                FAIL, 3,
                THREE, 1,
                FOUR, 1,
                FIVE, 1,
                FIVE_BONUS, 1,
                SIX, 1
        );
    }
}
