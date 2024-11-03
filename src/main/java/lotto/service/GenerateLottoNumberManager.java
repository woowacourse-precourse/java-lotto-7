package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumberGenerater;
import lotto.repository.LottoRepository;

public class GenerateLottoNumberManager {
    private List<List<Integer>> lottoNumber;
    private LottoRepository lottoRepository;

    public void generate(int num) {
        LottoNumberGenerater generater = new LottoNumberGenerater();
        for (int i = 0; i < num; i++) {
            List<Integer> list = generater.numberGenerate();
            lottoNumber.add(list);
        }
        lottoRepository.saveLottoNumbers(lottoNumber);
    }

    public List<List<Integer>> getRandomLottoNumbers() {
        return lottoRepository.getLottoNumbers();
    }

    public GenerateLottoNumberManager(LottoRepository lottoRepository) {
        lottoNumber = new ArrayList<>();
        this.lottoRepository = lottoRepository;
    }

}
