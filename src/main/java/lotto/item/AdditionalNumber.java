package lotto.item;

public class AdditionalNumber {
    private final int number;

    public AdditionalNumber(String additionalMoneyforValid) {
        validation(additionalMoneyforValid);
        this.number = Integer.parseInt(additionalMoneyforValid);
    }

    public int getNumber() {
        return number;
    }

    private void validation(String additionalMoneyforValid) {
        try{
            Integer.parseInt(additionalMoneyforValid);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        if (!((Integer.parseInt(additionalMoneyforValid) >= 1) &&
                (Integer.parseInt(additionalMoneyforValid) <= 45))) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }
    }
}
