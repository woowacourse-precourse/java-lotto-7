package lotto;

public class SpyLottoIssuer extends LottoIssuer {

    private final Lotto[] lottos;

    public SpyLottoIssuer(int price) {
        super(price);
        lottos = new Lotto[1];
    }

    @Override
    public Lotto[] getLottos() {
        return this.lottos;
    }

    public void setLottos(Lotto lotto) {
        this.lottos[0] = lotto;
    }
}
