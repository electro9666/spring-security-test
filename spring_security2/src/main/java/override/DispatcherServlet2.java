package override;

import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherServlet2 extends DispatcherServlet {
	public DispatcherServlet2() {
		super();
		System.out.println("----- DispatcherServlet2");
	}
}
