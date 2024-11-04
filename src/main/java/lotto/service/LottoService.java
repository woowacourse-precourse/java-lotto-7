package lotto.service;

import lotto.constant.LottoConstant;
import lotto.model.Lotto;
import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> responseLottoTicket(int amount){
        List<Lotto> lottos = new ArrayList<>();
        generateLottoTicket(amount/LottoConstant.LOTTO_PRICE, lottos);
        return lottos;
    }

    private void generateLottoTicket(int count, List<Lotto> lottos){
        for(int i=0;i<count;i++){
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers(){
        return LottoNumberGenerator.responseLottoNumbers();
    }
}
