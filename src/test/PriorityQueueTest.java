import java.util.PriorityQueue;
import java.util.stream.Stream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){

        return Stream.of(
                arguments(new int[]{3,8,2,4},new int[] {3,4,2,8}),
                arguments(new int[]{2,4,6,8},new int[] {8,4,6,2}),
                arguments(new int[]{7,2,1,3},new int[] {1,7,3,2}),
                arguments(new int[]{8,9,3,6},new int[] {9,3,6,8}),
                arguments(new int[]{4,2,8,5},new int[] {2,4,5,8})
        );
    }

    @ParameterizedTest(name="#{index} -Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int [] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int [] result = new int[random_array.length];
        for (int i =0 ; i<random_array.length;i++){
            test.add(random_array[i]);
        }

        for(int i =0 ; i< random_array.length;i++){
            result[i] = test.poll();

        }
        assertArrayEquals(correct_array,result);
    }


    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void OfferTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().forEach(null);
        });
    }
}
