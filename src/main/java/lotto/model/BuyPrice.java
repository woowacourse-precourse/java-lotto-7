package lotto.model;

/**
 * 구매금액을 가지고 있는다.
 * 구매 금액에 대한 유효성 검사를 가진다.
 */
public class BuyPrice {
    private Integer price;

    public BuyPrice(String inputPrice) {
        String trimPrice = inputPrice.replaceAll("\\s+", "");
        containStrValidation(trimPrice);
        devideThousandValidation(trimPrice);
        checkZeroTest(trimPrice);
        this.price = Integer.parseInt(trimPrice);
    }

    private void containStrValidation(String inputPrice) {
        if (!inputPrice.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력해주세요.");
        }
    }

    private void devideThousandValidation(String inputPrice) {
        Integer parsePrice = Integer.parseInt(inputPrice);
        if (parsePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잔돈이 없습니다. 1000원 단위에 맞춰 입력해주세요.");
        }
    }

    private void checkZeroTest(String inputPrice) {
        Integer parsePrice = Integer.parseInt(inputPrice);
        if (parsePrice == 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 내셔야 구매가 가능합니다.");
        }
    }

    private void biggerThanThousand(String inpuString) {
        Integer parsePrice = Integer.parseInt(inpuString);
        if (parsePrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 천원 이상을 입금해주셔야합니다~!");
        }
    }

    public Integer getPrice() {
        return price;
    }
}
