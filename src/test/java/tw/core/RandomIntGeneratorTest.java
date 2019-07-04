package tw.core;


import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void init(){
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void testGenerateNumsMethod(){
        String generateNums = randomIntGenerator.generateNums(9, 4);
        Assert.assertThat(generateNums.length(), Is.is(7));
    }
}