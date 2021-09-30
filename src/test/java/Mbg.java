import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/26 20:19
 */
public class Mbg {
    @Test
    public void test() throws Exception {
                List<String> warnings = new ArrayList<String>();
                boolean overwrite = true;
                //配置文件路径，其他不用动运行即可
                File configFile = new File("mbg.xml");
                ConfigurationParser cp = new ConfigurationParser(warnings);
                Configuration config = cp.parseConfiguration(configFile);
                DefaultShellCallback callback = new DefaultShellCallback(overwrite);
                MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
                myBatisGenerator.generate(null);
    }
}
