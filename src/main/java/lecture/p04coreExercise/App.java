package lecture.p04coreExercise;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	public static void main(String[] args) {
		
		String contextFilePath = "/lecture/p04coreExercise/context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(contextFilePath);
		
		Computer c = context.getBean(Computer.class);
//		Memory m = context.getBean(Memory.class);
		Memory m = (Memory)context.getBean("memory");
		
		log.warn(c);
		log.warn(m);
		
		log.warn(c.getMemory());
		
	}
}
