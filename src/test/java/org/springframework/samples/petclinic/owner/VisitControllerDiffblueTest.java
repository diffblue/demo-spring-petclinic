package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {VisitController.class})
@ExtendWith(SpringExtension.class)
class VisitControllerDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private VisitController visitController;
  /**
   * Method under test: {@link VisitController#loadPetWithVisit(int, int, Map)}
   */
  @Test
  void testLoadPetWithVisit() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);
    Owner owner = mock(Owner.class);
    when(owner.getPet(Mockito.<Integer>any())).thenReturn(pet);
    doNothing().when(owner).setId(Mockito.<Integer>any());
    doNothing().when(owner).setFirstName(Mockito.<String>any());
    doNothing().when(owner).setLastName(Mockito.<String>any());
    doNothing().when(owner).setAddress(Mockito.<String>any());
    doNothing().when(owner).setCity(Mockito.<String>any());
    doNothing().when(owner).setTelephone(Mockito.<String>any());
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    HashMap<String, Object> model = new HashMap<>();

    // Act
    visitController.loadPetWithVisit(1, 1, model);

    // Assert
    verify(owner).setId(Mockito.<Integer>any());
    verify(owner).setFirstName(eq("Jane"));
    verify(owner).setLastName(eq("Doe"));
    verify(owner).getPet(Mockito.<Integer>any());
    verify(owner).setAddress(eq("42 Main St"));
    verify(owner).setCity(eq("Oxford"));
    verify(owner).setTelephone(eq("6625550144"));
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertEquals(2, model.size());
    assertEquals(1, ((Pet) model.get("pet")).getVisits().size());
  }

  /**
   * Method under test: {@link VisitController#initNewVisitForm()}
   */
  @Test
  void testInitNewVisitForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/owners/{ownerId}/pets/{petId}/visits/new", "Uri Variables", "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(visitController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test:
   * {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult)}
   */
  @Test
  void testProcessNewVisitForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/owners/{ownerId}/pets/{petId}/visits/new", "Uri Variables", "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(visitController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }
}
