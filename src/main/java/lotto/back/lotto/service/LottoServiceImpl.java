package lotto.back.lotto.service;

import lotto.back.global.annotation.Service;
import lotto.back.lotto.config.LottoConfig;
import lotto.back.lotto.domain.Lotto;
import lotto.back.lotto.domain.Lottos;
import lotto.back.lotto.domain.result.LottoResults;
import lotto.back.lotto.repository.PrizeLottoRepository;
import lotto.back.lotto.repository.PurchasedLottosRepository;
import lotto.global.dto.request.LottoResultRequestDTO;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.dto.response.LottoResultResponseDTOs;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;
import lotto.global.exception.CustomIllegalArgumentException;

@Service
public class LottoServiceImpl implements LottoService {

    private final PurchasedLottosRepository purchasedLottosRepository;

    private final PrizeLottoRepository prizeLottoRepository;


    public LottoServiceImpl(PurchasedLottosRepository purchasedLottosRepository,
                                  PrizeLottoRepository prizeLottoRepository) {
        this.purchasedLottosRepository = purchasedLottosRepository;
        this.prizeLottoRepository = prizeLottoRepository;
    }


    @Override
    public PurchasedLottoResponseDTOs purchase(PurchaseLottoRequestDTO purchaseLottoRequestDTO) {
        validatePrice(purchaseLottoRequestDTO.price());
        Integer lottoCount = getLottoCount(purchaseLottoRequestDTO.price());

        Lottos lottos = Lottos.generateRandomLottos(lottoCount);
        purchasedLottosRepository.save(lottos);

        return PurchasedLottoResponseDTOs.from(lottos);
    }

    private void validatePrice(Integer price) {
        if ((price <= 0) || (price % LottoConfig.PRICE.get() != 0)) {
            throw new CustomIllegalArgumentException(
                    String.format("로또 가격은 개당 %d원입니다.", LottoConfig.PRICE.get())
            );
        }
    }

    private Integer getLottoCount(Integer price) {
        return price / LottoConfig.PRICE.get();
    }

    @Override
    public void setPrizeLotto(SetPrizeLottoRequestDTO setPrizeLottoRequestDTO) {
        Lotto prizeLotto = new Lotto(setPrizeLottoRequestDTO.prizeNumbers());

        prizeLottoRepository.save(setPrizeLottoRequestDTO.uuid(), prizeLotto);
    }

    @Override
    public LottoResultResponseDTOs getResult(LottoResultRequestDTO lottoResultRequestDTO) {
        Lottos lottos = purchasedLottosRepository.findById(lottoResultRequestDTO.uuid());
        Lotto prizeLotto = prizeLottoRepository.findById(lottoResultRequestDTO.uuid());

        LottoResults lottoResults = new LottoResults(
                lottos,
                prizeLotto,
                lottoResultRequestDTO.bonusNumber()
        );
        Double profit = calculateProfitRate(lottoResults, lottoResults.getPrice());

        return LottoResultResponseDTOs.from(lottoResults, profit);
    }

    private Double calculateProfitRate(LottoResults results, Integer price) {
        if (price <= 0) {
            throw new CustomIllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        long sum = results.getLottoResults().stream()
                .mapToLong(lottoResult -> lottoResult.getLottoStatus().getPrize())
                .sum();

        return (double) sum / price * 100;
    }

}
