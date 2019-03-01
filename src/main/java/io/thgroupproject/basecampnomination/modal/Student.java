package io.thgroupproject.basecampnomination.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
    public UUID id;

    @NotNull
    @Size(min = 1, max= 20)
    public String StudentName;
    @NotNull
    @Size(min = 1, max = 20)
    public String SchoolDistrict;
    @NotNull
    public Integer Age;
    @NotNull
    public  String Email;
    @NotNull
    public String PhoneNumber;
    @NotNull
    public Date gradDate;
    @NotNull
    @Size(min = 5)
    public String Aptitude;
    @NotNull
    @Size(min = 5)
    public String workEthic;
    @NotNull
    @Size(min = 5)
    public String passion;
    @NotNull
    public Date interviewDate;

    public void setAge(Integer age) {
        if (age == null) {
            Age = 18;
        }
    }

    public void setGradDate(String dateString) {

        try {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = df.parse(dateString);

            gradDate = today;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

//    public void setPhoneNumber(String phone) {
//        if (validatePhoneNumber(phone)) {
//            PhoneNumber = phone;
//        } else {
//            PhoneNumber = "phone";
//        }
//    }

    public void setInterviewDate(String dateString) {

        try {
            String pattern = "yyyy-MM-dd";
            DateFormat intDate = new SimpleDateFormat(pattern);
            Date meeting = intDate.parse(dateString);

            interviewDate = meeting;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

//    public static boolean validatePhoneNumber(String phoneNumber){
//        if (phoneNumber.matches("\\d{10}") | phoneNumber.matches("\\d{7}")){
//            return true;
//        }else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")){
//            return true;
//        }else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x| (ext))\\d{3,5}")) {
//            return true;
//        } else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
//            return true;
//        } else {
//            return false;
//        }
//    }



    public Student(UUID id, String StudentName, String schoolDistrict, int age, String email, String phoneNumber, Date gradDate, String Apptitude, String workEthic, String passion, Date interviewDate) {

        this.id = id;
        this.StudentName = StudentName;
        this.SchoolDistrict = schoolDistrict;
        this.Age = age;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.gradDate = gradDate;
        this.Aptitude = Apptitude;
        this.workEthic = workEthic;
        this.passion = passion;
        this.interviewDate = interviewDate;

    }

    public String preview(String text) {
        if (text.length() < 100) {
            return text;
        } else {
            return text.substring(0,97) + "...";
        }
    }

    public String[] paragraphs(String text) {
        return text.split("\n");
    }
}
