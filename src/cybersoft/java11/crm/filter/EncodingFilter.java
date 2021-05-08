package cybersoft.java11.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
	private int requestSeq = 1;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// To: set charset encoding for request and response
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
//		System.out.printf("Access time: %d\n", requestSeq++);
		
//		System.out.println("Received request.");
		chain.doFilter(request, response);
//		System.out.println("Sent response.");
		
	}

}
