/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.BookData;
import pojo.leejoUtil;

/**
 *
 * @author khofi
 */
@ManagedBean
@SessionScoped
public class DAOBook {
    public List<BookData> retriveBookData(){
        List stud = new ArrayList();
        BookData stud1 = new BookData();
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from BookData");
            stud = query.list();
            stud.add(stud1.getIdBook());
            stud.add(stud1.getIcNumber());
            stud.add(stud1.getFullName());
            stud.add(stud1.getEmail());
            stud.add(stud1.getCheckin());
            stud.add(stud1.getCheckout());
            stud.add(stud1.getRoom());
            stud.add(stud1.getGender());
            stud.add(stud1.getNight());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    public List<BookData> getByID(String uID){
        BookData book = new BookData();
        List<BookData> iBook = new ArrayList();
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from BookData where id_book =:id");
            query.setString("id", uID);
            book = (BookData) query.uniqueResult();
            iBook = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iBook;
    }
    public void deleteBook(Integer uID){
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            BookData book = (BookData) session.load(BookData.class, new Integer(uID));
            session.delete(book);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateBook(BookData book){
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(book);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void editBook(BookData book){
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(book);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addBook(BookData book){
        Transaction trans = null;
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(book);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
