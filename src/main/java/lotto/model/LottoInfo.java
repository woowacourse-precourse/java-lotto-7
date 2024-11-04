package lotto.model;

public record LottoInfo(
    int[] winningNum,
    int bonusNum
) {
    public static LottoInfo map(
        String winningNumInput,
        String bonusNumInput
    ) {
        return new LottoInfo(
            winningNum,
            bonusNum
        );
    }
}
