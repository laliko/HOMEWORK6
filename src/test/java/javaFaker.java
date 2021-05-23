import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class javaFaker {
    Faker faker = new Faker();
    @Test
    public void test() {
        System.out.println(faker.number().digits(11));
    }
}
