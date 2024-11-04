package lotto.model;

public record LottoEntity(
    int[] lotto
) {
    public static LottoEntity map(
        int[] lotto
    ) {
        return new LottoEntity(
            lotto
        );
    }
}
