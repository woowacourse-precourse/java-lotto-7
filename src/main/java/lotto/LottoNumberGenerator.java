package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {

    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public List<List<Integer>> generateLottoNumbers(){
        int lottoTicketCount = LottoMachine.buy();
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumbers.add(randomNumber);
        }
        return lottoNumbers;
    }
}
