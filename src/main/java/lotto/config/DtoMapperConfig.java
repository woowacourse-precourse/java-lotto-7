package lotto.config;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.service.mapper.DtoMapper;
import lotto.service.mapper.LottoDtoMapper;
import lotto.service.mapper.LottosDtoMapper;

public class DtoMapperConfig {
    public DtoMapper<Lottos, LottosDto> lottosDtoMapper(){
        return new LottosDtoMapper(lottoDtoMapper());
    }

    public DtoMapper<Lotto, LottoDto> lottoDtoMapper(){
        return new LottoDtoMapper();
    }



}
