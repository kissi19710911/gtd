package hu.ikiss.gtd.server.dao.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class DbConnection {

  @Autowired
  hu.ikiss.gtd.dao.ProjectDAO projectDao;

  @Autowired
  hu.ikiss.gtd.dao.TaskDAO    taskDao;

  @Pointcut("execution(* hu.ikiss.gtd.server.dao.impl.*.setConverter(..))")
  public void daoSetConverter() {
  }

  @Pointcut("execution(* hu.ikiss.gtd.server.dao.impl.*.setEm(..))")
  public void daoSetEm() {
  }

  @Pointcut("execution(* hu.ikiss.gtd.server.dao.impl.ProjectDAO.*(..)) && !daoSetEm() && !daoSetConverter() ")
  public void projectDAOMethodsWithDBAccess() {
  }

  @Before("projectDAOMethodsWithDBAccess()")
  public void setProjectConnection(final JoinPoint joinPoint) {
    this.projectDao.setEm();
    this.projectDao.setConverter();
  }

  @Before("taskDAOMethodsWithDBAccess()")
  public void setTaskConnection(final JoinPoint joinPoint) {
    this.taskDao.setEm();
    this.taskDao.setConverter();
  }

  @Pointcut("execution(* hu.ikiss.gtd.server.dao.impl.TaskDAO.*(..)) && !daoSetEm() && !daoSetConverter() ")
  public void taskDAOMethodsWithDBAccess() {
  }
}
