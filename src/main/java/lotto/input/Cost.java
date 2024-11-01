package lotto.input;

public class Cost implements Input {

    private int cost;

    @Override
    public void validate(String input) {
        cost = Integer.parseInt(input);
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 가능한 금액은 1,000원으로 나누어 떨어져야합니다.");
        }
    }

    public int getCost() {
        return cost;
    }
}
