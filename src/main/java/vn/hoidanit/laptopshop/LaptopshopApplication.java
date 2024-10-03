package vn.hoidanit.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// @SpringBootApplication
// khi để annotation như thế này, tự động config security
// nhờ annotation này cta sẽ chạy được dự án của chúng ta lên, sẽ khởi đụng lên SpringContext, SpringContainer, tất cả các bean sẽ nạp vào đây
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
// include(bao gồm) >< exclude(loại bỏ ra) => ở trong ngữ cảnh này, ta loại bỏ
// đi Spring Security

public class LaptopshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopshopApplication.class, args);

		ApplicationContext thebinh = SpringApplication.run(LaptopshopApplication.class, args);

		for (String s : thebinh.getBeanDefinitionNames()) {
			System.out.println(s);
		}

	}

}
