package override;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class DelegatingFilterProxy2 extends DelegatingFilterProxy {
	public DelegatingFilterProxy2() {
		super();
		System.out.println("----- DelegatingFilterProxy2");
	}

	public DelegatingFilterProxy2(Filter delegate) {
		super(delegate);
		System.out.println("----- DelegatingFilterProxy2 delegate");
	}

	public DelegatingFilterProxy2(String targetBeanName) {
		super(targetBeanName);
		System.out.println("----- DelegatingFilterProxy2 targetBeanName");
	}

	public DelegatingFilterProxy2(String targetBeanName, WebApplicationContext wac) {
		super(targetBeanName, wac);
		System.out.println("----- DelegatingFilterProxy2 targetBeanName wac");
	}
	
	public void initFilterBean() throws ServletException {
		super.initFilterBean();
		System.out.println("DelegatingFilterProxy2 initFilterBean");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		super.doFilter(request, response, filterChain);
		System.out.println("DelegatingFilterProxy2 doFilter");
		
		WebApplicationContext findWebApplicationContext = WebApplicationContextUtils.findWebApplicationContext(getServletContext());
		System.out.println("findWebApplicationContext: " + findWebApplicationContext);
		XmlWebApplicationContext xmlw = (XmlWebApplicationContext) findWebApplicationContext; 
		System.out.println("xmlw: " + xmlw);
		
		Collection<ApplicationListener<?>> applicationListeners = xmlw.getApplicationListeners();
		System.out.println("applicationListeners:" + applicationListeners);
	}
}
