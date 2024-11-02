package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private List<Lottos> lottos = new ArrayList<>();

    public void buyLottos(int lottoTickets) {
        for(int num = 0; num < lottoTickets; num++) {
            Lottos lottoNumbers= Lottos.generateLottoNumbers();
            lottos.add(lottoNumbers);
        }
    }

    public String getLottoList() {
        return getLottos().stream()
                .map(lottos -> lottos.getLottoNumbers().toString())
                .collect(Collectors.joining("\n"));
    }

    public List<Lottos> getLottos() {
        return lottos;
    }
}
