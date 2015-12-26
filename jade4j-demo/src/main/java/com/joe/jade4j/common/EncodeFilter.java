package com.joe.jade4j.common;

import java.io.IOException;
import javax.servlet.*;

public class EncodeFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		String encoding = config.getInitParameter("encoding");
		if (null != encoding && !"".equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}