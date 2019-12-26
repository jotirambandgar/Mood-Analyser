import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer();
        String message = analyser.analyse("I am sad right now");
        Assert.assertEquals("Sad",message);

    }

    @Test
    public void whenGivenHappy_shouldRetunHappy() {

        MoodAnalyzer analyser = new MoodAnalyzer();
        String message = analyser.analyse("i am happy right now");
        Assert.assertEquals("Happy",message);

    }

    @Test
    public void whenGivenSadMessageWithAlphbetCapital_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer();
        String message = analyser.analyse("i am Sad right now");
        Assert.assertEquals("Sad",message);

    }

    @Test
    public void whenGivenMessageIsNull_shouldHandelException() {
        try {

            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalyzerException.class);
            MoodAnalyzer analyser = new MoodAnalyzer();
            String message = analyser.analyse(null);
            Assert.assertEquals("Invalid", message);
        }
        catch (MoodAnalyzerException exception){
            exception.printStackTrace();
        }
    }

    @Test
    public void whenGivenMessageIsNull_sholdThrowException() {
        try{
            MoodAnalyzer analyser = new MoodAnalyzer();
            String message = analyser.analyse(null);
        }
        catch (Exception e) {
            Assert.assertEquals("please enter proper message",e.getMessage());
        }

    }
}
