package lotto.winning.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.model.Lotto;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoTicketsDto;
import lotto.dto.WinningNumberDto;

public class MatchingBetweenWinningAndTickets {
    private final List<Lotto> LottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private List<Integer> numberOfMatching;
    
    public MatchingBetweenWinningAndTickets() {
        LottoTickets = LottoTicketsDto.getLottoTicketsDto().LottoTickets();
        winningNumbers = WinningNumberDto.getWinningNumberDto().winningNumbers();
        bonusNumber = BonusNumberDto.getBonusNumberDto().bonusNumber();
    }
    
    public List<Integer> getMatching() {
        setNumberOfMatching();
        checkBonusWinning();
        return numberOfMatching;
    }
    
    private void setNumberOfMatching() {
        numberOfMatching = LottoTickets.stream()
                            .map(lotto -> (int) lotto.getNumbers().stream()
                                .filter(winningNumbers::contains)
                                .count())
                            .collect(Collectors.toList());
    }

    private void checkBonusWinning() {
        for (int i = 0; i < numberOfMatching.size(); i++) {
            if(numberOfMatching.get(i) == 5) {
                numberOfMatching.set(i, matchBonusNumber(LottoTickets.get(i)));
            }
        }
    }

    private int matchBonusNumber(Lotto LottoTicketOf5matches) {
        boolean isMatchedWithBonus = LottoTicketOf5matches.getNumbers().stream().anyMatch(number -> number == bonusNumber);
        if(isMatchedWithBonus) {
            return 10;
        }
        return 5;
    }
}
