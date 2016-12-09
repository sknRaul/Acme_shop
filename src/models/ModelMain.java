/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import jdda.ConnectionDB;
import views.ViewMain;
/**
 *
 * @author panda
 */
public class ModelMain {
    public ConnectionDB con = new ConnectionDB();
    private ViewMain viewMain;
    JasperViewer window;
    public void generate(String address, ViewMain viewMain){
        try {
            this.viewMain = viewMain;
            JasperReport report = JasperCompileManager.compileReport(address);
            JasperPrint viewReport = JasperFillManager.fillReport(report, null, con.Connection("acme_shop", "root", "1234"));
            //JasperViewer.viewReport(viewReport);
            window = new JasperViewer(viewReport,false);
            window.setDefaultCloseOperation(viewMain.DISPOSE_ON_CLOSE);
            window.setSize(window.getMaximumSize());
            window.setExtendedState(window.MAXIMIZED_BOTH);
            window.setVisible(true);
        } catch (Exception e) {
            System.err.printf("Error al generar el reporte");
        }
    }
}
