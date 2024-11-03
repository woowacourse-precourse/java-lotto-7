package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.util.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.constant.LottoConstants.*;

public class OutputView {


    public static void printEmptyLine(){
        System.out.println();
    }


    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }


}