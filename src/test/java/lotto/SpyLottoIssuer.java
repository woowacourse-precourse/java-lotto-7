package lotto;

public class SpyLottoIssuer extends LottoIssuer {

    private final Lotto[] lottos;

    public SpyLottoIssuer(Price price) {
        super(price);
        lottos = new Lotto[price.getValue()/1000];
    }

    @Override
    public Lotto[] getLottos() {
        return this.lottos;
    }

    public void setLottos(Lotto lotto, int idx) {
        this.lottos[idx] = lotto;
    }
}
