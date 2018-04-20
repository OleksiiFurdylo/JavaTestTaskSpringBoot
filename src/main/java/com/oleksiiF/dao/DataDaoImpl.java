package com.oleksiiF.dao;

import com.oleksiiF.model.Data;
import com.oleksiiF.model.DataTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by OleksiiF on 20.04.2018.
 */
@Repository
public class DataDaoImpl implements DataDao{

    File file = new File("datadb.db");
    String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
    Connection conn;


    public DataDaoImpl() throws IOException, SQLException {
        conn = DriverManager.getConnection(url);
    }


   public String putToDB(Data data){
       PreparedStatement st;

        try {
           for(DataTemplate d: data.getData()) {
               st = conn.prepareStatement("INSERT INTO data(hash, format, url, " +
                       "title, documentOf, datePublished, dateModified, id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

               st.setString(1, d.getHash());
               st.setString(2, d.getFormat());
               st.setString(3, d.getUrl());
               st.setString(4, d.getTitle());
               st.setString(5, d.getDocumentOf());
               st.setString(6, d.getDatePublished());
               st.setString(7, d.getDateModified());
               st.setString(8, d.getId());

               st.executeUpdate();
           }
           //st.close();

       } catch (SQLException e) {
           e.printStackTrace();
           return e.getMessage();
       }

       return "inserted successfully";
   }


}
