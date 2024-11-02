package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private List<Lottos> lottos = new ArrayList<>();
    private Lotto winningLottoNumbers;

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

    public void inputWinningLottoNumbers(String rawWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        winningLottoNumbers = new Lotto(winningNumbers);
    }


    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
