package board.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}

	@Bean
	public FilterRegistrationBean encondingfilterBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterencodingFilter = new CharacterEncodingFilter();
		characterencodingFilter.setForceEncoding(true);
		characterencodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterencodingFilter);
		return registrationBean;
	}

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
//		multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 파일당 업로드 크기 제한 (5MB)
//		return multipartResolver;
//	}

}
