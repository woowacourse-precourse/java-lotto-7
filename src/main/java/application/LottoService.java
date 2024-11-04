package application;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < price / LOTTO_PRICE; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }



}
