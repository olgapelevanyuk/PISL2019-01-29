package by.it.group673602.chernyak.laboratory05.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "userdata", schema = "test_db")
public class UserdataEntity {
    private int userDataId;
    private String userName;
    private String secondName;
    private String lastName;
    private String phoneNum;
    private Date birthday;
    private byte gender;
    private String passportSeria;
    private String passportNum;
    private String identicationNum;
    private Serializable passportWhoGive;
    private Date passportGiveDate;
    private Serializable livingCity;
    private Serializable address;
    private String homePhone;
    private String email;
    private Serializable citizenship;

    @Id
    @Column(name = "UserDataId")
    public int getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(int userDataId) {
        this.userDataId = userDataId;
    }

    @Basic
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "SecondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "PhoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "Birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Gender")
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "PassportSeria")
    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    @Basic
    @Column(name = "PassportNum")
    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @Basic
    @Column(name = "IdenticationNum")
    public String getIdenticationNum() {
        return identicationNum;
    }

    public void setIdenticationNum(String identicationNum) {
        this.identicationNum = identicationNum;
    }

    @Basic
    @Column(name = "PassportWhoGive")
    public Serializable getPassportWhoGive() {
        return passportWhoGive;
    }

    public void setPassportWhoGive(Serializable passportWhoGive) {
        this.passportWhoGive = passportWhoGive;
    }

    @Basic
    @Column(name = "PassportGiveDate")
    public Date getPassportGiveDate() {
        return passportGiveDate;
    }

    public void setPassportGiveDate(Date passportGiveDate) {
        this.passportGiveDate = passportGiveDate;
    }

    @Basic
    @Column(name = "LivingCity")
    public Serializable getLivingCity() {
        return livingCity;
    }

    public void setLivingCity(Serializable livingCity) {
        this.livingCity = livingCity;
    }

    @Basic
    @Column(name = "Address")
    public Serializable getAddress() {
        return address;
    }

    public void setAddress(Serializable address) {
        this.address = address;
    }

    @Basic
    @Column(name = "HomePhone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Citizenship")
    public Serializable getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Serializable citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserdataEntity that = (UserdataEntity) o;
        return userDataId == that.userDataId &&
                gender == that.gender &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNum, that.phoneNum) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(passportSeria, that.passportSeria) &&
                Objects.equals(passportNum, that.passportNum) &&
                Objects.equals(identicationNum, that.identicationNum) &&
                Objects.equals(passportWhoGive, that.passportWhoGive) &&
                Objects.equals(passportGiveDate, that.passportGiveDate) &&
                Objects.equals(livingCity, that.livingCity) &&
                Objects.equals(address, that.address) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(citizenship, that.citizenship);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userDataId, userName, secondName, lastName, phoneNum, birthday, gender, passportSeria, passportNum, identicationNum, passportWhoGive, passportGiveDate, livingCity, address, homePhone, email, citizenship);
    }
}
