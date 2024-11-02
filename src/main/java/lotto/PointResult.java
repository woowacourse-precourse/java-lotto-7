package lotto;

public class PointResult {

    private final int point;
    private final int bonusPoint;

    public PointResult(int point, int bonusPoint) {
        this.point = point;
        this.bonusPoint = bonusPoint;
    }


    public Integer getPoint() {
        return point;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }
}
