package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.NumGenerator;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(int ticketCount, NumGenerator generator) {
        lottoTicket = new ArrayList<Lotto>();
        generateLotto(ticketCount, generator);
    }

    private void generateLotto(int ticketCount, NumGenerator generator) {
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(generator.generate());
            lottoTicket.add(lotto);
        }
    }

    public List<String> getPrintFormNumbers() {
        List<String> printForms = new ArrayList<>();
        lottoTicket.stream()
            .forEach(lotto -> printForms.add(lotto.toString()));
        return printForms;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
