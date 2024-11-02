package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto>lottoTickets=new ArrayList<>();

    public LottoGame(int purchaseAmount){
        for(int i=0;i<purchaseAmount/1000; i++){
            List<Integer> lottoNumbers=new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoTickets.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto>getLottoTickets(){
        return new ArrayList<>(lottoTickets);
    }
    public int getLottoCount(){
        return lottoTickets.size();
    }
}