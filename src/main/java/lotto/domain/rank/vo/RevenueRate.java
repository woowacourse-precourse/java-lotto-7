package lotto.domain.rank.vo;

public record RevenueRate(float value) {
    public static RevenueRate of(int revenue, int expenses) {
        return new RevenueRate(((float) revenue / (float) expenses) * 100);
    }
}
