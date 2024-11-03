package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private int numberOfLotto;
    private List<Lotto> lottoTickets;

    public Lottos(int numberOfLotto){
        this.numberOfLotto= numberOfLotto;
        createLottos(numberOfLotto);
    }

    private void createLottos(int numberOfLotto){
        List<Lotto> lottoTickets= new ArrayList<>();
        for(int i=0;i<numberOfLotto;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
