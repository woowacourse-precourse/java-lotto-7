package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoNumberSelector {

    private final WinningNumber winningNumber;

    private final List<Lotto> purchasedLottos;

    public WinningLottoNumberSelector(final WinningNumber winningNumber,final List<Lotto> purchasedLottos){
        this.winningNumber = winningNumber;
        this.purchasedLottos = purchasedLottos;
    }


    public int matchNumber(final Lotto purchasedLotto){

        int correctNumber = 0;

        for(int i=0; i<purchasedLotto.getNumbers().size();i++){
            if(winningNumber.getWinningRegularLotto().getNumbers().contains(purchasedLotto.getNumbers().get(i))){
                correctNumber++;
            }
        }

        return correctNumber;
    }

    public boolean containSpecialNumber(final Lotto purchasedLotto){

        return purchasedLotto.getNumbers()
                .stream()
                .anyMatch(i->i== getSpecialNumber().getSpecialNumber());

    }

    public List<Lotto> getPurchasedLottos(){
        return Collections.unmodifiableList(purchasedLottos);
    }

    public SpecialNumber getSpecialNumber(){
        return winningNumber.getSpecialNumber();
    }

}
