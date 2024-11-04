package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(makeLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    private int findRank(Lotto lotto, LottoGame game) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(game.getWinningNumbers()::contains)
                .count();

        return switch (matchCount) {
            case 3 -> 5;
            case 4 -> 4;
            case 5 -> lotto.getNumbers().contains(game.getBonusNumber()) ? 2 : 3;
            case 6 -> 1;
            default -> 0;
        };
    }
}
