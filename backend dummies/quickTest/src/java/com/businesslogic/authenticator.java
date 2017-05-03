
package com.controller.quickTest;
import com.model.quickTest.dbManager;
import com.model.quickTest.password;
import com.model.quickTest.teacher;
import java.security.MessageDigest;

/**
 *
 * @author RAJAT
 */
public class authenticator {
    
    
    private String encrypt(String password)
    {
       try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();
        StringBuilder sb = new StringBuilder();
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

    public int authenticateTeacher(String user , String rawpassword)
    {
        dbManager obj = new dbManager();
        teacher tobj = obj.teacher_search(user);
        if(tobj == null)
            return 0;
        password pobj = new password();
        pobj.loadDataFromDB(obj.getConnector(), tobj.getID());
        System.out.println(encrypt(rawpassword)+"\n");
        System.out.println(pobj.getPass()+"\n");
        if( encrypt(rawpassword).equals(pobj.getPass()))
            return tobj.getID();
        return -1;
    }
    
}
