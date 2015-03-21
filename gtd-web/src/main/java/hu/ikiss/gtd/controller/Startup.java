package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.server.init.InitRemoteService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Servlet implementation class Startup
 */
@Controller
public class Startup extends HttpServlet implements InitializingBean {
  private static final long serialVersionUID = 1L;

  @Autowired
  InitRemoteService init;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Startup() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub

  }

}
