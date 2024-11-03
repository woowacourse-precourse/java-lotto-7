package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InvalidPurchaseAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    // 구입 금액을 기준으로 로또 개수를 계산하고 발행
    public void purchaseLottos(int amount) {
        int count = calculateLottoCount(amount);
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
    }

    // 구입 금액을 기준으로 로또 개수를 계산
    private int calculateLottoCount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new InvalidPurchaseAmountException("구입 금액이 부족하여 로또를 구매할 수 없습니다.");
        }
        return amount / LOTTO_PRICE;
    }

    // 무작위로 중복되지 않는 6개의 숫자로 로또 생성
    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()); // 오름차순 정렬
        return new Lotto(numbers);
    }

    // 발행된 로또 목록 반환
    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    // 당첨 결과 계산
    public Result calculateResults(Set<Integer> winningNumbers, int bonusNumber, int totalSpent) {
        Result result = new Result(totalSpent);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            // Rank Enum을 사용하여 당첨 등수를 판별
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.updateResult(rank);
        }
        return result;
    }
}