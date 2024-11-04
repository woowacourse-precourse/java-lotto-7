package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public record Result(List<Integer> lottoMatchResults, BigDecimal earningRate) {
}
