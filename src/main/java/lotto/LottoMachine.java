package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private final LottoStatistics lottoStatistics = new LottoStatistics();

    public void run(){
        InputView input = new InputView();
        OutputView output = new OutputView();
        int money = input.inputMoney();
        int num = money / 1000;

        System.out.println("\n" + num + "개를 구매했습니다.");

        List<Lotto> lottoTickets = generateLottoTickets(num);
        output.printLottoNumbers(lottoTickets);

        Lotto numbers = input.LottoNumber();
        int bonusNum = input.bonusNum(numbers);

        calculateStatistics(lottoTickets, numbers.getNumbers(), bonusNum);
        output.printStatistics(lottoStatistics);
        output.printRevenue(lottoStatistics.getTotalPrize(), money);
    }

    private void calculateStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNum) {
        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusMatch = (matchCount == 5 && lotto.getNumbers().contains(bonusNum)); // 보너스 번호 일치 여부 확인
            lottoStatistics.incrementCount(matchCount, hasBonusMatch);
        }
    }

    private List<Lotto> generateLottoTickets(int num) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            List<Integer> numbers = generateUniqueLottoNumbers();
            lottoTickets.add(new Lotto(numbers));
        }

        return lottoTickets;
    }

    private List<Integer> generateUniqueLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
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
