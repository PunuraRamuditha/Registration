import java.sql.*;

public class ConStudent {
    public static Connection connect(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registrations", "root", null);
            Statement sDB = conn.createStatement();
            sDB.execute("Create Table if not exists Student_details(StudentID int primary key auto_increment, Student_Fname varchar(300),Student_Lname varchar(300),Student_Email varchar(300),Student_Contact int)");
            sDB.execute("Create Table if not exists Student_Course(StudentID int, CourseID int , constraint FK_Student_Course foreign key(StudentID,CourseID) references Student_details(StudentID,CourseID))");
            
            System.out.println(conn);
            sDB.close();
            
        }
        catch (Exception e){
            System.out.println("inter.DBConnect.connect()");
        }
        return conn;
    
}

}