package lotto.config;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.service.DtoMapper;
import lotto.service.LottoDtoMapper;
import lotto.service.LottosDtoMapper;

public class DtoMapperConfig {
    public DtoMapper<Lottos, LottosDto> lottosDtoMapper(){
        return new LottosDtoMapper(lottoDtoMapper());
    }

    public DtoMapper<Lotto, LottoDto> lottoDtoMapper(){
        return new LottoDtoMapper();
    }



}
