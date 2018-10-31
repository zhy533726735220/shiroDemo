import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import javax.jnlp.ServiceManager;

public class TestLoginDemo {
    public static void main(String[] args) {

        // 取得Factory接口对象，主要的目的四通过配置文件加载文件中的信息，这些信息暂时不能成为认证信息
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro5.ini");
        // 取得里面所保存的所有的认证信息
        SecurityManager serviceManager = factory.getInstance();
        // 利用一个专门的认证操作的处理类，实现认证处理的具体实现
        SecurityUtils.setSecurityManager(serviceManager);
        // 获取进行用户名和密码认证的接口对象
        Subject subject = SecurityUtils.getSubject();

        // 这里的账号：admin和密码hello，是从网页传过来的
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "hello");
        // 实现用户登录处理
        subject.login(token);
        // 取得用户名
        System.out.println(subject.getPrincipal());
        // 检测角色
        subject.checkRole("dept");
        // 检查权限
        subject.checkPermission("member:add");
    }
}
