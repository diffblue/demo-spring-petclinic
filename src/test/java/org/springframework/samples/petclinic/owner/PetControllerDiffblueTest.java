package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {PetController.class})
@ExtendWith(SpringExtension.class)
class PetControllerDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private PetController petController;
  /**
   * Method under test: {@link PetController#populatePetTypes()}
   */
  @Test
  void testPopulatePetTypes() {
    // Arrange
    ArrayList<PetType> petTypeList = new ArrayList<>();
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    Collection<PetType> actualPopulatePetTypesResult = petController.populatePetTypes();

    // Assert
    verify(ownerRepository).findPetTypes();
    assertTrue(actualPopulatePetTypesResult.isEmpty());
    assertSame(petTypeList, actualPopulatePetTypesResult);
  }

  /**
   * Method under test: {@link PetController#populatePetTypes()}
   */
  @Test
  void testPopulatePetTypes2() {
    // Arrange
    when(ownerRepository.findPetTypes()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.populatePetTypes());
    verify(ownerRepository).findPetTypes();
  }

  /**
   * Method under test: {@link PetController#findOwner(int)}
   */
  @Test
  void testFindOwner() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);

    // Act
    Owner actualFindOwnerResult = petController.findOwner(1);

    // Assert
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertSame(owner, actualFindOwnerResult);
  }

  /**
   * Method under test: {@link PetController#findOwner(int)}
   */
  @Test
  void testFindOwner2() {
    // Arrange
    when(ownerRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> petController.findOwner(1));
    verify(ownerRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  void testFindPet() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);

    // Act
    Pet actualFindPetResult = petController.findPet(1, 1);

    // Assert
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertNull(actualFindPetResult);
  }

  /**
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  void testFindPet2() {
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

    // Act
    Pet actualFindPetResult = petController.findPet(1, 1);

    // Assert
    verify(owner).setId(Mockito.<Integer>any());
    verify(owner).setFirstName(Mockito.<String>any());
    verify(owner).setLastName(Mockito.<String>any());
    verify(owner).getPet(Mockito.<Integer>any());
    verify(owner).setAddress(Mockito.<String>any());
    verify(owner).setCity(Mockito.<String>any());
    verify(owner).setTelephone(Mockito.<String>any());
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertSame(pet, actualFindPetResult);
  }

  /**
   * Method under test: {@link PetController#findPet(int, Integer)}
   */
  @Test
  void testFindPet3() {
    // Arrange
    Owner owner = mock(Owner.class);
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

    // Act
    Pet actualFindPetResult = petController.findPet(1, null);

    // Assert
    verify(owner).setId(Mockito.<Integer>any());
    verify(owner).setFirstName(Mockito.<String>any());
    verify(owner).setLastName(Mockito.<String>any());
    verify(owner).setAddress(Mockito.<String>any());
    verify(owner).setCity(Mockito.<String>any());
    verify(owner).setTelephone(Mockito.<String>any());
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertTrue(actualFindPetResult.getVisits().isEmpty());
  }

  /**
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
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
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm2() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new",
        "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(petController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm3() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new", 1);
    requestBuilder.contentType("text/plain");

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
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm4() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new", 1)
        .param("address", "42 Main St");

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
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm5() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new", 1)
        .param("city", "Oxford");

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
   * Method under test: {@link PetController#initCreationForm(Owner, ModelMap)}
   */
  @Test
  void testInitCreationForm6() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/new", 1)
        .param("telephone", "6625550144");

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
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
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
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm2() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/{petId}/edit",
        "Uri Variables", "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(petController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm3() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/pets/{petId}/edit", 1,
        1);
    requestBuilder.contentType("text/plain");

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
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm4() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/owners/{ownerId}/pets/{petId}/edit", 1, 1)
        .param("address", "42 Main St");

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
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm5() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/owners/{ownerId}/pets/{petId}/edit", 1, 1)
        .param("city", "Oxford");

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
   * Method under test: {@link PetController#initUpdateForm(Owner, int, ModelMap)}
   */
  @Test
  void testInitUpdateForm6() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/owners/{ownerId}/pets/{petId}/edit", 1, 1)
        .param("telephone", "6625550144");

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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm2() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new",
        "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(petController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm3() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1);
    requestBuilder.contentType("text/plain");

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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm4() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1)
        .param("address", "42 Main St");

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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm5() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1)
        .param("city", "Oxford");

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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm6() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/new", 1)
        .param("telephone", "6625550144");

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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm7() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
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
   * Method under test:
   * {@link PetController#processCreationForm(Owner, Pet, BindingResult, ModelMap)}
   */
  @Test
  void testProcessCreationForm8() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
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
   * Method under test:
   * {@link PetController#processUpdateForm(Pet, BindingResult, Owner, ModelMap)}
   */
  @Test
  void testProcessUpdateForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/pets/42/edit",
        "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(petController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }
}
