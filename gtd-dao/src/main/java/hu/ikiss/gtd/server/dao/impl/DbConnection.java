package hu.ikiss.gtd.server.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class DbConnection {

  @PersistenceContext(unitName = "gtdDS")
  private EntityManager em;

  @Autowired
  ProjectDAO            projectDao;

  @Autowired
  TaskDAO               taskDao;

  @Pointcut("execution(public hu.ikiss.gtd.dao.impl..*.*(..))")
  public void methodsWithDBAccess() {
  }

  @Before("methodsWithDBAccess")
  public void setConnection(final JoinPoint joinPoint) {
    this.taskDao.setEM(this.em);
    this.projectDao.setEM(this.em);
  }
}
