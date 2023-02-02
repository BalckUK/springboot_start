package board.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.board.filter.encondingFilter;
import board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	private static final String[] INCLUDE_PATHS = { "/*" };

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}

	@Bean
	public FilterRegistrationBean filterBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new encondingFilter());
		CharacterEncodingFilter characterencodingFilter = new CharacterEncodingFilter();
		characterencodingFilter.setForceEncoding(true);
		characterencodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterencodingFilter);
		registrationBean.setOrder(Integer.MIN_VALUE);
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

}
