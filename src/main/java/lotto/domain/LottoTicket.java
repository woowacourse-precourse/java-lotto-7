package lotto.domain;

public class LottoTicket {
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }
    
    public void printLottoNumbers() {
        System.out.println(lotto.getNumbers());
    }
}
