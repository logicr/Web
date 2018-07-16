package club.logicr.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Jan on 2018/7/16.
 * @version 1.0
 */
@Component
public class MyDataSource {
//    @Value(value = "#{properties['url']}")
    @Value(value = "${url}")
    private  String url;
//    @Value(value = "#{properties['username']}")
    @Value(value = "${username}")
    private  String username;
//    @Value(value = "#{properties['password']}")
    @Value(value = "${password}")
    private  String password;
//    @Value(value = "#{properties['classname']}")
    @Value(value = "${classname}")
    private  String classname;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
