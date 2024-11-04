package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class Issuing {
    public List<Lotto> lottoTickets(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i<count;i++){
            lottos.add(randomLotto());
        }
        return lottos;
    }
    private Lotto randomLotto(){
        List<Integer> numbers = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return new Lotto(numbers);
    }
}
