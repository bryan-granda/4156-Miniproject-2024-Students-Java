package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit testing for the RouteController Class.
 */
@SpringBootTest
@ContextConfiguration
public class RouteControllerTests {

  @BeforeAll
  public static void setupDepartmentForTesting() {
    testFileDatabase = new MyFileDatabase(0, "./data.txt");
    testRouteController = new RouteController();
    testDepartments = testFileDatabase.getDepartmentMapping();
    testDepartment = testDepartments.get("COMS");
  }

  @Test
  public void indexTest() {
    String expected = "Welcome, in order to make an API call direct your browser or Postman to an endpoint "
        + "\n\n This can be done using the following format: \n\n http:127.0.0"
        + ".1:8080/endpoint?arg=value";

    assertEquals(expected, testRouteController.index());
  }

  @Test
  public void retrieveDepartmentTest() {
    ResponseEntity<?> res = testRouteController.retrieveDepartment("COMS");
    String body = res.getBody().toString();
    HttpStatusCode status = res.getStatusCode();
    assertEquals("COMS", body);
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void retrieveCourseTest() {
    ResponseEntity<?> res = testRouteController.retrieveCourse("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void isCourseFullTest() {
    ResponseEntity<?> res = testRouteController.isCourseFull("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void getMajorCountFromDeptTest() {
    ResponseEntity<?> res = testRouteController.getMajorCtFromDept("COMS");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void identifyDeptChairTest() {
    ResponseEntity<?> res = testRouteController.identifyDeptChair("COMS");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void findCourseLocationTest() {
    ResponseEntity<?> res = testRouteController.findCourseLocation("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void findCourseInstructorTest() {
    ResponseEntity<?> res = testRouteController.findCourseInstructor("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void findCourseTimeTest() {
    ResponseEntity<?> res = testRouteController.findCourseTime("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void addMajorToDeptTest() {
    ResponseEntity<?> res = testRouteController.addMajorToDept("COMS");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void removeMajorFromDeptTest() {
    ResponseEntity<?> res = testRouteController.removeMajorFromDept("CHEM");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void dropStudentTest() {
    ResponseEntity<?> res = testRouteController.dropStudent("COMS", 1004);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);

    String actual = res.getBody().toString();
    String expected = "Student has been dropped.";
    assertEquals(expected, actual);
  }

  @Test
  public void setEnrollmentCountTest() {
    ResponseEntity<?> res = testRouteController.setEnrollmentCount("COMS", 1004, 300);
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void changeCourseTimeTest() {
    ResponseEntity<?> res = testRouteController.changeCourseTime("COMS", 1004, "10:10-11:25");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void changeCourseTeacherTest() {
    ResponseEntity<?> res = testRouteController.changeCourseTeacher("CHEM", 1403, "Bryan Granda");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }

  @Test
  public void changeCourseLocationTest() {
    ResponseEntity<?> res = testRouteController.changeCourseLocation("CHEM", 1403, "401 URI");
    HttpStatusCode status = res.getStatusCode();
    assertEquals(HttpStatus.OK, status);
  }


 /** The routeController instances used for testing. */
  public static MyFileDatabase testFileDatabase;
  public static RouteController testRouteController;
  public static Department testDepartment;
  public static HashMap<String, Department> testDepartments;
}
