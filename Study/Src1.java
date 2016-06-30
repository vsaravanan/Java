

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

aaddd

VPRB259-MarketingGroup.hbm.xml


