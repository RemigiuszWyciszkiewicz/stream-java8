package tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

import app.model.Address;
import app.model.MobileNumber;
import app.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MyTests {

    Student student1 = new Student(
            "Jayesh",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

    Student student2 = new Student(
            "Khyati",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

    Student student3 = new Student(
            "Jason",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

    List<Student> studentList = Arrays.asList(student1, student2, student3);

    @Test
    void getStudentWithSpecificName() {

        Student student = studentList.stream().filter(st -> st.getName().equals("Jayesh")).findFirst().get();

        assertThat(student.getName(),is("Jayesh"));

    }

    @Test
    void getstudentWithMachingAddress() {
       Student student = studentList.stream().filter(st -> st.getAddress().getZipcode().contains("1235")).findFirst().get();

        assertThat(student.getAddress().getZipcode(),is("1235"));
    }

    @Test
    void studentsWithNumber3333()
    {
        List<Student> studentWithMatchingnumber = studentList.stream()
                .filter(student -> student.getMobileNumbers()
                        .stream()
                        .anyMatch(mobileNumber -> mobileNumber.getNumber().equals("3333")))
                .collect(Collectors.toList());


        assertAll(
                () -> assertThat(studentWithMatchingnumber,hasSize(2)),
                () -> assertThat(studentWithMatchingnumber.get(1).getName(),is("Jason")));

    }

    @Test
    void studentWithNumber1233and1234() {
        List<Student> students = 
    }





}
