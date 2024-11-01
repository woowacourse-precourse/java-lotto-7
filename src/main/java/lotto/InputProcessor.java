package lotto;

public class InputProcessor {
    private int tryCount;

    public InputProcessor() {
        this.tryCount = 0;
    }

    public void processPrice(String readLine) {
        try {
            Integer.parseInt(readLine);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자를 입력해주세요.");
        }
        int tmpPrice = Integer.parseInt(readLine.trim());
        validatePrice(tmpPrice);
        this.tryCount = tmpPrice / 1000;
    }

    private void validatePrice(int tmpPrice) {
        priceUnitValidate(tmpPrice);
        rangeValidate(tmpPrice);
    }


    private void rangeValidate(int param) {
        if (param < 0) {
            throw new IllegalArgumentException("[ERROR] 음수를 입력할 수 없습니다.");
        }
    }

    private void priceUnitValidate(int tmpPrice) {
        if (tmpPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액의 단위는 1000입니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
