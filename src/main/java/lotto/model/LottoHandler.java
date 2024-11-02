package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private List<Lotto> lottos = new ArrayList<>();

    public void buyLottos(int lottoTickets) {
        for(int num = 0; num < lottoTickets; num++) {
            Lotto lotto = Lotto.generateLottoNumbers();
            lottos.add(lotto);
        }
    }

    public String getLottoList() {
        return getLottos().stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
