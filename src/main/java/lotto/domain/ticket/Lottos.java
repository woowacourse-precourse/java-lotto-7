package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos (List<Lotto> lottoList){
        this.lottos = lottoList;
    }

    public static Lottos createLottos(
            int purchasedLottoCount
            , LottoFactory lottoFactory){

        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < purchasedLottoCount; i++){
            Lotto lotto = (lottoFactory.createLotto());
            lottoList.add(lotto);
        }

        return new Lottos(lottoList);

    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
