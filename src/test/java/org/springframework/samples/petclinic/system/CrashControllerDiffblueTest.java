package org.springframework.samples.petclinic.system;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CrashControllerDiffblueTest {
  /**
   * Method under test: {@link CrashController#triggerException()}
   */
  @Test
  void testTriggerException() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   jakarta.servlet.ServletException: Request processing failed: java.lang.RuntimeException: Expected: controller used to showcase what happens when an exception is thrown
    //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
    //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
    //   java.lang.RuntimeException: Expected: controller used to showcase what happens when an exception is thrown
    //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
    //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CrashController()).triggerException());
  }
}
