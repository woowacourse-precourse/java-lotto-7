package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private List<Integer> lottoPlaceCount;

    public LottoRepository(){
        lottoPlaceCount = new ArrayList<>(Collections.nCopies(5,0));
    }

    public void saveLotto(Lotto lotto){
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottos(){
        return Collections.unmodifiableList(lottoTickets);
    }

    public void increaseCount(int place){
        int currentCount = lottoPlaceCount.get(place);
        lottoPlaceCount.set(place, currentCount+1);
    }

    public List<Integer> getLottoPlaceCount(){
        return Collections.unmodifiableList(lottoPlaceCount);
    }
}
