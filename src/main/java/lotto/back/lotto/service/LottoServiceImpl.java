package lotto.back.lotto.service;

import java.util.UUID;
import lotto.back.global.annotation.Service;
import lotto.back.lotto.domain.Lottos;
import lotto.back.lotto.repository.PurchasedLottosRepository;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;

@Service
public class LottoServiceImpl implements LottoService {

    private final PurchasedLottosRepository purchasedLottosRepository;


    public LottoServiceImpl(PurchasedLottosRepository purchasedLottosRepository) {
        this.purchasedLottosRepository = purchasedLottosRepository;
    }


    @Override
    public PurchasedLottoResponseDTOs purchase(PurchaseLottoRequestDTO purchaseLottoRequestDTO) {
        UUID uuid = UUID.randomUUID();
        Lottos lottos = Lottos.purchase(uuid, purchaseLottoRequestDTO.price());

        purchasedLottosRepository.save(lottos);

        return PurchasedLottoResponseDTOs.from(lottos);
    }

}
