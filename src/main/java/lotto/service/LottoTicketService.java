package lotto.service;

import java.util.List;
import lotto.domain.LottoNumberGenerater;
import lotto.reposi.LottoRepository;
import lotto.valuate.PriceValuate;

public class LottoTicketService {


    public int purchaseLottoTickets(int price) {
        PriceValuate.isValidPrice(price);
        return (price / 1000);
    }

    public void generateLottoNumbers(int numberOfLottos, LottoRepository lottoRepository) {
        List<List<Integer>> lottoNumber;
        lottoNumber = new LottoNumberGenerater().generateLottoTickets(numberOfLottos);
        saveLottoNumber(lottoNumber, lottoRepository);
    }

    private void saveLottoNumber(List<List<Integer>> lottoNumber, LottoRepository lottoRepository) {
        lottoRepository.saveLottoNumbers(lottoNumber);
    }

    public List<List<Integer>> getLottoNumbers(LottoRepository lottoRepository) {
        return lottoRepository.getLottoNumbers();
    }

}
