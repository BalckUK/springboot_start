package board.board.filter;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class encondingFilter implements Filter{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		log.info("--필터 인스턴스 초기화--");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String requestURI = req.getRequestURI();
		
		log.info("--Request("+requestURI+") 시작필터--");
		chain.doFilter(request, response);
		log.info("--Response("+requestURI+") 종료필터--");
		
	}

	
	
	@Override
	public void destroy() {
		log.info("--필터 인스터스 종료--");
	}
	
}
