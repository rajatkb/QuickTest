/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbmanagement;

import java.security.MessageDigest;

/**
 *
 * @author Rajat
 */
public class password {
    
    private int id;
    private String password;
    
    private String encrypt(String password)
    {
       try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        password = sb.toString();
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
        return password;
    }
    /*
        The encrypt method needs to be implemeneted
    */
    public void setData( int id , String rawPassword )
    {
        this.id = id;
        this.password = encrypt(rawPassword);
    }
    
    public void viewData()
    {
        System.out.println(this.id);
        System.out.println(this.password);
    }
    
    public String getPass()
    {
        return this.password;
    }
}
