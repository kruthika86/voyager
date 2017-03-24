package com.solrSearch.config.solr;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.server.support.HttpSolrServerFactoryBean;

@Configuration
@ConfigurationProperties(prefix = "solr")
public class ConfigSolr {
	
	//Initialize it with the url of the solr
	private String solrUrl="";
	
	//Initialize it with value by which it should time-out
	private int solrResponseTime= 10000;
	
	@Bean
	public HttpSolrServerFactoryBean solrServerBean(){
		HttpSolrServerFactoryBean solrFactoryBean = new HttpSolrServerFactoryBean();
		
		solrFactoryBean.setUrl(solrUrl);
		solrFactoryBean.setTimeout(solrResponseTime);
		
		return solrFactoryBean;
	}
	
	
	@Bean
	public SolrTemplate solrTemplate()throws Exception{
		if(!(solrUrl.isEmpty())){
			SolrTemplate solrTemplate = new SolrTemplate(solrServerBean().getObject());
			
			return solrTemplate;
		}
	
		return null;
	}
}
