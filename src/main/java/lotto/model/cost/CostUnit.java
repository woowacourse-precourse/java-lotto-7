package lotto.model.cost;

public enum CostUnit {

    COST_UNIT(1000);

    private final int unit;

    CostUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
