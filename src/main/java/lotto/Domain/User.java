package lotto.Domain;

public class User {
    private final int payment;
    private final int lottoNumbers;
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
