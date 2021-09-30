import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 19:24
 */
//声明此注解才能拿到ioc容器
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//Spring和SpringMVC的配置文件都要加载
@ContextConfiguration(value ={"classpath:applicationContext.xml","classpath:springmvc-config.xml"} )
public class springmvc_test {

    //传入Springmvc的ioc
    @Autowired
    private WebApplicationContext context;
    // 虚拟mvc请求，获取到处理结果。
    private MockMvc mockMvc;
    //在测试方法执行前执行，对mockMvc初始化
    @Before
    public void init(){
        //建立一个虚拟请求
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void test() throws Exception {
        //模拟请求拿到返回值
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test").param("pn", "2")).andReturn();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Ip")).andReturn();
        //获取请求域
        MockHttpServletResponse response = mvcResult.getResponse();
        System.out.println(response.getContentAsString());

    }
}

