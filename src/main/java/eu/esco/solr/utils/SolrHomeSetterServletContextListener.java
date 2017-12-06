package eu.esco.solr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SolrHomeSetterServletContextListener implements ServletContextListener {
  private static final Logger log = LoggerFactory.getLogger(SolrHomeSetterServletContextListener.class);

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    String solrSolrHome = System.getProperty("solr.solr.home");
    if (null != solrSolrHome) {
      log.info("solr.solr.home already set to '{}'", solrSolrHome);
      return;
    }

    String tenforceExtDirectory = System.getProperty("tenforce.ext.directory");
    if (null == tenforceExtDirectory) {
      log.warn("tenforce.ext.directory not set, not setting solr.solr.home");
      return;
    }

    if (!tenforceExtDirectory.endsWith("/")) tenforceExtDirectory += "/";
    String solrHomeFolder = tenforceExtDirectory + "solr_home";
    System.setProperty("solr.solr.home", solrHomeFolder);
    log.info("Solr home folder set to '{}'", solrHomeFolder);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
  }
}