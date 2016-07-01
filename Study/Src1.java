// AL-applicationContext.xml

<beans>

	<import resource="AL-applicationContext-aop.xml" />

	<bean id="passByReferenceDeepCopyHelper"
		class="com.fortis.rsa.commons.deepcopy.PassByReferenceDeepCopyHelper" />

	<rsa-integration:colocated id="alServiceFacade"
		interface="lu.bgl.fre.al.facade.AlServiceFacade" 
		targetName="alServiceFacadeImpl"
		layerId="ALFacade" 
		logExecutionTime="false"
		deepCopyHelper="passByReferenceDeepCopyHelper" />	

	<bean id="serviceDelegate" class="lu.bgl.fre.al.delegate.BlServiceDelegate">
		<property name="blServiceFacade" ref="blServiceFacade" />
	</bean>
	
	<bean id="boServiceDelegate" class="lu.bgl.fre.al.delegate.BoServiceDelegate">
		<property name="boServiceFacade" ref="boServiceFacade"/>
	</bean>

	<bean id="alServiceFacadeImpl" class="lu.bgl.fre.al.facade.impl.AlServiceFacadeImpl">
		<property name="serviceDelegate" ref="serviceDelegate" />
		<property name="boServiceDelegate" ref="boServiceDelegate"/>
	</bean>

</beans>


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
al
	public List<MarketingGroup> autoComplete(final Filter filter);

}

// FRE-BL - hibernate

public class ClientDataHibernateDao extends
		GenericHibernateDao<ClientData, ClientDataPK> implements ClientDataDao 
{
	private Map<String, String>	valueMapMonth;

	public List<ClientData> search(final PaginedFilter filter)
			throws DataAccessException 
	{
			// generating sql dynamically
	}	
	
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


// FRE-PL controller/form

@RequestMapping("/bo/search/searchMarketingGroupData")
@Controller
public class SearchMarketingGroupDataFormController
{

	
	@Autowired
	@Qualifier(value="mapper")
	private ModelMapper modelMapper;
	
	@Autowired
	private AlServiceDelegate serviceDelegate;
	
	
	@RequestMapping
	protected @ResponseBody Map<String, Object> handler(HttpServletRequest request, HttpServletResponse response, SearchMarketingGroupDataForm command) throws Exception 
	{
		Map<String, Object> model = new HashMap<String, Object>();

		PaginedFilter filter = modelMapper.map(command, PaginedFilter.class);
		
		{

			
			if ("true".equals(command.getSearchClient())) {
				try {
					Map<String, String> parameters = new HashMap<String, String>();
					parameters.put("client", command.getClientData());
					parameters.put("period", command.getPeriod());
					command.setSearchClient(null);
					
					List<MarketingGroup> result = new ArrayList<MarketingGroup>();
					MarketingGroup mg = new MarketingGroup();
					MarketingGroupPK pk = new MarketingGroupPK();
					pk.setCode("All");
					mg.setMarketingGroupPK(pk);
					mg.setCodeBO("All");
					result.add(mg);
					List<String> mgs = this.serviceDelegate.getAllClusterForClientOnSearch(parameters);
					for (String c : mgs) {
						mg = new MarketingGroup();
						pk = new MarketingGroupPK();
						pk.setCode(c);
						mg.setMarketingGroupPK(pk);
						mg.setCodeBO(c);
						result.add(mg);
					}

					model.put("values", result);
					
					ResultInfo ri = new ResultInfo();
					ri.setPage(1);
					ri.setRecords(result.size());
					ri.setTotal(result.size());
					
					model.put("info", ri);
				} catch (JuridictionException e) {
					model.put("juridiction", "refuse");
				}
			} else {

				List<MarketingGroup> result = this.serviceDelegate.filterMarketingGroupData(filter);
				model.put("values", result);
				ResultInfo ri = filter.getResultInfo();
				if(ri == null){
					ri = new ResultInfo();
					ri.setPage(1);
					ri.setRecords(result.size());
					ri.setTotal(result.size());
				}
				model.put("info", ri);
			}
		}
		return  model;
	}
  
}

// FRE-PL controller

@Controller
@RequestMapping(value="/service/**")
public class JSONController{

	@Autowired
	private AlServiceDelegate serviceDelegate;
	
	@RequestMapping(value="/getAutoCompleteMarketingGroup")
	public @ResponseBody List<MarketingGroup> getAutoCompleteMarketingGroup(
			final HttpServletRequest request, final HttpServletResponse response)
			throws GlobalException 
	{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("period", request.getParameter("period"));
		parameters.put("marketingGroup", request.getParameter("marketingGroup"));

		return this.serviceDelegate.autoCompleteMarketingGroup(parameters);
	}
	
	public @ResponseBody List<MarketingGroup> getMarketingGroupList(final HttpServletRequest request,
			final HttpServletResponse response) throws GlobalException 
	{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("period", request.getParameter("period"));
		parameters.put("branch", request.getParameter("branch"));
		parameters.put("team", request.getParameter("team"));
		parameters.put("privateBanker", request.getParameter("privateBanker"));
		parameters.put("market", request.getParameter("market"));
		parameters.put("area", request.getParameter("area"));
		parameters.put("marketingCountry", request.getParameter("marketingCountry"));
		parameters.put("marketingGroup", request.getParameter("marketingGroup"));
		

		List<MarketingGroup> result = this.serviceDelegate.filterMarketingGroup(parameters);

		return result;
	}
	
	@RequestMapping(value="/getAllClusterForClientOnSearch")
	public @ResponseBody List<MarketingGroup> getAllClusterForClientOnSearch(
			final HttpServletRequest request, final HttpServletResponse response)
			throws GlobalException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("client", request.getParameter("client"));
		parameters.put("period", request.getParameter("period"));

		List<MarketingGroup> result = new ArrayList<MarketingGroup>();
		MarketingGroup mg = new MarketingGroup();
		MarketingGroupPK pk = new MarketingGroupPK();
		pk.setCode("All");
		mg.setMarketingGroupPK(pk);
		mg.setCodeBO("All");
		result.add(mg);
		List<String> mgs = this.serviceDelegate
				.getAllClusterForClientOnSearch(parameters);
		for (String c : mgs) {
			mg = new MarketingGroup();
			pk = new MarketingGroupPK();
			pk.setCode(c);
			mg.setMarketingGroupPK(pk);
			mg.setCodeBO(c);
			result.add(mg);
		}

		return result;
	}
	
	
}

// FRE-PL controller

@Controller
@RequestMapping(value="bo/report/save")
public class SaveReportController 
{

	@Autowired
	private AlServiceDelegate alServiceDelegate;

	@RequestMapping
	protected ModelAndView handleRequest(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		Map<String, String> filter = new HashMap<String, String>();

		filter.put("marketingGroup", request.getParameter("marketingGroup"));

		alServiceDelegate.saveReport(filter);

		return null;
	}

}

// FRE-PL delegate

public class AlServiceDelegate implements MessageSourceAware {


	private MessageSource messageSource;

	private AlServiceFacade alServiceFacade;

	public List<MarketingGroup> autoCompleteMarketingGroup(final Map<String, String> parameters) throws GlobalException {
		return this.alServiceFacade.autoCompleteMarketingGroup(parameters);
	}
	
	public List<MarketingGroup> filterMarketingGroup(final Map<String, String> parameters) throws GlobalException {
		return this.alServiceFacade.filterMarketingGroup(parameters);
	}

	public List<MarketingGroup> filterMarketingGroupData(final PaginedFilter filter) throws GlobalException {
		return this.alServiceFacade.filterMarketingGroupData(filter);
	}

}

// FRE-PL form - pojo

public class SearchClientDataForm extends JqGridForm {
	private String marketingGroup;
}


public class SearchMarketingGroupDataForm extends JqGridForm {
}


//searchGroupMarketing.jsp 
<form class="form"> 
	<div id="searchMarketingGroupAxis">
	<table>
		<tr>
			<td style="text-align: center;"><input  data-ng-model="marketingGroupNumbers" data-ng-keydown="searchMulti($event)"/><input type="hidden" id="searchSelectedMarketingGroup"/></td>
		</tr>
		<tr>
			<td style="text-align: center;"><span>Max results ( 50 )</span></td>
		</tr>		
	</table>
	</div>
</form>



//searchGroupMarketingDataForm.jsp 
	<div id="tooltipMarketingGroupAxis" class="tooltipImage"></div>
	
	<h3><spring:message code="query.form.marketingGroup.label"/></h3>
	
	<input id="helpMarketingGroupAxis" type="hidden" value="<spring:message code="help.marketing.group.axis"/>" />
	
  	<div class="gridContainer">
   		<div class="gridStyle" ng-grid="gridOptions"></div>
   		<div class="nbPages">Items: {{pagingOptions.totalServerItems}}, Pages : {{totalPages}}</div>
  	</div>
	
	<input id="marketingGroup" type="hidden" value="All" />
	
	
// view.xml
<tiles-definitions>

	<!--  Success views -->
	<definition name="defaultSuccess" extends="messageAjax" />
	
	<definition name="queryForm" extends="main">
		<put-attribute name="title" value="welcome.title" />
		<put-attribute name="body" value="/WEB-INF/dynamic/jsp/queryForm.jsp" />
	</definition>

	<definition name="periodForm" extends="dataAjax">
		<put-attribute name="ajaxData" value="/WEB-INF/dynamic/jsp/periodAxis.jsp" />
	</definition>

	<definition name="searchClientDataForm" extends="dataAjax">
		<put-attribute name="ajaxData" value="/WEB-INF/dynamic/jsp/searchClientDataForm.jsp"/>
	</definition>
	
	<definition name="searchMarketingGroupDataForm" extends="dataAjax">
		<put-attribute name="ajaxData" value="/WEB-INF/dynamic/jsp/searchMarketingGroupDataForm.jsp"/>
	</definition>
	

	<definition name="json" template="/WEB-INF/tiles/json/JSonLayout.jsp" />


</tiles-definitions>
	

// PL-applicationContext-JSON.xml

<beans>

	<context:property-placeholder location="classpath*:config/*.properties"/>
	
	<bean id="alServiceDelegate" class="lu.bgl.fre.pl.delegate.AlServiceDelegate">
		<property name="alServiceFacade" ref="alServiceFacade"/>
	</bean>
	
	<bean id="logInterceptor" class="lu.bgl.commons.pl.interceptor.LogInterceptor" />
	
	<bean id="modelPropertyEditorRegister" class="lu.bgl.fre.pl.editor.ModelPropertyEditorRegister">
		<property name="localDateEditor"  ref="localDateEditor"/>
		<property name="localTimeEditor" ref="localTimeEditor"/>
		<property name="longEditor" ref="longEditor"/>
		<property name="stringEditor" ref="stringEditor"/>
	</bean>	
	
	<!--  Editor -->
	
	<bean id="stringEditor" class="lu.bgl.fre.pl.editor.StringEditor"/>
	
	<bean id="localDateEditor" class="lu.bgl.fre.pl.editor.LocalDateEditor">
		<constructor-arg index="0"> 
			<value>dd-MM-yyyy</value>
		</constructor-arg>
	</bean>
	
	<bean id="localTimeEditor" class="lu.bgl.fre.pl.editor.LocalTimeEditor"/>
	
	<bean id="longEditor" class="lu.bgl.fre.pl.editor.LongEditor"/>	
	

</beans>	