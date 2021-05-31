import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private List<Time> createList (Time ... elems){
        return new ArrayList<Time>(Arrays.asList(elems));
    }
    private List <Integer> createSeconds(Integer ... elems){
        return new ArrayList<Integer>(Arrays.asList(elems));
    }

    @Test
    void everyBranchTest() {
        // 1 - 2.1 - 2.2 - 3 - 4 -5 - 6 - 19
        RuntimeException ex;
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-1,1,1))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        // 1 - 2.1 - 2.2 - 3 - 4 -7 -19
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(26,1,1))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        // 1 - 2.1 - 2.2 - 3 - 4 -8 - 9 - 10 - 19
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(15,-1,1))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        //1 - 2.1 - 2.2 - 3 - 4 -8 - 9 - 11 - 13 - 19
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(15,40,60))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //1 - 2.1 - 2.2 - 3 - 4 -8 - 9 - 11 - 12 - 17 - 2.3
        assertEquals(createSeconds(56403), SILab2.function(createList(new Time(15,40,3))));

        // 1 - 2.1 - 2.2 - 3 - 4 -8 - 14 - 15 - 17 - 2.3
        assertEquals(createSeconds(86400), SILab2.function(createList(new Time(24,0,0))));

        // 1 - 2.1 - 2.2 - 3 - 4 -8 - 14 - 16 - 19
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24,1,1))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
        //normal
        //assertEquals(createSeconds(43932), SILab2.function(createList(new Time(12,12,12))));

    }


    @Test
    void MultipleConditionTest(){
        // if(hr<0 || hr>24)
        // T || X
        RuntimeException ex;
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-1, 2 ,2))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        // F || T
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(26,33,11))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        // F || F
        assertEquals(createSeconds(43932), SILab2.function(createList(new Time(12,12,12))));
        // if (min < 0 || min > 59)
        // T || X
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,-1,22))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        // F || T
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,60,22))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        // F || F
        assertEquals(createSeconds(43932), SILab2.function(createList(new Time(12,12,12))));

        // if (sec >= 0 && sec <= 59)
        // T && T
        assertEquals(createSeconds(43932), SILab2.function(createList(new Time(12,12,12))));
        // T && F
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,22,62))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        // F && X
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,22,-2))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //if (hr == 24 && min == 0 && sec == 0)
        // T && T && T
        assertEquals(createSeconds(86400), SILab2.function(createList(new Time(24,0,0))));
        // T && T && F
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24,0,5))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        // T  && F && X
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24,12,5))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        // F && X && X - infeasible
    }
}