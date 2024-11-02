package lotto.Domain;

public class User {
    private final int payment;  // 지불한 금액
    private final int lottoNumbers; // 로또의 개수
    final int WON = 1000;

    public User(int payment) {
        this.payment = payment;
        this.lottoNumbers = calculateLottoNumbers(payment);
    }

    private int calculateLottoNumbers(int payment) {
        return payment / WON;
    }

    public int getLottoNumbers() {
        return lottoNumbers;
    }
}
