package pojo;
// Generated Oct 14, 2022 2:08:15 AM by Hibernate Tools 4.3.1

import DAO.DAOBook;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




/**
 * BookData generated by hbm2java
 */
@ManagedBean
@SessionScoped
public class BookData implements java.io.Serializable {


    private Integer idBook;
    private String checkout;
    private String checkin;
    private String email;
    private String icNumber;
    private String gender;
    private String night;
    private String room;
    private String fullName;

    public List<BookData>getRecords(){
        DAOBook book = new DAOBook();
        List<BookData> lBook = book.retriveBookData();
        return lBook;
    }
    public String getById(){
        String id_book = idBook.toString();
        DAOBook book = new DAOBook();
        List<BookData> lbook = book.getByID(id_book);
        checkout = lbook.get(0).checkout;
        checkin = lbook.get(0).checkin;
        email = lbook.get(0).email;
        icNumber = lbook.get(0).icNumber;
        gender = lbook.get(0).gender;
        night = lbook.get(0).night;
        room = lbook.get(0).room;
        fullName = lbook.get(0).fullName;
        return "admindash";
    }
    
    public void edit(){
        DAOBook book = new DAOBook();
        book.editBook(this);
        checkout = "";
        checkin = "";
        email = "";
        icNumber = "";
        gender = "";
        night = "";
        room = "";
        fullName = "";
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berhasil Update Data", null);
    }
    public void delete(){
        DAOBook book = new DAOBook();
        book.deleteBook(idBook);
        checkout = "";
        checkin = "";
        email = "";
        icNumber = "";
        gender = "";
        night = "";
        room = "";
        fullName = "";
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berhasil Delete Data", null);
    }
    public void save(){
        DAOBook add = new DAOBook();
        add.addBook(this);
    }
    
    public BookData() {
    }

    public BookData(String checkout, String checkin, String email, String icNumber, String gender, String night, String room, String fullName) {
       this.checkout = checkout;
       this.checkin = checkin;
       this.email = email;
       this.icNumber = icNumber;
       this.gender = gender;
       this.night = night;
       this.room = room;
       this.fullName = fullName;
    }
   
    public Integer getIdBook() {
        return this.idBook;
    }
    
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
    public String getCheckout() {
        return this.checkout;
    }
    
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public String getCheckin() {
        return this.checkin;
    }
    
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIcNumber() {
        return this.icNumber;
    }
    
    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNight() {
        return this.night;
    }
    
    public void setNight(String night) {
        this.night = night;
    }
    public String getRoom() {
        return this.room;
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }




}


