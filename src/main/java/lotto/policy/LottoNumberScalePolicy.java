package lotto.policy;

public enum LottoNumberScalePolicy {
    LOTTO_NUMBER_SCALE(6);

    private final int numberScale;
    LottoNumberScalePolicy(int numberScale) {
        this.numberScale = numberScale;
    }

    public int getNumberScale() {
        return numberScale;
    }
}
