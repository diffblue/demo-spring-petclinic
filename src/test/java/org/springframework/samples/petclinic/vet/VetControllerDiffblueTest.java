package org.springframework.samples.petclinic.vet;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {VetController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class VetControllerDiffblueTest {
  @Autowired
  private VetController vetController;

  @MockBean
  private VetRepository vetRepository;

  /**
   * Test {@link VetController#showVetList(int, Model)}.
   * <p>
   * Method under test: {@link VetController#showVetList(int, Model)}
   */
  @Test
  @DisplayName("Test showVetList(int, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VetController.showVetList(int, Model)"})
  void testShowVetList() throws Exception {
    // Arrange
    when(vetRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/vets.html");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(vetController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(4))
        .andExpect(MockMvcResultMatchers.model().attributeExists("currentPage", "listVets", "totalItems", "totalPages"))
        .andExpect(MockMvcResultMatchers.view().name("vets/vetList"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("vets/vetList"));
  }

  /**
   * Test {@link VetController#showResourcesVetList()}.
   * <p>
   * Method under test: {@link VetController#showResourcesVetList()}
   */
  @Test
  @DisplayName("Test showResourcesVetList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.springframework.samples.petclinic.vet.Vets VetController.showResourcesVetList()"})
  void testShowResourcesVetList() throws Exception {
    // Arrange
    when(vetRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(vetController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><vets/>"));
  }
}
