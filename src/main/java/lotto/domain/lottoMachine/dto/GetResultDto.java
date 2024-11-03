package lotto.domain.lottoMachine.dto;

import java.util.Map;
import lotto.domain.lottoMachine.Rank;

public record GetResultDto(Map<Rank,Integer> result) {
}
