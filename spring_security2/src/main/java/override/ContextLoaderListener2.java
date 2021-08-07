package override;

import org.springframework.web.context.ContextLoaderListener;

public class ContextLoaderListener2 extends ContextLoaderListener {
	public ContextLoaderListener2() {
		super();
		System.out.println("----- ContextLoaderListener2 create");
	}
}
