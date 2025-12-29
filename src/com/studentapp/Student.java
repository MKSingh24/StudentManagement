package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {

        if(validateAge(age) && validateName(name) && validateStudentId(studentId)){
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        courses=new ArrayList<String>(); //Intialization of courses
    }
    }
    //Getter


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public  void enrollCourse(String course){
        if(validateCourse(course)){ //first validate course is in JAVA DSA Devops
        if(!courses.contains(course)){ //then validate course is not present in list then add course
            courses.add(course);
            System.out.println(" Student is Enrolled to " + course + " Successfully!!");
        }else{
            System.err.println("Student Already Enrolled to the course: "+course);
        }
        }
    }



    public void printStudentInfo(){
        System.out.println("========Student Information========");
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("Student ID: "+studentId);
        System.out.println("Enrolled for: "+courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    //Validation method

    public boolean validateAge(int age){
        if(age>=19 && age<=35){
            return true;
        }else{
            System.err.println("Invalid Age!!! Student age need to be between 19-35");
            return false;
        }
    }

    public  boolean validateName(String name){
//        String namePattern="^[a-z]";  // if letter is  small mukesh
//          String namePattern="^[a-zA-Z]";  // if letter is  lower/upper -MukEsH

        String nameRegex="^[a-zA-Z\\s]+$";  // space between fname and lastname
        Pattern namepattern=Pattern.compile(nameRegex);
        Matcher namematcher=namepattern.matcher(name);
        if(namematcher.matches()){
            return  true;
        }else {
            System.err.println("Invalid Name!! Please Enter Alphabet Only!!");
            return false;
        }
    }
    public boolean validateStudentId(String studentId){
        String studentIdRegex="^S[0-9]+$";
        Pattern studentIdpattern=Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher= studentIdpattern.matcher(studentId);
        if(studentIdMatcher.matches()){
            return true;
        }else{
            System.err.println("Invalid StudentID!! Please Enter valid StudentId as S123 ");
            return false;
        }
    }

    public boolean validateCourse(String course){
        if(course.equalsIgnoreCase("JAVA") || course.equalsIgnoreCase("DSA")|| course.equalsIgnoreCase("Devops")){
            return true;
        }else{
            System.err.println("Invalid course!! Please Enter valid course from list [java,DSA,Devops] ");
            return false;
        }
    }
}
