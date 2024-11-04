package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoStatistics lottoStatistics = new LottoStatistics();
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void run() {
        int money = input.inputMoney();
        int numTickets = money / 1000;

        System.out.println("\n" + numTickets + "개를 구매했습니다.");
        List<Lotto> lottoTickets = generateLottoTickets(numTickets);
        output.printLottoNumbers(lottoTickets);

        Lotto winningLotto = input.LottoNumber();
        int bonusNum = input.bonusNum(winningLotto);
        calculateStatistics(lottoTickets, winningLotto.getNumbers(), bonusNum);

        output.printStatistics(lottoStatistics);
        output.printRevenue(lottoStatistics.getTotalPrize(), money);
    }

    private void calculateStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNum) {
        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusMatch = matchCount == 5 && lotto.getNumbers().contains(bonusNum);
            lottoStatistics.incrementCount(matchCount, hasBonusMatch);
        }
    }

    private List<Lotto> generateLottoTickets(int num) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoTickets.add(new Lotto(generateUniqueLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<Integer> generateUniqueLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int countMatchingNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
