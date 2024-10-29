package lotto;

public class Lotto {
    private final PrizeNumber prizeNumber;

    public Lotto(PrizeNumber prizeNumber) {
        validate(prizeNumber);
        this.prizeNumber = prizeNumber;
    }

    private void validate(PrizeNumber prizeNumber) {
        if (prizeNumber.getNumbers().size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
