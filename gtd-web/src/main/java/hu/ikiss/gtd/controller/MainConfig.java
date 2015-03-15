package hu.ikiss.gtd.controller;

import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

//@Configuration
public class MainConfig {
 
    @Bean
    DataSource dataSource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = (DataSource) jndi.lookup("jdbc/gtdDB");
        } catch (NamingException e) {
        }
        return dataSource;
    }

}