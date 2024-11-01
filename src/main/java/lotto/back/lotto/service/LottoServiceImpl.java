package lotto.back.lotto.service;

import java.util.UUID;
import lotto.back.global.annotation.Service;
import lotto.back.lotto.domain.Lotto;
import lotto.back.lotto.domain.Lottos;
import lotto.back.lotto.repository.PrizeLottoRepository;
import lotto.back.lotto.repository.PurchasedLottosRepository;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;

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

}
