package lotto.model.lottoPurchaser;

import lotto.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLottoRepository implements LottoRepository {

    private final List<Lotto> issuedLottoRepository = new ArrayList<>();

    @Override
    public void saveLotto(Lotto lotto){
        issuedLottoRepository.add(lotto);
    }

    @Override
    public List<Lotto> findAllLotto(){
        return issuedLottoRepository;
    }

}




