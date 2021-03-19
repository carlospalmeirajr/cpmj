package cpmj.Pages;

public class MinhaContaPage {
	public static final String WELCOMEPAGE_SIGNOUT_CSS = "a.logout";
	public static final String WELCOMEPAGE_SEARCH_ID = "search_query_top";
	public static final String WELCOMEPAGE_SEARCH_CSS = "button[name='submit_search']"; 
	public static final String WELCOMEPAGE_NAME_USER_XPATH = "//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a/span";
	
	public static String getWelcomepageNameUserXpath() {
		return WELCOMEPAGE_NAME_USER_XPATH;
	}
	public static String getWelcomepageSignoutCss() {
		return WELCOMEPAGE_SIGNOUT_CSS;
	}
	public static String getWelcomepageSearchId() {
		return WELCOMEPAGE_SEARCH_ID;
	}
	public static String getWelcomepageSearchCss() {
		return WELCOMEPAGE_SEARCH_CSS;
	}
}
