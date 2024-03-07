package org.springframework.samples.petclinic.system;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CrashControllerDiffblueTest {
  /**
   * Method under test: {@link CrashController#triggerException()}
   */
  @Test
  void testTriggerException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CrashController()).triggerException());
  }
}
