package lotto.back.lotto.service;

import java.util.UUID;
import lotto.back.global.annotation.Service;
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
        UUID uuid = UUID.randomUUID();
        Lottos lottos = Lottos.purchase(uuid, purchaseLottoRequestDTO.price());

        purchasedLottosRepository.save(lottos);

        return PurchasedLottoResponseDTOs.from(lottos);
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

        int sum = results.getLottoResults().stream()
                .mapToInt(lottoResult -> lottoResult.getLottoStatus().getPrize())
                .sum();

        return (double) sum / price * 100;
    }

}
