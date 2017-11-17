/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;


import javax.ejb.Local;
import java.util.List;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Emil-Ruud
 */

@Local
public interface FilesManagerLocal {
    File getFile(String mergedNrEmail);
    List getListFromQuery(String query, Class<File> fileClass);
    Query createQuery(String query);
    boolean saveFile(File file);
    boolean updateFile(File file, HttpServletRequest request, HttpServletResponse response);
}