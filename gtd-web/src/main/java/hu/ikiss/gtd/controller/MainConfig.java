package hu.ikiss.gtd.controller;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiTemplate;

// @Configuration
public class MainConfig {

  @Bean
  DataSource dataSource() {
    DataSource dataSource = null;
    final JndiTemplate jndi = new JndiTemplate();
    try {
      dataSource = (DataSource) jndi.lookup("jdbc/gtdDB");
    } catch (final NamingException e) {
    }
    return dataSource;
  }

}
