package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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
  @MethodsUnderTest({"String PetController.initCreationForm(Owner, ModelMap)"})
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
  @MethodsUnderTest({"String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
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
  @MethodsUnderTest({"String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
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
  @MethodsUnderTest({"String PetController.processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)"})
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
  @MethodsUnderTest({"String PetController.initUpdateForm()"})
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Pet} {@link NamedEntity#getName()} return {@code null}.</li>
   *   <li>Then calls {@link NamedEntity#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes); given 'null'; when Pet getName() return 'null'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PetController.processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessUpdateForm_givenNull_whenPetGetNameReturnNull_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    OwnerRepository owners = mock(OwnerRepository.class);
    when(owners.save(Mockito.<Owner>any())).thenReturn(owner);
    PetController petController = new PetController(owners);
    Owner owner2 = mock(Owner.class);
    doNothing().when(owner2).setId(Mockito.<Integer>any());
    doNothing().when(owner2).setFirstName(Mockito.<String>any());
    doNothing().when(owner2).setLastName(Mockito.<String>any());
    doNothing().when(owner2).addPet(Mockito.<Pet>any());
    doNothing().when(owner2).setAddress(Mockito.<String>any());
    doNothing().when(owner2).setCity(Mockito.<String>any());
    doNothing().when(owner2).setTelephone(Mockito.<String>any());
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");
    Pet pet = mock(Pet.class);
    doNothing().when(pet).setId(Mockito.<Integer>any());
    doNothing().when(pet).setName(Mockito.<String>any());
    doNothing().when(pet).setBirthDate(Mockito.<LocalDate>any());
    doNothing().when(pet).setType(Mockito.<PetType>any());
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);

    PetType type2 = new PetType();
    type2.setId(1);
    type2.setName("Dog");
    Pet pet2 = mock(Pet.class);
    when(pet2.getName()).thenReturn(null);
    when(pet2.getBirthDate()).thenReturn(LocalDate.of(1970, 1, 1));
    doNothing().when(pet2).setId(Mockito.<Integer>any());
    doNothing().when(pet2).setName(Mockito.<String>any());
    doNothing().when(pet2).setBirthDate(Mockito.<LocalDate>any());
    doNothing().when(pet2).setType(Mockito.<PetType>any());
    pet2.setBirthDate(LocalDate.of(1970, 1, 1));
    pet2.setId(1);
    pet2.setName("Bella");
    pet2.setType(type2);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualProcessUpdateFormResult = petController.processUpdateForm(owner2, pet2, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(owners).save(isA(Owner.class));
    verify(owner2).setId(eq(1));
    verify(pet).setId(eq(1));
    verify(pet2).setId(eq(1));
    verify(pet2).getName();
    verify(pet).setName(eq("Bella"));
    verify(pet2).setName(eq("Bella"));
    verify(owner2).setFirstName(eq("Jane"));
    verify(owner2).setLastName(eq("Doe"));
    verify(owner2).addPet(isA(Pet.class));
    verify(owner2).setAddress(eq("42 Main St"));
    verify(owner2).setCity(eq("Oxford"));
    verify(owner2).setTelephone(eq("6625550144"));
    verify(pet2, atLeast(1)).getBirthDate();
    verify(pet).setBirthDate(isA(LocalDate.class));
    verify(pet2).setBirthDate(isA(LocalDate.class));
    verify(pet).setType(isA(PetType.class));
    verify(pet2).setType(isA(PetType.class));
    assertEquals("redirect:/owners/{ownerId}", actualProcessUpdateFormResult);
  }

  /**
   * Test {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then calls {@link Owner#getPet(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes); then calls getPet(String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PetController.processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessUpdateForm_thenCallsGetPet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    OwnerRepository owners = mock(OwnerRepository.class);
    when(owners.save(Mockito.<Owner>any())).thenReturn(owner);
    PetController petController = new PetController(owners);

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);
    Owner owner2 = mock(Owner.class);
    when(owner2.getPet(Mockito.<String>any(), anyBoolean())).thenReturn(pet);
    doNothing().when(owner2).setId(Mockito.<Integer>any());
    doNothing().when(owner2).setFirstName(Mockito.<String>any());
    doNothing().when(owner2).setLastName(Mockito.<String>any());
    doNothing().when(owner2).addPet(Mockito.<Pet>any());
    doNothing().when(owner2).setAddress(Mockito.<String>any());
    doNothing().when(owner2).setCity(Mockito.<String>any());
    doNothing().when(owner2).setTelephone(Mockito.<String>any());
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    PetType type2 = new PetType();
    type2.setId(1);
    type2.setName("Dog");

    Pet pet2 = new Pet();
    pet2.setBirthDate(LocalDate.of(1970, 1, 1));
    pet2.setId(1);
    pet2.setName("Bella");
    pet2.setType(type2);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualProcessUpdateFormResult = petController.processUpdateForm(owner2, pet2, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(owners).save(isA(Owner.class));
    verify(owner2).setId(eq(1));
    verify(owner2).setFirstName(eq("Jane"));
    verify(owner2).setLastName(eq("Doe"));
    verify(owner2).addPet(isA(Pet.class));
    verify(owner2).getPet(eq("Bella"), eq(false));
    verify(owner2).setAddress(eq("42 Main St"));
    verify(owner2).setCity(eq("Oxford"));
    verify(owner2).setTelephone(eq("6625550144"));
    assertEquals("redirect:/owners/{ownerId}", actualProcessUpdateFormResult);
  }

  /**
   * Test {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link Owner} (default constructor) Address is {@code 42 Main St}.</li>
   *   <li>Then return {@code redirect:/owners/{ownerId}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes); when Owner (default constructor) Address is '42 Main St'; then return 'redirect:/owners/{ownerId}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PetController.processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)"})
  void testProcessUpdateForm_whenOwnerAddressIs42MainSt_thenReturnRedirectOwnersOwnerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    OwnerRepository owners = mock(OwnerRepository.class);
    when(owners.save(Mockito.<Owner>any())).thenReturn(owner);
    PetController petController = new PetController(owners);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualProcessUpdateFormResult = petController.processUpdateForm(owner2, pet, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(owners).save(isA(Owner.class));
    assertEquals("redirect:/owners/{ownerId}", actualProcessUpdateFormResult);
  }
}
