package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputHandler implements AutoCloseable {
    public String readline(){
        try{
            return Console.readLine();
        } catch(NoSuchElementException|IllegalStateException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        Console.close();
    }
}
