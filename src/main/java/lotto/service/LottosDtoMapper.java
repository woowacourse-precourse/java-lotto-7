package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class LottosDtoMapper implements DtoMapper <Lottos,LottosDto> {
    private final LottoDtoMapper lottoDtoMapper;

    public LottosDtoMapper(LottoDtoMapper lottoDtoMapper) {
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
