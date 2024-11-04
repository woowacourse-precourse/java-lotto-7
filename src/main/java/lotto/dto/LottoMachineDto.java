package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public record LottoMachineDto(List<Lotto> lottos, int money) {
}
