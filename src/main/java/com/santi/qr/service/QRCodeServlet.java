/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santi.qr.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.santi.qr.model.Muestrario;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.nio.file.Files.size;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
 
public class QRCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String rutaqr="//home/santi//NetBeansProjects//proyectomk//imagenesqr//"+request.getParameter("proveedor")+"//"+request.getParameter("tipo");
        File qrFile = new File(rutaqr);
        qrFile.mkdirs();
        // Create the ByteMatrix for the QR-Code that encodes the given String
        Hashtable hintMap = new Hashtable();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = null;
        String variable = request.getParameter("ruta");
        try {
            byteMatrix = qrCodeWriter.encode(variable,BarcodeFormat.QR_CODE, 125, 125, hintMap);
        } catch (WriterException ex) {
            Logger.getLogger(QRCodeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Make the BufferedImage that are to hold the QRCode
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,
                BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
 
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // Paint and save the image using the ByteMatrix
        graphics.setColor(Color.BLACK);
 
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, "png", qrFile);
        response.sendRedirect("http://localhost:8084/proyectomk/muestrarios");
    }
}