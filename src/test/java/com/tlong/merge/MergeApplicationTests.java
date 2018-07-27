package com.tlong.merge;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tlong.merge.domain.primary.*;
import com.tlong.merge.domain.secondary.*;
import com.tlong.merge.repository.primary.*;
import com.tlong.merge.repository.secondary.*;
import com.tlong.merge.utils.ToListUtil;
import org.assertj.core.util.Strings;
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
import java.util.*;

import static com.tlong.merge.domain.secondary.QZjxxJpPeople.zjxxJpPeople;
import static com.tlong.merge.domain.secondary.QZjxxPeople.zjxxPeople;
import static com.tlong.merge.domain.secondary.QLongshiOrg.longshiOrg;
import static com.tlong.merge.domain.secondary.QZjxxJpManager.zjxxJpManager;
import static com.tlong.merge.domain.secondary.QZjxxAboutlongshi.zjxxAboutlongshi;
import static com.tlong.merge.domain.secondary.QZjxxCommodity.zjxxCommodity;
import static com.tlong.merge.domain.secondary.QZjxxCommoditytype.zjxxCommoditytype;

import static com.tlong.merge.domain.primary.QTlongUser.tlongUser;
import static com.tlong.merge.domain.primary.QTlongOrg.tlongOrg;
import static com.tlong.merge.domain.primary.QTlongAbout.tlongAbout;
import static com.tlong.merge.domain.primary.QTlongGoods.tlongGoods;
import static com.tlong.merge.domain.primary.QAppGoodsclass.appGoodsclass;



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
    @Resource
    private ZjxxAboutlongshiRepository zjxxAboutlongshiRepository;
    @Resource
    private TlongAboutRepository tlongAboutRepository;
    @Resource
    private ZjxxCommodityRepository zjxxCommodityRepository;
    @Resource
    private TlongGoodsRepository tlongGoodsRepository;
    @Resource
    private AppGoodsclassRepository appGoodsclassRepository;
    @Resource
    private ZjxxCommoditytypeRepository zjxxCommoditytypeRepository;
    @Resource
    private ZjxxLessonRepository zjxxLessonRepository;
    @Resource
    private CourseRepository courseRepository;
    @Resource
    private WebSlideshowRepository webSlideshowRepository;
    @Resource
    private ZjxxAdRepository zjxxAdRepository;
    @Resource
    private WebNewsRepository webNewsRepository;
    @Resource
    private ZjxxNewsRepository zjxxNewsRepository;
    @Resource
    private TsignCompanyRepository tsignCompanyRepository;
    @Resource
    private EsignCompanyRepository esignCompanyRepository;
    @Resource
    private TsignPersonRepository tsignPersonRepository;
    @Resource
    private EsignPersonRepository esignPersonRepository;
    @Resource
    private TsignHistoryRepository tsignHistoryRepository;
    @Resource
    private EsignRecordHistoryRepository esignRecordHistoryRepository;
    @Resource
    private ZjxxOrdersRepository zjxxOrdersRepository;
    @Resource
    private WebOrderRepository webOrderRepository;

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

        all.forEach(one ->{

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
		all.forEach(one ->{
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
//        zjxxCommoditytypeRepository.findAll()
    }

    /**
     * 关于天珑
     */
    @Test
    public void findAllAbout(){
        List<ZjxxAboutlongshi> all = zjxxAboutlongshiRepository.findAll();
        List<TlongAbout> newList = new ArrayList<>();
        all.forEach(one ->{
            TlongAbout tlongAbout = new TlongAbout();
            tlongAbout.setTitle(one.getTitle());
            tlongAbout.setContent(one.getAcontent());
            tlongAbout.setUserName(one.getAuthor());
            tlongAbout.setState(1);
            newList.add(tlongAbout);
        });
        tlongAboutRepository.save(newList);
    }

    /**
     * 商品分类
     */
    @Test
    public void findAllGoodsClass(){
        //先查出所有的商品一级分类
        Iterable<ZjxxCommoditytype> ZjxxCommoditytypes = zjxxCommoditytypeRepository.findAll(zjxxCommoditytype.pid.isNull()
        .or(zjxxCommoditytype.pid.isEmpty()));
        List<ZjxxCommoditytype> all = ToListUtil.IterableToList(ZjxxCommoditytypes);
        logger.info("当前一级分类共获取到:" + all.size() + "个.");

        //获取以及分类对应的二级分类
        List<String> ids = new ArrayList<>();
        all.forEach(one -> ids.add(one.getId()));
        Iterable<ZjxxCommoditytype> zjxxCommoditytypes = zjxxCommoditytypeRepository.findAll(zjxxCommoditytype.pid.in(ids));
        List<ZjxxCommoditytype> all1 = ToListUtil.IterableToList(zjxxCommoditytypes);

        Map<String,List<ZjxxCommoditytype>> map = new HashMap<>();
        all1.forEach(one ->{
            if (map.get(one.getPid()) == null){
                ArrayList<ZjxxCommoditytype> zjxxCommoditytypes1 = new ArrayList<>();
                zjxxCommoditytypes1.add(one);
                map.put(one.getPid(),zjxxCommoditytypes1);
            }else {
                List<ZjxxCommoditytype> zjxxCommoditytypes1 = map.get(one.getPid());
                zjxxCommoditytypes1.add(one);
            }
        });

        //map现在是包含了   一级分类为key   所包含二级分类集合为value
        //第一步存储一级分类id
        List<AppGoodsclass> firstGoodsClass = new ArrayList<>();
        all.forEach(one ->{
            AppGoodsclass appGoodsclass = new AppGoodsclass();
            appGoodsclass.setCurState(1);
            appGoodsclass.setIsDeleted(0);
            appGoodsclass.setGoodsClassLevel(1);
            appGoodsclass.setGoodsClassName(one.getTitle());
//            TODO 发布时间数据有问题
//            appGoodsclass.setPublishTime(one.getNewstime());
            firstGoodsClass.add(appGoodsclass);
        });
        appGoodsclassRepository.save(firstGoodsClass);

        //现在存储第二级别的商品分类
        List<AppGoodsclass> sencondGoodsClass = new ArrayList<>();

        map.forEach((key,value) -> value.forEach(one ->{
            AppGoodsclass appGoodsclass1 = new AppGoodsclass();
            appGoodsclass1.setCurState(1);
            appGoodsclass1.setIsDeleted(0);
            appGoodsclass1.setGoodsClassLevel(2);
//                TODO 发布时间有问题
//                appGoodsclass1.setPublishTime(one.getNewstime());
            appGoodsclass1.setGoodsClassName(one.getTitle());
            ZjxxCommoditytype one1 = zjxxCommoditytypeRepository.findOne(zjxxCommoditytype.id.eq(key));
            AppGoodsclass one2 = appGoodsclassRepository.findOne(appGoodsclass.goodsClassName.eq(one1.getTitle()));
            appGoodsclass1.setGoodsClassIdParent(one2.getId());
            sencondGoodsClass.add(appGoodsclass1);
        }));

        appGoodsclassRepository.save(sencondGoodsClass);

    }




    /**
     * 商品
     */
    @Test
    public void findAllGoods(){
        List<ZjxxCommodity> all = zjxxCommodityRepository.findAll();
        List<TlongGoods> newList = new ArrayList<>();
        all.forEach(one ->{
            TlongGoods tlongGoods = new TlongGoods();
            tlongGoods.setGoodsHead(one.getTitle());
            tlongGoods.setGoodsCode(one.getNumber());
//            //TODO 设置发布人ID需要去用户表查询该用户id然后赋值
////            tlongGoods.setPublishUserId(one.getCpeopleid());
//            //todo 设置商品分类需要去分类表查询分类id 现在的商品有的是只属于二级分类的
//            ZjxxCommoditytype one1;
//            AppGoodsclass one2;
//            logger.warn("@@@@@@@@@@@@@@@@@@@@@@@@" + one.getTitle());
//            if (!Strings.isNullOrEmpty(one.getCltype())){
//                logger.warn("clclclclclclclclclclc" + one.getCltype());
//                one1 = zjxxCommoditytypeRepository.findOne(one.getCltype());
//                ZjxxCommoditytype one3 = zjxxCommoditytypeRepository.findOne(one.getCtype());
//                if (one1 == null){
//                    logger.warn("问题" + one.getTitle());
//                }
//                AppGoodsclass one4 = appGoodsclassRepository.findOne(appGoodsclass.goodsClassName.eq(one3.getTitle())
//                    .and(appGoodsclass.goodsClassLevel.eq(1)));
//                if (one4 == null){
//                    logger.warn("ONE4 NULL+clclclclcl0 +" + one3.getTitle());
//                }else{
//                    logger.warn("@@@@@@@@@@############" + one4.getId());
//                }
//                one2 = appGoodsclassRepository.findOne(appGoodsclass.goodsClassName.eq(one1.getTitle())
//                    .and(appGoodsclass.goodsClassIdParent.eq(one4.getId())));
//            }else {
//                logger.warn("ctctctctctctctctctc" + one.getCtype());
//                one1 = zjxxCommoditytypeRepository.findOne(one.getCtype());
//                one2 = appGoodsclassRepository.findOne(appGoodsclass.goodsClassName.eq(one1.getTitle())
//                        .and(appGoodsclass.goodsClassIdParent.isNull()));
//            }
//            if (one2 == null){
//                logger.warn("这个商品有问题!!!!!!!!!!!!!!!!!!!!!"+ one.getTitle());
//            }
//            tlongGoods.setGoodsClassId(one2.getId());
            tlongGoods.setState(one.getChecked());
            tlongGoods.setDes(one.getIntroduction());
            tlongGoods.setDes(one.getInformation());
            tlongGoods.setStar(one.getStar());
            //TODO 真实星级 字符串还是用整形
//            tlongGoods.setRealStar(one.getStarreal());
            tlongGoods.setPublishClass(one.getUploadtype());
            tlongGoods.setVideo(one.getCvideo());
            tlongGoods.setCertificate(one.getCcertificate());
            tlongGoods.setGoodsPic(one.getCpicture());
            //TODO 图片类型是多个还是单个 数据类型用String还是Int
//            tlongGoods.setPicType(one.getPicturetype());
            //TODO 圈口大小 INT String
//            tlongGoods.setCircle(one.getRingsize());
            tlongGoods.setTheme(one.getTheme());
            tlongGoods.setStyle(one.getStyle());
            tlongGoods.setKindOfWater(one.getZhongshui());
            tlongGoods.setColor(one.getColor());
            tlongGoods.setFactoryPrice(Double.valueOf(one.getPrice4()));
            tlongGoods.setFounderPrice(Double.valueOf(one.getPrice1()));
            tlongGoods.setFlagshipPrice(Double.valueOf(one.getPrice2()));
            tlongGoods.setStorePrice(Double.valueOf(one.getPrice3()));
            tlongGoods.setPublishPrice(Double.valueOf(one.getPrice0()));
            tlongGoods.setPriceRange(one.getPricerang());
            tlongGoods.setNum(Integer.valueOf(one.getCount()));
            tlongGoods.setPriceType(Integer.valueOf(one.getPricetype()));
            tlongGoods.setWx(one.getServiceweixin());
            tlongGoods.setPhoneService(one.getServicephone());
            //TODO 发布时间老数据有问题看数据库
//            tlongGoods.setPublishTime(one.getNewstime());
            tlongGoods.setCurState(1);
            tlongGoods.setIsDeleted(0);
            newList.add(tlongGoods);
        });
        tlongGoodsRepository.save(newList);
    }


    @Test
    public void findAllClazz(){
        List<ZjxxLesson> all = zjxxLessonRepository.findAll();
        List<Course> newList = new ArrayList<>();
        all.forEach(one ->{
            Course course = new Course();
//            course.setStyleId(null);
            course.setTitle(one.getTitle());
//            TODO 课程目录跟center的数据类型不一样
//            course.setCatalog(one.getLessonindex());
            course.setTeacher(one.getLessonauthor());
            course.setDes(one.getLessoninfo());
            course.setVideo(one.getLessonvideo());
            course.setImg(one.getLessonpicture());
            course.setCurState(1);
//            TODO 发布时间格式不对
//            course.setPublishTime(one.getNewstime());
            newList.add(course);
        });
        courseRepository.save(newList);
    }


    /**
     * 轮播图
     */
    @Test
    public void findAllslideshow(){
        List<ZjxxAd> all = zjxxAdRepository.findAll();
        List<WebSlideshow> newList = new ArrayList<>();
        all.forEach(one ->{
            WebSlideshow webSlideshow = new WebSlideshow();
            webSlideshow.setContent(one.getAdcontent());
            webSlideshow.setCurState(1);
            webSlideshow.setIsDeleted(0);
            webSlideshow.setName(one.getUsername());
            webSlideshow.setPicUrl(one.getAdpicture());
            webSlideshow.setTitle(one.getTitle());
//            TODO 发布时间有问题
//            webSlideshow.setPublishTime(one.getNewstime());
            newList.add(webSlideshow);
        });
        webSlideshowRepository.save(newList);
    }

    /**
     * 新闻
     */
    @Test
    public void findAllNews(){
        List<ZjxxNews> all = zjxxNewsRepository.findAll();
        List<WebNews> newList = new ArrayList<>();
        all.forEach(one ->{
            WebNews webNews = new WebNews();
            webNews.setTitle(one.getTitle());
            webNews.setTitle(one.getNewsicon());
            webNews.setDes(one.getNcontent());
            webNews.setPic(one.getNpicture());
            webNews.setVideo(one.getNvideo());
            webNews.setPublishName(one.getUsername());
//            TODO 发布时间
//            webNews.setPublishTime(one.getNewstime());
            webNews.setIsCheck(one.getChecked());
            newList.add(webNews);
        });
        webNewsRepository.save(newList);
    }

    /**
     * E签宝公司
     */
    @Test
    public void findAllEsignCompany(){
        List<TsignCompany> all = tsignCompanyRepository.findAll();
        List<EsignCompany> newList = new ArrayList<>();
        all.forEach(one -> {
            EsignCompany esignCompany = new EsignCompany();
//            TODO 用户id
//            esignCompany.setUserId(one.getUserId());
            esignCompany.setCompanyName(one.getCompanyname());
            esignCompany.setCodeOrg(one.getCodeorg());
            esignCompany.setCodeUsc(one.getCodeusc());
            esignCompany.setLegalName(one.getLegalname());
            esignCompany.setLegalidNo(one.getLegalidno());
            esignCompany.setName(one.getName());
            esignCompany.setCardNo(one.getCardno());
            esignCompany.setSubbranch(one.getSubbranch());
            esignCompany.setBank(one.getBank());
            esignCompany.setProvice(one.getProvice());
            esignCompany.setCity(one.getCity());
            esignCompany.setServiceId(one.getServiceid());
            esignCompany.setTime(one.getTime());
            esignCompany.setTimePay(one.getTimePay());
//            老的表没有这个字段(单位类型：0-普通企业，1-社会团体，2-事业单位，3-民办非企业单位，4-党政及国家机构)
//            esignCompany.setOrganType();
            newList.add(esignCompany);
        });
        esignCompanyRepository.save(newList);
    }

    /**
     * E签宝个人
     */
    @Test
    public void findAllPerson(){
        List<TsignPerson> all = tsignPersonRepository.findAll();
        List<EsignPerson> newList = new ArrayList<>();
        all.forEach(one ->{
            EsignPerson esignPerson = new EsignPerson();
//            TODO 用户id 数据类型   需要查表
//            esignPerson.setUserId(one.getPeopleid());
            esignPerson.setRealName(one.getRealname());
            esignPerson.setIdCard(one.getIdcard());
            esignPerson.setBank(one.getBank());
            esignPerson.setPhone(one.getPhone());
            esignPerson.setServiceId(one.getServiceid());
            esignPerson.setTime(one.getTime());
            newList.add(esignPerson);
        });
        esignPersonRepository.save(newList);
    }

    /**
     * E签宝历史表
     */
    @Test
    public void findAllHistory(){
        List<TsignHistory> all = tsignHistoryRepository.findAll();
        List<EsignRecordHistory> newList = new ArrayList<>();
        all.forEach(one ->{
            EsignRecordHistory esignRecordHistory = new EsignRecordHistory();
            esignRecordHistory.setApi(one.getApi());
            esignRecordHistory.setReqData(one.getRequest());
            esignRecordHistory.setResData(one.getResponse());
            esignRecordHistory.setReqTime(one.getReqtime());
            esignRecordHistory.setResTime(one.getRestime());
            newList.add(esignRecordHistory);
        });
        esignRecordHistoryRepository.save(newList);

    }

    /**
     * 订单
     */
    @Test
    public void findAllOrder(){
        List<ZjxxOrders> all = zjxxOrdersRepository.findAll();
        List<WebOrder> newList = new ArrayList<>();
        all.forEach(one ->{
            WebOrder webOrder = new WebOrder();
//            TODO 商品id
//            webOrder.setGoodsId(one.getCommodityid());
//            TODO 下单时间
//            webOrder.setPlaceOrderTime(one.getNewstime());
            webOrder.setState(one.getOrdersstate());
//            TODO 用户id
//            webOrder.setUserId(one.getPeopleid());
            newList.add(webOrder);
        });
        webOrderRepository.save(newList);
    }

}
