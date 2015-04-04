package tomcatJunit;


import hu.ikiss.test.EmbeddedServer;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;

public class MyAppDeployedOnLocalTest {
  EmbeddedServer embeddedServer;
  @Before
  // or @BeforeClass
  public void startServer() throws ServletException {
      embeddedServer = new EmbeddedServer(9090, "/myservice");
      embeddedServer.start();

  }

  @After
  // or @AfterClass
  public void stopServer() {
      embeddedServer.stop();
  }

  public void test_send_request_without_parameters (){
          Client client = null;
          Reply reply = client.sendRequest();
          assertTrue (reply.isOk());
  }
}