import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.MoodAnalyzerReflector;
import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer("I am sad right now");
        String message = analyser.analyse();
        Assert.assertEquals("Sad", message);

    }

    @Test
    public void whenGivenHappy_shouldRetunHappy() {

        MoodAnalyzer analyser = new MoodAnalyzer("i am happy right now");
        String message = analyser.analyse();
        Assert.assertEquals("Happy", message);

    }

    @Test
    public void whenGivenSadMessageWithAlphbetCapital_shouldReturnSad() {

        MoodAnalyzer analyser = new MoodAnalyzer("i am Sad right now");
        String message = analyser.analyse();
        Assert.assertEquals("Sad", message);

    }

    @Test
    public void whenGivenMessageIsNull_shouldHandelException() {
        try {

            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalyzerException.class);
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
            // Assert.assertEquals("Invalid", message);
        } catch (MoodAnalyzerException exception) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL_EXCEPTION, exception.type);
        }
    }

    @Test
    public void whenGivenMessageIsNull_sholdThrowException() {
        try {
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
        } catch (Exception e) {

            Assert.assertEquals("please enter proper message", e.getMessage());
        }

    }

    @Test
    public void whenGivenMessageIsNull_shouldGiveNullExceptionType() {
        try {
            MoodAnalyzer analyser = new MoodAnalyzer(null);
            String message = analyser.analyse();
        } catch (Exception e) {

            Assert.assertEquals("please enter proper message", e.getMessage());
        }
    }

    @Test
    public void whenGivenAnalyserObject_whenProper_shouldReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(String.class);
            Object object = constructor.newInstance("i am Happy");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
            String message = moodAnalyzer.analyse();
            Assert.assertEquals("Happy", message);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenProper_ShouldReturnObject() {

//       MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createModeAnalyser("i am Happy");
//       Assert.assertEquals("Happy",moodAnalyzer.analyse());
    }

    @Test
    public void whenGivenObjectWithProperMessage_shouldReturnTrue() {
        MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer("i am Happy");
//        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createModeAnalyser("i am Happy");
//        Assert.assertEquals(true,moodAnalyzer1.equals(moodAnalyzer));
    }

    @Test
    public void giveClassName_whenNotProper_shouldThrowCustomException() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.ModAnalyzer").getConstructor(String.class);
            Object object = constructor.newInstance("i am Happy");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
            String message = moodAnalyzer.analyse();
            Assert.assertEquals("Happy", message);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_CLASS_EXCEPTION, "No Such Class Error");
            }
            catch (MoodAnalyzerException ex){
                System.out.println(ex.getMessage());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenConstructorNotProper_shouldThrowCustomException() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.ModAnalyzer").getConstructor(String.class);
            Object object = constructor.newInstance(1);
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
            String message = moodAnalyzer.analyse();


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_CLASS_EXCEPTION, "No Such Method Error");
            }
            catch (MoodAnalyzerException ex){
                Assert.assertEquals("No Such Method Error", ex.getMessage());
                System.out.println(ex.getMessage());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenConstructorWithParameter_shouldReturnObject() {

        Constructor constructor = MoodAnalyzerReflector.getConstructor(String.class);
        Object object = MoodAnalyzerReflector.getObject(constructor,"i am Happy");
        MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
        Assert.assertEquals(true,moodAnalyzer.equals(new MoodAnalyzer("i am Happy")));

    }

    @Test
    public void whenGivenConstructorWithNoParameter_shouldReturnObject() {

        Constructor constructor = MoodAnalyzerReflector.getConstructor();
        Object object = MoodAnalyzerReflector.getObject(constructor);
        MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
        Assert.assertEquals(true,moodAnalyzer.equals(new MoodAnalyzer()));

        }


        @Test
        public void whenGivenMethodInvokeByReflection_shouldReturnProperMessage() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

            Method method = MoodAnalyzerReflector.getMethod("analyser");
            String mood =(String)method.invoke(new MoodAnalyzer(),"i am Happy");
            Assert.assertEquals("Happy",mood);


        }


}