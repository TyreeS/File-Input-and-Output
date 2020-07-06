
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
public class Employee implements Serializable {
    
    //Instance variables
    private String empNum = " ";
    private double salary;
    
    //Default constructor 
    public Employee(){
        
    }
    
    //Constructor with employee number and salary parameters 
    public Employee(String empNum, double salary){
        this.empNum = empNum;
        this.salary = salary;
    }

    //Encapsulated fields for employee number and salary
    /**
     * @return the empNum
     */
    public String getEmpNum() {
        return empNum;
    }

    /**
     * @param empNum the empNum to set
     */
    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    //toString method to print contents of the object 
    @Override
    public String toString(){
        return String.format("Employee Number: %s Employee Salary: %.2f Employee Rank: %s\n", empNum, salary, empRank(salary));
    }
    
    //empRank method returning a String for finding employee rank 
    public String empRank(double salary){
        
        String rank = " ";
        
        if(getSalary() <= 6000){
            rank = "Junior Staff";
        }
        if(getSalary() >6000 && getSalary() < 15000){
            rank = "Senior Staff";
        }
        if(getSalary() >= 15000){
            rank = "Manager";
        }
        return rank;
        
    }
    
}
