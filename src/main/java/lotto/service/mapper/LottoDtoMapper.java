package lotto.service.mapper;

import java.util.HashSet;
import lotto.domain.ticket.Lotto;
import lotto.dto.LottoDto;

public class LottoDtoMapper implements DtoMapper<Lotto,LottoDto>{
    @Override
    public LottoDto toDto(Lotto lotto) {
        return new LottoDto( new HashSet<>(lotto.getNumbers()));
    }
}
