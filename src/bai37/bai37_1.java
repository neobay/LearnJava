package bai37;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class bai37_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "EMP.TXT";
        File file = new File("F:\\LearnJava\\src\\bai37\\EMP.TXT");
        int choice = 0;
        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(readFromFile(fileName));
        var prevNumOfEmp = employees.size();

        do {
            System.out.println("==========================MENU============================");
            System.out.println("1. Thêm mới một nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tìm nhân viên theo tên");
            System.out.println("4. Xoá nhân viên theo mã cho trước");
            System.out.println("5. Lưu danh sách nhân viên vào file");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Tạm biệt");
                    break;
                case 1:
                    var emp = createNewEmployee(input);
                    //employees.add(emp);
                    if (prevNumOfEmp > 0){
                        setNextId(employees.get(prevNumOfEmp - 1).getId());
                    }
                    emp.setId(emp.getId());
                    employees.add(emp);
                    //setNextId(employees.get(prevNumOfEmp - 1).getId());
                    break;
                case 2:
                    showEmployees(employees);
                    break;
                case 3:
                    if (employees.size() > 0){
                        var name = "";
                        System.out.printf("Nhập tên nhân viên cần tìm: ");
                        name = input.next();
                        var result = searchByName(employees, name);
                        if (result.size() > 0){
                            System.out.println("Tìm thấy " + result.size() + " kết quả");
                            showEmployees(result);
                        }else {
                            System.out.println("Không tìm thấy nhân viên nào tên \"" + name +
                                    "\"");
                        }

                    }else {
                        System.out.println("Danh sách nhân viên rỗng");
                    }
                    break;
                case 4:
                    if (employees.size() > 0){
                        System.out.printf("Nhập mã nhân viên cần xoá: ");
                        var id = input.nextLine();
                        var isDeleted = removeEmp(employees, id);
                    }
                    break;
                case 5:
                    if (employees.size() > 0){
                        var isSuccess = writeToFile(employees, fileName);
                        if (isSuccess){
                            System.out.println("Ghi thành công");
                        }else {
                            System.out.println("Ghi thất bại");
                        }
                    }else {
                        System.out.println("Danh sách rỗng!");
                    }
                    break;
            }
        }while (choice != 0);
    }

    private static boolean writeToFile(ArrayList<Employee> employees, String fileName) {
        var currentInFile = readFromFile(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileName);
            for (int i = 0; i < employees.size(); i++) {
                var emp = employees.get(i);
                if (!isExisted(currentInFile, emp)){
                        printWriter.println(emp.getId());
                        printWriter.println(emp.getFullName());
                        printWriter.println(emp.getAddress());
                        printWriter.println(emp.getAge());
                        printWriter.println(emp.getPhoneNumber());
                        printWriter.println(emp.getSalary());
                        printWriter.println(emp.getExperience());
                }
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean isExisted(ArrayList<Employee> currentInFile, Employee emp) {
        for (var item: currentInFile) {
            if (item.getId().compareTo(emp.getId()) == 0){
                return true;
            }
        }
        return false;
    }

    private static boolean removeEmp(ArrayList<Employee> employees, String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().compareTo(id) == 0){
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Employee> searchByName(ArrayList<Employee> employees, String name) {
        var res = new ArrayList<Employee>();
        for (var emp: employees) {
            var firstName = getFirstName(emp.getFullName());
            if (firstName.compareToIgnoreCase(name) == 0){
                res.add(emp);
            }
        }
        return res;
    }

    private static String getFirstName(String fullName) {
        var index = fullName.lastIndexOf(" ");
        var firstName = fullName.substring(index + 1);
        return firstName;
    }


    private static void showEmployees(ArrayList<Employee> employees) {
       if (employees.size() > 0){
           System.out.println("==>Danh sách nhân viên<==");
           System.out.printf("%-12s%-25s%-15s%-10s%-15s%-15s%-15s\n",
                   "Mã NV", "Tên NV", "Địa chỉ", "Tuổi",
                    "Số ĐT", "Lương", "Kinh nghiệm");
           for (var emp: employees) {
               showEmp(emp);
           }
       }else {
           System.out.println("Danh sách nhân viên rỗng");
       }
    }

    private static void showEmp(Employee emp) {
        System.out.printf("%-12s%-25s%-15s%-10d%-15s%-15.2f%-15.2f\n",
                emp.getId(), emp.getFullName(), emp.getAddress(),
                emp.getAge(), emp.getPhoneNumber(), emp.getSalary(),
                emp.getExperience());
    }

    private static Employee createNewEmployee(Scanner input) {
        System.out.printf("Nhập tên nhân viên: ");
        var fullName = input.nextLine();
        System.out.printf("Địa chỉ: ");
        var address = input.nextLine();
        System.out.printf("Số điện thoại: ");
        var phoneNumber = input.nextLine();
        System.out.printf("Tuổi: ");
        int age = input.nextInt();
        System.out.printf("Mức lương: ");
        var salary = input.nextFloat();
        System.out.printf("Số năm kinh nghiệm: ");
        var exp = input.nextFloat();
        return new Employee(null, fullName, address, age, phoneNumber, salary, exp);
    }

    private static void setNextId(String id) {
        var nextIdStr = id.substring(3);
        var nextIdInt = Integer.parseInt(nextIdStr);
        Employee.setNextId(nextIdInt + 1);
    }

    private static ArrayList<Employee> readFromFile(String fileName) {
        ArrayList employees = new ArrayList<>();
        File file = new File("F:\\LearnJava\\src\\bai37\\EMP.TXT");
        //file.createNewFile();
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNextLine()) {
            var id = input.nextLine();
            var fullName = input.nextLine();
            var address = input.nextLine();
            var age = Integer.parseInt(input.nextLine());
            var phoneNumber = input.nextLine();
            var salary = Float.parseFloat(input.nextLine());
            var experience = Float.parseFloat(input.nextLine());
            Employee employee = new Employee(id, fullName, address, age, phoneNumber,
                    salary, experience);
            employees.add(employee);
        }
        input.close();
        return employees;
    }
}
