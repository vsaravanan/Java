import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProxyFactoryBeanExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "build/pfb.xml");
        
        MyBean bean1 = (MyBean)ctx.getBean("myBean1");
        MyBean bean2 = (MyBean)ctx.getBean("myBean2");
        
        System.out.println("Bean 1");
        bean1.execute();
        
        System.out.println("\nBean 2");
        bean2.execute();
    }
}