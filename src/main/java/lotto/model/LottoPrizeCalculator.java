package lotto.model;

import java.util.List;

public class LottoPrizeCalculator {
    public static void calculate(LottoTickets lottoTickets,WinningLotto winningLotto){
        for(Lotto lotto :lottoTickets.getLottoTickets()){
            List<Integer> lottoNumbers = lotto.getNumbers();
            comparePrize(lottoNumbers,winningLotto);
        }

    }

    private static void comparePrize(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        List<Integer> winningNumber = winningLotto.getWinningNumber();
        boolean matchBonus = false;

        lottoNumbers.retainAll(winningNumber);
        int matchCount = lottoNumbers.size();
        if(matchCount==5){
            int bonusNumber = winningLotto.getBonusNumber();
            if(lottoNumbers.contains(bonusNumber)){
                matchBonus = true;
            }
        }
    }
}
