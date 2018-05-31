package Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pyramid.entity.cache.CrawlerCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class TestWeb {

	@Resource(name = "crawlerCache")
	private CrawlerCache crawlerCache;

	/**
	 * 测试Spring注解获取properties文件的值
	 */
	@Test
	public void test01() {
		System.out.println("access_domains: " + crawlerCache.getAccessDomains());
	}

}
