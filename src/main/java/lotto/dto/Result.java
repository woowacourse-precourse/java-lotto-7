package lotto.dto;

import java.util.List;

public record Result(List<Integer> lottoMatchResults, Double earningRate) {
}
