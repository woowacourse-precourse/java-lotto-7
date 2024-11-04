package lotto.service;

import static lotto.constant.LottoValueConstant.LOTTO_PRICE;

import java.util.List;
import lotto.domain.LottoNumberGenerater;
import lotto.reposi.LottoRepository;
import lotto.valuate.PriceValuate;

public class LottoTicketService {


    public int purchaseLottoTickets(int price) {
        PriceValuate.isValidPrice(price);
        return (price / LOTTO_PRICE);
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
