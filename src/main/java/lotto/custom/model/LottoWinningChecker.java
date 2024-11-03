package lotto.custom.model;

import java.util.List;

public class LottoWinningChecker {
    public void run(Lottos myLottoTickets, List<Integer> winningNumbers, int bonusNumber, List<Integer> result) {
        for (Lotto ticket : myLottoTickets.getLottos()) {
            List<Integer> lottoTicket = ticket.getNumbers();
            int matchCount = countMatchingNumbers(lottoTicket, winningNumbers);
            
            updateResult(result, matchCount, lottoTicket.contains(bonusNumber));
        }
    }

    private int countMatchingNumbers(List<Integer> lottoTicket, List<Integer> winningNumbers) {
        return (int) lottoTicket.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void updateResult(List<Integer> result, int matchCount, boolean hasBonus) {
        if (matchCount == 3) {
            incrementResult(result, 0);
        }
        if (matchCount == 4) {
            incrementResult(result, 1);
        }
        if (matchCount == 5) {
            checkBonus(result, hasBonus);
        }
        if (matchCount == 6) {
            incrementResult(result, 4);
        }
    }

    private void checkBonus(List<Integer> result, boolean hasBonus) {
        if (!hasBonus) {
            incrementResult(result, 2);
        }
        if (hasBonus) {
            incrementResult(result, 3);
        }
    }

    private void incrementResult(List<Integer> result, int index) {
        result.set(index, result.get(index) + 1);
    }
}