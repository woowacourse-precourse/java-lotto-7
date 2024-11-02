package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final InputHandler inputHandler;

    public LottoService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<Lotto> lottoGenerate(int gameTrial) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<gameTrial; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public List<Integer> compareLottosWithWinning(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(compareLottoWithWinning(winningNumbers, lotto,bonusNum));
        }
        return result;
    }

    private int compareLottoWithWinning(List<Integer> winningNumbers, Lotto lotto, int bonusNum) {
        List<Integer> numbers = lotto.getNumbers();
        int cnt =0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                cnt+=1;
            }
        }
        if (cnt==5 && numbers.contains(bonusNum)){
            cnt+=2;
        }
        return cnt;
    }


}
