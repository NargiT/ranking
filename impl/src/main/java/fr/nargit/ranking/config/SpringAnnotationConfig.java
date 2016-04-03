package fr.nargit.ranking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * (c) 28-mars-2016
 *
 * @author tigran-mac
 */
@Configuration
@ComponentScan(basePackages = {"fr.nargit.ranking.service", "fr.nargit.ranking.dao"})
public class SpringAnnotationConfig {

  @Autowired
  DataSource dataSource;

}
