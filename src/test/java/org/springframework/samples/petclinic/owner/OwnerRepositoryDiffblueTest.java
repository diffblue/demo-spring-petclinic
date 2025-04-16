package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {OwnerRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.springframework.samples.petclinic.owner"})
class OwnerRepositoryDiffblueTest {
  @Autowired
  private OwnerRepository ownerRepository;

  /**
   * Test {@link OwnerRepository#findPetTypes()}.
   * <p>
   * Method under test: {@link OwnerRepository#findPetTypes()}
   */
  @Test
  @DisplayName("Test findPetTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findPetTypes()"})
  void testFindPetTypes() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    List<PetType> actualFindPetTypesResult = ownerRepository.findPetTypes();

    // Assert
    assertEquals(6, actualFindPetTypesResult.size());
    PetType getResult = actualFindPetTypesResult.get(0);
    assertEquals("bird", getResult.getName());
    PetType getResult2 = actualFindPetTypesResult.get(1);
    assertEquals("cat", getResult2.getName());
    PetType getResult3 = actualFindPetTypesResult.get(2);
    assertEquals("dog", getResult3.getName());
    PetType getResult4 = actualFindPetTypesResult.get(3);
    assertEquals("hamster", getResult4.getName());
    PetType getResult5 = actualFindPetTypesResult.get(4);
    assertEquals("lizard", getResult5.getName());
    PetType getResult6 = actualFindPetTypesResult.get(5);
    assertEquals("snake", getResult6.getName());
    assertEquals(1, getResult2.getId().intValue());
    assertEquals(2, getResult3.getId().intValue());
    assertEquals(3, getResult5.getId().intValue());
    assertEquals(4, getResult6.getId().intValue());
    assertEquals(5, getResult.getId().intValue());
    assertEquals(6, getResult4.getId().intValue());
    assertFalse(getResult.isNew());
    assertFalse(getResult2.isNew());
    assertFalse(getResult3.isNew());
    assertFalse(getResult4.isNew());
    assertFalse(getResult5.isNew());
    assertFalse(getResult6.isNew());
  }

  /**
   * Test {@link OwnerRepository#findByLastNameStartingWith(String, Pageable)}.
   * <p>
   * Method under test: {@link OwnerRepository#findByLastNameStartingWith(String, Pageable)}
   */
  @Test
  @DisplayName("Test findByLastNameStartingWith(String, Pageable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page OwnerRepository.findByLastNameStartingWith(String, Pageable)"})
  void testFindByLastNameStartingWith() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    Page<Owner> actualFindByLastNameStartingWithResult = ownerRepository.findByLastNameStartingWith("Doe",
        Pageable.unpaged());

    // Assert
    assertTrue(actualFindByLastNameStartingWithResult instanceof PageImpl);
    List<Owner> toListResult = actualFindByLastNameStartingWithResult.toList();
    assertEquals(1, toListResult.size());
    assertSame(owner, toListResult.get(0));
  }

  /**
   * Test {@link OwnerRepository#findById(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link OwnerRepository#findById(Integer)}
   */
  @Test
  @DisplayName("Test findById(Integer) with 'Integer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OwnerRepository.findById(Integer)"})
  void testFindByIdWithInteger() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act
    Optional<Owner> actualFindByIdResult = ownerRepository.findById(owner3.getId());

    // Assert
    assertTrue(actualFindByIdResult.isPresent());
    assertSame(owner3, actualFindByIdResult.get());
  }

  /**
   * Test {@link ListCrudRepository#findAll()}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findAll()"})
  void testFindAll() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    List<Owner> actualFindAllResult = ownerRepository.findAll();

    // Assert
    assertEquals(12, actualFindAllResult.size());
    assertSame(owner, actualFindAllResult.get(10));
    assertSame(owner2, actualFindAllResult.get(11));
  }

  /**
   * Test {@link ListCrudRepository#findAllById(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findAllById(Iterable)"})
  void testFindAllById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");

    Owner owner4 = new Owner();
    owner4.setAddress("42 Main St");
    owner4.setCity("Oxford");
    owner4.setFirstName("Jane");
    owner4.setLastName("Doe");
    owner4.setTelephone("6625550144");

    Owner owner5 = new Owner();
    owner5.setAddress("42 Main St");
    owner5.setCity("Oxford");
    owner5.setFirstName("Jane");
    owner5.setLastName("Doe");
    owner5.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);
    ownerRepository.save(owner4);
    ownerRepository.save(owner5);
    Integer id = owner3.getId();
    Integer id2 = owner4.getId();
    List<Integer> ids = Arrays.asList(id, id2, owner5.getId());

    // Act
    List<Owner> actualFindAllByIdResult = ownerRepository.findAllById(ids);

    // Assert
    assertEquals(3, actualFindAllByIdResult.size());
    assertSame(owner3, actualFindAllByIdResult.get(0));
    assertSame(owner4, actualFindAllByIdResult.get(1));
    assertSame(owner5, actualFindAllByIdResult.get(2));
  }

  /**
   * Test {@link JpaRepository#findAll(Example)} with {@code example}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findAll(Example)"})
  void testFindAllWithExample() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act
    List<Owner> actualFindAllResult = ownerRepository.findAll(example);

    // Assert
    assertEquals(1, actualFindAllResult.size());
    assertSame(owner, actualFindAllResult.get(0));
  }

  /**
   * Test {@link QueryByExampleExecutor#findAll(Example, Pageable)} with {@code example}, {@code pageable}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page OwnerRepository.findAll(Example, Pageable)"})
  void testFindAllWithExamplePageable() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act
    Page<Owner> actualFindAllResult = ownerRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Owner> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    assertSame(owner, toListResult.get(0));
  }

  /**
   * Test {@link JpaRepository#findAll(Example, Sort)} with {@code example}, {@code sort}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName("Test findAll(Example, Sort) with 'example', 'sort'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findAll(Example, Sort)"})
  void testFindAllWithExampleSort() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act
    List<Owner> actualFindAllResult = ownerRepository.findAll(example, Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    assertSame(owner, actualFindAllResult.get(0));
  }

  /**
   * Test {@link OwnerRepository#findAll(Pageable)} with {@code pageable}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page OwnerRepository.findAll(Pageable)"})
  void testFindAllWithPageable() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    Page<Owner> actualFindAllResult = ownerRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Owner> toListResult = actualFindAllResult.toList();
    assertEquals(12, toListResult.size());
    assertSame(owner, toListResult.get(10));
    assertSame(owner2, toListResult.get(11));
  }

  /**
   * Test {@link ListPagingAndSortingRepository#findAll(Sort)} with {@code sort}.
   * <p>
   * Method under test: {@link OwnerRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.findAll(Sort)"})
  void testFindAllWithSort() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    List<Owner> actualFindAllResult = ownerRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(12, actualFindAllResult.size());
    assertSame(owner, actualFindAllResult.get(10));
    assertSame(owner2, actualFindAllResult.get(11));
  }

  /**
   * Test {@link CrudRepository#count()}.
   * <p>
   * Method under test: {@link OwnerRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long OwnerRepository.count()"})
  void testCount() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act and Assert
    assertEquals(12L, ownerRepository.count());
  }

  /**
   * Test {@link QueryByExampleExecutor#count(Example)} with {@code Example}.
   * <p>
   * Method under test: {@link OwnerRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long OwnerRepository.count(Example)"})
  void testCountWithExample() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act and Assert
    assertEquals(1L, ownerRepository.count(example));
  }

  /**
   * Test {@link CrudRepository#delete(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.delete(Object)"})
  void testDelete() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);

    // Act
    ownerRepository.delete(owner3);

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link CrudRepository#deleteAll()}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteAll()"})
  void testDeleteAll() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    ownerRepository.deleteAll();

    // Assert
    assertTrue(ownerRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteAllById(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteAllById(Iterable)"})
  void testDeleteAllById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");

    Owner owner4 = new Owner();
    owner4.setAddress("42 Main St");
    owner4.setCity("Oxford");
    owner4.setFirstName("Jane");
    owner4.setLastName("Doe");
    owner4.setTelephone("6625550144");

    Owner owner5 = new Owner();
    owner5.setAddress("42 Main St");
    owner5.setCity("Oxford");
    owner5.setFirstName("Jane");
    owner5.setLastName("Doe");
    owner5.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);
    ownerRepository.save(owner4);
    ownerRepository.save(owner5);
    Integer id = owner3.getId();
    Integer id2 = owner4.getId();
    List<Integer> ids = Arrays.asList(id, id2, owner5.getId());

    // Act
    ownerRepository.deleteAllById(ids);

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link JpaRepository#deleteAllByIdInBatch(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteAllByIdInBatch(Iterable)"})
  void testDeleteAllByIdInBatch() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    ownerRepository.deleteAllByIdInBatch(new ArrayList<>());

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link JpaRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteAllInBatch(Iterable)"})
  void testDeleteAllInBatchWithIterable() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");

    Owner owner4 = new Owner();
    owner4.setAddress("42 Main St");
    owner4.setCity("Oxford");
    owner4.setFirstName("Jane");
    owner4.setLastName("Doe");
    owner4.setTelephone("6625550144");

    Owner owner5 = new Owner();
    owner5.setAddress("42 Main St");
    owner5.setCity("Oxford");
    owner5.setFirstName("Jane");
    owner5.setLastName("Doe");
    owner5.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);
    ownerRepository.save(owner4);
    ownerRepository.save(owner5);
    List<Owner> entities = Arrays.asList(owner3, owner4, owner5);

    // Act
    ownerRepository.deleteAllInBatch(entities);

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link CrudRepository#deleteAll(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteAll(Iterable)"})
  void testDeleteAllWithIterable() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");

    Owner owner4 = new Owner();
    owner4.setAddress("42 Main St");
    owner4.setCity("Oxford");
    owner4.setFirstName("Jane");
    owner4.setLastName("Doe");
    owner4.setTelephone("6625550144");

    Owner owner5 = new Owner();
    owner5.setAddress("42 Main St");
    owner5.setCity("Oxford");
    owner5.setFirstName("Jane");
    owner5.setLastName("Doe");
    owner5.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);
    ownerRepository.save(owner4);
    ownerRepository.save(owner5);
    List<Owner> entities = Arrays.asList(owner3, owner4, owner5);

    // Act
    ownerRepository.deleteAll(entities);

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link CrudRepository#deleteById(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteById(Object)"})
  void testDeleteById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act
    ownerRepository.deleteById(owner3.getId());

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link JpaRepository#deleteInBatch(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.deleteInBatch(Iterable)"})
  void testDeleteInBatch() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");

    Owner owner4 = new Owner();
    owner4.setAddress("42 Main St");
    owner4.setCity("Oxford");
    owner4.setFirstName("Jane");
    owner4.setLastName("Doe");
    owner4.setTelephone("6625550144");

    Owner owner5 = new Owner();
    owner5.setAddress("42 Main St");
    owner5.setCity("Oxford");
    owner5.setFirstName("Jane");
    owner5.setLastName("Doe");
    owner5.setTelephone("6625550144");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);
    ownerRepository.save(owner3);
    ownerRepository.save(owner4);
    ownerRepository.save(owner5);
    List<Owner> entities = Arrays.asList(owner3, owner4, owner5);

    // Act
    ownerRepository.deleteInBatch(entities);

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link CrudRepository#existsById(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OwnerRepository.existsById(Object)"})
  void testExistsById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act and Assert
    assertTrue(ownerRepository.existsById(owner3.getId()));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OwnerRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); given Owner (default constructor) Address is '42 Main St'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OwnerRepository.exists(Example)"})
  void testExists_givenOwnerAddressIs42MainSt_thenReturnTrue() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act and Assert
    assertTrue(ownerRepository.exists(example));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OwnerRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OwnerRepository.exists(Example)"})
  void testExists_thenReturnFalse() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("17 High St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act and Assert
    assertFalse(ownerRepository.exists(example));
  }

  /**
   * Test {@link QueryByExampleExecutor#findOne(Example)}.
   * <p>
   * Method under test: {@link OwnerRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OwnerRepository.findOne(Example)"})
  void testFindOne() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    Example<Owner> example = Example.of(owner3);

    // Act
    Optional<Owner> actualFindOneResult = ownerRepository.findOne(example);

    // Assert
    assertTrue(actualFindOneResult.isPresent());
    assertSame(owner, actualFindOneResult.get());
  }

  /**
   * Test {@link JpaRepository#flush()}.
   * <p>
   * Method under test: {@link OwnerRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OwnerRepository.flush()"})
  void testFlush() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act
    ownerRepository.flush();

    // Assert
    List<Owner> findAllResult = ownerRepository.findAll();
    assertEquals(12, findAllResult.size());
    assertSame(owner, findAllResult.get(10));
    assertSame(owner2, findAllResult.get(11));
  }

  /**
   * Test {@link JpaRepository#getById(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#getById(Object)}
   */
  @Test
  @DisplayName("Test getById(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OwnerRepository.getById(Object)"})
  void testGetById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act and Assert
    assertSame(owner3, ownerRepository.getById(owner3.getId()));
  }

  /**
   * Test {@link JpaRepository#getOne(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#getOne(Object)}
   */
  @Test
  @DisplayName("Test getOne(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OwnerRepository.getOne(Object)"})
  void testGetOne() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act and Assert
    assertEquals(1, ownerRepository.getOne(1).getId().intValue());
  }

  /**
   * Test {@link JpaRepository#getReferenceById(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#getReferenceById(Object)}
   */
  @Test
  @DisplayName("Test getReferenceById(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OwnerRepository.getReferenceById(Object)"})
  void testGetReferenceById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act and Assert
    assertSame(owner3, ownerRepository.getReferenceById(owner3.getId()));
  }

  /**
   * Test {@link CrudRepository#save(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OwnerRepository.save(Object)"})
  void testSave() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    // Act and Assert
    assertSame(owner, ownerRepository.save(owner));
  }

  /**
   * Test {@link ListCrudRepository#saveAll(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.saveAll(Iterable)"})
  void testSaveAll() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    List<Owner> entities = Arrays.asList(owner, owner2, owner3);

    // Act and Assert
    assertEquals(entities, ownerRepository.saveAll(entities));
  }

  /**
   * Test {@link JpaRepository#saveAllAndFlush(Iterable)}.
   * <p>
   * Method under test: {@link OwnerRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OwnerRepository.saveAllAndFlush(Iterable)"})
  void testSaveAllAndFlush() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    List<Owner> entities = Arrays.asList(owner, owner2, owner3);

    // Act and Assert
    assertEquals(entities, ownerRepository.saveAllAndFlush(entities));
  }

  /**
   * Test {@link JpaRepository#saveAndFlush(Object)}.
   * <p>
   * Method under test: {@link OwnerRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OwnerRepository.saveAndFlush(Object)"})
  void testSaveAndFlush() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    // Act and Assert
    assertSame(owner, ownerRepository.saveAndFlush(owner));
  }
}
