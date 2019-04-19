import com.strawman.cloud.EurekaFeginApplication;
import com.strawman.cloud.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TestJunit
 * @Author tao
 * @Date 2019/4/19 13:24
 * @Version 1.0
 */
//@SpringBootTest(classes = EurekaFeginApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestJunit {

    @Autowired
    private TestService t;

    @Test
    public void test(){
        System.out.println(" ぺぺ strawman ぺぺ 打印 ："+t.info());
    }

}
