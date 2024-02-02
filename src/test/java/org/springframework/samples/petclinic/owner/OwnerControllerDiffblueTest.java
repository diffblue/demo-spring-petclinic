package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {OwnerController.class})
@ExtendWith(SpringExtension.class)
class OwnerControllerDiffblueTest {
  @Autowired
  private OwnerController ownerController;

  @MockBean
  private OwnerRepository ownerRepository;
  /**
   * Method under test: {@link OwnerController#findOwner(Integer)}
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
    Owner actualFindOwnerResult = ownerController.findOwner(1);

    // Assert
    verify(ownerRepository).findById(Mockito.<Integer>any());
    assertSame(owner, actualFindOwnerResult);
  }

  /**
   * Method under test: {@link OwnerController#findOwner(Integer)}
   */
  @Test
  void testFindOwner2() {
    // Arrange, Act and Assert
    assertTrue(ownerController.findOwner(null).getPets().isEmpty());
  }

  /**
   * Method under test: {@link OwnerController#initCreationForm(Map)}
   */
  @Test
  void testInitCreationForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/new");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Method under test: {@link OwnerController#initCreationForm(Map)}
   */
  @Test
  void testInitCreationForm2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/new", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Method under test: {@link OwnerController#initFindForm()}
   */
  @Test
  void testInitFindForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/find");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/findOwners"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/findOwners"));
  }

  /**
   * Method under test: {@link OwnerController#initUpdateOwnerForm(int, Model)}
   */
  @Test
  void testInitUpdateOwnerForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processCreationForm(Owner, BindingResult)}
   */
  @Test
  void testProcessCreationForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/new");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  void testProcessFindForm() throws Exception {
    // Arrange
    when(ownerRepository.findByLastName(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/owners");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/findOwners"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/findOwners"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  void testProcessFindForm2() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner);
    PageImpl<Owner> pageImpl = new PageImpl<>(content);
    when(ownerRepository.findByLastName(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/owners");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/owners/1"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/owners/1"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  void testProcessFindForm3() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setId(2);
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner2);
    content.add(owner);
    PageImpl<Owner> pageImpl = new PageImpl<>(content);
    when(ownerRepository.findByLastName(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/owners");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(5))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("currentPage", "listOwners", "owner", "totalItems", "totalPages"))
        .andExpect(MockMvcResultMatchers.view().name("owners/ownersList"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/ownersList"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  void testProcessFindForm4() throws Exception {
    // Arrange
    when(ownerRepository.findByLastName(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/owners");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("page", String.valueOf(1)).param("lastName", "Doe");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/findOwners"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/findOwners"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int)}
   */
  @Test
  void testProcessUpdateOwnerForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    doNothing().when(ownerRepository).save(Mockito.<Owner>any());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/owners/{ownerId}"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/owners/1"));
  }

  /**
   * Method under test:
   * {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int)}
   */
  @Test
  void testProcessUpdateOwnerForm2() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    doNothing().when(ownerRepository).save(Mockito.<Owner>any());
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Method under test: {@link OwnerController#showOwner(int)}
   */
  @Test
  void testShowOwner() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(owner);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/{ownerId}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("owner"))
        .andExpect(MockMvcResultMatchers.view().name("owners/ownerDetails"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("owners/ownerDetails"));
  }
}
