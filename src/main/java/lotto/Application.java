package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<Lotto> purchasedLottoList = new ArrayList<>();
    LottoQuickPick lottoQuickPick = new LottoQuickPick();

    purchasedLottoList = lottoQuickPick.quickPick();
  }
}