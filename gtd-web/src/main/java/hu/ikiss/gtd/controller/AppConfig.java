package hu.ikiss.gtd.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("hu.ikiss.gtd")
@EnableAspectJAutoProxy
public class AppConfig {
  // @Bean
  // public DbConnection dbConnection() {
  // return new DbConnection();
  // }

  // @Bean
  // public hu.ikiss.gtd.dao.ProjectDAO projectDAO() {
  // return new hu.ikiss.gtd.server.dao.impl.ProjectDAO();
  // }

  // @Bean
  // public ProjectServices projectServices() {
  // return new ProjectServices();
  // }

  // @Bean
  // public hu.ikiss.gtd.server.dao.impl.TaskDAO taskDAO() {
  // return new hu.ikiss.gtd.server.dao.impl.TaskDAO();
  // }

  // @Bean
  // public TaskServices taskServices() {
  // return new TaskServices();
  // }

}
