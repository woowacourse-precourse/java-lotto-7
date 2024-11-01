package lotto.service;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerater;
import java.util.List;
import lotto.repository.LottoRepository;

public class GenerateLottoNumberManager {
    private List<List<Integer>> lottoNumber;

    public List<List<Integer>> generate(int num){
        LottoNumberGenerater generater = new LottoNumberGenerater();
        for(int i = 0; i < num; i++){
            List<Integer> list = generater.numberGenerate();
            new Lotto(list);
            lottoNumber.add(list);
        }
        new LottoRepository(lottoNumber);
        return lottoNumber;
    }

    public GenerateLottoNumberManager(){
        lottoNumber = new ArrayList<>();
    }

}
