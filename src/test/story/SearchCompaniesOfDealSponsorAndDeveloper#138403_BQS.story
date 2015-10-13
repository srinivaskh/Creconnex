Meta:
@storyType BQS

Narrative:
As a user
I verify companies of deal sponsor user who have selected "Deal Sponsor","Developer" are retrieved when deal sponsor search is performed.

Scenario: TC 138403: Verify companies of Deal Sponsor,Developer are displayed when search is performed
When I update TestCaseId 138403
When I update TestCaseName Perform: "Developer, Deal Sponsor >> Deal Sponsor, Developer" search Verify that companies of "Deal Sponsor", "Developer" sub role are retrieved.
When I launch RealConnex application
And I click on Log In button in RealConnex login page
And I enter user email ID
And I enter Password
And I click on login button
Then I should see 'Search' image
When I click on 'Search' button
And I click on 'Developers, Sponsors & GPs' link
And I select 'Developer','DealSponsor' link
And I click on 'View Search Results' button
Then I should see 'Developers, Sponsors & GPs' as find in search option
And I should see 'Developer, Deal Sponsor' as sub role in search option
When I select Companies option in filter by label
Then I should see 'Sterling' company name of deal sponsor
When I click on company name of deal sponsor
And I return back to the searched page
Then I verify 'Developer' company name is displayed
When I click on Developer company name
And I return back to the searched page
And I set value for average deal size
Then I verify 'Sterling' company is retrieved in the search result
And I verify company name of developer
When I clear value for average deal size
And I set value for year in business
Then I verify 'Sterling' company is retrieved in the search result
And I verify company name of developer
When I clear value for year in business
And I set value for number of professionals
Then I verify 'Sterling' company is retrieved in the search result
And I verify company name of developer
When I clear value for number of professionals
When I set value for sq ft developed
Then I verify 'Sterling' company is retrieved in the search result
And I verify company name of developer
When I clear value for sq ft developed
And I set value of deals completed
Then I verify 'Sterling' company is retrieved in the search result
And I verify company name of developer
When I clear value of deals completed
Then I should see 'Search' image
When I click on 'Search' button
And I click on 'Developers, Sponsors & GPs' link
And I select 'Developer','DealSponsor' link
And I click on 'View Search Results' button
And I select Companies option in filter by label
And I click on 'Route to Sponsor' drop down field
And I select direct only option in route to sponsor drop down list
And I select 'Placement Agents' option in the 'Route to Sponsor' field
Then I verify 'Steele' company selected 'Placement Agents' option is displayed in the search result
When I deselect 'Placement Agents' option in the 'Route to Sponsor' field
And I select 'Intermediary' option in the 'Route to Sponsor' field
Then I verify 'Sterling' company selected 'Placement Agents' option is displayed in the search result
And I verify 'Max N' company selected 'Placement Agents' option is displayed in the search result
When I deselect 'Placement Agents' option in the 'Route to Sponsor' field
And I select 'Brokers' option in the 'Route to Sponsor' field
Then I verify 'Sterling' company selected 'Brokers' option is displayed in the search result
And I verify 'Max N' company selected 'Brokers' option is displayed in the search result
When I deselect 'Brokers' option in the 'Route to Sponsor' field
And I select 'Placement Agents' option in the 'Route to Sponsor' field
Then I verify 'Sterling' company selected 'Placement Agents' option is displayed in the search result
And I verify 'Max N' company selected 'Placement Agents' option is displayed in the search result
When I deselect 'Placement Agents' option in the 'Route to Sponsor' field
And I select 'All' option in the 'Route to Sponsor' field
Then I verify 'Sterling' company selected 'All' option is displayed in the search result
And I verify 'Max N' company selected 'All' option is displayed in the search result
When I deselect 'All' option in the 'Route to Sponsor' field
And I click on asset experience field
And I select 'Office' option in the 'Asset Type' field
Then I verify 'Sterling' company selected 'Office' option is displayed in the search result
When I deselect 'All' option in the 'Asset Type' field
And I select 'Solar' option in the 'Asset Type' field
Then I verify 'Steele' company selected 'Solar' option is displayed in the search result
When I deselect 'Solar' option in the 'Asset Type' field
And I select 'Office' option in the 'Asset Experience' field
Then I verify 'Terain' company selected 'Office' option is displayed in the search result
And I verify 'Max N' company selected 'Office' option is displayed in the search result
When I deselect 'Office' option in the 'Asset Type' field
And I select 'Multi-family' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Multi-family' option is displayed in the search result
And I verify 'Max N' company selected 'Multi-family' option is displayed in the search result
When I deselect 'Multi-family' option in the 'Asset Type' field
And I select 'Hotel' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Hotel' option is displayed in the search result
And I verify 'Max N' company selected 'Hotel' option is displayed in the search result
When I deselect 'Hotel' option in the 'Asset Type' field
And I select 'Sports & Entertainment' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Sports & Entertainment' option is displayed in the search result
And I verify 'Max N' company selected 'Sports & Entertainment' option is displayed in the search result
When I deselect 'Sports & Entertainment' option in the 'Asset Type' field
And I select 'Health Care' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Health Care' option is displayed in the search result
And I verify 'Max N' company selected 'Health Care' option is displayed in the search result
When I deselect 'Health Care' option in the 'Asset Type' field
And I select 'Storage' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Storage' option is displayed in the search result
And I verify 'Max N' company selected 'Storage' option is displayed in the search result
When I deselect 'Storage' option in the 'Asset Type' field
And I select 'Other' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Other' option is displayed in the search result
And I verify 'Max N' company selected 'Other' option is displayed in the search result
When I deselect 'Other' option in the 'Asset Type' field
And I select 'Retail' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Retail' option is displayed in the search result
And I verify 'Max N' company selected 'Retail' option is displayed in the search result
When I deselect 'Retail' option in the 'Asset Type' field
And I select 'Industrial' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Industrial' option is displayed in the search result
And I verify 'Max N' company selected 'Industrial' option is displayed in the search result
When I deselect 'Industrial' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Residential +' option is displayed in the search result
And I verify 'Max N' company selected 'Residential +' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Residential +' option is displayed in the search result
And I verify 'Max N' company selected 'Residential +' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
And I select 'Single Family' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Single Family' option is displayed in the search result
And I verify 'Max N' company selected 'Single Family' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
And I select 'Retirement' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Retirement' option is displayed in the search result
And I verify 'Max N' company selected 'Retirement' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
And I select 'Student Housing' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Student Housing' option is displayed in the search result
And I verify 'Max N' company selected 'Student Housing' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
And I select 'Other Housing' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Other Housing' option is displayed in the search result
And I verify 'Max N' company selected 'Other Housing' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Residential +' option in the 'Asset Type' field
And I select 'Multi-Family' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Multi-Family' option is displayed in the search result
And I verify 'Max N' company selected 'Multi-Family' option is displayed in the search result
When I deselect 'Residential +' option in the 'Asset Type' field
And I select 'Mixed Use' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Mixed Use' option is displayed in the search result
And I verify 'Max N' company selected 'Mixed Use' option is displayed in the search result
When I deselect 'Mixed Use' option in the 'Asset Type' field
And I select 'Commercial' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Commercial' option is displayed in the search result
And I verify 'Max N' company selected 'Commercial' option is displayed in the search result
When I deselect 'Commercial' option in the 'Asset Type' field
And I select 'Solar' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'Solar' option is displayed in the search result
And I verify 'Max N' company selected 'Solar' option is displayed in the search result
When I deselect 'Solar' option in the 'Asset Type' field
And I select 'All' option in the 'Asset Type' field
Then I verify 'Terain' company selected 'All' option is displayed in the search result
And I verify 'Max N' company selected 'All' option is displayed in the search result
When I deselect 'All' option in the 'Asset Type' field
And I select 'Core' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Core' option is displayed in the search result
And I verify 'Max N' company selected 'Core' option is displayed in the search result
When I deselect 'Core' option in the 'Risk Profile' field
And I select 'Core' option in the 'Risk Profile' field
Then I verify 'Steele' company selected 'Core' option is displayed in the search result
When I deselect 'Core' option in the 'Risk Profile' field
And I select 'Opportunistic' option in the 'Risk Profile' field
Then I verify 'Steele' company selected 'Opportunistic' option is displayed in the search result
When I deselect 'Opportunistic' option in the 'Risk Profile' field
And I select 'Opportunistic' option in the 'Risk Profile' field
Then I verify 'Steele' company selected 'Opportunistic' option is displayed in the search result
When I deselect 'Opportunistic' option in the 'Risk Profile' field
And I click on 'RiskProfile' drop down field
And I select a risk profile in drop down list
Then I verify company name of deal sponsor of all search option is displayed
And I verify developer company name of all search option is displayed
When I click on 'RiskProfile' drop down field
And I select 'Core Plus' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Core Plus' option is displayed in the search result
And I verify 'Max N' company selected 'Core Plus' option is displayed in the search result
When I deselect 'Core Plus' option in the 'Risk Profile' field
And I select 'Value Add' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Value Add' option is displayed in the search result
And I verify 'Max N' company selected 'Value Add' option is displayed in the search result
When I deselect 'Value Add' option in the 'Risk Profile' field
And I select 'Development' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Development' option is displayed in the search result
And I verify 'Max N' company selected 'Development' option is displayed in the search result
When I deselect 'Development' option in the 'Risk Profile' field
And I select 'Opportunistic' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Opportunistic' option is displayed in the search result
And I verify 'Max N' company selected 'Opportunistic' option is displayed in the search result
When I deselect 'Opportunistic' option in the 'Risk Profile' field
And I select 'Other' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'Other' option is displayed in the search result
And I verify 'Max N' company selected 'Other' option is displayed in the search result
When I deselect 'Other' option in the 'Risk Profile' field
And I select 'All' option in the 'Risk Profile' field
Then I verify 'Terain' company selected 'All' option is displayed in the search result
And I verify 'Max N' company selected 'All' option is displayed in the search result
When I deselect 'All' option in the 'Risk Profile' field
And I select 'Acquisition' option in the 'Asset Strategy' field
Then I verify 'Sterling' company selected 'Acquisition' option is displayed in the search result
When I deselect 'Acquisition' option in the 'Asset Strategy' field
And I select 'Sale Leaseback' option in the 'Asset Strategy' field
Then I verify 'Steele' company selected 'Sale Leaseback' option is displayed in the search result
When I deselect 'Sale Leaseback' option in the 'Asset Strategy' field
And I select 'Acquisition' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Acquisition' option is displayed in the search result
And I verify 'Max N' company selected 'Acquisition' option is displayed in the search result
When I deselect 'Acquisition' option in the 'Asset Strategy' field
And I select 'Sale Leaseback' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Sale Leaseback' option is displayed in the search result
And I verify 'Max N' company selected 'Sale Leaseback' option is displayed in the search result
When I deselect 'Sale Leaseback' option in the 'Asset Strategy' field
And I select 'Stable Income Producing' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Stable Income Producing' option is displayed in the search result
And I verify 'Max N' company selected 'Stable Income Producing' option is displayed in the search result
When I deselect 'Stable Income Producing' option in the 'Asset Strategy' field
And I select 'Quick Flip' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Quick Flip' option is displayed in the search result
And I verify 'Max N' company selected 'Quick Flip' option is displayed in the search result
When I deselect 'Quick Flip' option in the 'Asset Strategy' field
And I select 'Restructuring (Corporate)' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Restructuring (Corporate)' option is displayed in the search result
And I verify 'Max N' company selected 'Restructuring (Corporate)' option is displayed in the search result
When I deselect 'Restructuring (Corporate)' option in the 'Asset Strategy' field
And I select 'Recapitalization' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Recapitalization' option is displayed in the search result
And I verify 'Max N' company selected 'Recapitalization' option is displayed in the search result
When I deselect 'Recapitalization' option in the 'Asset Strategy' field
And I select 'Land Bank' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Land Bank' option is displayed in the search result
And I verify 'Max N' company selected 'Land Bank' option is displayed in the search result
When I deselect 'Land Bank' option in the 'Asset Strategy' field
And I select 'Change of Use/Reposition' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Change of Use/Reposition' option is displayed in the search result
And I verify 'Max N' company selected 'Change of Use/Reposition' option is displayed in the search result
When I deselect 'Change of Use/Reposition' option in the 'Asset Strategy' field
And I select 'Development' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Development' option is displayed in the search result
And I verify 'Max N' company selected 'Development' option is displayed in the search result
When I deselect 'Development' option in the 'Asset Strategy' field
And I select 'Platform Build/Programmatic' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Platform Build/Programmatic' option is displayed in the search result
And I verify 'Max N' company selected 'Platform Build/Programmatic' option is displayed in the search result
When I deselect 'Platform Build/Programmatic' option in the 'Asset Strategy' field
And I select 'Pursuit' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Pursuit' option is displayed in the search result
And I verify 'Max N' company selected 'Pursuit' option is displayed in the search result
When I deselect 'Pursuit' option in the 'Asset Strategy' field
And I select 'Lease-Up' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Lease-Up' option is displayed in the search result
And I verify 'Max N' company selected 'Lease-Up' option is displayed in the search result
When I deselect 'Lease-Up' option in the 'Asset Strategy' field
And I select 'Work-out/Distress' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Work-out/Distress' option is displayed in the search result
And I verify 'Max N' company selected 'Work-out/Distress' option is displayed in the search result
When I deselect 'Work-out/Distress' option in the 'Asset Strategy' field
And I select 'Public-to-Private Transactions' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Public-to-Private Transactions' option is displayed in the search result
And I verify 'Max N' company selected 'Public-to-Private Transactions' option is displayed in the search result
When I deselect 'Public-to-Private Transactions' option in the 'Asset Strategy' field
And I select 'Rezoning' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Rezoning' option is displayed in the search result
And I verify 'Max N' company selected 'Rezoning' option is displayed in the search result
When I deselect 'Rezoning' option in the 'Asset Strategy' field
And I select 'Renovation/Rehabilitation' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Renovation/Rehabilitation' option is displayed in the search result
And I verify 'Max N' company selected 'Renovation/Rehabilitation' option is displayed in the search result
When I deselect 'Renovation/Rehabilitation' option in the 'Asset Strategy' field
And I select 'Forward Commitment/Forward Purchase' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Forward Commitment/Forward Purchase' option is displayed in the search result
And I verify 'Max N' company selected 'Forward Commitment/Forward Purchase' option is displayed in the search result
When I deselect 'Forward Commitment/Forward Purchase' option in the 'Asset Strategy' field
And I select 'Other' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'Other' option is displayed in the search result
And I verify 'Max N' company selected 'Other' option is displayed in the search result
When I deselect 'Other' option in the 'Asset Strategy' field
And I select 'All' option in the 'Asset Strategy' field
Then I verify 'Terain' company selected 'All' option is displayed in the search result
And I verify 'Max N' company selected 'All' option is displayed in the search result
When I deselect 'All' option in the 'Asset Strategy' field
And I click on Syndicate check box
Then I verify 'Sterling' company is retrieved in the search result
And I verify 'Steele' company is retrieved in the search result
When I un check Syndicate check box
And I select co-invests with partners field
Then I verify 'Sterling' company is retrieved in the search result
And I verify 'Steele' company is retrieved in the search result
When I clear co invests with partners field
And I logout from RealConnex application


