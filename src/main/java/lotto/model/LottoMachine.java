package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private boolean isPurchased = false;
    private Set<Integer> winningNumbers;
    private int totalPrizeAmount = 0;

    public void purchaseLottos(String amountStr) {
        int amount = parseAmount(amountStr);
        validatePurchaseAmount(amount);
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
        isPurchased = true;
    }

    private int parseAmount(String amountStr) {
        try {
            return Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException("구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new InvalidPurchaseAmountException("구입 금액이 충분하지 않거나 1,000원 단위가 아닙니다.");
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public void validateWinningNumbers(String numbers) {
        Set<Integer> uniqueNumbers = parseWinningNumbers(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new InvalidLottoNumberException("로또 번호는 중복될 수 없습니다.");
        }
        this.winningNumbers = uniqueNumbers;
    }

    private Set<Integer> parseWinningNumbers(String numbers) {
        String[] splitNumbers = numbers.split(",");
        if (splitNumbers.length != 6) {
            throw new InvalidLottoNumberException("당첨 번호는 6개의 숫자로 입력해야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        try {
            for (String numStr : splitNumbers) {
                int num = Integer.parseInt(numStr.trim());
                if (num < 1 || num > 45) {
                    throw new InvalidLottoNumberException("로또 번호는 1부터 45 사이여야 합니다.");
                }
                uniqueNumbers.add(num);
            }
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumberException("당첨 번호는 숫자로 입력해야 합니다.");
        }

        return uniqueNumbers;
    }

    public void validateBonusNumber(String bonusStr) {
        int bonus = parseBonusNumber(bonusStr);
        if (bonus < 1 || bonus > 45) {
            throw new InvalidBonusNumberException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers != null && winningNumbers.contains(bonus)) {
            throw new InvalidBonusNumberException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

    }

    private int parseBonusNumber(String bonusStr) {
        try {
            return Integer.parseInt(bonusStr);
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberException("보너스 번호는 숫자로 입력해야 합니다.");
        }
    }

    public void calculateYield(int totalSpent) {
        validatePurchaseState();
        validateTotalSpent(totalSpent);
    }

    private void validatePurchaseState() {
        if (!isPurchased) {
            throw new LottoNotPurchasedException("로또가 발행되지 않은 상태에서는 수익률을 계산할 수 없습니다.");
        }
    }

    private void validateTotalSpent(int totalSpent) {
        if (totalSpent <= 0) {
            throw new IllegalArgumentException("[ERROR] 총 구입 금액은 0보다 커야 합니다.");
        }
    }

    public Result calculateResults(Set<Integer> winningNumbers, int bonusNumber, int totalSpent) {
        validatePurchaseState();
        validateWinningNumbersState(winningNumbers, bonusNumber);

        Result result = new Result(totalSpent);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.updateResult(rank);
            totalPrizeAmount += rank.getReward();
        }
        return result;
    }

    private void validateWinningNumbersState(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers == null || winningNumbers.size() != 6 || bonusNumber < 1 || bonusNumber > 45) {
            throw new UninitializedWinningNumbersException("당첨 번호와 보너스 번호가 설정되지 않은 상태에서 당첨 결과를 확인할 수 없습니다.");
        }
    }

    public List<Lotto> getPurchasedLottos() {
        if (!isPurchased) {
            throw new LottoNotPurchasedException("로또가 발행되지 않은 상태에서는 로또 목록을 확인할 수 없습니다.");
        }
        return purchasedLottos;
    }
}