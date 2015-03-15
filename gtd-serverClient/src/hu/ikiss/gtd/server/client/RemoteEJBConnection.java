package hu.ikiss.gtd.server.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteEJBConnection {

	private String appName;
	private String moduleName;
	private String distinctName;
	private String beanName;
	private String viewClassName;
	
	private Context context;
	private static Map<String, Object> ejbs = new HashMap<String, Object>();

	public Object getEJB(String lookupString) throws NamingException {
		final Object ret;
		if (ejbs.containsKey(lookupString)) {
			ret = ejbs.get(lookupString);
		} else {
			ret = lookup(lookupString);
			ejbs.put(lookupString, ret);
		}
		return ret;
	}

	private String getLookupString(String appName, String moduleName,
			String distinctName, String beanName, String viewClassName) {
		String ret = /*"ejb:"*/ "/" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + viewClassName;
		return ret;
	}

	private Object lookup(String appName, String moduleName,
			String distinctName, String beanName, String viewClassName) throws NamingException {
		String lookupString = getLookupString(appName, moduleName,
				distinctName, beanName, viewClassName);
		return lookup(lookupString);
	}

	public Object lookup() throws NamingException {
		return lookup(getAppName(), getModuleName(),
				getDistinctName(), getBeanName(), getViewClassName());
	}
	private Object lookup(String lookupString) throws NamingException {
		Object bean = context.lookup(lookupString);
		return bean;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDistinctName() {
		return distinctName;
	}

	public void setDistinctName(String distinctName) {
		this.distinctName = distinctName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getViewClassName() {
		return viewClassName;
	}

	public void setViewClassName(String viewClassName) {
		this.viewClassName = viewClassName;
	}

	{
		Properties props = new Properties();
		/*
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		try {
			context = new InitialContext(jndiProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		 String JBOSS_CONTEXT="org.jboss.naming.remote.client.InitialContextFactory";;
		  props.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_CONTEXT);
		  props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		  props.put(Context.SECURITY_PRINCIPAL, "gtd");//
		  props.put(Context.SECURITY_CREDENTIALS, "gtdgtd");
		  try {
			context = new InitialContext(props);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
