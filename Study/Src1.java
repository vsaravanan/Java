
// FRE-AL

public class BlServiceDelegate {

	private BlServiceFacade blServiceFacade;


	public List<MarketingGroup> autoCompleteMarketingGroup(final Filter filter) throws GlobalException {
		return this.blServiceFacade.autoCompleteMarketingGroup(filter);
	}
	
	public List<MarketingGroup> filterMarketingGroup(final Filter filter) throws GlobalException {
		return this.blServiceFacade.filterMarketingGroup(filter);
	}

	public List<MarketingGroup> filterMarketingGroupData(final PaginedFilter filter) throws GlobalException {
		return this.blServiceFacade.filterMarketingGroupData(filter);
	}

}

// FRE-AL

public class AlServiceFacadeImpl implements AlServiceFacade {


	private BoServiceDelegate boServiceDelegate;

	@Override
	public List<MarketingGroup> autoCompleteMarketingGroup(
			final Map<String, String> parameters) throws GlobalException {

		String period = parameters.containsKey("period") ? parameters
				.get("period") : StringUtils.EMPTY;
		String marketingGroup = parameters.containsKey("marketingGroup") ? parameters
				.get("marketingGroup") : StringUtils.EMPTY;

		Filter filter = new Filter();

		if (StringUtils.isEmpty(period)) {
			return new ArrayList<MarketingGroup>();
		} else {
			filter.addValueFilter("marketingGroupPK.period",
					Integer.valueOf(period));

		}

		if (StringUtils.isNotEmpty(marketingGroup)
				&& !"All".equals(marketingGroup)) {
			filter.addValueFilter("marketingGroupPK.code", marketingGroup);
		}

		return this.serviceDelegate.autoCompleteMarketingGroup(filter);
	}
	


	@Override
	public List<MarketingGroup> filterMarketingGroup(
			final Map<String, String> parameters) throws GlobalException {

		String period = parameters.containsKey("period") ? parameters
				.get("period") : StringUtils.EMPTY;
		String business = parameters.containsKey("business") ? parameters
				.get("business") : StringUtils.EMPTY;
		String branch = parameters.containsKey("branch") ? parameters
				.get("branch") : StringUtils.EMPTY;
		String team = parameters.containsKey("team") ? parameters.get("team")
				: StringUtils.EMPTY;
		String privateBanker = parameters.containsKey("privateBanker") ? parameters
				.get("privateBanker") : StringUtils.EMPTY;
		String marketing = parameters.containsKey("marketing") ? parameters
				.get("marketing") : StringUtils.EMPTY;
		String market = parameters.containsKey("market") ? parameters
				.get("market") : StringUtils.EMPTY;
		String area = parameters.containsKey("area") ? parameters.get("area")
				: StringUtils.EMPTY;
		String marketingGroup = parameters.containsKey("marketingGroup") ? parameters
				.get("marketingGroup") : StringUtils.EMPTY;

		Filter filter = new Filter();

		if (StringUtils.isEmpty(period)) {
			return new ArrayList<MarketingGroup>();
		} else {
			filter.addValueFilter("marketingGroupPK.period",
					Integer.valueOf(period));

		}

		if (StringUtils.isNotEmpty(area) && !"All".equals(area)) {
			AreaPK primaryKey = this.buildAreaPK(period, area);
			filter.addValueFilter("clientDatas.area.areaPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(market) && !"All".equals(market)) {
			MarketPK primaryKey = this.buildMarketPK(period, market);
			filter.addValueFilter("clientDatas.market.marketPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(marketing) && !"All".equals(marketing)) {
			MarketingCountryPK primaryKey = this.buildMarketingPK(period,
					marketing);
			filter.addValueFilter(
					"clientDatas.marketingCountry.marketingCountryPK",
					primaryKey);
		}

		if (StringUtils.isNotEmpty(marketingGroup)
				&& !"All".equals(marketingGroup)) {
			MarketingGroupPK primaryKey = this.buildMarketingGroupPK(period,
					marketingGroup);
			filter.addValueFilter(
					"clientDatas.marketingGroup.marketingGroupPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(business) && !"All".equals(business)) {
			BusinessPK primaryKey = this.buildBusinessPK(period, business);
			filter.addValueFilter("clientDatas.business.businessPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(branch) && !"All".equals(branch)) {
			BranchPK primaryKey = this.buildBranchPK(period, branch);
			filter.addValueFilter("clientDatas.branch.branchPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(team) && !"All".equals(team)) {
			TeamPK primaryKey = this.buildTeamPK(period, team);
			filter.addValueFilter("clientDatas.team.teamPK", primaryKey);
		}

		if (StringUtils.isNotEmpty(privateBanker)
				&& !"All".equals(privateBanker)) {
			PrivateBankerPK privateBankerPK = this.buildPrivateBankerPK(period,
					privateBanker);
			filter.addValueFilter("clientDatas.privateBanker.privateBankerPK",
					privateBankerPK);
		}

		return this.serviceDelegate.filterMarketingGroup(filter);

	}


	@Override
	public List<MarketingGroup> filterMarketingGroupData(
			final PaginedFilter filter) throws GlobalException {
		return this.serviceDelegate.filterMarketingGroupData(filter);
	}

	
}


// FRE-BL - resources/hibernate/monthly
//VPRB259-MarketingGroup.hbm.xml

<hibernate-mapping schema="PRB">

	<class name="lu.bgl.fre.dto.MarketingGroup" table="TPRB259" entity-name="entity.marketing.group">

		<composite-id name="marketingGroupPK" class="lu.bgl.fre.dto.MarketingGroupPK">
			<key-property name="period" type="java.lang.Integer" column="NO_PER" />
			<key-property name="code" type="java.lang.String" column="NO_IDT_GRP_MRK" />
		</composite-id>
	</class>

</hibernate-mapping> 

// FRE-BL - resources/spring
//BL-applicationContext-BusinessObject.xml

<beans>
	<bean id="businessObjectDao" class="lu.bgl.fre.bl.dao.bo.BusinessObjectDaoImpl">
		<property name="businessObjectTemplate" ref="businessObjectTemplate"/>
		<property name="ressourceBundleUtils" ref="ressourceBundleUtils" />
		<property name="mappedKeys">
			<map key-type="java.lang.String" value-type="java.lang.String">
				<!--  From Business Object to entity -->
				<entry key="Groupe_Marketing" value="marketingGroup"/>
			</map>
		</property>
	</bean>
</beans>

// FRE-BL - resources/spring
//BL-applicationContext.xml

<beans>
	<import resource="BL-applicationContext-aop.xml" />
	<import resource="BL-applicationContext-BusinessObject.xml" />
	<import resource="BL-applicationContext-persistence.xml" />
	
	<context:property-placeholder location="classpath:**/*.properties" />	
		
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="distinct*" propagation="SUPPORTS" read-only="true"
				rollback-for="java.lang.Throwable" />		
			<tx:method name="get*" propagation="SUPPORTS" read-only="true"
				rollback-for="java.lang.Throwable" />
			<tx:method name="search*" propagation="SUPPORTS" read-only="true"
				rollback-for="java.lang.Throwable" />
			<tx:method name="save*" propagation="REQUIRED"
				rollback-for="java.lang.Throwable" />
			<tx:method name="update*" propagation="REQUIRED"
				rollback-for="java.lang.Throwable" />
			<tx:method name="delete*" propagation="REQUIRED"
				rollback-for="java.lang.Throwable" />
		</tx:attributes>
	</tx:advice>

	<bean id="passByReferenceDeepCopyHelper"
		class="com.fortis.rsa.commons.deepcopy.PassByReferenceDeepCopyHelper" />

	<rsa-integration:colocated id="blServiceFacade"
		interface="lu.bgl.fre.bl.facade.BlServiceFacade" 
		targetName="blServiceFacadeImpl"
		layerId="BLFacade" 
		logExecutionTime="false" 
		txAdvice="txAdvice" 
		deepCopyHelper="passByReferenceDeepCopyHelper" />	
		
	<bean id="ressourceBundleUtils" class="lu.bgl.commons.i18n.RessourceBundleUtils"/>

	<bean id="blServiceFacadeImpl" class="lu.bgl.fre.bl.facade.impl.BlServiceFacadeImpl">
		<property name="marketingGroupDao" ref="marketingGroupDao"/>
	</bean>
	

	<bean id="messageSource"
		class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basenames">
			<list merge="true">
				<value>i18n/bo-exceptions</value>
			</list>
		</property>
	</bean>

</beans>


// FRE-BL - hibernate


public abstract class GenericHibernateDao<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, ID> {

	if marketingGroupPK.code
	
}
	
	
// FRE-BL - model/ReportParameter

public class ReportParameter {

	public enum ExportType {
		PDF("pdf", "application/pdf"),
		XLS("xls", "application/vnd.ms-excel");
	}
		
	public String getMarketingGroup() {
		return this.marketingGroup;
	}		
	
}

// FRE-BL - dao

public interface MarketingGroupDao extends GenericDao<MarketingGroup, MarketingGroupPK> {

	public List<MarketingGroup> autoComplete(final Filter filter);

}


// FRE-BL - dao/hibernate

public class MarketingGroupHibernateDao extends
		GenericHibernateDao<MarketingGroup, MarketingGroupPK> implements
		MarketingGroupDao {

	public List<MarketingGroup> autoComplete(final Filter filter) {
	
		DetachedCriteria criteria = this.buildCriteria(DetachedCriteria.forEntityName(getActiveEntityName()),filter, true);

		criteria.setProjection(Projections.distinct(Projections.id()));
		List<MarketingGroupPK> ids = this.getHibernateTemplate()
				.findByCriteria(criteria, 0, 50);
		criteria.setProjection(null);

		criteria = DetachedCriteria.forEntityName(getActiveEntityName());
		.
		.
	
	}
}


// FRE-BL - facade/impl/
		
public class BlServiceFacadeImpl implements BlServiceFacade {

	private MarketingGroupDao marketingGroupDao;

	@Override
	public List<MarketingGroup> autoCompleteMarketingGroup(final Filter filter)
			throws GlobalException {
		return this.marketingGroupDao.autoComplete(filter);
	}
	
	@Override
	public List<MarketingGroup> filterMarketingGroup(final Filter filter)
			throws GlobalException {
		// Unique MarketingGroup
		return this.marketingGroupDao.distinct(filter);
	}
	@Override

	public List<MarketingGroup> filterMarketingGroupData(final PaginedFilter filter) throws GlobalException {
		Set<MarketingGroup> resultQuery = new TreeSet<MarketingGroup>(new Comparator<MarketingGroup>() {
			@Override
			public int compare(MarketingGroup o1, MarketingGroup o2) {
				return o1.getCodeBO().compareTo(o2.getCodeBO());
			}
		});
		

		resultQuery.addAll(this.marketingGroupDao.searchDistinct(filter));
		
		List<MarketingGroup> result = new ArrayList<MarketingGroup>(resultQuery);
		createDefaultMarkingGroup(result, filter);
		return result;		
	}		
}	
		
// FRE-BL - dto/	
MarketingGroup.java
MarketingGroupPK.java	

// FRE-PL

public class ClientSearchConverter extends AbstractConverter<SearchClientDataForm, PaginedFilter> {

	@Override
	protected PaginedFilter convert(SearchClientDataForm source) {
	
		PaginedFilter filter = new PaginedFilter(source.getPage(), source.getRows());
		filter.addValueFilter("marketingGroup", source.getMarketingGroup());
		return filter;
	}
	


}

// FRE-PL

public class MarketingSearchConverter extends AbstractConverter<SearchMarketingGroupDataForm, PaginedFilter> {

	@Override
	protected PaginedFilter convert(SearchMarketingGroupDataForm source) {
		
		PaginedFilter filter = new PaginedFilter(source.getPage(), source.getRows());
		filter.addValueFilter("marketingGroupPK.period", Integer.valueOf(source.getPeriod()));
		filter.addValueFilter("marketingGroupPK.code", source.getMarketingGroup());
		return filter;
	}
	

}

// FRE-PL

public abstract class ReportController{

	protected ExportType exportType;

	@Autowired
	private AlServiceDelegate alServiceDelegate;

	public ReportController() {
		setExportType();
	}
	
	@RequestMapping
	public ModelAndView handleRequest(final HttpServletRequest request, final HttpServletResponse response) throws Exception {

		ReportParameter parameter = new ReportParameter();

		parameter.setMarketingGroup(request.getParameter("marketingGroup"));

		byte[] content = this.alServiceDelegate.getContentReport(parameter);

		response.setContentType(this.exportType.getContentType());
		response.setHeader("Cache-Control", "public, must-revalidate");
		response.setCharacterEncoding("UTF-8");

		byte buffer[] = new byte[1024];

		OutputStream os = response.getOutputStream();
		InputStream inputStream = new ByteArrayInputStream(content);

		int readByte;

		while ((readByte = inputStream.read(buffer)) != -1) {
			os.write(buffer, 0, readByte);
		}

		os.flush();

		return null;
	}


}

