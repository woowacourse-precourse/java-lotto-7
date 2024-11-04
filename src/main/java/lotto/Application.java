package lotto;

public class Application {
    public static void main(String[] args) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.issue();
        lottoTickets.print();

        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.init();

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);
        lottoResult.checkResult();
        lottoResult.print();
    }
}
