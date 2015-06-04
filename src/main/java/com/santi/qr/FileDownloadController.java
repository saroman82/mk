/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santi.qr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.io.IOUtils;    // Apache commons IO
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
 
public class FileDownloadController implements Controller {
 
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        try {
        
            String nombreFichero = "rustico.png";
            String unPath = "/home/santi/NetBeansProjects/proyectomk/imagenesqr/91";
 
            response.setContentType("image/png");

            InputStream is = new FileInputStream(unPath+nombreFichero);
             
            IOUtils.copy(is, response.getOutputStream());
             
            response.flushBuffer();
             
        } catch (IOException ex) {
            // Sacar log de error.
            throw ex;
        }
         
        return null;
    }
}
