package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.exception.InsufficientFundsException;
import lotto.exception.InvalidLottoOperationException;
import lotto.exception.LottoNotPurchasedException;
import lotto.exception.UninitializedWinningNumbersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private boolean isPurchased = false;

    // 구입 금액 부족 시 예외 발생
    public void purchaseLottos(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new InsufficientFundsException("구입 금액이 부족하여 로또를 구매할 수 없습니다.");
        }
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
        isPurchased = true;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()); // 오름차순 정렬
        return new Lotto(numbers);
    }

    // 당첨 결과 계산
    // 미발행 상태 또는 번호 미설정 시 예외 발생
    public Result calculateResults(Set<Integer> winningNumbers, int bonusNumber, int totalSpent) {
        if (!isPurchased) {
            throw new LottoNotPurchasedException("로또가 발행되지 않은 상태에서는 당첨 결과를 확인할 수 없습니다.");
        }
        if (winningNumbers == null || winningNumbers.size() != 6 || bonusNumber < 1 || bonusNumber > 45) {
            throw new UninitializedWinningNumbersException("당첨 번호와 보너스 번호가 설정되지 않은 상태에서 당첨 결과를 확인할 수 없습니다.");
        }

        Result result = new Result(totalSpent);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.updateResult(rank);
        }
        return result;
    }

    public List<Lotto> getPurchasedLottos() {
        if (!isPurchased) {
            throw new LottoNotPurchasedException("로또가 발행되지 않은 상태에서는 로또 목록을 확인할 수 없습니다.");
        }
        return purchasedLottos;
    }
}