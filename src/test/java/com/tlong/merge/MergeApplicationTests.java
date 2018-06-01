package com.tlong.merge;

import com.tlong.merge.domain.TlongUser;
import com.tlong.merge.repository.test1.UserTest1Repository;
import com.tlong.merge.repository.test2.UserTest2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MergeApplicationTests {

	final Logger logger = LoggerFactory.getLogger(MergeApplicationTests.class);

	@Resource
	private UserTest1Repository userTest1Repository;

	@Resource
	private UserTest2Repository userTest2Repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindAll(){
		List<TlongUser> all = userTest1Repository.findAll();
		logger.warn(all.size()+"$$$$$$$$$$$$$$$$$$");

		List<TlongUser> all1 = userTest2Repository.findAll();
		logger.warn(all1.size()+"$$$$$$$$$$$$$$$$$$");
	}

}
