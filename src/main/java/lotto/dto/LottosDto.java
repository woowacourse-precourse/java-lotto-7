package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto.Lotto;

public record LottosDto(List<Lotto> lottos, int ticketCount) {
    public static LottosDto of(List<Lotto> lottos, int ticketCount) {
        return new LottosDto(lottos, ticketCount);
    }

    public String getLottosAsString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public int getTicketCount(){
        return ticketCount();
    }
}
