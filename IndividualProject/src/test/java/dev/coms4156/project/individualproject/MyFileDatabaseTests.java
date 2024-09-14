package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit testing for the MyFileDatabase Class.
 */
@SpringBootTest
@ContextConfiguration
public class MyFileDatabaseTests {

  /**
 * Instances a test Department and Database file object to use for testing.
 */
  @BeforeAll
  public static void dataBaseSetupTest() {
    testDatabase = new MyFileDatabase(0, "./data.txt");
    assertNotNull(testDatabase);

    String[] times = { "11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55" };
    String[] locations = { "417 IAB", "309 HAV", "301 URIS" };

    // data for coms dept
    Course coms1004 = new Course("Adam Cannon", locations[0], times[0], 400);
    coms1004.setEnrolledStudentCount(249);
    Course coms3134 = new Course("Brian Borowski", locations[2], times[1], 250);
    coms3134.setEnrolledStudentCount(242);
    Course coms3157 = new Course("Jae Lee", locations[0], times[1], 400);
    coms3157.setEnrolledStudentCount(311);
    Course coms3203 = new Course("Ansaf Salleb-Aouissi", locations[2], times[2], 250);
    coms3203.setEnrolledStudentCount(215);
    Course coms3261 = new Course("Josh Alman", locations[0], times[3], 150);
    coms3261.setEnrolledStudentCount(140);
    Course coms3251 = new Course("Tony Dear", "402 CHANDLER", "1:10-3:40", 125);
    coms3251.setEnrolledStudentCount(99);
    Course coms3827 = new Course("Daniel Rubenstein", "207 Math", times[2], 300);
    coms3827.setEnrolledStudentCount(283);
    Course coms4156 = new Course("Gail Kaiser", "501 NWC", times[2], 120);
    coms4156.setEnrolledStudentCount(109);
    Map<String, Course> courses = new HashMap<>();
    courses.put("1004", coms1004);
    courses.put("3134", coms3134);
    courses.put("3157", coms3157);
    courses.put("3203", coms3203);
    courses.put("3261", coms3261);
    courses.put("3251", coms3251);
    courses.put("3827", coms3827);
    courses.put("4156", coms4156);
    Department compSci = new Department("COMS", courses, "Luca Carloni", 2700);
    testMapping = new HashMap<>();
    testMapping.put("COMS", compSci);
  }

  @Test
  @Order(1)
  public void setMappingTest() {
    testDatabase.setMapping(testMapping);

    assertSame(testDatabase.getDepartmentMapping(), testMapping);
  }

  @Test
  @Order(2)
  public void toStringTest() {
    StringBuilder concat = new StringBuilder();
    for (Map.Entry<String, Department> entry : testMapping.entrySet()) {
      String key = entry.getKey();
      Department value = entry.getValue();
      concat.append("For the ").append(key).append(" department: \n").append(value.toString());
    }

    testDatabase.setMapping(testMapping);
    String expected = concat.toString();
    String actual = testDatabase.toString();

    assertEquals(expected, actual);
  }


  public static MyFileDatabase testDatabase;
  public static Map<String, Department> testMapping;
}
