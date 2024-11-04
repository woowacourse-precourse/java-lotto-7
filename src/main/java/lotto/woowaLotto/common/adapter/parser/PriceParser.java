package lotto.woowaLotto.common.adapter.parser;

public class PriceParser{

    public int parse(String input) {
        validEmpty(input);
        try{
            int price = Integer.parseInt(input);
            validUnit(price);
            validRange(price);
            return price;
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 로또 구입 비용은 정수여야 합니다.");
            e.printStackTrace();
            return 0;
        }
    }

    private void validEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 비용은 비어있을 수 없습니다.");
        }
    }

    private void validRange(int price) {
        if(price <= 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 비용은 양수여야 합니다.");
        }
    }

    private void validUnit(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 비용은 1000원 단위여야 합니다.");
        }
    }
}
