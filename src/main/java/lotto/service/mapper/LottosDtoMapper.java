package lotto.service.mapper;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class LottosDtoMapper implements DtoMapper <Lottos,LottosDto> {
    private final DtoMapper <Lotto,LottoDto> lottoDtoMapper;

    public LottosDtoMapper(DtoMapper <Lotto,LottoDto> lottoDtoMapper) {
        this.lottoDtoMapper = lottoDtoMapper;
    }

    @Override
    public LottosDto toDto(Lottos lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoDtos.add(lottoDtoMapper.toDto(lotto));
        }

        return new LottosDto(lottoDtos);
    }
}
