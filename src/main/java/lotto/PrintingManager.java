package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrintingManager {
    public void printing_TwoDList(List<List<Integer>> twoDList_lotto){
        for (List<Integer> row : twoDList_lotto){
            System.out.println(row);
        }
    }
}
