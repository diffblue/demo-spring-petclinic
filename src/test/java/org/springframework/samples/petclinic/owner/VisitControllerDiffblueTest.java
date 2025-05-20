package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ContextConfiguration(classes = {VisitController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class VisitControllerDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private VisitController visitController;

  /**
   * Test {@link VisitController#loadPetWithVisit(int, int, Map)}.
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Id is one.</li>
   *   <li>Then {@link HashMap#HashMap()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link VisitController#loadPetWithVisit(int, int, Map)}
   */
  @Test
  @DisplayName("Test loadPetWithVisit(int, int, Map); given PetType (default constructor) Id is one; then HashMap() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Visit VisitController.loadPetWithVisit(int, int, Map)"})
  void testLoadPetWithVisit_givenPetTypeIdIsOne_thenHashMapSizeIsTwo() {
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
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    HashMap<String, Object> model = new HashMap<>();

    // Act
    Visit actualLoadPetWithVisitResult = visitController.loadPetWithVisit(1, 1, model);

    // Assert
    verify(owner).setId(eq(1));
    verify(owner).setFirstName(eq("Jane"));
    verify(owner).setLastName(eq("Doe"));
    verify(owner).getPet(eq(1));
    verify(owner).setAddress(eq("42 Main St"));
    verify(owner).setCity(eq("Oxford"));
    verify(owner).setTelephone(eq("6625550144"));
    verify(ownerRepository).findById(eq(1));
    assertEquals(2, model.size());
    assertNull(actualLoadPetWithVisitResult.getId());
    assertNull(actualLoadPetWithVisitResult.getDescription());
    assertTrue(model.containsKey("owner"));
    assertTrue(actualLoadPetWithVisitResult.isNew());
    assertSame(pet, model.get("pet"));
  }

  /**
   * Test {@link VisitController#loadPetWithVisit(int, int, Map)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VisitController#loadPetWithVisit(int, int, Map)}
   */
  @Test
  @DisplayName("Test loadPetWithVisit(int, int, Map); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Visit VisitController.loadPetWithVisit(int, int, Map)"})
  void testLoadPetWithVisit_thenThrowIllegalArgumentException() {
    // Arrange
    Optional<Owner> emptyResult = Optional.empty();
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> visitController.loadPetWithVisit(1, 1, new HashMap<>()));
    verify(ownerRepository).findById(eq(1));
  }

  /**
   * Test {@link VisitController#initNewVisitForm()}.
   * <p>
   * Method under test: {@link VisitController#initNewVisitForm()}
   */
  @Test
  @DisplayName("Test initNewVisitForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VisitController.initNewVisitForm()"})
  void testInitNewVisitForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/owners/{ownerId}/pets/{petId}/visits/new", "Uri Variables", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(visitController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String VisitController.processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)"})
  void testProcessNewVisitForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/owners/{ownerId}/pets/{petId}/visits/new", "Uri Variables", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(visitController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
