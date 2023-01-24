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
import pojo.Adminlogin;
import pojo.leejoUtil;

@ManagedBean
@SessionScoped
public class DAOAdmin {
    public List<Adminlogin> getBy(String uName, String uPass){
        Transaction trans = null;
        Adminlogin us = new Adminlogin();
        List<Adminlogin> user = new ArrayList();
        Session session = leejoUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Adminlogin where username=:uName AND password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (Adminlogin) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
