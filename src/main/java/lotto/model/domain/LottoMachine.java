package lotto.model.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.generator.NumberGenerator;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generateLottos(LottoTickets lottoTickets) {
        // 구입 금액에 해당하는 만큼 로또를 발행해야 한다. -> 모두 발행하기에 getter 조회
        return IntStream.range(0, lottoTickets.getTicketCount())
                .mapToObj(i -> new Lotto(numberGenerator.generateLottoNumbers()))
                .toList();
    }
}
