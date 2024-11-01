package lotto.policy;

public class BasicPolicy implements LottoPolicy{
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_COMPOSITION_SCALE = 6;
    private static final long FIRST_PRIZE = 2000000000L;


    @Override
    public int minimumNumber() {
        return MINIMUM_LOTTO_NUMBER;
    }

    @Override
    public int maximumNumber() {
        return MAXIMUM_LOTTO_NUMBER;
    }

    @Override
    public int lottoCompositionScale() {
        return LOTTO_COMPOSITION_SCALE;
    }

    @Override
    public long firstPrizeMoney(){
        return FIRST_PRIZE;
    }

    @Override
    public long SecondPrizeMoney() {
        return 0;
    }

    @Override
    public long thirdPrizeMoney() {
        return 0;
    }

    @Override
    public long fourthPrizeMoney() {
        return 0;
    }

    @Override
    public long fifthPrizeMoney() {
        return 0;
    }
}
