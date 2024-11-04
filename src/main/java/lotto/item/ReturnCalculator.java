package lotto.item;

public class ReturnCalculator {
    public ReturnCalculator() {}

    public Double getReturnRate(int spentMoney, int winningMoney) {
        double returnRate = ((double)winningMoney/(double)spentMoney)*100;
        returnRate = Math.round(returnRate*10)/10.0;  // 소수점 둘째 자리에서 반올림

        return returnRate;
    }

    public void printReturnRate(int spentMoney, int winningMoney) {
        System.out.println("총 수익률은 " + String.format("%.1f", getReturnRate(spentMoney, winningMoney)) + "%입니다.");
    }
}