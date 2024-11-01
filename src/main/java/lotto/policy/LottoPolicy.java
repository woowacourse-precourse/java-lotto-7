package lotto.policy;

public interface LottoPolicy {
    public int minimumNumber();
    public int maximumNumber();
    public int lottoCompositionScale();
    public long firstPrizeMoney();
    public long SecondPrizeMoney();
    public long thirdPrizeMoney();
    public long fourthPrizeMoney();
    public long fifthPrizeMoney();
}
