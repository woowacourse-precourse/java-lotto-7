package lotto;

public class Customer {
    public int lottoCount;
    public int budget;

    public Customer(String budget) {
        calculateLottoCount(budget); // 생성자에서 static 변수에 값 할당
    }

    private void calculateLottoCount(String budget) {
        int totalBudget = 0;
        try {
            totalBudget = Integer.parseInt(budget);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR");
        }
        // 입력하는 값이 숫자인지도 검증해야됨
        if (totalBudget % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 입력하는 돈이 1000으로 나누어 떨어져야합니다.");
        }
        lottoCount = totalBudget / 1000;
        this.budget = totalBudget;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getMoney() {
        return budget;
    }

}
