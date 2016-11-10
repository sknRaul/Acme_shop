/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import jdda.ConnectionDB;
/**
 *
 * @author panda
 */
public class ModelMain {
    public ConnectionDB con = new ConnectionDB();
    
    public void generate(String address){
        try {
            JasperReport report = JasperCompileManager.compileReport(address);
            System.out.printf("Archivo cargado");
            JasperPrint viewReport = JasperFillManager.fillReport(report, null, con.Connection("acme_shop", "root", "1234"));
            System.out.printf("Archivo llenado");
            JasperViewer.viewReport(viewReport);
            System.out.printf("Mostrando archivo");
        } catch (Exception e) {
            System.err.printf("Error al generar el reporte");
        }
    }
}
