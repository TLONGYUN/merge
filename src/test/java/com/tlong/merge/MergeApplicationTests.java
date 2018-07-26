package com.tlong.merge;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tlong.merge.domain.primary.TlongOrg;
import com.tlong.merge.domain.primary.TlongUser;
import com.tlong.merge.domain.secondary.LongshiOrg;
import com.tlong.merge.domain.secondary.ZjxxJpPeople;
import com.tlong.merge.domain.secondary.ZjxxPeople;
import com.tlong.merge.repository.primary.TlongOrgRepository;
import com.tlong.merge.repository.primary.UserTest1Repository;
import com.tlong.merge.repository.secondary.LongshiOrgRepository;
import com.tlong.merge.repository.secondary.ZjxxJpManagerRepository;
import com.tlong.merge.repository.secondary.ZjxxJpPeopleRepository;
import com.tlong.merge.repository.secondary.ZjxxPeopleRepository;
import com.tlong.merge.utils.ToListUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static com.tlong.merge.domain.secondary.QZjxxJpPeople.zjxxJpPeople;
import static com.tlong.merge.domain.secondary.QZjxxPeople.zjxxPeople;
import static com.tlong.merge.domain.secondary.QLongshiOrg.longshiOrg;
import static com.tlong.merge.domain.secondary.QZjxxJpManager.zjxxJpManager;

import static com.tlong.merge.domain.primary.QTlongUser.tlongUser;
import static com.tlong.merge.domain.primary.QTlongOrg.tlongOrg;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MergeApplicationTests {

	final Logger logger = LoggerFactory.getLogger(MergeApplicationTests.class);

	@Resource
	private UserTest1Repository userTest1Repository;
	@Resource
	private ZjxxPeopleRepository zjxxPeopleRepository;
	@Resource
	private LongshiOrgRepository longshiOrgRepository;
	@Resource
	private TlongOrgRepository tlongOrgRepository;
	@Resource
	private ZjxxJpPeopleRepository zjxxJpPeopleRepository;

	@Resource
	private ZjxxJpManagerRepository zjxxJpManagerRepository;

	@Qualifier("entityManagerSecondary")
	@Resource
	private EntityManager entityManagerSecondary;

	@Qualifier("entityManagerPrimary")
	@Resource
	private EntityManager entityManagerPrimary;

	private JPAQueryFactory primaryQueryFactory;
	private JPAQueryFactory SecondaryQueryFactory;

	@PostConstruct
	public void init() {
		primaryQueryFactory = new JPAQueryFactory(entityManagerPrimary);
		SecondaryQueryFactory = new JPAQueryFactory(entityManagerSecondary);
	}

	@Test
	public void contextLoads() {
		List<Integer> list = new ArrayList<>(4);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//直接从集合中获取并行流，然后执行缩减操作，下面的代码输出24
		System.out.println(list.stream().reduce(10, (a, b) -> a - b));
	}

	/**
	 * 	**********所有方法需要在这里记录*************
	 * 	  方法名称		执行状态  	  执行目的
	 * testFindALL    执行通过完成   测试查询所有的数据
	 */



	@Test
	public void testFindAll(){
//		List<com.tlong.merge.domain.primary.TlongUser> all = userTest1Repository.findAll();
//		logger.warn("新版本tlong_user数据库一共有" + all.size() + "条数据");

		List<ZjxxPeople> all1 = zjxxPeopleRepository.findAll();
		logger.warn("老版本数据库zjxx_people一共有" + all1.size() + "条数据");

		List<ZjxxJpPeople> all2 = zjxxJpPeopleRepository.findAll();
		logger.warn("老版本数据库zjxx_jp_people一共有" + all2.size() + "条数据");

		List<ZjxxJpPeople> fetch1 = SecondaryQueryFactory.select(zjxxJpPeople).from(zjxxJpPeople).fetch();

//		List<TlongUser> fetch2 = primaryQueryFactory.select(tlongUser).from(tlongUser).fetch();
		logger.warn(fetch1.size()+".............................................");
//		logger.warn(fetch2.size()+".............................................");

//		List<Tuple> fetch = SecondaryQueryFactory.select(zjxxPeople, zjxxJpPeople.password)
//				.from(zjxxPeople,zjxxJpPeople)
//				.where(zjxxPeople.title.eq(zjxxJpPeople.title))
//				.fetch();
//		fetch.stream().forEach(one ->{
//			one.get(zjxxJpPeople.password);
//			logger.warn(one.get(zjxxJpPeople.password));
//		});


	}

	@Test
	public void testFIndAllOrg(){
        Iterable<LongshiOrg> longshiOrgs = longshiOrgRepository.findAll(longshiOrg.isdelete.eq(0));
        List<LongshiOrg> all = ToListUtil.IterableToList(longshiOrgs);

        all.stream().forEach(one ->{

			TlongOrg tlongOrg = new TlongOrg();

			if (one.getParentOrg() == null) {
				//父级都为天珑 所以统一设置为1   目前只有这两级所以这么迁移
				tlongOrg.setParentOrgId(null);
				tlongOrg.setOrgLevel(0); //省级
			}else {
				tlongOrg.setOrgLevel(1); //市级
			}

			tlongOrg.setOrgName(one.getTitle());
			tlongOrg.setOrgAddress(one.getOrgAddress());
			tlongOrg.setOrgEmail(one.getOrgEmail());
			tlongOrg.setOrgPhone(one.getOrgPhone());
			tlongOrg.setCreateDate(one.getCreateDate());
			tlongOrg.setLegalOrg(one.getLegalOrg());
			tlongOrg.setOrgSize(one.getOrgSize());
			tlongOrg.setCurState(0);
			tlongOrg.setIsDeleted(0);
			tlongOrgRepository.save(tlongOrg);
		});
		//下面要修正parentID
		all.stream().forEach(one ->{
			if (one.getParentOrg() != null){
				logger.info("该组织父级组织id为" + one.getParentOrg());
                logger.info("新数据库中该机构名称为" + one.getTitle());
                //找到老数据库中改机构数据
                LongshiOrg one1 = longshiOrgRepository.findOne(longshiOrg.id.eq(one.getParentOrg())
                    .and(longshiOrg.isdelete.eq(0)));
                //获取新数据库中老数据库对应的父org的id
                TlongOrg one2 = tlongOrgRepository.findOne(tlongOrg.orgName.eq(one1.getTitle())
                    .and(tlongOrg.isDeleted.ne(1)));
                logger.info("新数据库中机构" + one.getTitle() + "的父级机构的id在新数据库中是" + one2.getId());
                //获取新数据库中对应此条老数据的机构数据
                TlongOrg one3 = tlongOrgRepository.findOne(tlongOrg.orgName.eq(one.getTitle())
                    .and(tlongOrg.isDeleted.ne(1)));
                one3.setParentOrgId(one2.getId());
                tlongOrgRepository.save(one3);
            }
		});
		logger.warn("本次数据转移一共处理了" + all.size() + "条数据");
	}



	@Test
    public void findAllUser(){
    }

    /**
     * 关于天珑
     */
    @Test
    public void findAllAbout(){

    }

}
