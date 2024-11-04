package lotto.util;

public class ProfitCalculator {

  public static double calculateProfitRate(int investment, int earnings) {
    if (investment == 0) {
      return 0.0;
    }
    return ((double) earnings / investment) * 100;
  }

}
