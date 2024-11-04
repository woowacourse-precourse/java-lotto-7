package lotto.model;


import java.math.BigInteger;


public class LottoBuy {
   private final BigInteger amount;


   public LottoBuy(BigInteger amount) {
       validate(amount);
       this.amount = amount;
   }


   private void validate(BigInteger amount) {
       if (amount.compareTo(BigInteger.ZERO) <= 0 || !amount.mod(BigInteger.valueOf(1000)).equals(BigInteger.ZERO)) {
           throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
       }
   }


   public BigInteger getNumberOfLottos() {
       return amount.divide(BigInteger.valueOf(1000));
   }
}
