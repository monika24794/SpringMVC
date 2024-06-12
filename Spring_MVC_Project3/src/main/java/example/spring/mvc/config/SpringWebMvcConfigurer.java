package example.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc //enabling callback mechanism support
public class SpringWebMvcConfigurer  implements WebMvcConfigurer{
@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolverRef =
				new InternalResourceViewResolver();
		String Prefix="/WEB-INF/pages/";
		String suffix=".jsp";
		viewResolverRef.setPrefix(Prefix);
		viewResolverRef.setSuffix(suffix);
		
		return viewResolverRef;
	}
}
