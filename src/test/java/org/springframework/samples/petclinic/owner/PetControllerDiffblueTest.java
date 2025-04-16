package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ContextConfiguration(classes = {PetController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class PetControllerDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private PetController petController;

  /**
   * Test {@link PetController#populatePetTypes()}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#populatePetTypes()}
   */
  @Test
  @DisplayName("Test populatePetTypes(); then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection PetController.populatePetTypes()"})
  void testPopulatePetTypes_thenReturnList() {
    // Arrange
    ArrayList<PetType> petTypeList = new ArrayList<>();
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    Collection<PetType> actualPopulatePetTypesResult = petController.populatePetTypes();

    // Assert
    verify(ownerRepository).findPetTypes();
    assertTrue(actualPopulatePetTypesResult instanceof List);
    assertTrue(actualPopulatePetTypesResult.isEmpty());
    assertSame(petTypeList, actualPopulatePetTypesResult);
  }

  /**
   * Test {@link PetController#populatePetTypes()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#populatePetTypes()}
   */
  @Test
  @DisplayName("Test populatePetTypes(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection PetController.populatePetTypes()"})
  void testPopulatePetTypes_thenThrowIllegalArgumentException() {
    // Arrange
    when(ownerRepository.findPetTypes()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.populatePetTypes());
    verify(ownerRepository).findPetTypes();
  }

  /**
   * Test {@link PetController#findOwner(int)}.
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 42 Main St}.</li>
   *   <li>Then return {@link Owner} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findOwner(int)}
   */
  @Test
  @DisplayName("Test findOwner(int); given Owner (default constructor) Address is '42 Main St'; then return Owner (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Owner PetController.findOwner(int)"})
  void testFindOwner_givenOwnerAddressIs42MainSt_thenReturnOwner() {
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

    // Act
    Owner actualFindOwnerResult = petController.findOwner(1);

    // Assert
    verify(ownerRepository).findById(eq(1));
    assertSame(owner, actualFindOwnerResult);
  }

  /**
   * Test {@link PetController#findOwner(int)}.
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findOwner(int)}
   */
  @Test
  @DisplayName("Test findOwner(int); given OwnerRepository findById(Integer) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Owner PetController.findOwner(int)"})
  void testFindOwner_givenOwnerRepositoryFindByIdReturnEmpty() {
    // Arrange
    Optional<Owner> emptyResult = Optional.empty();
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.findOwner(1));
    verify(ownerRepository).findById(eq(1));
  }

  /**
   * Test {@link PetController#findOwner(int)}.
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findOwner(int)}
   */
  @Test
  @DisplayName("Test findOwner(int); given OwnerRepository findById(Integer) throw IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Owner PetController.findOwner(int)"})
  void testFindOwner_givenOwnerRepositoryFindByIdThrowIllegalArgumentExceptionWithFoo() {
    // Arrange
    when(ownerRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.findOwner(1));
    verify(ownerRepository).findById(eq(1));
  }

  /**
   * Test {@link PetController#findPet(int, Integer)}.
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 42 Main St}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  @DisplayName("Test findPet(int, Integer); given Owner (default constructor) Address is '42 Main St'; when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet PetController.findPet(int, Integer)"})
  void testFindPet_givenOwnerAddressIs42MainSt_whenOne_thenReturnNull() {
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

    // Act
    Pet actualFindPetResult = petController.findPet(1, 1);

    // Assert
    verify(ownerRepository).findById(eq(1));
    assertNull(actualFindPetResult);
  }

  /**
   * Test {@link PetController#findPet(int, Integer)}.
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  @DisplayName("Test findPet(int, Integer); given OwnerRepository findById(Integer) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet PetController.findPet(int, Integer)"})
  void testFindPet_givenOwnerRepositoryFindByIdReturnEmpty() {
    // Arrange
    Optional<Owner> emptyResult = Optional.empty();
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.findPet(1, 1));
    verify(ownerRepository).findById(eq(1));
  }

  /**
   * Test {@link PetController#findPet(int, Integer)}.
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  @DisplayName("Test findPet(int, Integer); given OwnerRepository findById(Integer) throw IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet PetController.findPet(int, Integer)"})
  void testFindPet_givenOwnerRepositoryFindByIdThrowIllegalArgumentExceptionWithFoo() {
    // Arrange
    when(ownerRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.findPet(1, 1));
    verify(ownerRepository).findById(eq(1));
  }

  /**
   * Test {@link PetController#findPet(int, Integer)}.
   * <ul>
   *   <li>Given {@link OwnerRepository}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then Visits return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  @DisplayName("Test findPet(int, Integer); given OwnerRepository; when 'null'; then Visits return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet PetController.findPet(int, Integer)"})
  void testFindPet_givenOwnerRepository_whenNull_thenVisitsReturnSet() {
    // Arrange and Act
    Pet actualFindPetResult = petController.findPet(1, null);

    // Assert
    Collection<Visit> visits = actualFindPetResult.getVisits();
    assertTrue(visits instanceof Set);
    assertNull(actualFindPetResult.getId());
    assertNull(actualFindPetResult.getName());
    assertNull(actualFindPetResult.getBirthDate());
    assertNull(actualFindPetResult.getType());
    assertTrue(visits.isEmpty());
    assertTrue(actualFindPetResult.isNew());
  }

  /**
   * Test {@link PetController#initCreationForm(Owner, ModelMap)}.
   * <p>
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  @DisplayName("Test initCreationForm(Owner, ModelMap)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PetController.initCreationForm(Owner, ModelMap)"})
  void testInitCreationForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(3))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner", "pet", "types"))
        .andExpect(MockMvcResultMatchers.view().name("pets/createOrUpdatePetForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("pets/createOrUpdatePetForm"));
  }

  /**
   * Test {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCreationForm(Owner, Pet, BindingResult, RedirectAttributes); when '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessCreationForm_when20200301() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1)
        .param("birthDate", "2020-03-01");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(3))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner", "pet", "types"))
        .andExpect(MockMvcResultMatchers.view().name("pets/createOrUpdatePetForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("pets/createOrUpdatePetForm"));
  }

  /**
   * Test {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@code Bella}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCreationForm(Owner, Pet, BindingResult, RedirectAttributes); when 'Bella'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessCreationForm_whenBella() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1)
        .param("name", "Bella");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(3))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner", "pet", "types"))
        .andExpect(MockMvcResultMatchers.view().name("pets/createOrUpdatePetForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("pets/createOrUpdatePetForm"));
  }

  /**
   * Test {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#post(String, Object[])} {@code /owners/{ownerId}/pets/new} one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCreationForm(Owner, Pet, BindingResult, RedirectAttributes); when post(String, Object[]) '/owners/{ownerId}/pets/new' one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessCreationForm_whenPostOwnersOwnerIdPetsNewOne() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(3))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner", "pet", "types"))
        .andExpect(MockMvcResultMatchers.view().name("pets/createOrUpdatePetForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("pets/createOrUpdatePetForm"));
  }

  /**
   * Test {@link PetController#initUpdateForm()}.
   * <p>
   * Method under test: {@link PetController#initUpdateForm()}
   */
  @Test
  @DisplayName("Test initUpdateForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PetController.initUpdateForm()"})
  void testInitUpdateForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/{petId}/edit", 1,
        1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(3))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner", "types"))
        .andExpect(MockMvcResultMatchers.view().name("pets/createOrUpdatePetForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("pets/createOrUpdatePetForm"));
  }

  /**
   * Test {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PetController.processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessUpdateForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/{petId}/edit",
        "Uri Variables", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(petController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
