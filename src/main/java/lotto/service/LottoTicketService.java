package lotto.service;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.LottoNumberGenerater;
import lotto.repository.LottoRepository;
import lotto.valuate.PriceValuate;

public class LottoTicketService {

    public int purchaseLottoTickets(int price) {
        PriceValuate.isValidPrice(price);
        return price / LottoConstant.LOTTO_PRICE;
    }

    public void generateLottoNumbers(int numberOfLottos, LottoRepository lottoRepository) {
        List<List<Integer>> lottoNumber;
        lottoNumber = new LottoNumberGenerater().generateLottoTickets(numberOfLottos);
        saveLottoNumber(lottoNumber, lottoRepository);
    }

    private void saveLottoNumber(List<List<Integer>> lottoNumber, LottoRepository lottoRepository) {
        lottoRepository.saveLottoNumbers(lottoNumber);
    }

    public List<List<Integer>> getRandomLottoNumbers(LottoRepository lottoRepository) {
        return lottoRepository.getLottoNumbers();
    }

}
