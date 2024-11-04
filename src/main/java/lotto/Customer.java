package lotto;

public class Customer {
    public int lottoCount;
    public int budget;

    public Customer(String budget) {
        calculateLottoCount(budget); // 생성자에서 static 변수에 값 할당
    }

    private void calculateLottoCount(String budget) {
        int totalBudget = Integer.parseInt(budget);
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
