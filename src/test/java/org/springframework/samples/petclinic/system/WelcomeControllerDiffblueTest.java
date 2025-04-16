package org.springframework.samples.petclinic.system;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WelcomeController.class})
@ExtendWith(SpringExtension.class)
class WelcomeControllerDiffblueTest {
  @Autowired
  private WelcomeController welcomeController;

  /**
   * Test {@link WelcomeController#welcome()}.
   * <p>
   * Method under test: {@link WelcomeController#welcome()}
   */
  @Test
  @DisplayName("Test welcome()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String WelcomeController.welcome()"})
  void testWelcome() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(welcomeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("welcome"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("welcome"));
  }
}
