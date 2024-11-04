package lotto.service;

import lotto.constant.LottoConstant;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleService {
    private final LottoService lottoService;

    public LottoBundleService() {
        this.lottoService = new LottoService();
    }

    public List<Lotto> generateLottoBundle(int amount){
        List<Lotto> lottos = new ArrayList<>();
        generateLottoBundle(calculateLottoBundleFromAmount(amount), lottos);
        return lottos;
    }

    private Integer calculateLottoBundleFromAmount(int amount){
        return amount/ LottoConstant.LOTTO_PRICE;
    }

    private void generateLottoBundle(int count, List<Lotto> lottos){
        for(int i=0;i<count;i++){
            lottos.add(lottoService.generateLotto());
        }
    }

}
