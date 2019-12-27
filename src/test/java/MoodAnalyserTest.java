import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer("I am sad right now");
        String message = analyser.analyse();
        Assert.assertEquals("Sad",message);

    }

    @Test
    public void whenGivenHappy_shouldRetunHappy() {

        MoodAnalyzer analyser = new MoodAnalyzer("i am happy right now");
        String message = analyser.analyse();
        Assert.assertEquals("Happy",message);

    }

    @Test
    public void whenGivenSadMessageWithAlphbetCapital_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer("i am Sad right now");
        String message = analyser.analyse();
        Assert.assertEquals("Sad",message);

    }

    @Test
    public void whenGivenMessageIsNull_shouldHandelException() {
        try {

            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalyzerException.class);
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
           // Assert.assertEquals("Invalid", message);
        }

        catch (MoodAnalyzerException exception){
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL_EXCEPTION, exception.type);
        }
    }

    @Test
    public void whenGivenMessageIsNull_sholdThrowException() {
        try{
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
        }
        catch (Exception e) {

            Assert.assertEquals("please enter proper message",e.getMessage());
        }

    }

    @Test
    public void whenGivenMessageIsNull_shouldGiveNullExceptionType() {
        try{
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
        }
        catch (Exception e) {

            Assert.assertEquals("please enter proper message",e.getMessage());
        }
    }

//    @Test
//    public void when() {
//    }
}
