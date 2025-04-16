package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PetTypeFormatter.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class PetTypeFormatterDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private PetTypeFormatter petTypeFormatter;

  /**
   * Test {@link PetTypeFormatter#print(PetType, Locale)} with {@code PetType}, {@code Locale}.
   * <p>
   * Method under test: {@link PetTypeFormatter#print(PetType, Locale)}
   */
  @Test
  @DisplayName("Test print(PetType, Locale) with 'PetType', 'Locale'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PetTypeFormatter.print(PetType, Locale)"})
  void testPrintWithPetTypeLocale() {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    // Act and Assert
    assertEquals("Dog", petTypeFormatter.print(petType, Locale.getDefault()));
  }

  /**
   * Test {@link PetTypeFormatter#parse(String, Locale)}.
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Id is one.</li>
   *   <li>Then return {@link PetType} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  @DisplayName("Test parse(String, Locale); given PetType (default constructor) Id is one; then return PetType (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PetType PetTypeFormatter.parse(String, Locale)"})
  void testParse_givenPetTypeIdIsOne_thenReturnPetType() throws ParseException {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    ArrayList<PetType> petTypeList = new ArrayList<>();
    petTypeList.add(petType);
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    PetType actualParseResult = petTypeFormatter.parse("Dog", Locale.getDefault());

    // Assert
    verify(ownerRepository).findPetTypes();
    assertSame(petType, actualParseResult);
  }

  /**
   * Test {@link PetTypeFormatter#parse(String, Locale)}.
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Id is two.</li>
   *   <li>Then return {@link PetType} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  @DisplayName("Test parse(String, Locale); given PetType (default constructor) Id is two; then return PetType (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PetType PetTypeFormatter.parse(String, Locale)"})
  void testParse_givenPetTypeIdIsTwo_thenReturnPetType() throws ParseException {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setId(2);
    petType2.setName("Bella");

    ArrayList<PetType> petTypeList = new ArrayList<>();
    petTypeList.add(petType2);
    petTypeList.add(petType);
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    PetType actualParseResult = petTypeFormatter.parse("Dog", Locale.getDefault());

    // Assert
    verify(ownerRepository).findPetTypes();
    assertSame(petType, actualParseResult);
  }

  /**
   * Test {@link PetTypeFormatter#parse(String, Locale)}.
   * <ul>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  @DisplayName("Test parse(String, Locale); then throw ParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PetType PetTypeFormatter.parse(String, Locale)"})
  void testParse_thenThrowParseException() throws ParseException {
    // Arrange
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(ParseException.class, () -> petTypeFormatter.parse("Dog", Locale.getDefault()));
    verify(ownerRepository).findPetTypes();
  }
}
