package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Ranking;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;

import lotto.view.OutputView;

import java.util.*;

import static lotto.enums.Constants.*;
import static lotto.enums.Ranking.MISS;

public class LottoService {

    public Money moneyGenerate(int input) {
        return new Money(input);
    }

    public Lotto lottoGenerate(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public WinningNumber winningNumberGenerate(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningNumber(lotto, bonusNumber);
    }

    public List<Lotto> lottosGenerate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int trial = money.getMoney()/1000;

        for (int i = 0; i < trial; i++) {
            Lotto lotto =lottoGenerate(Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUM.getValue(), MAX_LOTTO_NUM.getValue(),NUMBER_OF_LOTTO_NUMBERS.getValue()));
            lottos.add(lotto);
        }

        return lottos;
    }
    public Map<Ranking,Integer> compareLottosWithWinning(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<Ranking, Integer> result = resultInit();

        for (Lotto lotto : lottos) {
            Ranking rank = compareLottoWithWinning(winningNumber, lotto);

            if (rank!= MISS ){
                result.compute(rank, (ranking, integer) -> integer + 1);
            }
        }
        return result;
    }
    private Ranking compareLottoWithWinning(WinningNumber winningNumber, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int cnt =0;
        for (Integer number : numbers) {
            if (winningNumber.getWinningNumber().contains(number)) {
                cnt+=1;
            }
        }
        if (cnt==5 && numbers.contains(winningNumber.getBonusNumber())){
            cnt+=2;
        }
        return Ranking.valueOf(cnt);
    }


    private Map<Ranking, Integer> resultInit() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        Ranking[] values = Ranking.values();
        for (Ranking ranking : values) {
            if (ranking!=MISS){
                result.put(ranking, 0);
            }
        }
        return result;
    }

    public double calculateReturnRate(Map<Ranking, Integer> result, Money money) {
        double sum = 0;

        for (Ranking ranking : result.keySet()) {
            sum += ranking.getWinningAmount() * result.get(ranking);
        }
        return sum/money.getMoney()*100;
    }
}
