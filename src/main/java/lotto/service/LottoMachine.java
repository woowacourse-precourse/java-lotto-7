package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int count;
    private final List<Lotto> lottos;
    LottoMachine(int count){
        this.count = count;
        lottos = issueLottoTickets();
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
    private List<Lotto> issueLottoTickets(){
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
