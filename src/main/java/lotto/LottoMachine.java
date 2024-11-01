package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    static HashMap<Integer, Integer> map = new HashMap<>();

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

        List<Integer> winningNumbers = numbers.getNumbers();
        winningNumbers.add(bonusNum);

        calculateStatistics(lottoTickets, winningNumbers);
        output.printStatistics(map);
        output.printRevenue(map, money);
    }

    private void calculateStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers) {
        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            map.put(matchCount, map.getOrDefault(matchCount, 0) + 1);
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
        Collections.sort(numbers);
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
