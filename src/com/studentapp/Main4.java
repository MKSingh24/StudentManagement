package com.studentapp;

import java.util.*;

public class Main4 {

    private static List<Student> studentList;
    private static Scanner scanner;
    public  static void main(String[] args){

        System.out.println("***********STUDENT MANAGEMENT SYSTEM**********");

        studentList=new ArrayList<Student>();
        scanner=new Scanner(System.in);
        while (true){
            System.out.println("***********WELCOME**********");
        System.out.println("Select an option...");
        System.out.println("1. Register a Student");
        System.out.println("2. Find Student BY studentID");
        System.out.println("3. List All Student Information");
        System.out.println("4. List Student Information in sorted Order");
        System.out.println("5. Exit");

        int option=scanner.nextInt();
        switch (option){
            case 1:
                enrolledStudent(scanner);
                break;
            case 2:
                findStudentByID(scanner);
                break;
            case 3:
                printAllStudentData();
                break;
            case 4:
                sortByName();
                break;
            case 5:
                exit();
            default:
                System.out.println("Invalid option Selected...Please Enter between 1-5");
        }
        }
    }

    private static void exit() {
        System.out.println("***********THANK YOU***********");
        System.exit(0);
    }

    private static void printAllStudentData() {
        if(!studentList.isEmpty()){
        System.out.println("-------Print ALL Student Data-------");
        for(Student student:studentList){
            student.printStudentInfo();
        }

        }else{
            System.err.println("Student List is Empty!! No Record Found");
        }
    }

    private static void findStudentByID(Scanner scanner) {
        Student studentFound = null;
        System.out.println(" Enter the student id");
        String studentId=scanner.next();
        try{
            studentFound=studentList.stream().filter(student -> student.getStudentId()
                        .equalsIgnoreCase(studentId)).findFirst()
                .orElseThrow(()-> new RuntimeException(studentId+" Not Found"));
        }catch (RuntimeException e){
            System.err.println("Student with ID "+studentId+ " Not Found");
        }
        studentFound.printStudentInfo();
    }

    private static void enrolledStudent(Scanner scanner) {
        System.out.println("Enter Student name");
        String studentName=scanner.next();
        System.out.println("Enter Student Age");
        int studentAge=scanner.nextInt();
        System.out.println("Enter Student ID");
        String studentID=scanner.next();

        Student newStudent=new Student(studentName,studentAge,studentID);
        studentList.add(newStudent);
        while(true){
        System.out.println("Student Enter the course to be Enrolled");
        String courseName=scanner.next();
        if(courseName.equalsIgnoreCase("done")){
            break;
        }
        newStudent.enrollCourse(courseName);
        }
        newStudent.printStudentInfo();
    }


    //implement Comparator
    private static void sortByName() {
//        Comparator<Student> studentNameComparator=new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
        Comparator<Student> studentNameComparator=( o1,o2)->o1.getName().compareTo(o2.getName());
        Collections.sort(studentList,studentNameComparator);
        System.out.println(studentList);
        printAllStudentData();
    }
}
