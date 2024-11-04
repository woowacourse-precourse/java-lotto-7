package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.LottoResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoService {

    public List<Lotto> issueLottos(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList()));
        }
        return tickets;
    }

    public LottoResult checkWin(Lotto ticket, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = ticket.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
        return LottoResult.getResultForMatchAndBonus((int) matchCount, bonusMatch);
    }

    public double calculateProfitRate(List<LottoResult> results, int totalCost) {
        int totalPrize = results.stream().mapToInt(LottoResult::getPrize).sum();
        return ((double) totalPrize / totalCost) * 100;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6 || !isWithinRange(winningNumbers) || hasDuplicates(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }
}
