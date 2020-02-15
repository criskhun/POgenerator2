/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pogenerator;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.text.*;
import java.awt.PrintGraphics.*;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.awt.print.*;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.printreport.PDFPrintReport;
import java.awt.Shape;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import javax.print.attribute.standard.OrientationRequested;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author cris
 */
public class Main extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    private Object model;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        conn = (Connection) MySqlConnect.ConnectDB();
        CurrentDate();
        input_refresh();
        log_refresh();
        logcount();
        empcount();
        tableconfig();
        jobordertable();
        New_establishment();
        newestcount ();
        usertrans();
        tracount();
        entry_inventory();
        potable();
        pocount();
        rec_table();
        receiptcount();
        estabtable();
        filter_estab();
        filter_estaba();
        seticon();
        stocinoutcb();
        stockin_ref();
        inoutcount ();
        inoutcount2();
        stockout_ref();
        entry_inv();
        position_ref();
        positioncb();
        employee_ref();
        inactive_ref();
        employeelist();
        invreport_ref();
        //employee_fltr();
        activecount ();
        inactivecount ();
        salarycb();
        payroll_ref();
        dtremp();
        paysliptable();
        pulloutlogref();
        sss_ref();
        ph_ref();
        pi_ref();
        transparent();
        dashboard1 ();
        dashboard2 ();
        grossxnet ();
        ssscount ();
        sssdash();
        phdash();
        pidash();
        sumdash();
    }
    
    public void transparent(){
        jPanel39.setBackground(new Color(0,0,0,64) );
        jPanel40.setBackground(new Color(0,0,0,64) );
        jPanel41.setBackground(new Color(0,0,0,64) );
    }
    
    public void dashboard1 (){
    int active = jTable12.getRowCount();
    int inactive = jTable14.getRowCount();
    double total;
        d_aemp.setText(String.valueOf(active));
        d_iaemp.setText(String.valueOf(inactive));  
    total=active+inactive;
    d_temp.setText(Double.toString(total));
    }
    
    public void dashboard2 (){
        try{
        String sql = "Select sum(Gross), sum(Net) from payroll_tbl";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        String sum=rs.getString("sum(Gross)");
        String sum1=rs.getString("sum(Net)");
        d_grss.setText(sum);
        d_net.setText(sum1);
        }
        }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void grossxnet (){
        double a,b,c;
    a = Double.parseDouble(d_grss.getText());
    b = Double.parseDouble(d_net.getText());
    c = a + b;
    c = Math.round(c*100)/100.0;
    d_salary.setText(Double.toString(c));
    }
    
    public void sssdash (){
        try{
        String sql = "Select sum(EE), sum(ER) from sss_table";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        String sum=rs.getString("sum(EE)");
        String sum1=rs.getString("sum(ER)");
        jtf15.setText(sum);
        jtf21.setText(sum1);
        }
        }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    public void phdash (){
        try{
        String sql = "Select sum(EE), sum(ER) from ph_tbl";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        String sum=rs.getString("sum(EE)");
        String sum1=rs.getString("sum(ER)");
        jtf16.setText(sum);
        jtf20.setText(sum1);
        }
        }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    public void pidash (){
        try{
        String sql = "Select sum(EE), sum(ER) from pi_tbl";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        String sum=rs.getString("sum(EE)");
        String sum1=rs.getString("sum(ER)");
        jtf17.setText(sum);
        jtf19.setText(sum1);
        }
        }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    public void sumdash(){
    double eess,eeph,eepi,erss,erph,erpi,ee,er,ss,ph,pi,total;
    eess = Double.parseDouble(jtf15.getText());
    eeph = Double.parseDouble(jtf16.getText());
    eepi = Double.parseDouble(jtf17.getText());
    erss = Double.parseDouble(jtf21.getText());
    erph = Double.parseDouble(jtf20.getText());
    erpi = Double.parseDouble(jtf19.getText());
    
    ss = eess + erss;
    ph = eeph + erph;
    pi = eepi + erpi;
    ee = eess + eeph + eepi;
    er = erss + erph + erpi;
    total = ee + er;
    
    ss = Math.round(ss*100)/100.0;
    ph = Math.round(ph*100)/100.0;
    pi = Math.round(pi*100)/100.0;
    ee = Math.round(ee*100)/100.0;
    er = Math.round(er*100)/100.0;
    total = Math.round(total*100)/100.0;
    jtf24.setText(Double.toString(ss));
    jtf25.setText(Double.toString(ph));
    jtf26.setText(Double.toString(pi));
    jtf22.setText(Double.toString(ee));
    jtf23.setText(Double.toString(er));
    jtf27.setText(Double.toString(total));
    }
    
    public void saltrans(){
    Date date = dfrom.getDate();
        Date date1 = dto.getDate();
        DateFormat format = new SimpleDateFormat("MMMMM, dd");
        DateFormat format1 = new SimpleDateFormat("MMMMM, dd, yyyy");
        ps1.setText(format.format(date));
        ps2.setText(format1.format(date1));
        ps3.setText((String) sal_emp.getSelectedItem());
        ps4.setText(sal_id.getText());
        ps5.setText(sal_pos.getText());
        ps6.setText(sal_bs.getText());
        ps7.setText(gr_dr.getText());
        ps8.setText(test1.getText());
        ps9.setText(gr_ot.getText());
        ps10.setText(test2.getText());
        ps11.setText(test6.getText());
        ps12.setText(gr_ad.getText());
        ps13.setText(test3.getText());
        ps14.setText(test4.getText());
        ps15.setText(ded_ut.getText());
        ps16.setText(test7.getText());
        ps17.setText(ded_ch.getText());
        ps18.setText(test8.getText());
        ps19.setText(ded_od.getText());
        ps20.setText(mb_ss.getText());
        ps21.setText(mb_ph.getText());
        ps22.setText(mb_pi.getText());
        ps23.setText(mb_ot.getText());
        ps24.setText(tot_gross.getText());
        ps25.setText(netsal.getText());
        ps26.setText(test10.getText());
        ps27.setText(stat.getText());
        ps28.setText(dh.getText());
        ps29.setText(con.getText());
        ps30.setText(acc.getText());
        ps31.setText(ot_res.getText());
    }
    public void payslipprint(){
    PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Pay Slip");
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){//PageSize ps
                pf.setOrientation(PageFormat.LANDSCAPE);
                //ps.equals(PageSize.LEGAL.rotate());
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.40,0.40);
                jPanel25.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){ 
        try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
    }
    private void dropdownestab(){
     try {
            String sql = "SELECT Date,POnum,Establishment,Unit,Date_return,Date_release,Release_to,Remarks"
                    + " FROM estab_tbl WHERE "
                    + "Date like ? or POnum like ? or Establishment like ? or Unit like ? or Date_return like ? or Date_release like ? or Release_to like ? or Remarks like ? ";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(2, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(3, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(3, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(4, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(5, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(6, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(7, "%" + filter_est.getSelectedItem() + "%");
            pst.setString(8, "%" + filter_est.getSelectedItem() + "%");
            

            rs = (ResultSet) pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            empcount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }
    public void ssssave(){
    try {
            String sql = "Insert into sss_table (Employee, Date, Account, Remarks, EE, ER ) values "
                    + "(?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String) sal_emp.getSelectedItem());//Remarks
            pst.setString(2, ((JTextField)dfrom.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(3, sal_sss.getText());//Release_to
            pst.setString(4, "****");//Release_to
            pst.setString(5, mb_ss.getText());//Release_to
            pst.setString(6, mb_ss1.getText());//Release_to
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void phsave(){
    try {
            String sql = "Insert into ph_tbl (Employee, Date, Account, Remarks, EE, ER ) values "
                    + "(?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String) sal_emp.getSelectedItem());//Remarks
            pst.setString(2, ((JTextField)dfrom.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(3, sal_phth.getText());//Release_to
            pst.setString(4, "Paid" + txt_date.getText());//Release_to
            pst.setString(5, mb_ph.getText());//Release_to
            pst.setString(6, mb_ph1.getText());//Release_to
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void pisave(){
    try {
            String sql = "Insert into pi_tbl (Employee, Date, Account, Remarks, EE, ER ) values "
                    + "(?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String) sal_emp.getSelectedItem());//Remarks
            pst.setString(2, ((JTextField)dfrom.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(3, sal_pgib.getText());//Release_to
            pst.setString(4, "Paid" + txt_date.getText());//Release_to
            pst.setString(5, mb_pi.getText());//Release_to
            pst.setString(6, mb_pi1.getText());//Release_to
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void salsave(){
    try {
            String sql = "Insert into payroll_tbl (Date_from, Date_to, Employee, Employee_ID, Position, Rate, Render, Basic, "
                    + "Over_time, OT_pay, Allowance, Additional, LHD, SHD, Under_time, UT_ded, Late, Late_ded, Other_ded, "
                    + "SSS, Philhealth, Pag_ibig, Other, Gross, Net, total_ded, status, date_hire, contact, atmacc, other_reason) values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, ((JTextField)dfrom.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(2, ((JTextField)dto.getDateEditor().getUiComponent()).getText());//Date_release
            pst.setString(3, (String) sal_emp.getSelectedItem());//Remarks
            pst.setString(4, sal_id.getText());//Release_to
            pst.setString(5, sal_pos.getText());//Release_to
            pst.setString(6, sal_bs.getText());//Release_to
            pst.setString(7, gr_dr.getText());//Release_to
            pst.setString(8, test1.getText());//Release_to
            pst.setString(9, gr_ot.getText());//Release_to
            pst.setString(10, test2.getText());//Release_to
            pst.setString(11, test6.getText());//Release_to
            pst.setString(12, gr_ad.getText());//Release_to
            pst.setString(13, test3.getText());//Release_to
            pst.setString(14, test4.getText());//Release_to
            pst.setString(15, ded_ut.getText());//Release_to
            pst.setString(16, test7.getText());//Release_to
            pst.setString(17, ded_ch.getText());//Release_to
            pst.setString(18, test8.getText());//Release_to
            pst.setString(19, ded_od.getText());//Release_to
            pst.setString(20, mb_ss.getText());//Release_to
            pst.setString(21, mb_ph.getText());//Release_to
            pst.setString(22, mb_pi.getText());//Release_to
            pst.setString(23, mb_ot.getText());//Release_to
            pst.setString(24, tot_gross.getText());//Release_to
            pst.setString(25, netsal.getText());//Release_to
            pst.setString(26, test10.getText());//Release_to
            pst.setString(27, stat.getText());//Release_to
            pst.setString(28, dh.getText());//Release_to
            pst.setString(29, con.getText());//Release_to
            pst.setString(30, acc.getText());//Release_to
            pst.setString(31, ot_res.getText());//Release_to

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, "
                    + "Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, "save");//transaction
            pst.setString(5, sal_id.getText());//ponum
            pst.setString(6, "Salary");//data
            pst.setString(7, "");//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void totalgross(){
    double basic, ot, lh, sh, add, gross, allowance;
    basic = Double.parseDouble(test1.getText());
    ot = Double.parseDouble(test2.getText());
    lh = Double.parseDouble(test3.getText());
    sh = Double.parseDouble(test4.getText());
    add = Double.parseDouble(gr_ad.getText());
    allowance = Double.parseDouble(gr_al.getText());
    
    //all=allowance/2;
    gross=basic+ot+lh+sh+add+allowance;
    
    gross = Math.round(gross*100)/100.0;
    tot_gross.setText(Double.toString(gross));
    netsal.setText(Double.toString(gross));
    }
    public void basicded(){
    double gross, dabs, ut, chr, od, ded, total;
    gross = Double.parseDouble(tot_gross.getText());
    dabs = Double.parseDouble(test6.getText());
    ut = Double.parseDouble(test7.getText());
    chr = Double.parseDouble(test8.getText());
    od = Double.parseDouble(ded_od.getText());
    
    ded = dabs+ut+chr+od;
    total = gross-ded;
    
    ded = Math.round(ded*100)/100.0;
    total = Math.round(total*100)/100.0;
    b_ded.setText(Double.toString(ded));
    netsal.setText(Double.toString(total));
    }
    public void mandatory(){
    double ss, ph, pi, ot, total, gross, ded, allded, net;
    ss = Double.parseDouble(mb_ss.getText());
    ph = Double.parseDouble(mb_ph.getText());
    pi = Double.parseDouble(mb_pi.getText());
    ot = Double.parseDouble(mb_ot.getText());
    gross = Double.parseDouble(tot_gross.getText());
    ded = Double.parseDouble(b_ded.getText());
    
    total = ss+ph+pi+ot;
    allded = ded+total;
    net = gross-allded;
    
    total = Math.round(total*100)/100.0;
    net = Math.round(net*100)/100.0;
    allded = Math.round(allded*100)/100.0;
    mand_tot.setText(Double.toString(total));
    netsal.setText(Double.toString(net));
    test10.setText(Double.toString(allded));
    }
    public void salary_com(){
    double spos, sadd, sal ;
    spos = Double.parseDouble(emp_sal.getText());
    sadd = Double.parseDouble(esal.getText());
    if(esal.getText().equals("")){
    double esal=0;
    sal = spos + sadd;
    tot_sal.setText(Double.toString(sal));
    }
    else{
    sal = spos + sadd;
    tot_sal.setText(Double.toString(sal));
    }
    }
    private void estabtable(){//print section
    String sql = "select * from info_estab_tbl";
    try{
        pst= conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            print_cb.addItem(rs.getString("e_establishment"));
           
        }
    }catch (Exception e) {
    }
    }   
    private void dtremp(){//print section
    String sql = "select * from employee_tbl";
    try{
        pst= conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            dtr_name.addItem(rs.getString("Full_Name"));  
            psemp.addItem(rs.getString("Full_Name"));  
        }
        
    }catch (Exception e) {
    }
    }  
    private void filter_estab(){//choices encode
    String sqll = "select * from info_estab_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            instab.addItem(rs.getString("e_establishment"));
            //filter_est.addItem(rs.getString("e_establishment"));
        }
    }catch (Exception e) {
    }
    } 
    private void filter_estaba(){//filter encode
    String sqll = "select * from info_estab_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            filter_est.addItem(rs.getString("e_establishment"));
        }
    }catch (Exception e) {
    }
    } 
    private void stocinoutcb(){//filter encode
    String sqll = "select * from inv_entry_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            stockinitem.addItem(rs.getString("item_name"));
            pull_itm.addItem(rs.getString("item_name"));
        }
    }catch (Exception e) {
    }
    } 
    private void employeelist(){//filter encode
    String sqll = "select * from employee_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            pull_emp.addItem(rs.getString("Full_Name"));
            pull_app.addItem(rs.getString("Full_Name"));
            pulllog.addItem(rs.getString("Full_Name"));
        }
    }catch (Exception e) {
    }
    }  
    private void positioncb(){//filter encode
    String sqll = "select * from position_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            position_cb.addItem(rs.getString("Position"));
        }
    }catch (Exception e) {
    }
    } 
    private void salarycb(){//filter encode
    String sqll = "select * from employee_tbl";
    try{
        pst= conn.prepareStatement(sqll);
        rs = pst.executeQuery();
        while(rs.next()){
            sal_emp.addItem(rs.getString("Full_Name"));
        }
    }catch (Exception e) {
    }
    } 
    public void tableconfig(){
    
        jTable4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(305);
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTableHeader Theader = jTable4.getTableHeader();
        Theader.setBackground(Color.red); // change the Background color
        Theader.setForeground(Color.WHITE); // change the Foreground
        Theader.setFont(new Font("Tahome", Font.BOLD, 12)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        TableModel model = (TableModel)jTable4.getModel();   
    } 
    public void jobordertable(){
    
        jTable6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable6.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable6.getColumnModel().getColumn(1).setPreferredWidth(405);
        jTable6.getColumnModel().getColumn(2).setPreferredWidth(122);
        jTable6.getColumnModel().getColumn(3).setPreferredWidth(135);

        JTableHeader Theader = jTable6.getTableHeader();
        Theader.setBackground(Color.black); // change the Background color
        Theader.setForeground(Color.WHITE); // change the Foreground
        Theader.setFont(new Font("Tahome", Font.BOLD, 12)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        TableModel model = (TableModel)jTable6.getModel();   
    }
    public void input_refresh() {//refresh and call for db table estab_tbl
        try {
            String sql = "SELECT * FROM estab_tbl ORDER BY Date DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));            
//           
          JTableHeader Theader = jTable2.getTableHeader();    
//   
          Theader.setBackground(Color.red); // change the Background color
        
        Theader.setForeground(Color.WHITE); // change the Foreground
        Theader.setFont(new Font("Tahome", Font.BOLD, 15)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text

        //String z = model.getValueAt(z, 8).toString();
        TableModel model = (TableModel)jTable2.getModel();
        
        if (inremark.getSelectedItem().equals("Used")){
        jTable2.setSelectionBackground(Color.gray);
        jTable2.setSelectionForeground(Color.black);
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          
         else if (inremark.getSelectedItem().equals("Released")){
         
        jTable2.setSelectionBackground(Color.green);
        jTable2.setSelectionForeground(Color.black);
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          
          else if (inremark.getSelectedItem().equals("Not Use")){
         
        jTable2.setSelectionBackground(Color.white);
        jTable2.setSelectionForeground(Color.black);
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
        
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void log_refresh() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM log_db";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void pulloutlogref() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM pulloutlog";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable18.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void invreport_ref(){
        try {
            String sql = "SELECT item, qty, remark FROM stockinout_tbl ORDER BY item ASC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            JTableHeader Theader = jTable15.getTableHeader();    
//   
          Theader.setBackground(Color.red); // change the Background color
        
        Theader.setForeground(Color.WHITE); // change the Foreground
        Theader.setFont(new Font("Tahome", Font.BOLD, 15)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
            jTable15.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void employee_fltr(){
    try {
            String sql = "SELECT *"
                    + " FROM employee_tbl WHERE "
                    + "Position like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + "HR Head" + "%");

            rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
            pull_app.addItem(rs.getString("Full_Name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }
    public void stockin_ref(){
    try {
    String sql = "SELECT * FROM stockinout_tbl ORDER BY item ASC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable10.setModel(DbUtils.resultSetToTableModel(rs));
            
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void paysliptable(){
    try {
    String sql = "SELECT * FROM payroll_tbl ORDER BY Date_from DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable17.setModel(DbUtils.resultSetToTableModel(rs));
            
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void stockout_ref(){
    try {
    String sql = "SELECT * FROM pullout_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable11.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void employee_ref(){
    try {
    String sql = "SELECT * FROM employee_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable12.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void position_ref(){
    try {
    String sql = "SELECT * FROM position_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable13.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void inactive_ref(){
    try {
    String sql = "SELECT * FROM inactive_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable14.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void payroll_ref(){
    try {
    String sql = "SELECT Salary_ID, Date_from, Date_to, Employee, Employee_ID, Position, Rate, Render, Basic, Over_time, "
            + "OT_pay, Allowance, Additional, LHD, SHD, Under_time, UT_ded, Late, Late_ded, Other_ded, SSS, Philhealth, "
            + "Pag_ibig, Other, other_reason, Gross, Net FROM payroll_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable16.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    public void entry_inventory() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM inv_entry_tbl ORDER BY item_name ASC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable9.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void rec_table() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM receipt_tbl ORDER BY r_number DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable8.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }   
    public void potable() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM job_order_tbl ORDER BY JOnum_jo DESC ";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void usertrans() {//refresh and call for db user_trans_tbl
        try {
            String sql = "SELECT * FROM user_trans_tbl ORDER BY Date_t DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable5.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void New_establishment() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM info_estab_tbl";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void sss_ref() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM sss_table ORDER BY Date DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable19.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
     public void ph_ref() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM ph_tbl ORDER BY Date DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable20.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     public void pi_ref() {//refresh and call for db table account_tbl
        try {
            String sql = "SELECT * FROM pi_tbl ORDER BY Date DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable21.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void pull_clear (){
    pull_emp.setSelectedItem("--Employee List--");
    pull_itm.setSelectedItem("--Select Stock--");
    pull_sto.setText("");
    pull_qty.setText("");
    pull_rem.setText("");
    pull_app.setSelectedItem("--Select Admin Checker--");
    pull_tot.setText("");
    }
    public void clear_account () {//clear account txt
        accfn.setText("");
        accuser.setText("");
        accpass.setText("");
        accnewpass.setText("");
        accconfirm.setText("");
    }
    public void clear_receipt () {
    rcp_date.setDate(null);
        rcp_num.setText("");
        rcp_amt.setText("");
        rcp_dsc.setText("");
        rcp_rec.setText("");
        rcp_unt.setText("");
        rcp_rep.setText("");
        
        date_rcp.setText("_______________");
        num_rcp.setText("_______________");
        amt_rcp.setText("_______________");
        dsc_rcp.setText("______________________________________________________");
        rep_rcp.setText("________________________________");
        unt_rcp.setText("________________________________");
        rec_rcp.setText("________________________________");
    } 
    public void CurrentDate() {//date and time to toolbar running

        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("h:mm:ss");
                txt_time.setText(s.format(d));

                SimpleDateFormat st = new SimpleDateFormat("MM/dd/yyyy");
                txt_date.setText(st.format(d));
            }
        })
                .start();
    }   
    public void loggedin() {//log-in from front page
        try {

            String sql = "SELECT * FROM account_tbl where username =? and password =?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, user.getText());
            pst.setString(2, pass.getText());
            
            rs = pst.executeQuery();
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Admin Logged In!");
            
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(true);
            jpprint.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jMenuBar1.setEnabled(true);
            jMenu1.setEnabled(true);
            jMenu2.setEnabled(true);
            jMenu3.setEnabled(true);
            jMenu4.setEnabled(true);
            jpaccount.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);

                     pst = (PreparedStatement) conn.prepareStatement("SELECT fullname  FROM account_tbl where username= '" + user.getText() + "' and password= '" + pass.getText() + "' ");
            rs = pst.executeQuery();
            if (rs.next()) {
                String add3 = rs.getString("fullname");
                txt_account.setText(add3);
                accfn.setText(add3); 
                //loginatt.setText("0");
                jLabel275.setText("0");
            }
  
            }
            else{
            JOptionPane.showMessageDialog(null, "incorrect username or password");
            loginclear ();
            double a;
            //a = Double.parseDouble(loginatt.getText());
            a = Double.parseDouble(jLabel275.getText());
            a = a+1;
            jLabel275.setText(Double.toString(a));
            if(a==3){
                JOptionPane.showMessageDialog(null, "Warning 3 attempts occured!");
            System.exit(0);
            }
            }
            try{
                 String sql2 = "Insert log_db (acct_name, date_login, time_login) values (?,?,?)";
               
               pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql2);
               
               pst.setString(1, txt_account.getText());
               pst.setString(2, txt_date.getText());
               pst.setString(3, txt_time.getText());
               
               pst.execute();
               //JOptionPane.showMessageDialog(null, "New User Login History Recorded");
             
                }catch(SQLException x) {
                    JOptionPane.showMessageDialog(null, x);
                }
        }catch(SQLException x) {
                    JOptionPane.showMessageDialog(null, x);
           
        }
                   }
    public void loginclear () {//clear login input
        user.setText("");
        pass.setText("");
    }
    public void signup () {//signup code for add account
if(signpass.getText().equals("") || signuser.getText().equals("") || signrepass.getText().equals("") || signfn.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Please fill the form");
        }
        else{
        try {
               String sql = "Insert into account_tbl (username, password, fullname, acct_date, acct_time) values (?,?,?,?,?)";
               
               pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
               
               pst.setString(1, signuser.getText());
               pst.setString(2, signpass.getText());
               pst.setString(3, signfn.getText());
               pst.setString(4, txt_date.getText());
               pst.setString(5, txt_time.getText());
               
               pst.execute();
               
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
        if (signpass.getText().equals(signrepass.getText())){
        JOptionPane.showMessageDialog(null, "New Admin Succesfully Save!");
        }
        else{
        JOptionPane.showMessageDialog(null, "Those password didn't match. Try again");
        signclear ();
        }
        }
    }
    public void signclear () {//sign in clear input
        signuser.setText("");
        signpass.setText("");
        signrepass.setText("");
        signfn.setText("");
}
    public void inputclear (){//encoding for new item clear inputs and disabling
        inponu.setText("");
        instab.setSelectedItem(" ");
        inremark.setSelectedItem(" ");
        inunit.setText("");
        indret.setDate(null);
        inrel.setDate(null);
        inreleaseto.setText("");
        }       
    public void emploueeclear(){
        emp_id.setText("");
        emp_fn.setText("");
        emp_co.setText("");
        emp_ad.setText("");
        position_cb.setSelectedItem("");
        emp_dh.setDate(null);
        emp_st.setSelectedItem("Employee Status");
        tot_sal.setText("");
        emp_al.setText("");
        emp_ss.setText("");
        emp_ph.setText("");
        emp_pi.setText("");
        emp_at.setText("");
        emp_sal.setText("");
        esal.setText("");
        emp_id.setEditable(true);
        jButton33.setEnabled(true);
        }        
    public void salclear(){
        dfrom.setDate(null);
        dto.setDate(null);
        sal_emp.setSelectedItem("--Select Employee List--");
        sal_id.setText("");
        sal_pos.setText("");
        sal_bs.setText("");
        gr_dr.setText("");
        gr_ot.setText("");
        gr_al.setText("");
        gr_ad.setText("0");
        gr_lh.setText("");
        gr_sh.setText("");
        tot_gross.setText("0");
        ded_ab.setText("");
        ded_ut.setText("");
        ded_ch.setText("0");
        ded_od.setText("0");
        b_ded.setText("0");
        mb_ss.setText("0");
        mb_ph.setText("0");
        mb_pi.setText("0");
        mb_ss1.setText("0");
        mb_ph1.setText("0");
        mb_pi1.setText("0");
        mb_ot.setText("0");
        netsal.setText("0");
        test1.setText("0");
        test2.setText("0");
        test3.setText("0");
        test4.setText("0");
        jLabel198.setText("0");
        test6.setText("0");
        test7.setText("0");
        test8.setText("0");
        mand_tot.setText("0");
        ded_ab.setText("0");
        ded_ut.setText("0");
        ded_rb.setSelected(false);
        ded_ab.setEnabled(false);
        ded_ut.setEnabled(false);
        ded_ch.setEnabled(false);
        ded_od.setEnabled(false);
        mb_rb.setSelected(false);
        mb_ss.setEnabled(false);
        mb_ph.setEnabled(false);
        mb_pi.setEnabled(false);
        mb_ss1.setEnabled(false);
        mb_ph1.setEnabled(false);
        mb_pi1.setEnabled(false);
        mb_ot.setEnabled(false);
        gr_dr.setEnabled(false);
        gr_ot.setEnabled(false);
        gr_ad.setEnabled(false);
        gr_lh.setEnabled(false);
        gr_sh.setEnabled(false);
        ot_res.setText("");
        test10.setText("0");
        sal_sss.setText("");
        sal_phth.setText("");
        sal_pgib.setText("");
        }       
    public void inputnew () {//for new button from encoding panel
        inponu.setEditable(true);
        inremark.setEnabled(true);
        instab.setEnabled(true);
        inunit.setEditable(true);
        indret.setEnabled(true);
        inrel.setEnabled(true);
        inreleaseto.setEditable(true);
        input_save.setEnabled(true);
        input_update.setEnabled(false);
        input_delete.setEnabled(false);
        input_new.setEnabled(false);
        inputclear();
        }
    public void empcount (){//code for counting table encoding
    int row = jTable2.getRowCount();
        count.setText(String.valueOf(row));
    }
    public void ssscount (){//code for counting table encoding
    int row = jTable19.getRowCount();
        sss_count.setText(String.valueOf(row));
    }
    public void inoutcount (){//code for counting table stock in/out
    int row = jTable10.getRowCount();
        jLabel111.setText(String.valueOf(row));
    }
    public void inoutcount2 (){//code for counting table stock in/out
    int row = jTable11.getRowCount();
        jLabel125.setText(String.valueOf(row));
    }
    public void activecount (){//code for counting table stock in/out
    int row = jTable12.getRowCount();
        jLabel162.setText(String.valueOf(row));
    }
    public void inactivecount (){//code for counting table stock in/out
    int row = jTable14.getRowCount();
        jLabel164.setText(String.valueOf(row));
    }
    public void entry_inv (){//code for counting table encoding
    int row = jTable9.getRowCount();
        inv_count.setText(String.valueOf(row));
    }
    public void logcount (){//code for cointing table account logs
    int row = jTable1.getRowCount();
        logcount.setText(String.valueOf(row));
    }
    public void newestcount (){//code for cointing table account logs
    int row = jTable3.getRowCount();
        new_count.setText(String.valueOf(row));
    }
    public void tracount (){//code for cointing table account logs
    int row = jTable5.getRowCount();
        transcount.setText(String.valueOf(row));
    }
    public void pocount (){//code for cointing table account logs
    int row = jTable7.getRowCount();
        jLabel71.setText(String.valueOf(row));
    }
    public void receiptcount (){
    int row = jTable8.getRowCount();
            rcp_count.setText(String.valueOf(row));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplogin = new javax.swing.JPanel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel271 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jpsignup = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        SignIn = new javax.swing.JButton();
        signfn = new javax.swing.JTextField();
        signuser = new javax.swing.JTextField();
        signpass = new javax.swing.JPasswordField();
        signrepass = new javax.swing.JPasswordField();
        jLabel238 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jpaccount = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        accsave = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        accupdate = new javax.swing.JButton();
        accfn = new javax.swing.JTextField();
        accuser = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        accpass = new javax.swing.JPasswordField();
        accnewpass = new javax.swing.JPasswordField();
        accconfirm = new javax.swing.JPasswordField();
        jLabel242 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jpmenu = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        jtf15 = new javax.swing.JTextField();
        jtf16 = new javax.swing.JTextField();
        jtf17 = new javax.swing.JTextField();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jtf19 = new javax.swing.JTextField();
        jtf20 = new javax.swing.JTextField();
        jtf21 = new javax.swing.JTextField();
        jLabel317 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jtf22 = new javax.swing.JTextField();
        jLabel319 = new javax.swing.JLabel();
        jtf23 = new javax.swing.JTextField();
        jLabel320 = new javax.swing.JLabel();
        jtf24 = new javax.swing.JTextField();
        jLabel321 = new javax.swing.JLabel();
        jtf25 = new javax.swing.JTextField();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jtf26 = new javax.swing.JTextField();
        jLabel324 = new javax.swing.JLabel();
        jtf27 = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        d_grss = new javax.swing.JTextField();
        d_net = new javax.swing.JTextField();
        d_salary = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        d_aemp = new javax.swing.JTextField();
        d_iaemp = new javax.swing.JTextField();
        d_temp = new javax.swing.JTextField();
        jLabel269 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jLabel246 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jpencode = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable()
        // table color column/row
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 7){

                    if(value.equals("Released"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.WHITE);

                    }
                    if(value.equals("Used")){
                        // if date  equal current date
                        componenet.setBackground(Color.BLUE);
                        componenet.setForeground(Color.WHITE);
                    }

                    if(value.equals("Unused")){
                        // if date  equal current date
                        componenet.setBackground(Color.DARK_GRAY);
                        componenet.setForeground(Color.WHITE);
                    }

                }

                else {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;
            }

        }
        ;
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        inponu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        inunit = new javax.swing.JTextField();
        inreleaseto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        input_save = new javax.swing.JButton();
        input_update = new javax.swing.JButton();
        input_delete = new javax.swing.JButton();
        input_new = new javax.swing.JButton();
        count = new javax.swing.JLabel();
        instab = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        indret = new com.toedter.calendar.JDateChooser();
        inrel = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        inremark = new javax.swing.JComboBox();
        filter_est = new javax.swing.JComboBox();
        acc_search = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton10 = new javax.swing.JButton();
        jLabel248 = new javax.swing.JLabel();
        jplog = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        logsearch = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        logcount = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jpprint = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        print_estab = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        print_po = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        print_unit = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        print_cb = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jpnewest = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        new_est = new javax.swing.JTextField();
        new_con = new javax.swing.JTextField();
        new_add = new javax.swing.JTextField();
        new_desc = new javax.swing.JTextField();
        new_save = new javax.swing.JButton();
        new_new = new javax.swing.JButton();
        new_update = new javax.swing.JButton();
        new_delete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        new_count = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        new_let = new javax.swing.JTextField();
        jLabel253 = new javax.swing.JLabel();
        jpusertrans = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        transcount = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jpjoborder = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jodate = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jonum = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jocomp = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jobill = new javax.swing.JLabel();
        jounit = new javax.swing.JLabel();
        table_total = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        inputjo = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        compjo = new javax.swing.JTextField();
        billjo = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        unitjo = new javax.swing.JTextField();
        datejo = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel254 = new javax.swing.JLabel();
        jpjotable = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jo_date = new com.toedter.calendar.JDateChooser();
        jo_num = new javax.swing.JTextField();
        jo_com = new javax.swing.JTextField();
        jo_bill = new javax.swing.JTextField();
        jo_unit = new javax.swing.JTextField();
        jo_update = new javax.swing.JButton();
        jo_delete = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel259 = new javax.swing.JLabel();
        jpreceipt = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        num_rcp = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        unt_rcp = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        date_rcp = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        dsc_rcp = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        rec_rcp = new javax.swing.JLabel();
        rep_rcp = new javax.swing.JLabel();
        amt_rcp = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        rcp_date = new com.toedter.calendar.JDateChooser();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        rcp_num = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        rcp_amt = new javax.swing.JTextField();
        rcp_dsc = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        rcp_rec = new javax.swing.JTextField();
        rcp_unt = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        rcp_rep = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        rcp_update = new javax.swing.JButton();
        rcp_delete = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        rcp_count = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        rcp_search = new javax.swing.JTextField();
        jLabel260 = new javax.swing.JLabel();
        jpporeq = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel262 = new javax.swing.JLabel();
        jpjoprint = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jopdate = new com.toedter.calendar.JDateChooser();
        jopnum = new javax.swing.JTextField();
        jopcomp = new javax.swing.JTextField();
        jopbill = new javax.swing.JTextField();
        jopunit = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel123 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        prt_date = new com.toedter.calendar.JDateChooser();
        prt_rct = new javax.swing.JTextField();
        prt_amt = new javax.swing.JTextField();
        prt_dsc = new javax.swing.JTextField();
        prt_rep = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        prt_unt = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        prt_rec = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel137 = new javax.swing.JLabel();
        prt_awrd = new javax.swing.JTextField();
        jLabel263 = new javax.swing.JLabel();
        jpinventory = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        PrinteReport = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable()
        {

            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 1){

                    if(value.equals("0"))
                    {

                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);

                    }
                    if(value.equals("0.0")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                    if(value.equals("0.00")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                }

                else {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;
            }

        }

        ;
        jPanel11 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        inv_itm = new javax.swing.JTextField();
        inv_dsc = new javax.swing.JTextField();
        inv_typ = new javax.swing.JComboBox();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        inv_count = new javax.swing.JLabel();
        id_lb = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        inv_ser = new javax.swing.JTextField();
        id_lb1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 4){

                    if(value.equals("0"))
                    {

                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);

                    }
                    if(value.equals("0.0")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                    if(value.equals("0.00")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                }

                else {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;

            }
        }
        ;
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        stockinitem = new javax.swing.JComboBox();
        stockqty = new javax.swing.JTextField();
        stockrem = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel126 = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        total_stock = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        stock_ser = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        pull_qty = new javax.swing.JTextField();
        pull_itm = new javax.swing.JComboBox();
        pull_rem = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 5){

                    if(value.equals("0"))
                    {

                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);

                    }
                    if(value.equals("0.0")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                    if(value.equals("0.00")){
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.WHITE);
                    }

                }

                else {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;

            }
        }
        ;
        jLabel125 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        pull_sto = new javax.swing.JTextField();
        pull_tot = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        pull_emp = new javax.swing.JComboBox();
        jLabel139 = new javax.swing.JLabel();
        pull_app = new javax.swing.JComboBox();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        pull_ser = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        pulllog = new javax.swing.JComboBox();
        jLabel234 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jLabel265 = new javax.swing.JLabel();
        jpemployee = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        emp_fn = new javax.swing.JTextField();
        emp_co = new javax.swing.JTextField();
        emp_ad = new javax.swing.JTextField();
        position_cb = new javax.swing.JComboBox();
        emp_st = new javax.swing.JComboBox();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel147 = new javax.swing.JLabel();
        tot_sal = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        emp_al = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        emp_ss = new javax.swing.JTextField();
        emp_ph = new javax.swing.JTextField();
        emp_pi = new javax.swing.JTextField();
        emp_at = new javax.swing.JTextField();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        emp_sal = new javax.swing.JTextField();
        esal = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        emp_dh = new com.toedter.calendar.JDateChooser();
        jLabel159 = new javax.swing.JLabel();
        active_ser = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        p_pos = new javax.swing.JTextField();
        p_rat = new javax.swing.JTextField();
        p_bon = new javax.swing.JTextField();
        p_des = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel167 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jButton37 = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        inactive_ser = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jpsalary = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        dfrom = new com.toedter.calendar.JDateChooser();
        jLabel174 = new javax.swing.JLabel();
        dto = new com.toedter.calendar.JDateChooser();
        jLabel175 = new javax.swing.JLabel();
        sal_emp = new javax.swing.JComboBox();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        sal_id = new javax.swing.JTextField();
        sal_pos = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        test1 = new javax.swing.JLabel();
        test2 = new javax.swing.JLabel();
        test3 = new javax.swing.JLabel();
        test4 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        test5 = new javax.swing.JLabel();
        test6 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        test7 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        test8 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        con = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        dh = new javax.swing.JLabel();
        acc = new javax.swing.JLabel();
        test10 = new javax.swing.JLabel();
        test9 = new javax.swing.JLabel();
        salaryid = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        sal_bs = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        gr_dr = new javax.swing.JTextField();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        gr_ot = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        gr_al = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        gr_ad = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        tot_gross = new javax.swing.JLabel();
        ded_ab = new javax.swing.JTextField();
        ded_ut = new javax.swing.JTextField();
        ded_ch = new javax.swing.JTextField();
        ded_od = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        b_ded = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        mb_ss = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        mb_ph = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        mb_pi = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        mb_ot = new javax.swing.JTextField();
        mb_rb = new javax.swing.JRadioButton();
        ded_rb = new javax.swing.JRadioButton();
        jLabel193 = new javax.swing.JLabel();
        netsal = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jLabel185 = new javax.swing.JLabel();
        gr_lh = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        gr_sh = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        mand_tot = new javax.swing.JLabel();
        ot_res = new javax.swing.JTextField();
        jLabel280 = new javax.swing.JLabel();
        mb_ss1 = new javax.swing.JTextField();
        mb_ph1 = new javax.swing.JTextField();
        mb_pi1 = new javax.swing.JTextField();
        jLabel281 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        sal_sss = new javax.swing.JTextField();
        sal_phth = new javax.swing.JTextField();
        sal_pgib = new javax.swing.JTextField();
        jLabel284 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable16 = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton48 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jButton41 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jLabel211 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jLabel212 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jButton44 = new javax.swing.JButton();
        jLabel225 = new javax.swing.JLabel();
        dtr_name = new javax.swing.JComboBox();
        jLabel226 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jButton45 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        ps1 = new javax.swing.JLabel();
        ps2 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        ps4 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        ps3 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        ps5 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        ps27 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        ps28 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        ps29 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        ps6 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        ps30 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel249 = new javax.swing.JLabel();
        ps7 = new javax.swing.JLabel();
        ps8 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        ps9 = new javax.swing.JLabel();
        ps10 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        ps11 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        ps12 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        ps13 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        ps14 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel267 = new javax.swing.JLabel();
        ps15 = new javax.swing.JLabel();
        ps16 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        ps17 = new javax.swing.JLabel();
        ps18 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        ps19 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        ps20 = new javax.swing.JLabel();
        ps21 = new javax.swing.JLabel();
        ps22 = new javax.swing.JLabel();
        ps23 = new javax.swing.JLabel();
        ps31 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel274 = new javax.swing.JLabel();
        ps24 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel283 = new javax.swing.JLabel();
        ps26 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel256 = new javax.swing.JLabel();
        ps25 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel231 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel232 = new javax.swing.JLabel();
        psemp = new javax.swing.JComboBox();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        jButton46 = new javax.swing.JButton();
        jLabel266 = new javax.swing.JLabel();
        jpmandatory = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable19 = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton51 = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel299 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton58 = new javax.swing.JButton();
        jLabel307 = new javax.swing.JLabel();
        jDateChooser13 = new com.toedter.calendar.JDateChooser();
        jPanel44 = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jButton59 = new javax.swing.JButton();
        jLabel298 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton60 = new javax.swing.JButton();
        jLabel312 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel311 = new javax.swing.JLabel();
        sss_count = new javax.swing.JTextField();
        jButton61 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable20 = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jLabel300 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jLabel301 = new javax.swing.JLabel();
        jButton54 = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel302 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable21 = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jLabel304 = new javax.swing.JLabel();
        jButton55 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel305 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        waste2 = new javax.swing.JPanel();
        jpprintreceipt = new javax.swing.JPanel();
        num_rcp1 = new javax.swing.JLabel();
        unt_rcp1 = new javax.swing.JLabel();
        date_rcp1 = new javax.swing.JLabel();
        dsc_rcp1 = new javax.swing.JLabel();
        awrd_rcp1 = new javax.swing.JLabel();
        rec_rcp1 = new javax.swing.JLabel();
        rep_rcp1 = new javax.swing.JLabel();
        amt_rcp1 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        waste = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        default_date = new javax.swing.JLabel();
        default_name = new javax.swing.JLabel();
        default_remark = new javax.swing.JLabel();
        none = new javax.swing.JLabel();
        accounttxt = new javax.swing.JLabel();
        changepass = new javax.swing.JLabel();
        potrans = new javax.swing.JLabel();
        newestabb = new javax.swing.JLabel();
        default_print = new javax.swing.JLabel();
        printpoform = new javax.swing.JLabel();
        default_joborder = new javax.swing.JLabel();
        default_receipt = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        emp_reason = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        loginatt = new javax.swing.JLabel();
        jpjoborderprint = new javax.swing.JPanel();
        jodate1 = new javax.swing.JLabel();
        jonum1 = new javax.swing.JLabel();
        jocomp1 = new javax.swing.JLabel();
        jobill1 = new javax.swing.JLabel();
        jounit1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_time = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_account = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmdashboard = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phonics Book Centrum Utility ver.3.4");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.CardLayout());

        jplogin.setBackground(new java.awt.Color(153, 0, 0));
        jplogin.setLayout(null);

        user.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userKeyPressed(evt);
            }
        });
        jplogin.add(user);
        user.setBounds(210, 350, 280, 26);

        pass.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        jplogin.add(pass);
        pass.setBounds(210, 400, 280, 26);

        jLabel271.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(255, 255, 255));
        jLabel271.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel271.setText("Dev. by: Cris Uriarte");
        jplogin.add(jLabel271);
        jLabel271.setBounds(920, 660, 250, 12);

        jLabel7.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");
        jplogin.add(jLabel7);
        jLabel7.setBounds(43, 357, 120, 23);

        jLabel8.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password:");
        jplogin.add(jLabel8);
        jLabel8.setBounds(47, 401, 120, 23);

        jButton1.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jplogin.add(jButton1);
        jButton1.setBounds(210, 460, 110, 31);

        jButton2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton2.setText("Sign up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jplogin.add(jButton2);
        jButton2.setBounds(350, 460, 140, 31);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newlogo_v2.png"))); // NOI18N
        jplogin.add(jLabel25);
        jLabel25.setBounds(540, 180, 417, 410);

        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/825.jpg"))); // NOI18N
        jplogin.add(jLabel236);
        jLabel236.setBounds(0, 0, 1230, 720);

        jLabel275.setText("0");
        jplogin.add(jLabel275);
        jLabel275.setBounds(340, 196, 30, 40);

        jPanel1.add(jplogin, "card2");

        jpsignup.setBackground(new java.awt.Color(153, 0, 0));
        jpsignup.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Username:");
        jpsignup.add(jLabel4);
        jLabel4.setBounds(102, 207, 77, 23);

        jLabel6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Password:");
        jpsignup.add(jLabel6);
        jLabel6.setBounds(106, 255, 73, 23);

        jLabel9.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Repeat Password:");
        jpsignup.add(jLabel9);
        jLabel9.setBounds(52, 301, 127, 23);

        jLabel10.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Fullname:");
        jpsignup.add(jLabel10);
        jLabel10.setBounds(109, 346, 70, 23);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jpsignup.add(jButton3);
        jButton3.setBounds(120, 400, 120, 31);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jpsignup.add(jButton4);
        jButton4.setBounds(260, 400, 140, 31);

        SignIn.setBackground(new java.awt.Color(255, 255, 255));
        SignIn.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        SignIn.setText("Sign In");
        SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInActionPerformed(evt);
            }
        });
        jpsignup.add(SignIn);
        SignIn.setBounds(418, 400, 120, 31);

        signfn.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpsignup.add(signfn);
        signfn.setBounds(238, 346, 300, 26);

        signuser.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpsignup.add(signuser);
        signuser.setBounds(238, 207, 300, 26);

        signpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jpsignup.add(signpass);
        signpass.setBounds(238, 253, 300, 28);

        signrepass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jpsignup.add(signrepass);
        signrepass.setBounds(238, 299, 300, 28);

        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newlogo_v2.png"))); // NOI18N
        jpsignup.add(jLabel238);
        jLabel238.setBounds(560, 120, 417, 410);

        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/14116.jpg"))); // NOI18N
        jpsignup.add(jLabel240);
        jLabel240.setBounds(0, 0, 1230, 700);

        jPanel1.add(jpsignup, "card3");

        jpaccount.setBackground(new java.awt.Color(153, 0, 0));
        jpaccount.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Full Name:");
        jpaccount.add(jLabel11);
        jLabel11.setBounds(74, 199, 110, 23);

        jLabel12.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username:");
        jpaccount.add(jLabel12);
        jLabel12.setBounds(70, 249, 120, 23);

        jLabel13.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Password:");
        jpaccount.add(jLabel13);
        jLabel13.setBounds(74, 305, 110, 23);

        jLabel14.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("New Password:");
        jpaccount.add(jLabel14);
        jLabel14.setBounds(42, 400, 140, 23);

        jLabel24.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Confirm:");
        jpaccount.add(jLabel24);
        jLabel24.setBounds(87, 452, 100, 23);

        accsave.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        accsave.setText("Save");
        accsave.setEnabled(false);
        accsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accsaveActionPerformed(evt);
            }
        });
        jpaccount.add(accsave);
        accsave.setBounds(390, 450, 150, 31);

        jButton6.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton6.setText("Login");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jpaccount.add(jButton6);
        jButton6.setBounds(390, 300, 150, 31);

        accupdate.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        accupdate.setText("Update");
        accupdate.setEnabled(false);
        accupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accupdateActionPerformed(evt);
            }
        });
        jpaccount.add(accupdate);
        accupdate.setBounds(390, 190, 150, 31);

        accfn.setEditable(false);
        accfn.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpaccount.add(accfn);
        accfn.setBounds(210, 200, 162, 26);

        accuser.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpaccount.add(accuser);
        accuser.setBounds(210, 250, 162, 26);
        jpaccount.add(jSeparator1);
        jSeparator1.setBounds(42, 360, 500, 10);

        accpass.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpaccount.add(accpass);
        accpass.setBounds(210, 310, 162, 26);

        accnewpass.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpaccount.add(accnewpass);
        accnewpass.setBounds(210, 400, 167, 26);

        accconfirm.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpaccount.add(accconfirm);
        accconfirm.setBounds(210, 450, 167, 26);

        jLabel242.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newlogo_v2.png"))); // NOI18N
        jpaccount.add(jLabel242);
        jLabel242.setBounds(560, 120, 417, 410);

        jLabel244.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpaccount.add(jLabel244);
        jLabel244.setBounds(-10, 0, 1230, 700);

        jPanel1.add(jpaccount, "card7");

        jpmenu.setBackground(new java.awt.Color(153, 0, 0));
        jpmenu.setLayout(null);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MANDATORY CONTRIBUTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel294.setForeground(new java.awt.Color(255, 255, 255));
        jLabel294.setText("SSS:");

        jLabel295.setForeground(new java.awt.Color(255, 255, 255));
        jLabel295.setText("Philhealth:");

        jLabel296.setForeground(new java.awt.Color(255, 255, 255));
        jLabel296.setText("HDMF:");

        jtf15.setEditable(false);
        jtf15.setBackground(new java.awt.Color(255, 255, 255));

        jtf16.setEditable(false);
        jtf16.setBackground(new java.awt.Color(255, 255, 255));

        jtf17.setEditable(false);
        jtf17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel313.setForeground(new java.awt.Color(255, 255, 255));
        jLabel313.setText("EMPLOYEE");

        jLabel314.setForeground(new java.awt.Color(255, 255, 255));
        jLabel314.setText("SSS:");

        jLabel315.setForeground(new java.awt.Color(255, 255, 255));
        jLabel315.setText("Philhealth:");

        jLabel316.setForeground(new java.awt.Color(255, 255, 255));
        jLabel316.setText("HDMF:");

        jtf19.setEditable(false);
        jtf19.setBackground(new java.awt.Color(255, 255, 255));

        jtf20.setEditable(false);
        jtf20.setBackground(new java.awt.Color(255, 255, 255));

        jtf21.setEditable(false);
        jtf21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel317.setForeground(new java.awt.Color(255, 255, 255));
        jLabel317.setText("EMPLOYEE");

        jLabel318.setForeground(new java.awt.Color(255, 255, 255));
        jLabel318.setText("SubTotal:");

        jtf22.setEditable(false);
        jtf22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel319.setForeground(new java.awt.Color(255, 255, 255));
        jLabel319.setText("SubTotal:");

        jtf23.setEditable(false);
        jtf23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel320.setForeground(new java.awt.Color(255, 255, 255));
        jLabel320.setText("TOTAL");

        jtf24.setEditable(false);
        jtf24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel321.setForeground(new java.awt.Color(255, 255, 255));
        jLabel321.setText("SSS:");

        jtf25.setEditable(false);
        jtf25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel322.setForeground(new java.awt.Color(255, 255, 255));
        jLabel322.setText("Philhealth:");

        jLabel323.setForeground(new java.awt.Color(255, 255, 255));
        jLabel323.setText("HDMF:");

        jtf26.setEditable(false);
        jtf26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel324.setForeground(new java.awt.Color(255, 255, 255));
        jLabel324.setText("Total:");

        jtf27.setEditable(false);
        jtf27.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel295, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel296, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtf16, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf15, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf17, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel313, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel318, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtf22, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel314, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel316, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel319, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel317, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtf23, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf20, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf21, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf19, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel322, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel321, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel324, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel323, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtf27, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf26, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel317, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel313, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel314)
                                    .addComponent(jtf21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel315)
                                    .addComponent(jtf20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel316)
                                    .addComponent(jtf19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel294)
                                    .addComponent(jtf15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel295)
                                    .addComponent(jtf16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel296)
                                    .addComponent(jtf17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel319)
                                .addComponent(jtf23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel318)
                                .addComponent(jtf22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel320)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel321)
                            .addComponent(jtf24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel322)
                            .addComponent(jtf25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel323)
                            .addComponent(jtf26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel324)
                            .addComponent(jtf27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpmenu.add(jPanel41);
        jPanel41.setBounds(370, 400, 770, 230);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SALARY EXPENSE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel291.setForeground(new java.awt.Color(255, 255, 255));
        jLabel291.setText("Gross:");

        jLabel292.setForeground(new java.awt.Color(255, 255, 255));
        jLabel292.setText("Net:");

        jLabel293.setForeground(new java.awt.Color(255, 255, 255));
        jLabel293.setText("Total :");

        d_grss.setEditable(false);
        d_grss.setBackground(new java.awt.Color(255, 255, 255));

        d_net.setEditable(false);
        d_net.setBackground(new java.awt.Color(255, 255, 255));

        d_salary.setEditable(false);
        d_salary.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel293)
                    .addComponent(jLabel292)
                    .addComponent(jLabel291))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(d_net, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_grss, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291)
                    .addComponent(d_grss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel292)
                    .addComponent(d_net, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel293)
                    .addComponent(d_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jpmenu.add(jPanel40);
        jPanel40.setBounds(370, 220, 360, 153);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYEE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Number of Active Employee:");

        jLabel289.setForeground(new java.awt.Color(255, 255, 255));
        jLabel289.setText("Number of Inactive Employee:");

        jLabel290.setForeground(new java.awt.Color(255, 255, 255));
        jLabel290.setText("Total of Employee:");

        d_aemp.setEditable(false);
        d_aemp.setBackground(new java.awt.Color(255, 255, 255));

        d_iaemp.setEditable(false);
        d_iaemp.setBackground(new java.awt.Color(255, 255, 255));

        d_temp.setEditable(false);
        d_temp.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel290)
                    .addComponent(jLabel289)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(d_iaemp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(d_aemp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_temp, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(d_aemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289)
                    .addComponent(d_iaemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel290)
                    .addComponent(d_temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpmenu.add(jPanel39);
        jPanel39.setBounds(370, 40, 360, 160);

        jLabel269.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel269.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel269.setText("Dev. by: Cris Uriarte");
        jpmenu.add(jLabel269);
        jLabel269.setBounds(915, 670, 250, 12);

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lg.png"))); // NOI18N
        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton5);
        jButton5.setBounds(10, 10, 140, 50);

        jButton49.setBackground(new java.awt.Color(204, 204, 204));
        jButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jo.png"))); // NOI18N
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton49);
        jButton49.setBounds(10, 190, 346, 80);

        jButton52.setBackground(new java.awt.Color(204, 204, 204));
        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/po.png"))); // NOI18N
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton52);
        jButton52.setBounds(10, 100, 346, 80);

        jButton56.setBackground(new java.awt.Color(204, 204, 204));
        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rcpt.png"))); // NOI18N
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton56);
        jButton56.setBounds(10, 280, 346, 80);

        jButton53.setBackground(new java.awt.Color(204, 204, 204));
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inv.png"))); // NOI18N
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton53);
        jButton53.setBounds(10, 370, 346, 80);

        jButton50.setBackground(new java.awt.Color(204, 204, 204));
        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/emp.png"))); // NOI18N
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton50);
        jButton50.setBounds(10, 460, 346, 80);

        jButton57.setBackground(new java.awt.Color(204, 204, 204));
        jButton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pay.png"))); // NOI18N
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        jpmenu.add(jButton57);
        jButton57.setBounds(10, 550, 346, 80);

        jLabel246.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpmenu.add(jLabel246);
        jLabel246.setBounds(0, 0, 1220, 700);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newlogo_v2.png"))); // NOI18N
        jpmenu.add(logo);
        logo.setBounds(520, 200, 417, 410);

        jPanel1.add(jpmenu, "card6");

        jpencode.setBackground(new java.awt.Color(153, 0, 0));
        jpencode.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Count:");
        jpencode.add(jLabel23);
        jLabel23.setBounds(20, 50, 46, 23);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jpencode.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 1166, 340);

        jLabel15.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search:");
        jpencode.add(jLabel15);
        jLabel15.setBounds(991, 50, 55, 23);

        jLabel16.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("POnumber:");
        jpencode.add(jLabel16);
        jLabel16.setBounds(260, 450, 78, 23);

        inponu.setEditable(false);
        inponu.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpencode.add(inponu);
        inponu.setBounds(390, 450, 180, 26);

        jLabel17.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Establishment:");
        jpencode.add(jLabel17);
        jLabel17.setBounds(240, 490, 105, 23);

        jLabel18.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Unit:");
        jpencode.add(jLabel18);
        jLabel18.setBounds(310, 530, 33, 23);

        inunit.setEditable(false);
        inunit.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpencode.add(inunit);
        inunit.setBounds(390, 530, 180, 26);

        inreleaseto.setEditable(false);
        inreleaseto.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jpencode.add(inreleaseto);
        inreleaseto.setBounds(720, 490, 180, 26);

        jLabel22.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Release To:");
        jpencode.add(jLabel22);
        jLabel22.setBounds(600, 490, 83, 23);

        jLabel21.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Date Release:");
        jpencode.add(jLabel21);
        jLabel21.setBounds(580, 450, 99, 23);

        jLabel19.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Date Return:");
        jpencode.add(jLabel19);
        jLabel19.setBounds(260, 570, 88, 23);

        input_save.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        input_save.setText("Save");
        input_save.setEnabled(false);
        input_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_saveActionPerformed(evt);
            }
        });
        jpencode.add(input_save);
        input_save.setBounds(950, 500, 110, 31);

        input_update.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        input_update.setText("Update");
        input_update.setEnabled(false);
        input_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_updateActionPerformed(evt);
            }
        });
        jpencode.add(input_update);
        input_update.setBounds(950, 550, 130, 31);

        input_delete.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        input_delete.setText("Delete");
        input_delete.setEnabled(false);
        input_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_deleteActionPerformed(evt);
            }
        });
        jpencode.add(input_delete);
        input_delete.setBounds(950, 600, 130, 31);

        input_new.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        input_new.setText("New");
        input_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_newActionPerformed(evt);
            }
        });
        jpencode.add(input_new);
        input_new.setBounds(950, 450, 110, 31);

        count.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        count.setForeground(new java.awt.Color(255, 255, 255));
        count.setText("_____");
        jpencode.add(count);
        count.setBounds(80, 50, 50, 23);

        instab.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        instab.setEnabled(false);
        jpencode.add(instab);
        instab.setBounds(390, 490, 180, 26);

        jLabel28.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Establishment:");
        jpencode.add(jLabel28);
        jLabel28.setBounds(592, 47, 105, 23);

        indret.setDateFormatString("yyyy-MM-dd");
        indret.setEnabled(false);
        jpencode.add(indret);
        indret.setBounds(390, 570, 180, 30);

        inrel.setDateFormatString("MM/dd/yyyy");
        inrel.setEnabled(false);
        jpencode.add(inrel);
        inrel.setBounds(720, 450, 180, 30);

        jLabel32.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Remark:");
        jpencode.add(jLabel32);
        jLabel32.setBounds(620, 530, 60, 23);

        inremark.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        inremark.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unused", "Released", "Used" }));
        inremark.setEnabled(false);
        jpencode.add(inremark);
        inremark.setBounds(720, 530, 180, 26);

        filter_est.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        filter_est.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                filter_estPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jpencode.add(filter_est);
        filter_est.setBounds(703, 48, 170, 20);

        acc_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                acc_searchKeyReleased(evt);
            }
        });
        jpencode.add(acc_search);
        acc_search.setBounds(1052, 52, 126, 20);

        jDateChooser1.setDateFormatString("MM/dd/yyyy");
        jpencode.add(jDateChooser1);
        jDateChooser1.setBounds(136, 44, 172, 20);

        jDateChooser2.setDateFormatString("MM/dd/yyyy");
        jpencode.add(jDateChooser2);
        jDateChooser2.setBounds(136, 9, 172, 20);

        jButton10.setText("Period");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jpencode.add(jButton10);
        jButton10.setBounds(314, 41, 130, 23);

        jLabel248.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpencode.add(jLabel248);
        jLabel248.setBounds(0, 0, 1210, 700);

        jPanel1.add(jpencode, "card5");

        jplog.setBackground(new java.awt.Color(153, 0, 0));
        jplog.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jplog.add(jScrollPane1);
        jScrollPane1.setBounds(6, 93, 1172, 600);

        jLabel26.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Search:");
        jplog.add(jLabel26);
        jLabel26.setBounds(6, 51, 52, 20);

        logsearch.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        logsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                logsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                logsearchKeyReleased(evt);
            }
        });
        jplog.add(logsearch);
        logsearch.setBounds(70, 47, 193, 26);

        jLabel27.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Count:");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jplog.add(jLabel27);
        jLabel27.setBounds(1054, 51, 47, 20);

        logcount.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        logcount.setForeground(new java.awt.Color(255, 255, 255));
        logcount.setText("___");
        jplog.add(logcount);
        logcount.setBounds(1139, 51, 39, 20);

        jLabel250.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jplog.add(jLabel250);
        jLabel250.setBounds(0, 0, 1240, 700);

        jPanel1.add(jplog, "card4");

        jpprint.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(null);

        jTextField2.setEnabled(false);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField2MouseExited(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(298, 3, 68, 20);

        jButton7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(1068, 0, 110, 23);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 11, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel30.setText("PHONICS BOOK CENTRUM");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 23, -1, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel34.setText("Prk. 13 Panaghiusa, Mabuhay, G.S.C.");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 57, -1, -1));

        jLabel35.setText("Tel.#: (083) 887-8801 | Cell.#: +639217679102 / +63972061253");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 77, -1, -1));

        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ITEM#", "DESCRIPTION", "QTY", "UNIT PRICE", "TOTAL"
            }
        ));
        jTable4.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(jTable4);
        jTable4.getAccessibleContext().setAccessibleName("");

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 712, 290));

        jSeparator2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 104, 158, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(66, 21, 21));
        jLabel31.setText("Purchase by");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 114, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 135, 158, 6));

        jSeparator4.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 158, 10));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(66, 21, 21));
        jLabel37.setText("Name:");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(66, 21, 21));
        jLabel38.setText("Unit:");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(66, 21, 21));
        jLabel39.setText("Plate #:");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(66, 21, 21));
        jLabel40.setText("PO #:");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(66, 21, 21));
        jLabel41.setText("Date:");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 158, 10));

        jSeparator6.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 158, 10));

        jSeparator7.setForeground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 158, 10));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("PURCHASE ORDER");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 170, 30));

        print_estab.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        print_estab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        print_estab.setText("ESTABLISHMENT");
        jPanel3.add(print_estab, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 380, 30));

        jLabel46.setText("_________________________");
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, -1));

        jLabel47.setText("____________________");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 150, 40));

        jLabel48.setText("Received by:");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Joule Heinrich N. Surposa");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 160, -1));

        jLabel50.setText("Owner/Proprietor");
        jPanel3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, -1, -1));

        jLabel51.setText("Signature over Printed Name");
        jPanel3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, -1, -1));

        print_po.setText("jLabel29");
        jPanel3.add(print_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        jTextField1.setText("________________");
        jTextField1.setBorder(null);
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 100, -1));

        print_unit.setText("________________");
        print_unit.setBorder(null);
        jPanel3.add(print_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, -1));

        jTextField4.setText("________________");
        jTextField4.setBorder(null);
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 100, -1));

        jLabel75.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jPanel3.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1020, -1));

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 37, 1184, 656);

        jLabel45.setText(".");
        jPanel2.add(jLabel45);
        jLabel45.setBounds(382, 7, 108, 14);

        print_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        print_cb.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                print_cbPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(print_cb);
        print_cb.setBounds(6, 2, 274, 20);

        jLabel29.setText("-");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(372, 7, 4, 14);

        jLabel251.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jPanel2.add(jLabel251);
        jLabel251.setBounds(0, 0, 1230, 700);

        javax.swing.GroupLayout jpprintLayout = new javax.swing.GroupLayout(jpprint);
        jpprint.setLayout(jpprintLayout);
        jpprintLayout.setHorizontalGroup(
            jpprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpprintLayout.setVerticalGroup(
            jpprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jpprint, "card8");

        jpnewest.setBackground(new java.awt.Color(204, 0, 0));
        jpnewest.setLayout(null);

        jLabel52.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Establishment:");
        jpnewest.add(jLabel52);
        jLabel52.setBounds(555, 140, 120, 30);

        jLabel53.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Contact:");
        jpnewest.add(jLabel53);
        jLabel53.setBounds(600, 180, 70, 30);

        jLabel54.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Address:");
        jpnewest.add(jLabel54);
        jLabel54.setBounds(602, 220, 70, 30);

        jLabel55.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Description:");
        jpnewest.add(jLabel55);
        jLabel55.setBounds(578, 260, 100, 30);

        new_est.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_est.setEnabled(false);
        jpnewest.add(new_est);
        new_est.setBounds(710, 140, 290, 29);

        new_con.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_con.setEnabled(false);
        jpnewest.add(new_con);
        new_con.setBounds(710, 180, 290, 29);

        new_add.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_add.setEnabled(false);
        jpnewest.add(new_add);
        new_add.setBounds(710, 220, 290, 29);

        new_desc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_desc.setEnabled(false);
        jpnewest.add(new_desc);
        new_desc.setBounds(710, 260, 290, 29);

        new_save.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_save.setText("Save");
        new_save.setEnabled(false);
        new_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_saveActionPerformed(evt);
            }
        });
        jpnewest.add(new_save);
        new_save.setBounds(850, 360, 110, 31);

        new_new.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_new.setText("New");
        new_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_newActionPerformed(evt);
            }
        });
        jpnewest.add(new_new);
        new_new.setBounds(710, 420, 120, 31);

        new_update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_update.setText("Update");
        new_update.setEnabled(false);
        new_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_updateActionPerformed(evt);
            }
        });
        jpnewest.add(new_update);
        new_update.setBounds(710, 360, 120, 31);

        new_delete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_delete.setText("Delete");
        new_delete.setEnabled(false);
        new_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_deleteActionPerformed(evt);
            }
        });
        jpnewest.add(new_delete);
        new_delete.setBounds(850, 420, 110, 31);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jpnewest.add(jScrollPane3);
        jScrollPane3.setBounds(20, 144, 452, 440);

        jLabel56.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Count:");
        jpnewest.add(jLabel56);
        jLabel56.setBounds(20, 109, 291, 23);

        new_count.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_count.setForeground(new java.awt.Color(255, 255, 255));
        new_count.setText("Count:");
        jpnewest.add(new_count);
        new_count.setBounds(317, 109, 46, 23);

        jLabel84.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("PO Letter:");
        jpnewest.add(jLabel84);
        jLabel84.setBounds(597, 310, 80, 30);

        new_let.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        new_let.setEnabled(false);
        jpnewest.add(new_let);
        new_let.setBounds(710, 310, 290, 29);

        jLabel253.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpnewest.add(jLabel253);
        jLabel253.setBounds(0, 0, 1220, 700);

        jPanel1.add(jpnewest, "card9");

        jpusertrans.setBackground(new java.awt.Color(204, 0, 0));
        jpusertrans.setForeground(new java.awt.Color(255, 255, 255));
        jpusertrans.setLayout(null);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jpusertrans.add(jScrollPane5);
        jScrollPane5.setBounds(6, 123, 1172, 570);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Count:");
        jpusertrans.add(jLabel20);
        jLabel20.setBounds(10, 100, 70, 14);

        transcount.setForeground(new java.awt.Color(255, 255, 255));
        transcount.setText("jLabel29");
        jpusertrans.add(transcount);
        transcount.setBounds(130, 100, 80, 14);

        jLabel257.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpusertrans.add(jLabel257);
        jLabel257.setBounds(0, 0, 1230, 700);

        jPanel1.add(jpusertrans, "card11");

        jpjoborder.setBackground(new java.awt.Color(153, 0, 0));
        jpjoborder.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setText("Job Order Data");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton11))
                .addContainerGap())
        );

        jpjoborder.add(jPanel5);
        jPanel5.setBounds(0, 0, 1184, 45);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Qty", "Description", "Unit Price", "Total Price"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable6KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jLabel43.setText("Company Name:");

        jLabel57.setText("Date");

        jodate.setText("__________");

        jLabel59.setText("JO#");

        jonum.setText("__________");

        jLabel63.setText("Bill to");

        jLabel64.setText("Name:");

        jLabel66.setText("Unit:");

        jLabel67.setText("Total:");

        jLabel65.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel65.setText("Job Order");

        jLabel72.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jocomp.setText("_________________");

        jLabel76.setText("_________________");

        jLabel77.setText("_________________");

        jobill.setText("_________________");

        jounit.setText("_________________");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel77)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jocomp)
                                            .addComponent(jLabel76))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel63)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel64))
                                            .addComponent(jLabel66))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jounit)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jobill)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                                .addGap(63, 63, 63))
                                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jonum)
                                                            .addComponent(jodate)))
                                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addGap(26, 26, 26)
                                        .addComponent(table_total, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jodate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jonum)
                    .addComponent(jLabel43)
                    .addComponent(jocomp)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jobill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel66)
                    .addComponent(jounit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(table_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72)
                .addContainerGap())
        );

        jpjoborder.add(jPanel6);
        jPanel6.setBounds(6, 50, 830, 590);

        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Date:");
        jpjoborder.add(jLabel82);
        jLabel82.setBounds(838, 63, 60, 14);

        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Job Order #:");
        jpjoborder.add(jLabel58);
        jLabel58.setBounds(838, 105, 90, 14);

        inputjo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputjoKeyReleased(evt);
            }
        });
        jpjoborder.add(inputjo);
        inputjo.setBounds(968, 101, 210, 20);

        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Company:");
        jpjoborder.add(jLabel92);
        jLabel92.setBounds(838, 147, 90, 14);

        compjo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                compjoKeyReleased(evt);
            }
        });
        jpjoborder.add(compjo);
        compjo.setBounds(968, 143, 210, 20);

        billjo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billjoKeyReleased(evt);
            }
        });
        jpjoborder.add(billjo);
        billjo.setBounds(968, 185, 210, 20);

        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Bill to:");
        jpjoborder.add(jLabel95);
        jLabel95.setBounds(838, 193, 70, 14);

        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Unit:");
        jpjoborder.add(jLabel101);
        jLabel101.setBounds(838, 235, 70, 14);

        unitjo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitjoKeyReleased(evt);
            }
        });
        jpjoborder.add(unitjo);
        unitjo.setBounds(968, 227, 210, 20);

        datejo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datejoKeyReleased(evt);
            }
        });
        jpjoborder.add(datejo);
        datejo.setBounds(968, 59, 210, 20);

        jButton15.setText("Clear");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jpjoborder.add(jButton15);
        jButton15.setBounds(838, 269, 110, 23);

        jLabel254.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpjoborder.add(jLabel254);
        jLabel254.setBounds(0, 0, 1230, 700);

        jPanel1.add(jpjoborder, "card12");

        jpjotable.setBackground(new java.awt.Color(204, 0, 0));
        jpjotable.setForeground(new java.awt.Color(255, 255, 255));
        jpjotable.setLayout(null);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        jpjotable.add(jScrollPane7);
        jScrollPane7.setBounds(6, 84, 678, 609);

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Date:");
        jpjotable.add(jLabel36);
        jLabel36.setBounds(702, 97, 27, 14);

        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("JO #:");
        jpjotable.add(jLabel61);
        jLabel61.setBounds(702, 134, 28, 14);

        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Company:");
        jpjotable.add(jLabel62);
        jLabel62.setBounds(702, 176, 49, 14);

        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Bill to:");
        jpjotable.add(jLabel68);
        jLabel68.setBounds(702, 218, 29, 14);

        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Unit:");
        jpjotable.add(jLabel69);
        jLabel69.setBounds(702, 260, 23, 14);

        jo_date.setDateFormatString("MM/dd/yyyy");
        jo_date.setEnabled(false);
        jpjotable.add(jo_date);
        jo_date.setBounds(791, 84, 387, 20);

        jo_num.setEnabled(false);
        jpjotable.add(jo_num);
        jo_num.setBounds(791, 130, 387, 20);

        jo_com.setEnabled(false);
        jpjotable.add(jo_com);
        jo_com.setBounds(791, 172, 387, 20);

        jo_bill.setEnabled(false);
        jpjotable.add(jo_bill);
        jo_bill.setBounds(791, 214, 387, 20);

        jo_unit.setEnabled(false);
        jpjotable.add(jo_unit);
        jo_unit.setBounds(791, 256, 387, 20);

        jo_update.setText("Update");
        jo_update.setEnabled(false);
        jo_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jo_updateActionPerformed(evt);
            }
        });
        jpjotable.add(jo_update);
        jo_update.setBounds(791, 298, 110, 23);

        jo_delete.setText("Delete");
        jo_delete.setEnabled(false);
        jo_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jo_deleteActionPerformed(evt);
            }
        });
        jpjotable.add(jo_delete);
        jo_delete.setBounds(1112, 298, 63, 23);

        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Count:");
        jpjotable.add(jLabel70);
        jLabel70.setBounds(6, 58, 33, 14);

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("_________");
        jpjotable.add(jLabel71);
        jLabel71.setBounds(48, 58, 77, 14);

        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Search:");
        jpjotable.add(jLabel81);
        jLabel81.setBounds(143, 58, 37, 14);

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });
        jpjotable.add(jTextField10);
        jTextField10.setBounds(199, 54, 136, 20);

        jButton12.setText("Back");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jpjotable.add(jButton12);
        jButton12.setBounds(1119, 6, 55, 23);

        jLabel259.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpjotable.add(jLabel259);
        jLabel259.setBounds(0, 0, 1230, 700);

        jPanel1.add(jpjotable, "card14");

        jpreceipt.setBackground(new java.awt.Color(204, 0, 0));
        jpreceipt.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Eras Demi ITC", 1, 18)); // NOI18N
        jLabel73.setText("Payment Receipt");
        jPanel7.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 35, 162, -1));

        jLabel74.setText("PHONICS_BOOK_CENTRUM");
        jPanel7.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 220, -1));

        jLabel78.setText("____________________________________________________________________");
        jPanel7.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 480, 20));

        jLabel85.setText("Receipt #:");
        jPanel7.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 53, -1, -1));

        num_rcp.setText("_______________");
        jPanel7.add(num_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 53, 117, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 80, 80));

        jLabel87.setText("Unit:");
        jPanel7.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jLabel88.setText("Received from:");
        jPanel7.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel89.setText("_____________________");
        jPanel7.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, 20));

        unt_rcp.setText("________________________________");
        jPanel7.add(unt_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 230, 20));

        jLabel91.setText("Repair Maintenance");
        jPanel7.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        date_rcp.setText("_______________");
        jPanel7.add(date_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 117, -1));

        jLabel93.setText("Date:");
        jPanel7.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        jLabel94.setText("Amount:");
        jPanel7.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        dsc_rcp.setText("______________________________________________________");
        jPanel7.add(dsc_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 390, 20));

        jLabel96.setText("Received by:");
        jPanel7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        jLabel97.setText("Amount (in words):");
        jPanel7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel98.setText("____________________________________________________");
        jPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 370, 20));

        jLabel99.setText("As payment for:");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel100.setText("Name of Representative:");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        rec_rcp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rec_rcp.setText("________________________________");
        jPanel7.add(rec_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 230, 20));

        rep_rcp.setText("________________________________");
        jPanel7.add(rep_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 230, 20));

        amt_rcp.setText("_______________");
        jPanel7.add(amt_rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jLabel86.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jPanel7.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 880, 10));

        jpreceipt.add(jPanel7);
        jPanel7.setBounds(6, 76, 880, 298);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);

        jpreceipt.add(jScrollPane8);
        jScrollPane8.setBounds(6, 485, 877, 208);

        jButton13.setText("Print");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jpreceipt.add(jButton13);
        jButton13.setBounds(892, 114, 90, 23);

        rcp_date.setDateFormatString("yyyy-MM-dd");
        rcp_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rcp_datePropertyChange(evt);
            }
        });
        jpreceipt.add(rcp_date);
        rcp_date.setBounds(160, 10, 165, 20);

        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Date:");
        jpreceipt.add(jLabel103);
        jLabel103.setBounds(69, 20, 70, 14);

        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Receipt #:");
        jpreceipt.add(jLabel104);
        jLabel104.setBounds(50, 50, 100, 14);

        rcp_num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_numKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_num);
        rcp_num.setBounds(160, 50, 165, 20);

        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Amount:");
        jpreceipt.add(jLabel105);
        jLabel105.setBounds(367, 10, 80, 14);

        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("Description:");
        jpreceipt.add(jLabel106);
        jLabel106.setBounds(348, 50, 100, 14);

        rcp_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_amtKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_amt);
        rcp_amt.setBounds(460, 10, 137, 20);

        rcp_dsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_dscKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_dsc);
        rcp_dsc.setBounds(460, 40, 137, 20);

        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("Representative:");
        jpreceipt.add(jLabel107);
        jLabel107.setBounds(619, 10, 120, 14);

        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("Unit:");
        jpreceipt.add(jLabel108);
        jLabel108.setBounds(675, 50, 60, 14);

        rcp_rec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_recKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_rec);
        rcp_rec.setBounds(1000, 10, 137, 20);

        rcp_unt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_untKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_unt);
        rcp_unt.setBounds(750, 40, 137, 20);

        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("Received:");
        jpreceipt.add(jLabel109);
        jLabel109.setBounds(905, 10, 90, 14);

        rcp_rep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_repKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_rep);
        rcp_rep.setBounds(750, 10, 137, 20);

        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jpreceipt.add(jButton14);
        jButton14.setBounds(892, 76, 90, 23);

        rcp_update.setText("Update");
        rcp_update.setEnabled(false);
        rcp_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcp_updateActionPerformed(evt);
            }
        });
        jpreceipt.add(rcp_update);
        rcp_update.setBounds(889, 485, 110, 23);

        rcp_delete.setText("Delete");
        rcp_delete.setEnabled(false);
        rcp_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcp_deleteActionPerformed(evt);
            }
        });
        jpreceipt.add(rcp_delete);
        rcp_delete.setBounds(889, 523, 110, 23);

        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Count:");
        jpreceipt.add(jLabel60);
        jLabel60.setBounds(6, 463, 80, 14);

        rcp_count.setForeground(new java.awt.Color(255, 255, 255));
        rcp_count.setText("_______");
        jpreceipt.add(rcp_count);
        rcp_count.setBounds(100, 460, 70, 14);

        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Filter:");
        jpreceipt.add(jLabel90);
        jLabel90.setBounds(280, 460, 60, 14);

        rcp_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcp_searchKeyReleased(evt);
            }
        });
        jpreceipt.add(rcp_search);
        rcp_search.setBounds(360, 460, 168, 20);

        jLabel260.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpreceipt.add(jLabel260);
        jLabel260.setBounds(0, 0, 1210, 700);

        jPanel1.add(jpreceipt, "card13");

        jpporeq.setBackground(new java.awt.Color(204, 0, 0));
        jpporeq.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/POReq.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jpporeq.add(jPanel8);
        jPanel8.setBounds(6, 6, 820, 692);

        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jpporeq.add(jButton9);
        jButton9.setBounds(830, 6, 100, 23);

        jLabel262.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpporeq.add(jLabel262);
        jLabel262.setBounds(0, 0, 1210, 700);

        jPanel1.add(jpporeq, "card15");

        jpjoprint.setBackground(new java.awt.Color(153, 0, 0));
        jpjoprint.setLayout(null);

        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setText("Date:");
        jpjoprint.add(jLabel117);
        jLabel117.setBounds(260, 120, 80, 14);

        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setText("JO #:");
        jpjoprint.add(jLabel118);
        jLabel118.setBounds(260, 150, 80, 14);

        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setText("Company Name:");
        jpjoprint.add(jLabel119);
        jLabel119.setBounds(200, 190, 140, 14);

        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("Bill to:");
        jpjoprint.add(jLabel120);
        jLabel120.setBounds(260, 220, 80, 14);

        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("Unit:");
        jpjoprint.add(jLabel121);
        jLabel121.setBounds(260, 260, 90, 14);

        jopdate.setDateFormatString("MM/dd/yyyy");
        jpjoprint.add(jopdate);
        jopdate.setBounds(384, 106, 165, 20);
        jpjoprint.add(jopnum);
        jopnum.setBounds(384, 145, 165, 20);
        jpjoprint.add(jopcomp);
        jopcomp.setBounds(384, 179, 165, 20);
        jpjoprint.add(jopbill);
        jopbill.setBounds(384, 213, 165, 20);
        jpjoprint.add(jopunit);
        jopunit.setBounds(384, 255, 165, 20);

        jLabel122.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("JOB ORDER PRINT");
        jpjoprint.add(jLabel122);
        jLabel122.setBounds(332, 42, 217, 28);

        jButton16.setText("Generate");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jpjoprint.add(jButton16);
        jButton16.setBounds(613, 205, 77, 23);

        jButton17.setText("Print");
        jButton17.setEnabled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jpjoprint.add(jButton17);
        jButton17.setBounds(613, 247, 82, 23);

        jButton18.setText("Clear");
        jpjoprint.add(jButton18);
        jButton18.setBounds(613, 161, 82, 23);
        jpjoprint.add(jSeparator12);
        jSeparator12.setBounds(6, 297, 1172, 10);

        jLabel123.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("RECEIPT PRINT");
        jpjoprint.add(jLabel123);
        jLabel123.setBounds(350, 341, 180, 28);

        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setText("Date:");
        jpjoprint.add(jLabel130);
        jLabel130.setBounds(260, 390, 80, 14);

        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setText("Receipt #:");
        jpjoprint.add(jLabel131);
        jLabel131.setBounds(230, 430, 110, 14);

        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setText("Amount:");
        jpjoprint.add(jLabel132);
        jLabel132.setBounds(240, 460, 100, 14);

        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Description:");
        jpjoprint.add(jLabel133);
        jLabel133.setBounds(220, 490, 120, 14);

        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setText("Representative:");
        jpjoprint.add(jLabel134);
        jLabel134.setBounds(200, 540, 140, 14);

        prt_date.setDateFormatString("MM/dd/yyyy");
        jpjoprint.add(prt_date);
        prt_date.setBounds(382, 381, 165, 20);
        jpjoprint.add(prt_rct);
        prt_rct.setBounds(382, 420, 165, 20);
        jpjoprint.add(prt_amt);
        prt_amt.setBounds(382, 454, 165, 20);
        jpjoprint.add(prt_dsc);
        prt_dsc.setBounds(382, 488, 165, 20);
        jpjoprint.add(prt_rep);
        prt_rep.setBounds(382, 530, 165, 20);

        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setText("Unit:");
        jpjoprint.add(jLabel135);
        jLabel135.setBounds(260, 570, 70, 14);
        jpjoprint.add(prt_unt);
        prt_unt.setBounds(382, 572, 165, 20);

        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setText("Received by:");
        jpjoprint.add(jLabel136);
        jLabel136.setBounds(220, 620, 130, 14);
        jpjoprint.add(prt_rec);
        prt_rec.setBounds(382, 614, 165, 20);

        jButton19.setText("Clear");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jpjoprint.add(jButton19);
        jButton19.setBounds(612, 520, 82, 23);

        jButton20.setText("Generate");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jpjoprint.add(jButton20);
        jButton20.setBounds(612, 564, 77, 23);

        jButton21.setText("Print");
        jButton21.setEnabled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jpjoprint.add(jButton21);
        jButton21.setBounds(612, 606, 82, 23);

        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setText("Amount in words:");
        jpjoprint.add(jLabel137);
        jLabel137.setBounds(612, 389, 160, 14);
        jpjoprint.add(prt_awrd);
        prt_awrd.setBounds(820, 380, 165, 20);

        jLabel263.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpjoprint.add(jLabel263);
        jLabel263.setBounds(0, 0, 1210, 700);

        jPanel1.add(jpjoprint, "card16");

        jpinventory.setBackground(new java.awt.Color(204, 0, 0));
        jpinventory.setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        PrinteReport.setText("Print Report");
        PrinteReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrinteReportActionPerformed(evt);
            }
        });

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(jTable15);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrinteReport)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(PrinteReport)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dash Board", jPanel12);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable9MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable9);

        jLabel80.setText("Item Name:");

        jLabel102.setText("Description:");

        jLabel110.setText("Type:");

        inv_typ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Consumable", "Spare Part", "Office Supply", "Others" }));

        jButton22.setText("Save");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Update");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Delete");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        inv_count.setText("jLabel79");

        id_lb.setText("ID");

        jLabel146.setText("Qty:");

        jLabel128.setText("Count:");

        jLabel168.setText("Search:");

        inv_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inv_serKeyReleased(evt);
            }
        });

        id_lb1.setText("ID:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton22)
                        .addGap(18, 18, 18)
                        .addComponent(jButton23)
                        .addGap(18, 18, 18)
                        .addComponent(jButton24))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel146)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel102)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id_lb1)
                                    .addComponent(jLabel80)))
                            .addComponent(jLabel110))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(id_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(inv_typ, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_dsc)
                            .addComponent(jTextField14)
                            .addComponent(inv_itm))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel168)
                        .addGap(18, 18, 18)
                        .addComponent(inv_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326)
                        .addComponent(jLabel128)
                        .addGap(18, 18, 18)
                        .addComponent(inv_count))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inv_count)
                            .addComponent(jLabel128)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel168)
                            .addComponent(inv_ser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_lb)
                            .addComponent(id_lb1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel80)
                                    .addComponent(inv_itm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel102))
                            .addComponent(inv_dsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel146)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inv_typ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton22)
                            .addComponent(jButton23)
                            .addComponent(jButton24))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("New Supply", jPanel11);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable10);

        jLabel111.setText("jLabel111");

        jLabel112.setText("Item:");

        jLabel113.setText("Qty:");

        jLabel114.setText("Remarks:");

        stockinitem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        stockinitem.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                stockinitemPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        stockqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockqtyKeyReleased(evt);
            }
        });

        jButton27.setText("Save");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Clear");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel126.setText("Stock:");

        stock.setText("0");
        stock.setEnabled(false);

        total_stock.setForeground(new java.awt.Color(255, 255, 255));
        total_stock.setText("Total");

        jLabel169.setText("Count:");

        jLabel170.setText("Search:");

        stock_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stock_serKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel114)
                    .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockinitem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockrem)
                    .addComponent(stockqty)
                    .addComponent(stock)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(total_stock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton28)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel170)
                        .addGap(18, 18, 18)
                        .addComponent(stock_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(319, 319, 319)
                        .addComponent(jLabel169)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel111)
                        .addComponent(jLabel169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel170)
                        .addComponent(stock_ser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(stockinitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(stockqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(stockrem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton27)
                            .addComponent(jButton28))
                        .addGap(18, 18, 18)
                        .addComponent(total_stock)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stock-in", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel115.setText("Item:");

        jLabel116.setText("Qty:");

        jLabel124.setText("Remarks:");

        pull_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pull_qtyKeyReleased(evt);
            }
        });

        pull_itm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Stock--" }));
        pull_itm.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                pull_itmPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton31.setText("Save");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Clear");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable11);

        jLabel125.setText("jLabel125");

        jLabel127.setText("Stock:");

        pull_sto.setText("0");
        pull_sto.setEnabled(false);

        pull_tot.setForeground(new java.awt.Color(255, 255, 255));
        pull_tot.setText("Total");

        jLabel138.setText("Requester:");

        pull_emp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Employee List--" }));

        jLabel139.setText("Approved by:");

        pull_app.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Admin Checker--" }));

        jLabel171.setText("Count:");

        jLabel172.setText("Search:");

        pull_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pull_serKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel127)
                            .addComponent(jLabel116)
                            .addComponent(jLabel115)
                            .addComponent(jLabel138))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pull_itm, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pull_sto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pull_qty)
                            .addComponent(pull_emp, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton31)
                                .addGap(18, 18, 18)
                                .addComponent(jButton32))
                            .addComponent(pull_tot))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel139)
                            .addComponent(jLabel124))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pull_rem)
                            .addComponent(pull_app, 0, 1, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel172)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pull_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336)
                        .addComponent(jLabel171)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel125))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel125)
                        .addComponent(jLabel171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel172)
                        .addComponent(pull_ser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(pull_emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel115)
                            .addComponent(pull_itm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(pull_sto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(pull_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(pull_rem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(pull_app, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton31)
                            .addComponent(jButton32))
                        .addGap(18, 18, 18)
                        .addComponent(pull_tot)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stock-out/Pull-out", jPanel10);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jTable18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane19.setViewportView(jTable18);

        pulllog.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        pulllog.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                pulllogPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel234.setText("Employee List:");

        jButton47.setText("Print");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1146, Short.MAX_VALUE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel234)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulllog, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton47)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulllog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel234)
                    .addComponent(jButton47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pull Out Log", jPanel32);

        jpinventory.add(jTabbedPane1);
        jTabbedPane1.setBounds(6, 6, 1160, 699);

        jLabel265.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpinventory.add(jLabel265);
        jLabel265.setBounds(-5, 0, 1230, 700);

        jPanel1.add(jpinventory, "card18");

        jpemployee.setBackground(new java.awt.Color(204, 0, 0));
        jpemployee.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel140.setText("ID number:");

        jLabel141.setText("Full Name:");

        jLabel142.setText("Contact #:");

        jLabel143.setText("Address:");

        jLabel144.setText("Position:");

        jLabel145.setText("Status:");

        position_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        position_cb.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                position_cbPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        emp_st.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employee Status", "Part-Time", "Probationary", "Regular" }));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable12.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable12MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable12);

        jLabel147.setText("Salary:");

        tot_sal.setEnabled(false);

        jLabel148.setText("Allowance:");

        jLabel153.setText("SSS:");

        jLabel154.setText("PhilHealth:");

        jLabel155.setText("Pag-ibig:");

        jLabel156.setText("ATM #:");

        jButton33.setText("Save");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Update");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setText("Inactive");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Clear");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        emp_sal.setEnabled(false);

        esal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                esalKeyReleased(evt);
            }
        });

        jLabel157.setText("+");

        jLabel158.setText("Date Hired:");

        emp_dh.setDateFormatString("yyyy-MM-dd");

        jLabel159.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(204, 51, 0));
        jLabel159.setText("ACTIVE EMPLOYEE");

        active_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                active_serKeyReleased(evt);
            }
        });

        jLabel161.setText("Count:");

        jLabel162.setText("Count");

        jLabel173.setText("Search:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel147))
                                    .addComponent(jLabel148))
                                .addComponent(jLabel153, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel158)
                                    .addComponent(jLabel145)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emp_st, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(emp_sal, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(esal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tot_sal)
                                .addComponent(emp_al)
                                .addComponent(emp_ss)
                                .addComponent(emp_dh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel140)
                            .addGap(19, 19, 19)
                            .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(position_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emp_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emp_co, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emp_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel144)
                                .addComponent(jLabel143)
                                .addComponent(jLabel142)
                                .addComponent(jLabel141))
                            .addGap(242, 242, 242)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel154, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel155, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel156, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emp_pi)
                            .addComponent(emp_at)
                            .addComponent(emp_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jButton33)
                                .addGap(18, 18, 18)
                                .addComponent(jButton34)
                                .addGap(18, 18, 18)
                                .addComponent(jButton35)
                                .addGap(18, 18, 18)
                                .addComponent(jButton36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel173)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(active_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel161)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel162)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel159)
                        .addGap(186, 186, 186))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel159)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel141)
                            .addComponent(emp_fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel142)
                            .addComponent(emp_co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143)
                            .addComponent(emp_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel144)
                            .addComponent(position_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel158)
                            .addComponent(emp_dh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel145)
                                    .addComponent(emp_st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel147)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emp_sal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(esal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel157)))
                                .addGap(18, 18, 18)
                                .addComponent(tot_sal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emp_al, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel148))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(emp_ss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel153)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emp_ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel154))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emp_pi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel155))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emp_at, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel156))))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton33)
                            .addComponent(jButton34)
                            .addComponent(jButton35)
                            .addComponent(jButton36)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(active_ser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel161)
                            .addComponent(jLabel162)
                            .addComponent(jLabel173))))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Employee", jPanel13);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel149.setText("Position:");

        jLabel150.setText("Rate:");

        jLabel151.setText("Bonus:");

        jLabel152.setText("Description:");

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable13MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(jTable13);

        jButton25.setText("Add");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Edit");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton29.setText("Delete");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("Clear");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jLabel167.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(204, 51, 0));
        jLabel167.setText("POSITION");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jButton25)
                        .addGap(18, 18, 18)
                        .addComponent(jButton26)
                        .addGap(18, 18, 18)
                        .addComponent(jButton29)
                        .addGap(18, 18, 18)
                        .addComponent(jButton30))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel167))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel152)
                                .addComponent(jLabel151)
                                .addComponent(jLabel149)
                                .addComponent(jLabel150))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(p_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(p_rat, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(p_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(p_des, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel167)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(p_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(p_rat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(p_bon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(p_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton26)
                    .addComponent(jButton29)
                    .addComponent(jButton30))
                .addGap(51, 51, 51))
        );

        jTabbedPane2.addTab("Position", jPanel15);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable14MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(jTable14);

        jButton37.setText("Active");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jLabel163.setText("Search:");

        inactive_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inactive_serKeyReleased(evt);
            }
        });

        jLabel164.setText("jLabel164");

        jLabel165.setText("Count:");

        jLabel166.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(204, 51, 0));
        jLabel166.setText("INACTIVE EMPLOYEE");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel163)
                        .addGap(18, 18, 18)
                        .addComponent(inactive_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel165)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel164)))
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel166)
                .addContainerGap(533, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel166)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel163)
                        .addComponent(inactive_ser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel165)
                        .addComponent(jLabel164)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Inactive Employee", jPanel14);

        jpemployee.add(jTabbedPane2);
        jTabbedPane2.setBounds(6, 6, 1176, 685);

        jLabel268.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpemployee.add(jLabel268);
        jLabel268.setBounds(0, 0, 1240, 700);

        jPanel1.add(jpemployee, "card19");

        jpsalary.setBackground(new java.awt.Color(204, 0, 0));
        jpsalary.setLayout(null);

        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(null);

        jLabel160.setText("Payroll Period Date:");
        jPanel16.add(jLabel160);
        jLabel160.setBounds(6, 39, 95, 14);

        dfrom.setDateFormatString("MM/dd/yyyy");
        jPanel16.add(dfrom);
        dfrom.setBounds(123, 26, 142, 20);

        jLabel174.setText("-");
        jPanel16.add(jLabel174);
        jLabel174.setBounds(271, 26, 15, 14);

        dto.setDateFormatString("MM/dd/yyyy");
        jPanel16.add(dto);
        dto.setBounds(292, 26, 142, 20);

        jLabel175.setText("Employee:");
        jPanel16.add(jLabel175);
        jLabel175.setBounds(105, 78, 50, 14);

        sal_emp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Employee List--" }));
        sal_emp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sal_empItemStateChanged(evt);
            }
        });
        sal_emp.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                sal_empPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel16.add(sal_emp);
        sal_emp.setBounds(169, 73, 206, 20);

        jLabel176.setText("Employee ID:");
        jPanel16.add(jLabel176);
        jLabel176.setBounds(91, 121, 64, 14);

        jLabel177.setText("Position:");
        jPanel16.add(jLabel177);
        jLabel177.setBounds(114, 163, 41, 14);

        sal_id.setEnabled(false);
        jPanel16.add(sal_id);
        sal_id.setBounds(169, 117, 206, 20);

        sal_pos.setEnabled(false);
        jPanel16.add(sal_pos);
        sal_pos.setBounds(169, 159, 206, 20);

        jPanel18.setBackground(new java.awt.Color(102, 102, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        test1.setForeground(new java.awt.Color(255, 255, 255));
        test1.setText("0");

        test2.setForeground(new java.awt.Color(255, 255, 255));
        test2.setText("0");

        test3.setForeground(new java.awt.Color(255, 255, 255));
        test3.setText("0");

        test4.setForeground(new java.awt.Color(255, 255, 255));
        test4.setText("0");

        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("basic");

        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setText("OT");

        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setText("LH");

        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("SH");

        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setText("0");

        test5.setForeground(new java.awt.Color(255, 255, 255));
        test5.setText("all");

        test6.setForeground(new java.awt.Color(255, 255, 255));
        test6.setText("0");

        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setText("allXabs");

        test7.setBackground(new java.awt.Color(255, 255, 255));
        test7.setForeground(new java.awt.Color(255, 255, 255));
        test7.setText("0");

        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setText("UT");

        test8.setForeground(new java.awt.Color(255, 255, 255));
        test8.setText("0");

        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setText("late");

        con.setForeground(new java.awt.Color(255, 255, 255));
        con.setText("CON");

        stat.setForeground(new java.awt.Color(255, 255, 255));
        stat.setText("STAT");

        dh.setForeground(new java.awt.Color(255, 255, 255));
        dh.setText("DH");

        acc.setForeground(new java.awt.Color(255, 255, 255));
        acc.setText("ACC");

        test10.setForeground(new java.awt.Color(255, 255, 255));
        test10.setText("0");

        test9.setForeground(new java.awt.Color(255, 255, 255));
        test9.setText("alldeduc");

        salaryid.setForeground(new java.awt.Color(255, 255, 255));
        salaryid.setText("SalaryID");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(test4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel202))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel198)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(test5))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(test1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel199))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(test2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel200))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(test3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel201)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                    .addComponent(test7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel205))
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addComponent(test6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel204)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(test8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel203)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(dh)
                                .addGap(18, 18, 18)
                                .addComponent(con))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(stat)
                                .addGap(18, 18, 18)
                                .addComponent(acc))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(test10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(test9))
                    .addComponent(salaryid))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(test1)
                            .addComponent(jLabel199)
                            .addComponent(test6)
                            .addComponent(jLabel204))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(test7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(test2)
                                .addComponent(jLabel200)
                                .addComponent(jLabel205)
                                .addComponent(stat)
                                .addComponent(acc))))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dh)
                        .addComponent(con)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(test3)
                    .addComponent(jLabel201)
                    .addComponent(test8)
                    .addComponent(jLabel203))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(test4)
                    .addComponent(jLabel202))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel198)
                    .addComponent(test5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(test10)
                    .addComponent(test9))
                .addGap(18, 18, 18)
                .addComponent(salaryid)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel18);
        jPanel18.setBounds(726, 26, 306, 198);

        jLabel178.setText("Rate :");
        jPanel16.add(jLabel178);
        jLabel178.setBounds(131, 205, 30, 14);

        sal_bs.setText("0");
        sal_bs.setEnabled(false);
        jPanel16.add(sal_bs);
        sal_bs.setBounds(169, 201, 206, 20);

        jLabel179.setText("Days Rendered:");
        jPanel16.add(jLabel179);
        jLabel179.setBounds(14, 297, 78, 14);

        gr_dr.setText("0");
        gr_dr.setEnabled(false);
        gr_dr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gr_drKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gr_drKeyReleased(evt);
            }
        });
        jPanel16.add(gr_dr);
        gr_dr.setBounds(109, 293, 152, 20);

        jLabel180.setText("Over Time (time):");
        jPanel16.add(jLabel180);
        jLabel180.setBounds(6, 347, 84, 14);

        jLabel181.setText("Gross");
        jPanel16.add(jLabel181);
        jLabel181.setBounds(227, 249, 27, 14);

        gr_ot.setText("0");
        gr_ot.setEnabled(false);
        gr_ot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gr_otKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gr_otKeyReleased(evt);
            }
        });
        jPanel16.add(gr_ot);
        gr_ot.setBounds(109, 343, 152, 20);

        jLabel182.setText("Allowance:");
        jPanel16.add(jLabel182);
        jLabel182.setBounds(41, 397, 52, 14);

        gr_al.setText("0");
        gr_al.setEnabled(false);
        jPanel16.add(gr_al);
        gr_al.setBounds(109, 393, 152, 20);

        jLabel183.setText("Additional:");
        jPanel16.add(jLabel183);
        jLabel183.setBounds(44, 443, 51, 14);

        gr_ad.setText("0");
        gr_ad.setEnabled(false);
        gr_ad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gr_adKeyPressed(evt);
            }
        });
        jPanel16.add(gr_ad);
        gr_ad.setBounds(109, 439, 152, 20);

        jLabel184.setText("Gross Salary:");
        jPanel16.add(jLabel184);
        jLabel184.setBounds(24, 568, 64, 14);

        tot_gross.setText("0");
        jPanel16.add(tot_gross);
        tot_gross.setBounds(112, 568, 84, 14);

        ded_ab.setText("0");
        ded_ab.setEnabled(false);
        ded_ab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ded_abKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ded_abKeyReleased(evt);
            }
        });
        jPanel16.add(ded_ab);
        ded_ab.setBounds(383, 293, 150, 20);

        ded_ut.setText("0");
        ded_ut.setEnabled(false);
        ded_ut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ded_utKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ded_utKeyReleased(evt);
            }
        });
        jPanel16.add(ded_ut);
        ded_ut.setBounds(383, 343, 150, 20);

        ded_ch.setText("0");
        ded_ch.setEnabled(false);
        ded_ch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ded_chKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ded_chKeyReleased(evt);
            }
        });
        jPanel16.add(ded_ch);
        ded_ch.setBounds(383, 393, 150, 20);

        ded_od.setText("0");
        ded_od.setEnabled(false);
        ded_od.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ded_odKeyPressed(evt);
            }
        });
        jPanel16.add(ded_od);
        ded_od.setBounds(383, 439, 150, 20);

        jLabel187.setText("Days Absent:");
        jPanel16.add(jLabel187);
        jLabel187.setBounds(303, 297, 65, 14);

        jLabel188.setText("Under Time (time):");
        jPanel16.add(jLabel188);
        jLabel188.setBounds(273, 347, 89, 14);

        jLabel189.setText("Late:");
        jPanel16.add(jLabel189);
        jLabel189.setBounds(349, 397, 25, 14);

        jLabel190.setText("Other Deduction:");
        jPanel16.add(jLabel190);
        jLabel190.setBounds(282, 443, 83, 14);

        jLabel191.setText("Basic Deduction:");
        jPanel16.add(jLabel191);
        jLabel191.setBounds(280, 570, 79, 14);

        b_ded.setText("0");
        jPanel16.add(b_ded);
        b_ded.setBounds(390, 570, 150, 14);

        jLabel194.setText("SSS:");
        jPanel16.add(jLabel194);
        jLabel194.setBounds(620, 350, 22, 14);

        mb_ss.setText("0");
        mb_ss.setEnabled(false);
        mb_ss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_ssKeyPressed(evt);
            }
        });
        jPanel16.add(mb_ss);
        mb_ss.setBounds(660, 340, 100, 20);

        jLabel195.setText("Philhealth:");
        jPanel16.add(jLabel195);
        jLabel195.setBounds(590, 400, 50, 14);

        mb_ph.setText("0");
        mb_ph.setEnabled(false);
        mb_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_phKeyPressed(evt);
            }
        });
        jPanel16.add(mb_ph);
        mb_ph.setBounds(660, 390, 100, 20);

        jLabel196.setText("Pag-ibig:");
        jPanel16.add(jLabel196);
        jLabel196.setBounds(600, 450, 42, 14);

        mb_pi.setText("0");
        mb_pi.setEnabled(false);
        mb_pi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_piKeyPressed(evt);
            }
        });
        jPanel16.add(mb_pi);
        mb_pi.setBounds(660, 440, 100, 20);

        jLabel197.setText("Other:");
        jPanel16.add(jLabel197);
        jLabel197.setBounds(610, 490, 32, 14);

        mb_ot.setText("0");
        mb_ot.setEnabled(false);
        mb_ot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_otKeyPressed(evt);
            }
        });
        jPanel16.add(mb_ot);
        mb_ot.setBounds(660, 490, 103, 20);

        mb_rb.setBackground(new java.awt.Color(255, 255, 255));
        mb_rb.setText("Mandatory Benefits");
        mb_rb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mb_rbMouseClicked(evt);
            }
        });
        jPanel16.add(mb_rb);
        mb_rb.setBounds(650, 240, 119, 23);

        ded_rb.setBackground(new java.awt.Color(255, 255, 255));
        ded_rb.setText("Deduction");
        ded_rb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ded_rbMouseClicked(evt);
            }
        });
        jPanel16.add(ded_rb);
        ded_rb.setBounds(444, 243, 73, 23);

        jLabel193.setText("Net Salary:");
        jPanel16.add(jLabel193);
        jLabel193.setBounds(588, 568, 54, 14);

        netsal.setText("0");
        jPanel16.add(netsal);
        netsal.setBounds(655, 568, 286, 14);

        jButton38.setText("Print");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton38);
        jButton38.setBounds(974, 289, 80, 23);

        jButton39.setText("Save");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton39);
        jButton39.setBounds(974, 339, 80, 23);

        jButton40.setText("Clear");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton40);
        jButton40.setBounds(974, 389, 80, 23);

        jLabel185.setText("Legal Holiday:");
        jPanel16.add(jLabel185);
        jLabel185.setBounds(25, 492, 67, 14);

        gr_lh.setText("0");
        gr_lh.setEnabled(false);
        gr_lh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gr_lhKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gr_lhKeyReleased(evt);
            }
        });
        jPanel16.add(gr_lh);
        gr_lh.setBounds(109, 488, 152, 20);

        jLabel186.setText("Special Holiday:");
        jPanel16.add(jLabel186);
        jLabel186.setBounds(14, 534, 75, 14);

        gr_sh.setText("0");
        gr_sh.setEnabled(false);
        gr_sh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gr_shKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gr_shKeyReleased(evt);
            }
        });
        jPanel16.add(gr_sh);
        gr_sh.setBounds(109, 530, 152, 20);

        jLabel192.setText("Mandatory Deduction:");
        jPanel16.add(jLabel192);
        jLabel192.setBounds(520, 550, 107, 14);

        mand_tot.setText("0");
        jPanel16.add(mand_tot);
        mand_tot.setBounds(660, 550, 50, 14);

        ot_res.setEnabled(false);
        ot_res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ot_resKeyPressed(evt);
            }
        });
        jPanel16.add(ot_res);
        ot_res.setBounds(380, 490, 150, 20);

        jLabel280.setText("Reason:");
        jPanel16.add(jLabel280);
        jLabel280.setBounds(330, 490, 40, 14);

        mb_ss1.setText("0");
        mb_ss1.setEnabled(false);
        mb_ss1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_ss1KeyPressed(evt);
            }
        });
        jPanel16.add(mb_ss1);
        mb_ss1.setBounds(830, 340, 100, 20);

        mb_ph1.setText("0");
        mb_ph1.setEnabled(false);
        mb_ph1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_ph1KeyPressed(evt);
            }
        });
        jPanel16.add(mb_ph1);
        mb_ph1.setBounds(830, 390, 100, 20);

        mb_pi1.setText("0");
        mb_pi1.setEnabled(false);
        mb_pi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mb_pi1KeyPressed(evt);
            }
        });
        jPanel16.add(mb_pi1);
        mb_pi1.setBounds(830, 440, 100, 20);

        jLabel281.setText("EMPLOYER");
        jPanel16.add(jLabel281);
        jLabel281.setBounds(830, 300, 90, 14);

        jLabel282.setText("EMPLOYEE");
        jPanel16.add(jLabel282);
        jLabel282.setBounds(660, 300, 90, 14);

        sal_sss.setEnabled(false);
        jPanel16.add(sal_sss);
        sal_sss.setBounds(490, 120, 206, 20);

        sal_phth.setEnabled(false);
        jPanel16.add(sal_phth);
        sal_phth.setBounds(490, 160, 206, 20);

        sal_pgib.setText("0");
        sal_pgib.setEnabled(false);
        jPanel16.add(sal_pgib);
        sal_pgib.setBounds(490, 200, 206, 20);

        jLabel284.setText("SSS:");
        jPanel16.add(jLabel284);
        jLabel284.setBounds(440, 130, 40, 14);

        jLabel286.setText("Philhealt:");
        jPanel16.add(jLabel286);
        jLabel286.setBounds(420, 170, 60, 14);

        jLabel287.setText("Pag-ibig:");
        jPanel16.add(jLabel287);
        jLabel287.setBounds(420, 200, 60, 14);

        jTabbedPane3.addTab("Salary", jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable16.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable16MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jTable16);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel206.setText("DATE");

        jDateChooser3.setDateFormatString("MM/dd/yyyy");

        jDateChooser4.setDateFormatString("MM/dd/yyyy");

        jButton48.setText("Filter");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel206))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton48)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel206)
                .addGap(38, 38, 38)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton48)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Date", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel207.setText("EMPLOYEE");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel208.setText("Employee Name");

        jLabel209.setText("Employee ID");

        jLabel210.setText("Position");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel207))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel208)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel209)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel210)))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel207)
                .addGap(18, 18, 18)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel208)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel209)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel210)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Employee", jPanel22);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Transaction"));

        jButton41.setText("Print");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton43.setText("Delete");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jLabel211.setText("Print Payroll Summary");

        jLabel213.setText("Delete Payroll Entry");

        jButton42.setText("Print Payslip");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jLabel212.setText("Re-print Payslip");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41)
                    .addComponent(jButton43)
                    .addComponent(jButton42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel211)
                    .addComponent(jLabel213)
                    .addComponent(jLabel212))
                .addGap(67, 67, 67))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton41)
                    .addComponent(jLabel211))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42)
                    .addComponent(jLabel212))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton43)
                    .addComponent(jLabel213))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTabbedPane4))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Payroll", jPanel17);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DTR"));

        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pogenerator/logoprint.png"))); // NOI18N

        jLabel215.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel215.setText("PHONICS");

        jLabel216.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel216.setText("BOOK");

        jLabel217.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel217.setText("CENTRUM");

        jLabel218.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel218.setText("Name:");

        jLabel219.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel219.setText("Rate:");

        jLabel220.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel220.setText("Month of:");

        jLabel221.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel221.setText("fullname");

        jLabel222.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel222.setText("rate");

        jLabel223.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel223.setText("date");

        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dtr.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel214)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel215)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel216)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel217))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel219)
                                    .addComponent(jLabel220))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel222)
                                    .addComponent(jLabel223)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel218)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel221)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel214)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel215)
                            .addComponent(jLabel216)
                            .addComponent(jLabel217))))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel218)
                    .addComponent(jLabel221))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel219)
                    .addComponent(jLabel222))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel220)
                    .addComponent(jLabel223))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel224)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane17.setViewportView(jPanel23);

        jButton44.setText("Print");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jLabel225.setText("Employee:");

        dtr_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Employee--" }));
        dtr_name.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                dtr_namePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel226.setText("Date:");

        jDateChooser5.setDateFormatString("MMMMM, yyyy");

        jButton45.setText("Select");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel225)
                            .addComponent(jLabel226))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtr_name, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton45))))
                    .addComponent(jButton44))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel225)
                            .addComponent(dtr_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel226)
                            .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addComponent(jButton44)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("DTR", jPanel19);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "PBC-payslip"));

        jLabel227.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel227.setText("PHONICS BOOK CENTRUM");

        jLabel228.setText("Purok 13, Pinaghiusa, Brgy. Mabuhay");

        jLabel229.setText("General Santos City, 9500");

        jLabel230.setText("Pay Slip for the period of ");

        ps1.setText("datefrom");

        ps2.setText("dateto");

        jLabel233.setText("Employee ID:");

        ps4.setText("Id");

        jLabel235.setText("Employee Name:");

        ps3.setText("fullname");

        jLabel237.setText("Position:");

        ps5.setText("pos");

        jLabel239.setText("Status:");

        ps27.setText("status");

        jLabel241.setText("Date Hired:");

        ps28.setText("dh");

        jLabel243.setText("Contact#:");

        ps29.setText("cont");

        jLabel245.setText("Rate:");

        ps6.setText("rate");

        jLabel247.setText("Account#:");

        ps30.setText("accnt");

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Earnings"));

        jLabel249.setText("Days Worked:");

        ps7.setText("rate");

        ps8.setText("rate");

        jLabel252.setText("Over Time:");

        ps9.setText("rate");

        ps10.setText("rate");

        jLabel255.setText("Allowance:");

        ps11.setText("rate");

        jLabel258.setText("Additional:");

        ps12.setText("rate");

        jLabel261.setText("Legal H.:");

        ps13.setText("rate");

        jLabel264.setText("Special H.:");

        ps14.setText("rate");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel249)
                    .addComponent(jLabel252)
                    .addComponent(jLabel255)
                    .addComponent(jLabel258)
                    .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel264))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(ps7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ps8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(ps9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ps10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ps14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ps13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ps12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ps11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel249)
                    .addComponent(ps7)
                    .addComponent(ps8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel252)
                    .addComponent(ps9)
                    .addComponent(ps10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel255)
                    .addComponent(ps11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel258)
                    .addComponent(ps12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel261)
                    .addComponent(ps13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel264)
                    .addComponent(ps14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Deduction"));

        jLabel267.setText("Under Time:");

        ps15.setText("rate");

        ps16.setText("rate");

        jLabel270.setText("Late:");

        ps17.setText("rate");

        ps18.setText("rate");

        jLabel273.setText("Other:");

        ps19.setText("rate");

        jLabel276.setText("SSS:");

        jLabel277.setText("Philhealth:");

        jLabel278.setText("Pag-ibig:");

        jLabel279.setText("Other:");

        ps20.setText("rate");

        ps21.setText("rate");

        ps22.setText("rate");

        ps23.setText("rate");

        ps31.setText("jLabel234");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel279)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ps23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel278)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ps22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel277)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ps21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel276, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ps20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel270)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ps17, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel267)
                                    .addGap(18, 18, 18)
                                    .addComponent(ps15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel273, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ps31, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ps16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ps18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ps19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel267)
                    .addComponent(ps15)
                    .addComponent(ps16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel270)
                    .addComponent(ps17)
                    .addComponent(ps18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel273)
                    .addComponent(ps19)
                    .addComponent(ps31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel276)
                    .addComponent(ps20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel277)
                    .addComponent(ps21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel278)
                    .addComponent(ps22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel279)
                    .addComponent(ps23))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel274.setText("Gross:");

        ps24.setText("rate");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel274)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ps24, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel274)
                    .addComponent(ps24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel283.setText("Total Deduction:");

        ps26.setText("rate");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel283)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ps26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel283)
                    .addComponent(ps26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel256.setText("Net Pay:");

        ps25.setText("fullname");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel256)
                .addGap(137, 137, 137)
                .addComponent(ps25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel256)
                    .addComponent(ps25))
                .addContainerGap())
        );

        jLabel285.setText("Employer's Signature");

        jLabel288.setText("Employe'es Signature");

        jLabel231.setText("-");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel227))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel228))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel233)
                            .addComponent(jLabel237)
                            .addComponent(jLabel241)
                            .addComponent(jLabel245))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel230)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ps1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel229)
                                        .addGap(30, 30, 30)))
                                .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ps2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ps5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(ps4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(ps28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ps6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel247)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ps30, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel243)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ps29, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel235)
                                        .addGap(73, 73, 73)
                                        .addComponent(ps3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel239)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ps27, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel288, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(214, 214, 214)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel227)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel228)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel229)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230)
                    .addComponent(ps1)
                    .addComponent(ps2)
                    .addComponent(jLabel231))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233)
                    .addComponent(ps4)
                    .addComponent(jLabel235)
                    .addComponent(ps3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel237)
                    .addComponent(ps5)
                    .addComponent(jLabel239)
                    .addComponent(ps27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel241)
                    .addComponent(ps28)
                    .addComponent(jLabel243)
                    .addComponent(ps29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel245)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ps6)
                        .addComponent(jLabel247)
                        .addComponent(ps30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel288)
                    .addComponent(jLabel285))
                .addGap(74, 74, 74))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filter"));

        jLabel232.setText("Employee:");

        psemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        psemp.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                psempPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        psemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psempActionPerformed(evt);
            }
        });

        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable17.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable17MouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(jTable17);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psemp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(psemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel232))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18)
                .addContainerGap())
        );

        jButton46.setText("Print");
        jButton46.setEnabled(false);
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton46)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Payslip", jPanel24);

        jpsalary.add(jTabbedPane3);
        jTabbedPane3.setBounds(6, 6, 1186, 699);

        jLabel266.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2841152.jpg"))); // NOI18N
        jpsalary.add(jLabel266);
        jLabel266.setBounds(0, 0, 1240, 700);

        jPanel1.add(jpsalary, "card20");

        jpmandatory.setBackground(new java.awt.Color(204, 0, 0));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable19.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable19.setGridColor(new java.awt.Color(255, 255, 255));
        jTable19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable19MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(jTable19);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "FILTER TABLE"));

        jLabel297.setText("Date Range:");

        jDateChooser6.setDateFormatString("MM/dd/yyyy");

        jButton51.setText("Go!");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jLabel299.setText("Employee Name:");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jButton58.setText("Print Report");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jLabel307.setText("_");

        jDateChooser13.setDateFormatString("MM/dd/yyyy");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel297, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel307, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser13, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel299)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton58)))
                .addContainerGap())
            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton51)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel297)
                    .addComponent(jLabel307)
                    .addComponent(jDateChooser13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton58))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), " UPDATE STATUS"));

        jLabel306.setText("Remarks:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Status--", "Paid", "Unpaid" }));

        jDateChooser12.setDateFormatString("MM/dd/yyyy");

        jButton59.setText("Go!");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jLabel298.setText("+");

        jButton60.setText("Update");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jLabel312.setText("jLabel312");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel306, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel312)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel44Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel306)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel298)))))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton59)
                            .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel312))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "RESULT"));

        jLabel308.setText("Employee Share:");

        jLabel309.setText("Employeer Share:");

        jLabel310.setText("Total Contribution:");

        jLabel311.setText("Count:");

        jButton61.setText("Calculate");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel308)
                    .addComponent(jLabel309)
                    .addComponent(jLabel310))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField18))
                .addGap(38, 38, 38)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel311)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sss_count, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jButton61)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel311)
                        .addComponent(sss_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel308)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel309)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton61))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel310)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane5.addTab("SSS", jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jTable20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane21.setViewportView(jTable20);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTER TABLE"));

        jLabel300.setText("Date Range:");

        jLabel301.setText("_");

        jButton54.setText("Go!");

        jLabel302.setText("Employee Name:");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel300, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel302)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton54)
                    .addComponent(jLabel301)
                    .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel300))
                .addGap(12, 12, 12)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel302)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Philhealth", jPanel34);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jTable21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane22.setViewportView(jTable21);

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTER TABLE"));

        jLabel303.setText("Date Range:");

        jLabel304.setText("_");

        jButton55.setText("Go!");

        jLabel305.setText("Employee Name:");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator16)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel305)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton55)
                    .addComponent(jLabel304)
                    .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel303))
                .addGap(12, 12, 12)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Pag-ibig", jPanel35);

        javax.swing.GroupLayout jpmandatoryLayout = new javax.swing.GroupLayout(jpmandatory);
        jpmandatory.setLayout(jpmandatoryLayout);
        jpmandatoryLayout.setHorizontalGroup(
            jpmandatoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmandatoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpmandatoryLayout.setVerticalGroup(
            jpmandatoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmandatoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jPanel1.add(jpmandatory, "card21");

        waste2.setBackground(new java.awt.Color(204, 0, 0));

        jpprintreceipt.setBackground(new java.awt.Color(255, 255, 255));
        jpprintreceipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        num_rcp1.setText("_______________");
        jpprintreceipt.add(num_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 53, 117, -1));

        unt_rcp1.setText("________________________________");
        jpprintreceipt.add(unt_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 230, 20));

        date_rcp1.setText("_______________");
        jpprintreceipt.add(date_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 117, -1));

        dsc_rcp1.setText("______________________________________________________");
        jpprintreceipt.add(dsc_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 390, 20));

        awrd_rcp1.setText("____________________________________________________");
        jpprintreceipt.add(awrd_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 370, 20));

        rec_rcp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rec_rcp1.setText("________________________________");
        jpprintreceipt.add(rec_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 230, 20));

        rep_rcp1.setText("________________________________");
        jpprintreceipt.add(rep_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 230, 20));

        amt_rcp1.setText("_______________");
        jpprintreceipt.add(amt_rcp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jLabel129.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jpprintreceipt.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 880, 10));

        javax.swing.GroupLayout waste2Layout = new javax.swing.GroupLayout(waste2);
        waste2.setLayout(waste2Layout);
        waste2Layout.setHorizontalGroup(
            waste2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waste2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpprintreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        waste2Layout.setVerticalGroup(
            waste2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waste2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpprintreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        jPanel1.add(waste2, "card17");

        waste.setBackground(new java.awt.Color(0, 0, 255));

        default_date.setText("--/--/--");

        default_name.setText("Input Name");

        default_remark.setText("Unused");

        none.setText("None");

        accounttxt.setText("Account");

        changepass.setText("Change Pass");

        potrans.setText("PO Transaction");

        newestabb.setText("New Establishment");

        default_print.setText("Print");

        printpoform.setText("Print PO Form");

        default_joborder.setText("Job Order");

        default_receipt.setText("Receipt");

        jLabel79.setText("Inventory Entry");

        jTextField3.setText("jTextField3");

        jTextField5.setText("jTextField5");

        emp_reason.setText("reason");

        jLabel272.setText("login attempt");

        loginatt.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(default_date)
                        .addComponent(default_name)
                        .addComponent(default_remark)
                        .addComponent(default_print)
                        .addComponent(none)
                        .addComponent(changepass)
                        .addComponent(accounttxt)
                        .addComponent(potrans)
                        .addComponent(newestabb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(printpoform)
                        .addComponent(default_joborder)
                        .addComponent(default_receipt)
                        .addComponent(jLabel79)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emp_reason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loginatt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel272, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(default_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(default_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_remark)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_print)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(none)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emp_reason)
                .addGap(18, 18, 18)
                .addComponent(jLabel272)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginatt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accounttxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(potrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newestabb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printpoform)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_joborder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_receipt)
                .addContainerGap())
        );

        jpjoborderprint.setBackground(new java.awt.Color(255, 255, 255));

        jodate1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jodate1.setText("__________");

        jonum1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jonum1.setText("__________");

        jocomp1.setText("_________________");

        jobill1.setText("_________________");

        jounit1.setText("_________________");

        javax.swing.GroupLayout jpjoborderprintLayout = new javax.swing.GroupLayout(jpjoborderprint);
        jpjoborderprint.setLayout(jpjoborderprintLayout);
        jpjoborderprintLayout.setHorizontalGroup(
            jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpjoborderprintLayout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jocomp1)
                .addGap(152, 152, 152)
                .addGroup(jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jounit1)
                    .addComponent(jobill1))
                .addGap(197, 197, 197)
                .addGroup(jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jonum1)
                    .addComponent(jodate1)))
        );
        jpjoborderprintLayout.setVerticalGroup(
            jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpjoborderprintLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jodate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpjoborderprintLayout.createSequentialGroup()
                        .addGroup(jpjoborderprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobill1)
                            .addComponent(jocomp1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jounit1))
                    .addComponent(jonum1))
                .addContainerGap(482, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout wasteLayout = new javax.swing.GroupLayout(waste);
        waste.setLayout(wasteLayout);
        wasteLayout.setHorizontalGroup(
            wasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wasteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpjoborderprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        wasteLayout.setVerticalGroup(
            wasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wasteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wasteLayout.createSequentialGroup()
                        .addComponent(jpjoborderprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(waste, "card10");

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Date:          ");
        jToolBar1.add(jLabel1);

        txt_date.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        txt_date.setForeground(new java.awt.Color(51, 51, 51));
        txt_date.setText("__________");
        jToolBar1.add(txt_date);

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("          Time:          ");
        jToolBar1.add(jLabel3);

        txt_time.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        txt_time.setForeground(new java.awt.Color(51, 51, 51));
        txt_time.setText("__________");
        jToolBar1.add(txt_time);

        jLabel5.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("          Account:          ");
        jToolBar1.add(jLabel5);

        txt_account.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        txt_account.setForeground(new java.awt.Color(51, 51, 51));
        txt_account.setText("__________");
        jToolBar1.add(txt_account);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setEnabled(false);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.setEnabled(false);
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmdashboard.setText("Dash Board");
        jmdashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmdashboardActionPerformed(evt);
            }
        });
        jMenu1.add(jmdashboard);

        jMenuItem2.setText("Encode");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Print Form");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Add Establishment");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator9);

        jMenuItem7.setText("Job Order");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Receipt");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator11);

        jMenuItem11.setText("Inventory");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Employee");
        jMenu4.setEnabled(false);

        jMenuItem12.setText("Employee Detail");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem14.setText("Salary");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem13.setText("Mandatory Contribution");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Account");
        jMenu2.setEnabled(false);

        jMenuItem1.setText("Manage");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Account Log");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem6.setText("User Transaction");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Print");
        jMenu3.setEnabled(false);

        jMenuItem9.setText("PO Request");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Job Order Entry");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loggedin();
        }
    }//GEN-LAST:event_userKeyPressed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loggedin();
        }
    }//GEN-LAST:event_passKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loggedin();
        user.setText("");
        pass.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jplogin.setVisible(false);
        jpsignup.setVisible(true);
        jpnewest.setVisible(false);
        jpusertrans.setVisible(false);
        jpjoborder.setVisible(false);
        jpreceipt.setVisible(false);
        jpjoprint.setVisible(false);
        jpinventory.setVisible(false);
        jpemployee.setVisible(false);
        jpsalary.setVisible(false);
        jpmandatory.setVisible(false);
        loginclear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        signup ();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        signclear ();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInActionPerformed
            jplogin.setVisible(true);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
        signclear();
    }//GEN-LAST:event_SignInActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            jplogin.setVisible(true);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpsalary.setVisible(false);
            
            jMenu1.setEnabled(false);
            jMenu2.setEnabled(false);
            jMenu3.setEnabled(false);
            jMenu4.setEnabled(false);
            txt_account.setText("__________");
            user.setText("");
            pass.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int z = jTable2.getSelectedRow();

            TableModel model = (TableModel)jTable2.getModel();
          inponu.setText(model.getValueAt(z, 1).toString());
          instab.setSelectedItem(model.getValueAt(z, 2).toString());
          inunit.setText(model.getValueAt(z, 3).toString());
          ((JTextField)indret.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 4).toString());
          ((JTextField)inrel.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 5).toString());
          inreleaseto.setText(model.getValueAt(z, 6).toString());
          inremark.setSelectedItem(model.getValueAt(z, 7).toString());   
          
          input_save.setEnabled(false);
          input_update.setEnabled(true);
          input_delete.setEnabled(true);
          input_new.setEnabled(true);
          inponu.setEditable(true);
          inunit.setEnabled(true);
          inunit.setEditable(true);
          inrel.setEnabled(true);
          inreleaseto.setEditable(true);
          inremark.setEnabled(true);
          indret.setEnabled(true);
          instab.setEnabled(true);
          
            
         
              // change the Background color
          String i = model.getValueAt(z, 7).toString();
          
          if (inremark.getSelectedItem().equals("Used")){
        jTable2.setSelectionBackground(Color.gray);
        jTable2.setSelectionForeground(Color.black);
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          
         else if (inremark.getSelectedItem().equals("Released")){
         
        jTable2.setSelectionBackground(Color.green);
        jTable2.setSelectionForeground(Color.black); 
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          
          else if (inremark.getSelectedItem().equals("Not Use")){
         
        jTable2.setSelectionBackground(Color.white);
        jTable2.setSelectionForeground(Color.black);
        jTable2.setFont(new Font("Tahome", Font.BOLD, 12));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          
    }//GEN-LAST:event_jTable2MouseClicked

    private void input_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_saveActionPerformed
        try {
            String sql = "Insert into estab_tbl (Date, POnum, Establishment, Unit, Date_return, Date_release, Release_to, Remarks) values (?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            //int index = jTable2.getSelectedRow();
            
            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, inponu.getText());//POnum
            pst.setString(3, (String) instab.getSelectedItem());//Establishment 
            pst.setString(4, inunit.getText());//Unit
            pst.setString(5, ((JTextField)indret.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(6, ((JTextField)inrel.getDateEditor().getUiComponent()).getText());//Date_release
            pst.setString(7, inreleaseto.getText());//Release_to
            pst.setString(8, (String) inremark.getSelectedItem());//Remarks

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, inponu.getText());//ponum
            pst.setString(6, potrans.getText());//data
            pst.setString(7, (String) instab.getSelectedItem());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        input_refresh();
        dropdownestab();
            inputclear ();
            empcount();
    }//GEN-LAST:event_input_saveActionPerformed

    private void input_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_updateActionPerformed
            try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE estab_tbl SET  Establishment=?, Unit=?, Date_return=?, Date_release=?, Release_to=?, Remarks=? WHERE POnum='" + inponu.getText() + "'");
            pst.setString(1, (String) instab.getSelectedItem());
            pst.setString(2, inunit.getText());
            pst.setString(3, ((JTextField)indret.getDateEditor().getUiComponent()).getText());
            pst.setString(4, ((JTextField)inrel.getDateEditor().getUiComponent()).getText());
            pst.setString(5, inreleaseto.getText());
            pst.setString(6, (String) inremark.getSelectedItem());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");

          inponu.setEditable(false);
          instab.setEditable(false); 
          instab.setEnabled(false);
          inunit.setEditable(false);
          indret.setEnabled(false);
          inrel.setEnabled(false);
          inreleaseto.setEditable(false);
          input_delete.setEnabled(false);
          input_update.setEnabled(false);
          inremark.setEnabled(false);
           
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_update.getText());//transaction
            pst.setString(5, inponu.getText());//ponum
            pst.setString(6, potrans.getText());//data
            pst.setString(7, (String) instab.getSelectedItem());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
        
        if(filter_est.getSelectedItem().equals(""))
        {
        input_refresh();
        }
        else{
    dropdownestab();
    }
            inputclear();
            empcount();
    }//GEN-LAST:event_input_updateActionPerformed

    private void jmdashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmdashboardActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(true);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jmdashboardActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(true);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void accsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accsaveActionPerformed
        if (accnewpass.getText().equals(accconfirm.getText())){

            try {
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE account_tbl SET  password=? WHERE username='" + accuser.getText() + "'");
                pst.setString(1, accnewpass.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Account Password changed");
                accfn.setEditable(false);
                accnewpass.setEditable(false);
                accconfirm.setEditable(false);
                accsave.setEnabled(false);
                accnewpass.setText("");
                accconfirm.setText("");
                accuser.setText("");
                accpass.setText("");
                accupdate.setEnabled(false);
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, changepass.getText());//transaction
            pst.setString(5, none.getText());//ponum
            pst.setString(6, accounttxt.getText());//data
            pst.setString(7, none.getText());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Password Mismatch");
            accnewpass.setText("");
            accconfirm.setText("");
        }
    }//GEN-LAST:event_accsaveActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        try {

            String sql = "SELECT * FROM account_tbl where username =? and password =? and fullname =?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, accuser.getText());
            pst.setString(2, accpass.getText());
            pst.setString(3, accfn.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Configure Account");
                accupdate.setEnabled(true);
                accsave.setEnabled(true);
                accfn.setEditable(true);
                accnewpass.setEditable(true);
                accconfirm.setEditable(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "incorrect username or password");
            }
        }catch(SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void accupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accupdateActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE account_tbl SET  fullname=? WHERE username='" + accuser.getText() + "'");
            pst.setString(1, accfn.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Account Name Updated");
            accfn.setEditable(false);
            accuser.setText("");
            accpass.setText("");
            accnewpass.setEditable(false);
            accconfirm.setEditable(false);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, accupdate.getText());//transaction
            pst.setString(5, none.getText());//ponum
            pst.setString(6, accounttxt.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_accupdateActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(true);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void input_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_newActionPerformed
        inputnew ();
    }//GEN-LAST:event_input_newActionPerformed

    private void input_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_deleteActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM estab_tbl  WHERE POnum = '" + inponu.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Transaction Removed");
                
            
          inponu.setEditable(false);
          instab.setEditable(false);
          inunit.setEditable(false);
          indret.setEnabled(false);
          inrel.setEnabled(false);
          inreleaseto.setEditable(false);
          input_delete.setEnabled(false);
          input_update.setEnabled(false);
          inremark.setEnabled(false);
          inremark.setSelectedItem("Unuse");
            }else{
                JOptionPane.showMessageDialog(null, "Please Check PO number!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_delete.getText());//transaction
            pst.setString(5, inponu.getText());//ponum
            pst.setString(6, potrans.getText());//data
            pst.setString(7, (String) instab.getSelectedItem());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        
        if(filter_est.getSelectedItem().equals(""))
        {
        input_refresh();
        }
        else{
    dropdownestab();
    }
                inputclear();
                empcount();
    }//GEN-LAST:event_input_deleteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(true);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
            log_refresh();
            logcount();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void logsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logsearchKeyReleased
        try {
            String sql = "SELECT acct_name,date_login,time_login"
                    + " FROM log_db WHERE "
                    + "acct_name like ? or date_login like ? or time_login like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + logsearch.getText() + "%");
            pst.setString(2, "%" + logsearch.getText() + "%");
            pst.setString(3, "%" + logsearch.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            empcount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        if(logsearch.equals("")){
       //input_new.setEnabled(true);
       }
        else{
       input_new.setEnabled(false); 
        }
    }//GEN-LAST:event_logsearchKeyReleased

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(true);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void logsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logsearchKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F8){
            try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE * FROM log_db");
            // int del = pst.executeUpdate();
            log_refresh();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }//GEN-LAST:event_logsearchKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.75,0.75);

                jPanel3.paint(g2);
                //

                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if(ok){
            
            try {
            String sql = "Insert into estab_tbl (Date, POnum, Establishment, Unit, Date_return, Date_release, Release_to, Remarks) values (?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            //int index = jTable2.getSelectedRow();
            
            pst.setString(1, default_date.getText());//date
            pst.setString(2, print_po.getText());//ponumber
            pst.setString(3, print_estab.getText());//establishment
            pst.setString(4, print_unit.getText());//unit
            pst.setString(5, print_unit.getText());//release to
            pst.setString(6, default_date.getText());//date release
            pst.setString(7, default_name.getText());//release to
            pst.setString(8, default_remark.getText());//remarks
            
            pst.execute();
            
            input_refresh();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            
            try{
                job.print();
                
            }
            catch (PrinterException ex){}
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, default_print.getText());//transaction
            pst.setString(5, print_po.getText());//ponum
            pst.setString(6, printpoform.getText());//data
            pst.setString(7, print_estab.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        jLabel45.setText("Enter PO #");
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited
        jLabel45.setText("");
    }//GEN-LAST:event_jTextField2MouseExited

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        
        String po = jTextField2.getText();
        print_po.setText(po);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void new_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_saveActionPerformed
        try {
            String sql = "Insert into info_estab_tbl (e_date, e_establishment, e_contact, e_address, e_description, e_letter) values (?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, txt_date.getText());
            pst.setString(2, new_est.getText());
            pst.setString(3, new_con.getText());
            pst.setString(4, new_add.getText());
            pst.setString(5, new_desc.getText());
            pst.setString(6, new_let.getText());

            pst.execute();
            newestcount ();
            New_establishment();
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
         try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, new_save.getText());//transaction
            pst.setString(5, none.getText());//ponum
            pst.setString(6, newestabb.getText());//data
            pst.setString(7, new_est.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        new_est.setText("");
            new_con.setText("");
            new_add.setText("");
            new_desc.setText("");
            new_let.setText("");
            
            new_new.setEnabled(true);
            new_save.setEnabled(false);
            new_delete.setEnabled(false);
            new_update.setEnabled(false);
            
          new_est.setEnabled(false);
          new_con.setEnabled(false);
          new_add.setEnabled(false);
          new_desc.setEnabled(false);
          new_let.setEnabled(false);
    }//GEN-LAST:event_new_saveActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(true);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void new_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_newActionPerformed
        new_update.setEnabled(false);
        new_save.setEnabled(true);
        new_delete.setEnabled(false);
        new_new.setEnabled(false);
        new_est.setEnabled(true);
          new_con.setEnabled(true);
          new_add.setEnabled(true);
          new_desc.setEnabled(true);
          new_let.setEnabled(true);
          new_est.setText("");
          new_con.setText("");
          new_add.setText("");
          new_desc.setText("");
          new_let.setText("");
    }//GEN-LAST:event_new_newActionPerformed

    private void new_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_updateActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE info_estab_tbl SET e_date=?, e_establishment=?, e_contact=?, e_address=?, e_description=?, e_letter=? WHERE e_establishment='" + new_est.getText() + "'");
            pst.setString(1, txt_date.getText());
            pst.setString(2, new_est.getText());
            pst.setString(3, new_con.getText());
            pst.setString(4, new_add.getText());
            pst.setString(5, new_desc.getText());
            pst.setString(6, new_let.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
            
            New_establishment();
  
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, new_update.getText());//transaction
            pst.setString(5, none.getText());//ponum
            pst.setString(6, newestabb.getText());//data
            pst.setString(7, new_est.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        new_update.setEnabled(false);
        new_save.setEnabled(false);
        new_delete.setEnabled(false);
        new_new.setEnabled(true);
        new_est.setText("");
        new_con.setText("");
        new_add.setText("");
        new_desc.setText("");
        new_let.setText("");
        new_est.setEnabled(false);
          new_con.setEnabled(false);
          new_add.setEnabled(false);
          new_desc.setEnabled(false);
          new_let.setEnabled(false);
    }//GEN-LAST:event_new_updateActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int z = jTable3.getSelectedRow();

            TableModel model = (TableModel)jTable3.getModel();
          new_est.setText(model.getValueAt(z, 1).toString());
          new_con.setText(model.getValueAt(z, 2).toString());
          new_add.setText(model.getValueAt(z, 3).toString());
          new_desc.setText(model.getValueAt(z, 4).toString());
          new_let.setText(model.getValueAt(z, 5).toString());

          new_update.setEnabled(true);
          new_delete.setEnabled(true);
          new_save.setEnabled(false);
          new_new.setEnabled(true);
          
          new_est.setEnabled(true);
          new_con.setEnabled(true);
          new_add.setEnabled(true);
          new_desc.setEnabled(true);
          new_let.setEnabled(true);

    }//GEN-LAST:event_jTable3MouseClicked

    private void new_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_deleteActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM info_estab_tbl  WHERE e_establishment = '" + new_est.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Establishment Removed");

            newestcount ();
            New_establishment();   

            }else{
                JOptionPane.showMessageDialog(null, "Please Check Establishment!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, new_delete.getText());//transaction
            pst.setString(5, none.getText());//ponum
            pst.setString(6, newestabb.getText());//data
            pst.setString(7, new_est.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        new_update.setEnabled(false);
        new_save.setEnabled(false);
        new_delete.setEnabled(false);
        new_new.setEnabled(true);
        new_est.setText("");
        new_con.setText("");
        new_add.setText("");
        new_desc.setText("");
        new_let.setText("");
        new_est.setEnabled(false);
          new_con.setEnabled(false);
          new_add.setEnabled(false);
          new_desc.setEnabled(false);
          new_let.setEnabled(false);
    }//GEN-LAST:event_new_deleteActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(true);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void acc_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acc_searchKeyReleased
            try {
            String sql = "SELECT Date,POnum,Establishment,Unit,Date_return,Date_release,Release_to,Remarks"
                    + " FROM estab_tbl WHERE "
                    + "Date like ? or POnum like ? or Establishment like ? or Unit like ? or Date_return like ? or Date_release like ? or Release_to like ? or Remarks like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + acc_search.getText() + "%");
            pst.setString(2, "%" + acc_search.getText() + "%");
            pst.setString(3, "%" + acc_search.getText() + "%");
            pst.setString(4, "%" + acc_search.getText() + "%");
            pst.setString(5, "%" + acc_search.getText() + "%");
            pst.setString(6, "%" + acc_search.getText() + "%");
            pst.setString(7, "%" + acc_search.getText() + "%");
            pst.setString(8, "%" + acc_search.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            empcount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        if(acc_search.equals("")){
       //input_new.setEnabled(true);
       }
        else{
       input_new.setEnabled(false); 
        }

    }//GEN-LAST:event_acc_searchKeyReleased

    private void filter_estPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_filter_estPopupMenuWillBecomeInvisible
        dropdownestab();
            
    }//GEN-LAST:event_filter_estPopupMenuWillBecomeInvisible

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(true);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Job Order" + txt_date.getText() + txt_time.getText());
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.70,0.70);
                jPanel6.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){   
            
            try {
            String sql = "Insert into job_order_tbl (Date_jo, JOnum_jo, Company_jo, Billed_jo, Unit_jo) values (?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, jodate.getText());//date
            pst.setString(2, jonum.getText());//Jo number
            pst.setString(3, jocomp.getText());//company
            pst.setString(4, jobill.getText());//bill to
            pst.setString(5, jounit.getText());//unit
            
            pst.execute();
            
            potable();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            
            try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, default_print.getText());//transaction
            pst.setString(5, jonum.getText());//ponum
            pst.setString(6, default_joborder.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        datejo.setText("");
        inputjo.setText("");
        compjo.setText("");
        billjo.setText("");
        unitjo.setText("");
        
        jodate.setText("__________");
        jonum.setText("__________");
        jocomp.setText("_________________");
        jobill.setText("_________________");
        jounit.setText("_________________");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void inputjoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputjoKeyReleased
        String po = inputjo.getText();
        jonum.setText(po);
    }//GEN-LAST:event_inputjoKeyReleased

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
         int z = jTable7.getSelectedRow();

            TableModel model = (TableModel)jTable7.getModel();
          ((JTextField)jo_date.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 0).toString());
          jo_num.setText(model.getValueAt(z, 1).toString());
          jo_com.setText(model.getValueAt(z, 2).toString());
          jo_bill.setText(model.getValueAt(z, 3).toString());
          jo_unit.setText(model.getValueAt(z, 4).toString());
          
          jodate.setText(model.getValueAt(z, 0).toString());
          jonum.setText(model.getValueAt(z, 1).toString());
          jocomp.setText(model.getValueAt(z, 2).toString());
          jobill.setText(model.getValueAt(z, 3).toString());
          jounit.setText(model.getValueAt(z, 4).toString());
   
          jo_date.setEnabled(true);
          jo_num.setEnabled(true);
          jo_com.setEnabled(true);
          jo_bill.setEnabled(true);
          jo_unit.setEnabled(true);
          
          jo_update.setEnabled(true);
          jo_delete.setEnabled(true);
              
    }//GEN-LAST:event_jTable7MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(true);
            jpreceipt.setVisible(false);
            
            datejo.setText("");
        inputjo.setText("");
        compjo.setText("");
        billjo.setText("");
        unitjo.setText("");
        
        jodate.setText("__________");
        jonum.setText("__________");
        jocomp.setText("_________________");
        jobill.setText("_________________");
        jounit.setText("_________________");
            
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(true);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            
          jo_date.setEnabled(false);
          jo_num.setEnabled(false);
          jo_com.setEnabled(false);
          jo_bill.setEnabled(false);
          jo_unit.setEnabled(false);
          jo_date.setDate(null);
          jo_num.setText("");
          jo_com.setText("");
          jo_bill.setText("");
          jo_unit.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void print_cbPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_print_cbPopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT e_letter FROM info_estab_tbl where e_establishment = '" + (String) print_cb.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("e_letter");
       jTextField2.setText(name);
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        String po = (String) print_cb.getSelectedItem();
        print_estab.setText(po);
        if(print_cb.getSelectedItem().equals(" ")){
        jTextField2.setText("");
        //jTextField3.setText("");
        jTextField2.setEnabled(false);
        //jTextField3.setEnabled(false);
        }
        else{
        jTextField2.setEnabled(true);
       //jTextField3.setEnabled(true);
        }
    }//GEN-LAST:event_print_cbPopupMenuWillBecomeInvisible

    private void jo_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jo_updateActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE job_order_tbl SET  Date_jo=?, JOnum_jo=?, Company_jo=?, Billed_jo=?, Unit_jo=? WHERE JOnum_jo='" + jo_num.getText() + "'");
            pst.setString(1, ((JTextField)jo_date.getDateEditor().getUiComponent()).getText());
            pst.setString(2, jo_num.getText());
            pst.setString(3, jo_com.getText());
            pst.setString(4, jo_bill.getText());
            pst.setString(5, jo_unit.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
            potable();
            pocount ();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, jo_update.getText());//transaction
            pst.setString(5, jo_num.getText());//ponum
            pst.setString(6, default_joborder.getText());//data
            pst.setString(7, jo_com.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
                    jo_date.setEnabled(false);
            jo_num.setEnabled(false);
            jo_com.setEnabled(false);
            jo_bill.setEnabled(false);
            jo_unit.setEnabled(false);
            jo_date.setDate(null);
          jo_num.setText("");
          jo_com.setText("");
          jo_bill.setText("");
          jo_unit.setText("");  
    }//GEN-LAST:event_jo_updateActionPerformed

    private void jo_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jo_deleteActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM job_order_tbl  WHERE JOnum_jo = '" + jo_num.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Transaction Removed");
   
          jo_date.setDate(null);
          jo_num.setText("");
          jo_com.setText("");
          jo_bill.setText("");
          jo_unit.setText("");
          
          potable();
          pocount();
            }else{
                JOptionPane.showMessageDialog(null, "Please Check PO number!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }     
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, jo_delete.getText());//transaction
            pst.setString(5, jo_num.getText());//ponum
            pst.setString(6, default_joborder.getText());//data
            pst.setString(7, jo_com.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }   
    }//GEN-LAST:event_jo_deleteActionPerformed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        try {
            String sql = "SELECT *"
                    + " FROM job_order_tbl WHERE "
                    + "Date_jo like ? or JOnum_jo like ? or Company_jo like ? or Billed_jo like ? or Unit_jo like ? ";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField10.getText() + "%");
            pst.setString(2, "%" + jTextField10.getText() + "%");
            pst.setString(3, "%" + jTextField10.getText() + "%");
            pst.setString(4, "%" + jTextField10.getText() + "%");
            pst.setString(5, "%" + jTextField10.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
            //potable();
          pocount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(true);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Job Order" + txt_date.getText() + txt_time.getText());
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.70,0.70);
                jPanel7.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){ 
            
            try {
            String sql = "Insert into receipt_tbl (r_date, r_number, r_amount, r_description, r_name, r_unit, r_receive) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, ((JTextField)rcp_date.getDateEditor().getUiComponent()).getText());//date
            pst.setString(2, rcp_num.getText());//receipt num
            pst.setString(3, rcp_amt.getText());//amount
            pst.setString(4, rcp_dsc.getText());//description
            pst.setString(5, rcp_rep.getText());//representative
            pst.setString(6, rcp_unt.getText());//unit
            pst.setString(7, rcp_rec.getText());//receive
            
            pst.execute();
            rec_table();
            receiptcount();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            
            try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
        
    try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, default_print.getText());//transaction
            pst.setString(5, num_rcp.getText());//ponum
            pst.setString(6, default_receipt.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }       
    }//GEN-LAST:event_jButton13ActionPerformed

    private void rcp_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rcp_datePropertyChange

        String text = ((JTextField)rcp_date.getDateEditor().getUiComponent()).getText();
        date_rcp.setText(text);
    }//GEN-LAST:event_rcp_datePropertyChange

    private void rcp_numKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_numKeyReleased
        String text1 = rcp_num.getText();
        num_rcp.setText(text1);
    }//GEN-LAST:event_rcp_numKeyReleased

    private void rcp_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_amtKeyReleased
        String text2 = rcp_amt.getText();
        amt_rcp.setText(text2);
    }//GEN-LAST:event_rcp_amtKeyReleased

    private void rcp_dscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_dscKeyReleased
        String text3 = rcp_dsc.getText();
        dsc_rcp.setText(text3);
    }//GEN-LAST:event_rcp_dscKeyReleased

    private void rcp_repKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_repKeyReleased
        String text4 = rcp_rep.getText();
        rep_rcp.setText(text4);
    }//GEN-LAST:event_rcp_repKeyReleased

    private void rcp_untKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_untKeyReleased
        String text4 = rcp_unt.getText();
        unt_rcp.setText(text4);
    }//GEN-LAST:event_rcp_untKeyReleased

    private void rcp_recKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_recKeyReleased
        String text5 = rcp_rec.getText();
        rec_rcp.setText(text5);
    }//GEN-LAST:event_rcp_recKeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        clear_receipt ();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        int z = jTable8.getSelectedRow();

            TableModel model = (TableModel)jTable8.getModel();
        ((JTextField)rcp_date.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 0).toString());    
        rcp_num.setText(model.getValueAt(z, 1).toString());
        rcp_amt.setText(model.getValueAt(z, 2).toString());
        rcp_dsc.setText(model.getValueAt(z, 3).toString());
        rcp_rec.setText(model.getValueAt(z, 4).toString());
        rcp_unt.setText(model.getValueAt(z, 5).toString());
        rcp_rep.setText(model.getValueAt(z, 6).toString());

        rcp_update.setEnabled(true);
        rcp_delete.setEnabled(true);
    }//GEN-LAST:event_jTable8MouseClicked

    private void rcp_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcp_updateActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE receipt_tbl SET  r_date=?, r_number=?, r_amount=?, r_description=?, r_name=?, r_unit=?, r_receive=? WHERE r_number='" + rcp_num.getText() + "'");
            pst.setString(1, ((JTextField)rcp_date.getDateEditor().getUiComponent()).getText());
            pst.setString(2, rcp_num.getText());
            pst.setString(3, rcp_amt.getText());
            pst.setString(4, rcp_dsc.getText());
            pst.setString(5, rcp_rec.getText());
            pst.setString(6, rcp_unt.getText());
            pst.setString(7, rcp_rep.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
            rec_table();
            clear_receipt ();
            rcp_update.setEnabled(false);
            rcp_delete.setEnabled(false);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, rcp_update.getText());//transaction
            pst.setString(5, rcp_num.getText());//ponum
            pst.setString(6, default_receipt.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }//GEN-LAST:event_rcp_updateActionPerformed

    private void rcp_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcp_deleteActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM receipt_tbl  WHERE r_number = '" + rcp_num.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Transaction Removed");
            clear_receipt ();    
            receiptcount();    
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Receipt number!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date dont change
            pst.setString(2, txt_time.getText());//POnum dont change
            pst.setString(3, txt_account.getText());//user dont change
            pst.setString(4, rcp_delete.getText());//transaction
            pst.setString(5, rcp_num.getText());//ponum
            pst.setString(6, default_receipt.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }   
        rec_table();
    }//GEN-LAST:event_rcp_deleteActionPerformed

    private void rcp_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcp_searchKeyReleased
        try {
            String sql = "SELECT *"
                    + " FROM receipt_tbl WHERE "
                    + "r_date like ? or r_number like ? or r_amount like ? or r_description like ? or r_name like ? or r_unit like ? or r_receive like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + rcp_search.getText() + "%");
            pst.setString(2, "%" + rcp_search.getText() + "%");
            pst.setString(3, "%" + rcp_search.getText() + "%");
            pst.setString(4, "%" + rcp_search.getText() + "%");
            pst.setString(5, "%" + rcp_search.getText() + "%");
            pst.setString(6, "%" + rcp_search.getText() + "%");
            pst.setString(7, "%" + rcp_search.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable8.setModel(DbUtils.resultSetToTableModel(rs));
            receiptcount(); 
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_rcp_searchKeyReleased

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(true);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Job Order" + txt_date.getText() + txt_time.getText());
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.PORTRAIT);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.95,0.95);
                jPanel8.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){ 

            try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                String sql = "select * from  estab_tbl where Date_release "
                        + "between '" + (String) sdf.format(jDateChooser2.getDate()) + "' "
                        + "and '" + (String) sdf.format(jDateChooser1.getDate()) + "' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
  JOptionPane.showConfirmDialog(null, e);
            }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void compjoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_compjoKeyReleased
        String po = compjo.getText();
        jocomp.setText(po);
    }//GEN-LAST:event_compjoKeyReleased

    private void billjoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billjoKeyReleased
        String po = billjo.getText();
        jobill.setText(po);
    }//GEN-LAST:event_billjoKeyReleased

    private void unitjoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitjoKeyReleased
        String po = unitjo.getText();
        jounit.setText(po);
    }//GEN-LAST:event_unitjoKeyReleased

    private void datejoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datejoKeyReleased
        String po = datejo.getText();
        jodate.setText(po);
    }//GEN-LAST:event_datejoKeyReleased

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        datejo.setText("");
        inputjo.setText("");
        compjo.setText("");
        billjo.setText("");
        unitjo.setText("");
        jodate.setText("__________");
        jonum.setText("__________");
        jocomp.setText("_________________");
        jobill.setText("_________________");
        jounit.setText("_________________");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String po = ((JTextField)jopdate.getDateEditor().getUiComponent()).getText();
        jodate1.setText(po);
        String po1 = jopnum.getText();
        jonum1.setText(po1);
        String po2 = jopcomp.getText();
        jocomp1.setText(po2); 
        String po3 = jopbill.getText();
        jobill1.setText(po3);
        String po4 = jopunit.getText();
        jounit1.setText(po4);
        jButton17.setEnabled(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
         PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Job Order" + txt_date.getText() + txt_time.getText());
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.70,0.70);
                jpjoborderprint.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){   
            
            try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
        jButton17.setEnabled(false);
        jopdate.setDate(null);
        jopnum.setText("");
        jopcomp.setText("");
        jopbill.setText("");
        jopunit.setText("");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(true);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String po = ((JTextField)prt_date.getDateEditor().getUiComponent()).getText();
        date_rcp1.setText(po);
        String po1 = prt_rct.getText();
        num_rcp1.setText(po1);
        String po2 = prt_amt.getText();
        amt_rcp1.setText(po2); 
        String po3 = prt_dsc.getText();
        dsc_rcp1.setText(po3);
        String po4 = prt_rep.getText();
        rep_rcp1.setText(po4);
        String po5 = prt_unt.getText();
        unt_rcp1.setText(po5);
        String po6 = prt_rec.getText();
        rec_rcp1.setText(po6);
        String po7 = prt_awrd.getText();
        awrd_rcp1.setText(po7);
        jButton21.setEnabled(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
         PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Job Order" + txt_date.getText() + txt_time.getText());
        job.setPrintable(new Printable(){
            
 
  //image = op.filter(image, null);
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.70,0.70);

                jpprintreceipt.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){   
            
            try{
                job.print(); 
            }
            catch (PrinterException ex){}
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        prt_date.setDate(null);
        prt_rct.setText("");
        prt_amt.setText("");
        prt_dsc.setText("");
        prt_rep.setText("");
        prt_unt.setText("");
        prt_rec.setText("");
        prt_awrd.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(true);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        try {
            String sql = "Insert into inv_entry_tbl (date_entry, item_name, description, type, update_date) values (?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, inv_itm.getText());//intem name
            pst.setString(3, inv_dsc.getText());//description
            pst.setString(4, (String) inv_typ.getSelectedItem());//type
            pst.setString(5, txt_date.getText());

            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sqlll = "Insert into stockinout_tbl (date, time, item, qty, remark, acc) values (?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sqlll);
            pst.setString(1, txt_date.getText());//intem name
            pst.setString(2, txt_time.getText());//intem name
            pst.setString(3, inv_itm.getText());//intem name
            pst.setString(4, jTextField14.getText());//intem name
            pst.setString(5, "");//intem name
            pst.setString(6, txt_account.getText());//intem name
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sqlll1 = "Insert into pullout_tbl (Date, Time, Request_by, Item, Qty, Remarks, Approved_by) values (?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sqlll1);
            pst.setString(1, "");//intem name
            pst.setString(2, "");//intem name
            pst.setString(3, "");//intem name
            pst.setString(4, inv_itm.getText());//intem name
            pst.setString(5, jTextField14.getText());//intem name
            pst.setString(6, "");//intem name
            pst.setString(7, "");//intem name
            
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, inv_itm.getText());//ponum
            pst.setString(6, jLabel79.getText());//data
            pst.setString(7, none.getText());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
                    inv_itm.setText("");
            inv_dsc.setText("");
            inv_typ.setSelectedItem("");
            jTextField14.setText("0");
        entry_inventory();//table refresh
        entry_inv();//change to its own counting
        stockin_ref();
        stockout_ref();
        inoutcount2();
        stocinoutcb();
        invreport_ref();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
            int z = jTable9.getSelectedRow();

            TableModel model = (TableModel)jTable9.getModel();
          id_lb.setText(model.getValueAt(z, 0).toString());
          //jTextField5.setText(model.getValueAt(z, 1).toString());
          inv_dsc.setText(model.getValueAt(z, 2).toString());
          inv_itm.setText(model.getValueAt(z, 3).toString());
          inv_typ.setSelectedItem(model.getValueAt(z, 4).toString());
          //txt_date.setText(model.getValueAt(z, 5).toString());
    }//GEN-LAST:event_jTable9MouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE inv_entry_tbl SET  description=?, item_name=?, type=?, update_date=? WHERE entry_id='" + id_lb.getText() + "'");

            pst.setString(1, inv_dsc.getText());
            pst.setString(2, inv_itm.getText());
            pst.setString(3, (String) inv_typ.getSelectedItem());
            pst.setString(4, txt_date.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Updated");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE stockinout_tbl SET  item=? WHERE stock_id='" + id_lb.getText() + "'");

            pst.setString(1, inv_itm.getText());
            pst.execute();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE pullout_tbl SET  Item=? WHERE pullout_id='" + id_lb.getText() + "'");

            pst.setString(1, inv_itm.getText());
            pst.execute();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, jButton23.getText());//transaction
            pst.setString(5, inv_itm.getText());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
        inv_itm.setText("");
            inv_dsc.setText("");
            inv_typ.setSelectedItem("");
            jTextField14.setText("0");
            stockin_ref();
            stockout_ref();
            inoutcount2();
        entry_inventory();//table refresh
        entry_inv();//change to its own counting
        invreport_ref();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        //table_total.setText(Integer.toString(getSum()));
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyReleased
       //table_total.setText(Integer.toString(getSum()));
    }//GEN-LAST:event_jTable6KeyReleased

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM inv_entry_tbl  WHERE entry_id = '" + id_lb.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Inventory Item Removed");
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM pullout_tbl  WHERE pullout_id = '" + id_lb.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Pullout Item Removed");
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM stockinout_tbl  WHERE stock_id = '" + id_lb.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Stock-in Item Removed");
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_delete.getText());//transaction
            pst.setString(5, inv_itm.getText());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }         
        entry_inventory();//table refresh
        entry_inv();//change to its own counting 
        stockin_ref();
        stockout_ref();
        inoutcount2();
        stocinoutcb();
        invreport_ref();
              inoutcount2();  
            inv_itm.setText("");
            inv_dsc.setText("");
            inv_typ.setSelectedItem("");
            jTextField14.setText("0");

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE stockinout_tbl SET date=?, time=?, qty=?, remark=?, acc=? WHERE item='" + stockinitem.getSelectedItem() + "'");
            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//time
            pst.setString(3, total_stock.getText());//stock
            pst.setString(4, stockrem.getText());//remarks
            pst.setString(5, txt_account.getText());//account
           
            pst.executeUpdate();
            stockin_ref();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE pullout_tbl SET Qty=? WHERE Item='" + stockinitem.getSelectedItem() + "'");
            pst.setString(1, total_stock.getText());
           
            pst.executeUpdate();
            stockout_ref();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, (String) stockinitem.getSelectedItem());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        stockinitem.setSelectedItem(" ");
        stock.setText("0");
        stockqty.setText("");
        stockrem.setText("");
        total_stock.setText("");
        invreport_ref();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void stockinitemPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_stockinitemPopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT qty FROM stockinout_tbl where item = '" + (String) stockinitem.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("qty");
       stock.setText(name);
       //jTextField3.setText(name);
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_stockinitemPopupMenuWillBecomeInvisible

    private void stockqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockqtyKeyReleased
        double a, b, c;
        
        a = Double.parseDouble(stock.getText());
        b = Double.parseDouble(stockqty.getText());
        c=a+b;
        total_stock.setText(Double.toString(c));
        
    }//GEN-LAST:event_stockqtyKeyReleased

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        stockinitem.setSelectedItem(" ");
        stock.setText("0");
        stockqty.setText("");
        stockrem.setText("");
        total_stock.setText("");
        
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(true);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try {
            String sqll = "Insert into position_tbl (Position, Rate, Bonus, Description, Date, Account) values (?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sqll);
            pst.setString(1, p_pos.getText());//intem name
            pst.setString(2, p_rat.getText());//intem name
            pst.setString(3, p_bon.getText());//intem name
            pst.setString(4, p_des.getText());//intem name
            pst.setString(5, txt_date.getText());//intem name
            pst.setString(6, txt_account.getText());//intem name
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, p_pos.getText());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        p_pos.setText("");
        p_rat.setText("");
        p_bon.setText("");
        p_des.setText("");
        jButton25.setEnabled(false);
        position_ref();
        positioncb();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE position_tbl SET  Rate=?, Bonus=?, Description=?, Date=?, Account=? WHERE Position='" + p_pos.getText() + "'");

            pst.setString(1, p_rat.getText());
            pst.setString(2, p_bon.getText());
            pst.setString(3, p_des.getText());
            pst.setString(4, txt_date.getText());
            pst.setString(5, txt_account.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Updated");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, jButton23.getText());//transaction
            pst.setString(5, p_pos.getText());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
        p_pos.setEditable(true);
        jButton25.setEnabled(true);
        p_pos.setText("");
        p_rat.setText("");
        p_bon.setText("");
        p_des.setText("");
        position_ref();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM position_tbl  WHERE Position = '" + p_pos.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Transaction Removed");
                
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_delete.getText());//transaction
            pst.setString(5, p_pos.getText());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//data

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        p_pos.setEditable(true);
        jButton25.setEnabled(true);
        p_pos.setText("");
        p_rat.setText("");
        p_bon.setText("");
        p_des.setText("");
        position_ref();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTable13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable13MouseClicked
         int z = jTable13.getSelectedRow();

            TableModel model = (TableModel)jTable13.getModel();
          p_pos.setText(model.getValueAt(z, 1).toString());
          p_rat.setText(model.getValueAt(z, 2).toString());
          p_bon.setText(model.getValueAt(z, 3).toString());
          p_des.setText(model.getValueAt(z, 4).toString());
          
          p_pos.setEditable(false);
          jButton25.setEnabled(false);
    }//GEN-LAST:event_jTable13MouseClicked

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        p_pos.setText("");
        p_rat.setText("");
        p_bon.setText("");
        p_des.setText("");
        p_pos.setEditable(true);
        jButton25.setEnabled(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void position_cbPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_position_cbPopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT Rate FROM Position_tbl where Position = '" + (String) position_cb.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("Rate");
       emp_sal.setText(name);
       tot_sal.setText(name);
       
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_position_cbPopupMenuWillBecomeInvisible

    private void esalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esalKeyReleased
        salary_com();
    }//GEN-LAST:event_esalKeyReleased

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        if(emp_st.getSelectedItem().equals("Employee Status")){ 
        JOptionPane.showMessageDialog(null, "Choose Item Below!");
        }
        else{
        try {
            String sql = "Insert into employee_tbl (ID_Number, Full_Name, Contact, Address, Position, Date_hire, Status, Salary, Allowance, SSS, Philhealth, Pag_ibig, ATMnum) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, emp_id.getText());//Date
            pst.setString(2, emp_fn.getText());//POnum
            pst.setString(3, emp_co.getText());//POnum
            pst.setString(4, emp_ad.getText());//POnum
            pst.setString(5, (String) position_cb.getSelectedItem());//Establishment 
            pst.setString(6, ((JTextField)emp_dh.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(7, (String) emp_st.getSelectedItem());//Establishment
            pst.setString(8, tot_sal.getText());//Release_to
            pst.setString(9, emp_al.getText());//Release_to
            pst.setString(10, emp_ss.getText());//Release_to
            pst.setString(11, emp_ph.getText());//Release_to
            pst.setString(12, emp_pi.getText());//Release_to
            pst.setString(13, emp_at.getText());//Release_to

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, emp_id.getText());//ponum
            pst.setString(6, "");//data
            pst.setString(7, "");//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        emploueeclear();
        employee_ref();
        employeelist();
        activecount ();
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable12MouseClicked
        int z = jTable12.getSelectedRow();

            TableModel model = (TableModel)jTable12.getModel();
          emp_id.setText(model.getValueAt(z, 0).toString());
          emp_fn.setText(model.getValueAt(z, 1).toString());
          emp_co.setText(model.getValueAt(z, 2).toString());
          emp_ad.setText(model.getValueAt(z, 3).toString());
          position_cb.setSelectedItem(model.getValueAt(z, 4).toString());
          ((JTextField)emp_dh.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 5).toString());
          emp_st.setSelectedItem(model.getValueAt(z, 6).toString());  
          tot_sal.setText(model.getValueAt(z, 7).toString());
          emp_sal.setText(model.getValueAt(z, 7).toString());
          emp_al.setText(model.getValueAt(z, 8).toString());
          emp_ss.setText(model.getValueAt(z, 9).toString());
          emp_ph.setText(model.getValueAt(z, 10).toString());
          emp_pi.setText(model.getValueAt(z, 11).toString());
          emp_at.setText(model.getValueAt(z, 12).toString());
          
          emp_id.setEditable(false);
          jButton33.setEnabled(false);
    }//GEN-LAST:event_jTable12MouseClicked

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE employee_tbl SET  Full_Name=?, Contact=?, Address=?, Position=?, Status=?, Salary=?, Allowance=?, SSS=?, Philhealth=?, Pag_ibig=?, ATMnum=?, Date_hire=? WHERE ID_Number='" + emp_id.getText() + "'");

            pst.setString(1, emp_fn.getText());
            pst.setString(2, emp_co.getText());
            pst.setString(3, emp_ad.getText());
            pst.setString(4, (String) position_cb.getSelectedItem());
            pst.setString(5, (String) emp_st.getSelectedItem());
            pst.setString(6, tot_sal.getText());
            pst.setString(7, emp_al.getText());
            pst.setString(8, emp_ss.getText());
            pst.setString(9, emp_ph.getText());
            pst.setString(10, emp_pi.getText());
            pst.setString(11, emp_at.getText());
            pst.setString(12, ((JTextField)emp_dh.getDateEditor().getUiComponent()).getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
           
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_update.getText());//transaction
            pst.setString(5, emp_id.getText());//ponum
            pst.setString(6, "");//data
            pst.setString(7, "");//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
        emploueeclear();
        employee_ref();
        employeelist();
        activecount ();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        emploueeclear();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
                String res = JOptionPane.showInputDialog(this, "State Reason");
                emp_reason.setText(res);

        try {
            String sql = "Insert into inactive_tbl (Date, ID_Number, Full_Name, Contact, Address, Position, Date_hire, Status, Salary, Allowance, SSS, Philhealth, Pag_ibig, ATMnum, Reason) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, emp_id.getText());//Date
            pst.setString(3, emp_fn.getText());//POnum
            pst.setString(4, emp_co.getText());//POnum
            pst.setString(5, emp_ad.getText());//POnum
            pst.setString(6, (String) position_cb.getSelectedItem());//Establishment 
            pst.setString(7, ((JTextField)emp_dh.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(8, (String) emp_st.getSelectedItem());//Establishment
            pst.setString(9, tot_sal.getText());//Release_to
            pst.setString(10, emp_al.getText());//Release_to
            pst.setString(11, emp_ss.getText());//Release_to
            pst.setString(12, emp_ph.getText());//Release_to
            pst.setString(13, emp_pi.getText());//Release_to
            pst.setString(14, emp_at.getText());//Release_to
            pst.setString(15, emp_reason.getText());//Release_to

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

         try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM employee_tbl  WHERE ID_Number = '" + emp_id.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Employee Successfully Inactive!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, "Inactive Employee");//transaction
            pst.setString(5, emp_id.getText());//ponum
            pst.setString(6, "");//data
            pst.setString(7, "");//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 

        emploueeclear();
        inactive_ref();
        employee_ref();
        activecount ();
        inactivecount ();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jTable14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable14MouseClicked
        int z = jTable14.getSelectedRow();

            TableModel model = (TableModel)jTable14.getModel();
          emp_id.setText(model.getValueAt(z, 1).toString());
          emp_fn.setText(model.getValueAt(z, 2).toString());
          emp_co.setText(model.getValueAt(z, 3).toString());
          emp_ad.setText(model.getValueAt(z, 4).toString());
          position_cb.setSelectedItem(model.getValueAt(z, 5).toString());
          ((JTextField)emp_dh.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 6).toString());
          emp_st.setSelectedItem(model.getValueAt(z, 7).toString());  
          tot_sal.setText(model.getValueAt(z, 8).toString());
          emp_sal.setText(model.getValueAt(z, 8).toString());
          emp_al.setText(model.getValueAt(z, 9).toString());
          emp_ss.setText(model.getValueAt(z, 10).toString());
          emp_ph.setText(model.getValueAt(z, 11).toString());
          emp_pi.setText(model.getValueAt(z, 12).toString());
          emp_at.setText(model.getValueAt(z, 13).toString());
    }//GEN-LAST:event_jTable14MouseClicked

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
            try {
            String sql = "Insert into employee_tbl (ID_Number, Full_Name, Contact, Address, Position, Date_hire, Status, Salary, Allowance, SSS, Philhealth, Pag_ibig, ATMnum) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, emp_id.getText());//Date
            pst.setString(2, emp_fn.getText());//POnum
            pst.setString(3, emp_co.getText());//POnum
            pst.setString(4, emp_ad.getText());//POnum
            pst.setString(5, (String) position_cb.getSelectedItem());//Establishment 
            pst.setString(6, ((JTextField)emp_dh.getDateEditor().getUiComponent()).getText());//Date_return
            pst.setString(7, (String) emp_st.getSelectedItem());//Establishment
            pst.setString(8, tot_sal.getText());//Release_to
            pst.setString(9, emp_al.getText());//Release_to
            pst.setString(10, emp_ss.getText());//Release_to
            pst.setString(11, emp_ph.getText());//Release_to
            pst.setString(12, emp_pi.getText());//Release_to
            pst.setString(13, emp_at.getText());//Release_to

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
            try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM inactive_tbl  WHERE ID_Number = '" + emp_id.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Employee Successfully Active!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, "Re-active Employee");//transaction
            pst.setString(5, emp_id.getText());//ponum
            pst.setString(6, "");//data
            pst.setString(7, "");//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        emploueeclear();
        employee_ref();
        inactive_ref();
        inactivecount ();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void pull_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pull_qtyKeyReleased
        double a, b, c;
        
        a = Double.parseDouble(pull_sto.getText());
        b = Double.parseDouble(pull_qty.getText());
        c=a-b;
        pull_tot.setText(Double.toString(c));
    }//GEN-LAST:event_pull_qtyKeyReleased

    private void pull_itmPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_pull_itmPopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT qty FROM pullout_tbl where Item = '" + (String) pull_itm.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("Qty");
       pull_sto.setText(name);
       //jTextField3.setText(name);
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_pull_itmPopupMenuWillBecomeInvisible

    private void PrinteReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrinteReportActionPerformed
        MessageFormat header = new MessageFormat("PBC Inventory Check List");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
        jTable15.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }
        catch (java.awt.print.PrinterException e){
            System.err.format("Connot print %s%n", e.getMessage());
        }
        
//          try{
//            //Map<String,Object>  para= new HashMap<String,Object>();
//
//            String file ="C:\\Users\\cris\\Documents\\NetBeansProjects\\POgenerator3\\src\\Reportprint\\report1.jrxml";
//            //InputStream jasperResource = this.getClass().getClassLoader().getResourceAsStream(...);
//            //  JasperReport report = (JasperReport) JRLoader.loadObject(jasperResource);
//            //JasperReport jr = JasperC ompileManager.compileReport(file);
//            //  String path = getServletContext().getRealPath("/jrxml/employeesList.jrxml");
//              
//                  Class.forName("com.mysql.jdbc.Driver");
//             
//            java.sql.Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/stockinout_tbl","root","");
//            //conn = (Connection) MySqlConnect.ConnectDB();
//            InputStream input = new FileInputStream(new File(file));
//            JasperDesign jasperDesign = JRXmlLoader.load(input);
//            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
            //JasperReport jr = JasperCompileManager.compileReport(this.getClass().getClassLoader().getResourceAsStream(file));
            //HashMap para= new HashMap();
//            DecimalFormat df = new DecimalFormat("P0.00");
//            String tprice = df.format(Double.valueOf(tot_Sum.getText()));
//            //String tqty = df.format(Double.valueOf(tot_Sum.getText()));
//            String cash = df.format(Double.valueOf(s_cash.getText()));
//            String change = df.format(Double.valueOf(s_change.getText()));
//            para.put("tprice", tprice);
//            para.put("tqty", Sqty.getText());
//            para.put("cash", cash);
//            para.put("change", change);
//            para.put("costumer", jTextField2.getText());
//            para.put("cashier",user.getText());
            //JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data());
//            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
//            JasperPrintManager.printReport(jp, true);
//          }catch(SQLException x){JOptionPane.showMessageDialog(null, x);} catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            
//        } catch (JRException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }//GEN-LAST:event_PrinteReportActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE pullout_tbl SET Date=?, Time=?, Request_by=?, Qty=?, Remarks=?, Approved_by=? WHERE Item='" + pull_itm.getSelectedItem() + "'");
            pst.setString(1, txt_date.getText());
            pst.setString(2, txt_time.getText());
            pst.setString(3, (String) pull_emp.getSelectedItem());
            pst.setString(4, pull_tot.getText());
            pst.setString(5, pull_rem.getText());
            pst.setString(6, (String) pull_app.getSelectedItem());
           
            pst.executeUpdate();
            stockout_ref();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE stockinout_tbl SET qty=? WHERE item='" + pull_itm.getSelectedItem() + "'");
            pst.setString(1, pull_tot.getText());//Date
           
            pst.executeUpdate();
            stockin_ref();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into pulloutlog (Date, Time, Employee, Item, Qty, Remarks, Approved) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, (String) pull_emp.getSelectedItem());//ponum
            pst.setString(4, (String) pull_itm.getSelectedItem());//ponum
            pst.setString(5, pull_qty.getText());//data
            pst.setString(6, pull_rem.getText());//estab
            pst.setString(7, (String) pull_app.getSelectedItem());//ponum

            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "Insert into user_trans_tbl (Date_t, Time_t, User_t, Transaction_t, POnum_t, Data_t, Establishment_t) values (?,?,?,?,?,?,?)";

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, txt_date.getText());//Date
            pst.setString(2, txt_time.getText());//POnum
            pst.setString(3, txt_account.getText());//user
            pst.setString(4, input_save.getText());//transaction
            pst.setString(5, (String) pull_itm.getSelectedItem());//ponum
            pst.setString(6, none.getText());//data
            pst.setString(7, none.getText());//estab

            pst.execute();
            usertrans();
            tracount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        invreport_ref();
        pulloutlogref();
        pull_clear ();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        pull_clear ();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void inv_serKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_serKeyReleased
        try {
            String sql = "SELECT entry_id, date_entry, description, item_name, type, update_date"
                    + " FROM inv_entry_tbl WHERE "
                    + "entry_id like ? or date_entry like ? or description like ? or item_name like ? or type like ? or update_date like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + inv_ser.getText() + "%");
            pst.setString(2, "%" + inv_ser.getText() + "%");
            pst.setString(3, "%" + inv_ser.getText() + "%");
            pst.setString(4, "%" + inv_ser.getText() + "%");
            pst.setString(5, "%" + inv_ser.getText() + "%");
            pst.setString(6, "%" + inv_ser.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable9.setModel(DbUtils.resultSetToTableModel(rs));
            entry_inv ();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_inv_serKeyReleased

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        int z = jTable10.getSelectedRow();

            TableModel model = (TableModel)jTable10.getModel();
          stockinitem.setSelectedItem(model.getValueAt(z, 3).toString());
          total_stock.setText(model.getValueAt(z, 4).toString());
          stock.setText(model.getValueAt(z, 4).toString());
          stockrem.setText(model.getValueAt(z, 5).toString());
    }//GEN-LAST:event_jTable10MouseClicked

    private void stock_serKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stock_serKeyReleased
        try {
            String sql = "SELECT stock_id, date, time, item, qty, remark, acc"
                    + " FROM stockinout_tbl WHERE "
                    + "stock_id like ? or date like ? or time like ? or item like ? or qty like ? or remark like ? or acc like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + stock_ser.getText() + "%");
            pst.setString(2, "%" + stock_ser.getText() + "%");
            pst.setString(3, "%" + stock_ser.getText() + "%");
            pst.setString(4, "%" + stock_ser.getText() + "%");
            pst.setString(5, "%" + stock_ser.getText() + "%");
            pst.setString(6, "%" + stock_ser.getText() + "%");
            pst.setString(7, "%" + stock_ser.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable10.setModel(DbUtils.resultSetToTableModel(rs));
            inoutcount ();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_stock_serKeyReleased

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        int z = jTable11.getSelectedRow();

            TableModel model = (TableModel)jTable11.getModel();
          pull_emp.setSelectedItem(model.getValueAt(z, 3).toString());
          pull_itm.setSelectedItem(model.getValueAt(z, 4).toString());
          pull_sto.setText(model.getValueAt(z, 5).toString());
          pull_tot.setText(model.getValueAt(z, 5).toString());
          pull_rem.setText(model.getValueAt(z, 6).toString());
          pull_app.setSelectedItem(model.getValueAt(z, 7).toString());
    }//GEN-LAST:event_jTable11MouseClicked

    private void pull_serKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pull_serKeyReleased
        try {
            String sql = "SELECT pullout_id, Date, Time, Request_by, Item, Qty, Remarks, Approved_by"
                    + " FROM pullout_tbl WHERE "
                    + "pullout_id like ? or Date like ? or Time like ? or Request_by like ? or Item like ? or Qty like ? or Remarks like ? or Approved_by like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + pull_ser.getText() + "%");
            pst.setString(2, "%" + pull_ser.getText() + "%");
            pst.setString(3, "%" + pull_ser.getText() + "%");
            pst.setString(4, "%" + pull_ser.getText() + "%");
            pst.setString(5, "%" + pull_ser.getText() + "%");
            pst.setString(6, "%" + pull_ser.getText() + "%");
            pst.setString(7, "%" + pull_ser.getText() + "%");
            pst.setString(8, "%" + pull_ser.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable11.setModel(DbUtils.resultSetToTableModel(rs));
            inoutcount2();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_pull_serKeyReleased

    private void active_serKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_active_serKeyReleased
        try {
            String sql = "SELECT *"
                    + " FROM employee_tbl WHERE "
                    + "ID_Number like ? or Full_Name like ? or Contact like ? or Address like ? or Position like ? or"
                    + " Date_hire like ? or Status like ? or Salary like ? or Allowance like ? or SSS like ? or"
                    + " Philhealth like ? or Pag_ibig like ? or ATMnum like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + active_ser.getText() + "%");
            pst.setString(2, "%" + active_ser.getText() + "%");
            pst.setString(3, "%" + active_ser.getText() + "%");
            pst.setString(4, "%" + active_ser.getText() + "%");
            pst.setString(5, "%" + active_ser.getText() + "%");
            pst.setString(6, "%" + active_ser.getText() + "%");
            pst.setString(7, "%" + active_ser.getText() + "%");
            pst.setString(8, "%" + active_ser.getText() + "%");
            pst.setString(9, "%" + active_ser.getText() + "%");
            pst.setString(10, "%" + active_ser.getText() + "%");
            pst.setString(11, "%" + active_ser.getText() + "%");
            pst.setString(12, "%" + active_ser.getText() + "%");
            pst.setString(13, "%" + active_ser.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable12.setModel(DbUtils.resultSetToTableModel(rs));
            activecount ();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        
    }//GEN-LAST:event_active_serKeyReleased

    private void inactive_serKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inactive_serKeyReleased
    try {
            String sql = "SELECT *"
                    + " FROM inactive_tbl WHERE "
                    + " Date like ? or ID_Number like ? or Full_Name like ? or Contact like ? or Address like ? or Position like ? or"
                    + " Date_hire like ? or Status like ? or Salary like ? or Allowance like ? or SSS like ? or"
                    + " Philhealth like ? or Pag_ibig like ? or ATMnum like ? or Reason like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + inactive_ser.getText() + "%");
            pst.setString(2, "%" + inactive_ser.getText() + "%");
            pst.setString(3, "%" + inactive_ser.getText() + "%");
            pst.setString(4, "%" + inactive_ser.getText() + "%");
            pst.setString(5, "%" + inactive_ser.getText() + "%");
            pst.setString(6, "%" + inactive_ser.getText() + "%");
            pst.setString(7, "%" + inactive_ser.getText() + "%");
            pst.setString(8, "%" + inactive_ser.getText() + "%");
            pst.setString(9, "%" + inactive_ser.getText() + "%");
            pst.setString(10, "%" + inactive_ser.getText() + "%");
            pst.setString(11, "%" + inactive_ser.getText() + "%");
            pst.setString(12, "%" + inactive_ser.getText() + "%");
            pst.setString(13, "%" + inactive_ser.getText() + "%");
            pst.setString(14, "%" + inactive_ser.getText() + "%");
            pst.setString(15, "%" + inactive_ser.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable14.setModel(DbUtils.resultSetToTableModel(rs));
            inactivecount ();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }    
        
    }//GEN-LAST:event_inactive_serKeyReleased

    private void sal_empPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_sal_empPopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT ID_Number, Position, Salary, Allowance, Date_hire, Status, Contact, ATMnum, SSS, Philhealth, Pag_ibig FROM employee_tbl where Full_Name = '" + (String) sal_emp.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("ID_Number");
        String name1 =rs.getString("Position");
        String name2 =rs.getString("Salary");
        String name3 =rs.getString("Allowance");
        String name4 =rs.getString("Date_hire");
        String name5 =rs.getString("Status");
        String name6 =rs.getString("Contact");
        String name7 =rs.getString("ATMnum");
        String name8 =rs.getString("SSS");
        String name9 =rs.getString("Philhealth");
        String name10 =rs.getString("Pag_ibig");
       sal_id.setText(name);
       sal_pos.setText(name1);
       sal_bs.setText(name2);
       gr_al.setText(name3);
       dh.setText(name4);
       stat.setText(name5);
       con.setText(name6);
       acc.setText(name7);
       sal_sss.setText(name8);
       sal_phth.setText(name9);
       sal_pgib.setText(name10);
       
       double all, total;
       all = Double.parseDouble(gr_al.getText());
       
       total = all/2;
       total = Math.round(total*100)/100.0;
       test6.setText(Double.toString(total));

        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_sal_empPopupMenuWillBecomeInvisible

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(true);
            jpmandatory.setVisible(false);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void ded_rbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ded_rbMouseClicked
        if(ded_rb.isSelected()){
        ded_ab.setEnabled(true);
        ded_ut.setEnabled(true);
        ded_ch.setEnabled(true);
        ded_od.setEnabled(true);
        ot_res.setEnabled(true);
        }
        else{
        ded_ab.setEnabled(false);
        ded_ut.setEnabled(false);
        ded_ch.setEnabled(false);
        ded_od.setEnabled(false);
        ot_res.setEnabled(false);
        ot_res.setText("");
        ded_ab.setText("0");
        ded_ut.setText("0");
        ded_ch.setText("0");
        ded_od.setText("0");
        test7.setText("0");
        test8.setText("0");
        b_ded.setText("0");
        double all, total;
       all = Double.parseDouble(gr_al.getText());
       
       total = all/2;
       total = Math.round(total*100)/100.0;
       test6.setText(Double.toString(total));
        }
        totalgross();
        basicded();
        mandatory();
    }//GEN-LAST:event_ded_rbMouseClicked

    private void mb_rbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mb_rbMouseClicked
        if(mb_rb.isSelected()){
        mb_ss.setEnabled(true);
        mb_ph.setEnabled(true);
        mb_pi.setEnabled(true);
        mb_ot.setEnabled(true);
        mb_ss1.setEnabled(true);
        mb_ph1.setEnabled(true);
        mb_pi1.setEnabled(true);
        }
        else{
        mb_ss.setEnabled(false);
        mb_ph.setEnabled(false);
        mb_pi.setEnabled(false);
        mb_ot.setEnabled(false);
        mb_ss1.setEnabled(false);
        mb_ph1.setEnabled(false);
        mb_pi1.setEnabled(false);
        mb_ss.setText("0");
        mb_ph.setText("0");
        mb_pi.setText("0");
        mb_ot.setText("0");
        mb_ph1.setText("0");
        }
        totalgross();
        basicded();
        mandatory(); 
    }//GEN-LAST:event_mb_rbMouseClicked

    private void gr_drKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_drKeyReleased
        double day, basic, total;
        day = Double.parseDouble(gr_dr.getText());
        basic = Double.parseDouble(sal_bs.getText());;
        
        total=day*basic;

        test1.setText(Double.toString(total));
    }//GEN-LAST:event_gr_drKeyReleased

    private void gr_otKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_otKeyReleased
        double basic, otperhour, otrender, otpay;
        basic = Double.parseDouble(sal_bs.getText());
        otrender = Double.parseDouble(gr_ot.getText());
        
        otperhour=basic/8;
        otpay=otperhour*otrender;
        
        test2.setText(Double.toString(otpay));
    }//GEN-LAST:event_gr_otKeyReleased

    private void gr_lhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_lhKeyReleased
        double basic, days, legal;
        basic = Double.parseDouble(sal_bs.getText());
        days = Double.parseDouble(gr_lh.getText());
        
        legal=basic*days;
        
        test3.setText(Double.toString(legal));
    }//GEN-LAST:event_gr_lhKeyReleased

    private void gr_shKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_shKeyReleased
        double basic, days, special, total;
        basic = Double.parseDouble(sal_bs.getText());
        days = Double.parseDouble(gr_sh.getText());
        
        special=basic*0.30;
        total=special*days;
        
        test4.setText(Double.toString(total)); 
    }//GEN-LAST:event_gr_shKeyReleased

    private void gr_drKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_drKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_gr_drKeyPressed

    private void gr_otKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_otKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_gr_otKeyPressed

    private void gr_adKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_adKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_gr_adKeyPressed

    private void gr_lhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_lhKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_gr_lhKeyPressed

    private void gr_shKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gr_shKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_gr_shKeyPressed

    private void ded_abKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_abKeyReleased
        
        double pday, abs, all, allw, less, total;
        abs = Double.parseDouble(ded_ab.getText());
        all = Double.parseDouble(gr_al.getText());
        if(abs > 0 || abs < 1){
        abs=1;
        }
        allw = all/2;
        pday = allw/13;
        less = pday*abs;
        total =allw-less;
        total = Math.round(total*100)/100.0;
        
        test6.setText(Double.toString(total)); 
    }//GEN-LAST:event_ded_abKeyReleased

    private void ded_utKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_utKeyReleased
        double bpay, ptime, pmin, ut, total;
        bpay = Double.parseDouble(sal_bs.getText());
        ut = Double.parseDouble(ded_ut.getText());
        
        ptime=bpay/8;
        total=ut*ptime;
        total = Math.round(total*100)/100.0;
        
        test7.setText(Double.toString(total));
    }//GEN-LAST:event_ded_utKeyReleased

    private void ded_abKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_abKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_ded_abKeyPressed

    private void ded_utKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_utKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_ded_utKeyPressed

    private void ded_chKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_chKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_ded_chKeyPressed

    private void ded_odKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_odKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_ded_odKeyPressed

    private void mb_ssKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_ssKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_ssKeyPressed

    private void mb_phKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_phKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_phKeyPressed

    private void mb_piKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_piKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_piKeyPressed

    private void mb_otKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_otKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_otKeyPressed

    private void ded_chKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ded_chKeyReleased

        double day, basic, total, total2, total3;
        day = Double.parseDouble(ded_ch.getText());
        basic = Double.parseDouble(sal_bs.getText());;
        
        total = basic/8;
        total2=total/60;
        total3=total2*day;
        total3 = Math.round(total3*100)/100.0;
        test8.setText(Double.toString(total3));
    }//GEN-LAST:event_ded_chKeyReleased

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        if(mb_rb.isSelected()){
            totalgross();
            basicded();
            mandatory();
        ssssave();
        phsave();
        pisave();
        salsave();    
        payroll_ref();
        sss_ref();
        ph_ref();
        pi_ref();
        salclear();
        ssscount ();
        }
        else{
        salsave();
        payroll_ref();
        salclear();
        } 
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        salclear();
    }//GEN-LAST:event_jButton40ActionPerformed

    private void sal_empItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sal_empItemStateChanged
         if(sal_emp.getSelectedItem().equals("--Select Employee List-")){
        gr_dr.setEnabled(false);
        gr_ot.setEnabled(false);
        gr_ad.setEnabled(false);
        gr_lh.setEnabled(false);
        gr_sh.setEnabled(false);
        }
        else {
        gr_dr.setEnabled(true);
        gr_ot.setEnabled(true);
        gr_ad.setEnabled(true);
        gr_lh.setEnabled(true);
        gr_sh.setEnabled(true);
        }
    }//GEN-LAST:event_sal_empItemStateChanged

    private void dtr_namePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_dtr_namePopupMenuWillBecomeInvisible
        try{
        
        String sql="SELECT Full_Name, Salary FROM employee_tbl where Full_Name = '" + (String) dtr_name.getSelectedItem() + "' ";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
        String name =rs.getString("Full_Name");
        String name1 =rs.getString("Salary");

       jLabel221.setText(name);
       jLabel222.setText(name1);

        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_dtr_namePopupMenuWillBecomeInvisible

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        Date date = jDateChooser5.getDate();
        DateFormat format = new SimpleDateFormat("MMMMM, yyyy");
        jLabel223.setText(format.format(date));
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("DTR");
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){//PageSize ps
                pf.setOrientation(PageFormat.PORTRAIT);
                //ps.equals(PageSize.LEGAL.rotate());
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.89,0.89);
                jPanel23.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){ 
        try{
                job.print();  
            }
            catch (PrinterException ex){}
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        if(mb_rb.isSelected()){
            totalgross();
            basicded();
            mandatory();
        ssssave();
        phsave();
        pisave();
        salsave();    
        saltrans();
        payslipprint();
        payroll_ref();
        sss_ref();
        ph_ref();
        pi_ref();
        salclear();
        ssscount ();
        }
        else{
        saltrans();
        payslipprint();
        salsave();
        payroll_ref();
        salclear();
        } 
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jTable17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable17MouseClicked
        int z = jTable17.getSelectedRow();

            TableModel model = (TableModel)jTable17.getModel();

          ps1.setText(model.getValueAt(z, 1).toString());
          ps2.setText(model.getValueAt(z, 2).toString());
          ps3.setText(model.getValueAt(z, 3).toString());
          ps4.setText(model.getValueAt(z, 4).toString());
          ps5.setText(model.getValueAt(z, 5).toString());
          ps6.setText(model.getValueAt(z, 6).toString());
          ps7.setText(model.getValueAt(z, 7).toString());
          ps8.setText(model.getValueAt(z, 8).toString());
          ps9.setText(model.getValueAt(z, 9).toString());
          ps10.setText(model.getValueAt(z, 10).toString());
          ps11.setText(model.getValueAt(z, 11).toString());
          ps12.setText(model.getValueAt(z, 12).toString());
          ps13.setText(model.getValueAt(z, 13).toString());
          ps14.setText(model.getValueAt(z, 14).toString());
          ps15.setText(model.getValueAt(z, 15).toString());
          ps16.setText(model.getValueAt(z, 16).toString());
          ps17.setText(model.getValueAt(z, 17).toString());
          ps18.setText(model.getValueAt(z, 18).toString());
          ps19.setText(model.getValueAt(z, 19).toString());
          ps20.setText(model.getValueAt(z, 20).toString());
          ps21.setText(model.getValueAt(z, 21).toString());
          ps22.setText(model.getValueAt(z, 22).toString());
          ps23.setText(model.getValueAt(z, 23).toString());
          ps24.setText(model.getValueAt(z, 24).toString());
          ps25.setText(model.getValueAt(z, 25).toString());
          ps26.setText(model.getValueAt(z, 26).toString());
          ps27.setText(model.getValueAt(z, 27).toString());
          ps28.setText(model.getValueAt(z, 28).toString());
          ps29.setText(model.getValueAt(z, 29).toString());
          ps30.setText(model.getValueAt(z, 30).toString());

    }//GEN-LAST:event_jTable17MouseClicked

    private void psempPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_psempPopupMenuWillBecomeInvisible
        
        try {
                    String sql = "SELECT *"
                    + " FROM payroll_tbl WHERE "
                    + "Employee like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + psemp.getSelectedItem() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable17.setModel(DbUtils.resultSetToTableModel(rs));
            empcount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_psempPopupMenuWillBecomeInvisible

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        payslipprint();
    }//GEN-LAST:event_jButton46ActionPerformed

    private void psempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psempActionPerformed
        if (psemp.getSelectedItem()==(" ")){
        jButton46.setEnabled(false);
        }
        else {
        jButton46.setEnabled(true);
        }
    }//GEN-LAST:event_psempActionPerformed

    private void pulllogPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_pulllogPopupMenuWillBecomeInvisible
        try {
                    String sql = "SELECT *"
                    + " FROM pulloutlog WHERE "
                    + "Employee like ?";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + pulllog.getSelectedItem() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable18.setModel(DbUtils.resultSetToTableModel(rs));
            empcount();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }//GEN-LAST:event_pulllogPopupMenuWillBecomeInvisible

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        boolean fitWidth = true;
        boolean showPrintDialog = true;
        boolean interactive = true;
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            MessageFormat header = new MessageFormat("PULLOUT REPORT");
            jTable18.print(mode, header, footer,showPrintDialog, set, interactive, null);

        } catch (Exception e) {
        e.printStackTrace();
        }

    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed

        boolean fitWidth = true;
        boolean showPrintDialog = true;
        boolean interactive = true;
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            //set.add(null)
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            MessageFormat header = new MessageFormat("PAYROLL REPORT " + txt_date.getText());
            jTable16.print(mode, header, footer,showPrintDialog, set, interactive, null);

        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jTable16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable16MouseClicked
        int z = jTable16.getSelectedRow();

            TableModel model = (TableModel)jTable16.getModel();
          salaryid.setText(model.getValueAt(z, 0).toString());
          ((JTextField)dfrom.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 1).toString());
          ((JTextField)dto.getDateEditor().getUiComponent()).setText(model.getValueAt(z, 2).toString());
          sal_emp.setSelectedItem(model.getValueAt(z, 3).toString());
          sal_id.setText(model.getValueAt(z, 4).toString());
          sal_pos.setText(model.getValueAt(z, 5).toString());
          sal_bs.setText(model.getValueAt(z, 6).toString());
          gr_dr.setText(model.getValueAt(z, 7).toString());
          test1.setText(model.getValueAt(z, 8).toString());
          gr_ot.setText(model.getValueAt(z, 9).toString());
          test2.setText(model.getValueAt(z, 10).toString());
          gr_al.setText(model.getValueAt(z, 11).toString());
          gr_ad.setText(model.getValueAt(z, 12).toString());
          test3.setText(model.getValueAt(z, 13).toString());
          test4.setText(model.getValueAt(z, 14).toString());
          ded_ut.setText(model.getValueAt(z, 15).toString());
          test7.setText(model.getValueAt(z, 16).toString());
          ded_ch.setText(model.getValueAt(z, 17).toString());
          test8.setText(model.getValueAt(z, 18).toString());
          ded_od.setText(model.getValueAt(z, 19).toString());
          mb_ss.setText(model.getValueAt(z, 20).toString());
          mb_ph.setText(model.getValueAt(z, 21).toString());
          mb_pi.setText(model.getValueAt(z, 22).toString());
          mb_ot.setText(model.getValueAt(z, 23).toString());
          ot_res.setText(model.getValueAt(z, 24).toString());
          tot_gross.setText(model.getValueAt(z, 25).toString());
          netsal.setText(model.getValueAt(z, 26).toString());
    }//GEN-LAST:event_jTable16MouseClicked

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        saltrans();
        payslipprint();
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM payroll_tbl  WHERE Salary_ID = '" + salaryid.getText() + "'");
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Payroll Item Removed");
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Item!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        payroll_ref();
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                String sql = "select * from  payroll_tbl where Date_from "
                        + " between '" + (String) sdf.format(jDateChooser3.getDate()) + "' "
                        + " and '" + (String) sdf.format(jDateChooser4.getDate()) + "' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable16.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
  JOptionPane.showConfirmDialog(null, e);
            }
            //payroll_ref();
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        try {
            String sql = "SELECT *"
                    + " FROM payroll_tbl WHERE "
                    + "Employee like ? or Employee_ID like ? or Position like ? ";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField6.getText() + "%");
            pst.setString(2, "%" + jTextField6.getText() + "%");
            pst.setString(3, "%" + jTextField6.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable16.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        //payroll_ref();
    }//GEN-LAST:event_jTextField6KeyReleased

    private void ot_resKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ot_resKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_ot_resKeyPressed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(true);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(true);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(true);
            jpjoprint.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(true);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(true);
            jpsalary.setVisible(false);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
            jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(true);
    }//GEN-LAST:event_jButton57ActionPerformed

    private void mb_ss1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_ss1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_ss1KeyPressed

    private void mb_ph1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_ph1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_ph1KeyPressed

    private void mb_pi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mb_pi1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F7){
            totalgross();
            basicded();
            mandatory();
        }
    }//GEN-LAST:event_mb_pi1KeyPressed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        jplogin.setVisible(false);    
            jpsignup.setVisible(false);
            jpmenu.setVisible(false);
            jpencode.setVisible(false);
            jplog.setVisible(false);
            jpaccount.setVisible(false);
            jplog.setVisible(false);
            jpprint.setVisible(false);
            jpnewest.setVisible(false);
            jpusertrans.setVisible(false);
            jpjoborder.setVisible(false);
            jpjotable.setVisible(false);
            jpreceipt.setVisible(false);
            jpporeq.setVisible(false);
            jpinventory.setVisible(false);
            jpemployee.setVisible(false);
            jpsalary.setVisible(false);
            jpmandatory.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        salclear();
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                String sql = "select * from  sss_table where date "
                        + " between '" + (String) sdf.format(jDateChooser6.getDate()) + "' "
                        + " and '" + (String) sdf.format(jDateChooser13.getDate()) + "' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable19.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
  JOptionPane.showConfirmDialog(null, e);
            }
            ssscount();
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        try {
            String sql = "SELECT *"
                    + " FROM sss_table WHERE "
                    + " Employee like ? ";

            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField7.getText() + "%");

            rs = (ResultSet) pst.executeQuery();
            jTable19.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        ssscount();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        jTextField11.setText(jComboBox1.getSelectedItem() +" " + sdf.format(jDateChooser12.getDate()));
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jTable19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable19MouseClicked
         int z = jTable19.getSelectedRow();

            TableModel model = (TableModel)jTable19.getModel();
          jLabel312.setText(model.getValueAt(z, 0).toString());
          jTextField11.setText(model.getValueAt(z, 4).toString());
    }//GEN-LAST:event_jTable19MouseClicked

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE sss_table SET  Remarks=? WHERE ID='" + jLabel312.getText() + "'");

            pst.setString(1, jTextField11.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Updated");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        sss_ref();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        int numrow = jTable19.getRowCount();
        int numrow2 = jTable19.getRowCount();
        double tot = 0, tot2 = 0, total;
        for (int i = 0 ; i < numrow ; i ++){
            double val = Double.valueOf(jTable19.getValueAt(i, 5).toString());
            tot += val;
        }
        jTextField12.setText(Double.toString(tot));
        
        for (int ii = 0 ; ii < numrow2 ; ii ++ ){
            double val2 = Double.valueOf(jTable19.getValueAt(ii, 6).toString());
            tot2 += val2;
        }
        jTextField13.setText(Double.toString(tot2));
        
        total = tot + tot2;
        jTextField18.setText(Double.toString(total));
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        MessageFormat header = new MessageFormat("SSS CONTRIBUTION REPORT");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
        jTable19.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }
        catch (java.awt.print.PrinterException e){
            System.err.format("Connot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton58ActionPerformed

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrinteReport;
    private javax.swing.JButton SignIn;
    private javax.swing.JLabel acc;
    private javax.swing.JTextField acc_search;
    private javax.swing.JPasswordField accconfirm;
    private javax.swing.JTextField accfn;
    private javax.swing.JPasswordField accnewpass;
    private javax.swing.JLabel accounttxt;
    private javax.swing.JPasswordField accpass;
    private javax.swing.JButton accsave;
    private javax.swing.JButton accupdate;
    private javax.swing.JTextField accuser;
    private javax.swing.JTextField active_ser;
    private javax.swing.JLabel amt_rcp;
    private javax.swing.JLabel amt_rcp1;
    private javax.swing.JLabel awrd_rcp1;
    private javax.swing.JLabel b_ded;
    private javax.swing.JTextField billjo;
    private javax.swing.JLabel changepass;
    private javax.swing.JTextField compjo;
    private javax.swing.JLabel con;
    private javax.swing.JLabel count;
    private javax.swing.JTextField d_aemp;
    private javax.swing.JTextField d_grss;
    private javax.swing.JTextField d_iaemp;
    private javax.swing.JTextField d_net;
    private javax.swing.JTextField d_salary;
    private javax.swing.JTextField d_temp;
    private javax.swing.JLabel date_rcp;
    private javax.swing.JLabel date_rcp1;
    private javax.swing.JTextField datejo;
    private javax.swing.JTextField ded_ab;
    private javax.swing.JTextField ded_ch;
    private javax.swing.JTextField ded_od;
    private javax.swing.JRadioButton ded_rb;
    private javax.swing.JTextField ded_ut;
    private javax.swing.JLabel default_date;
    private javax.swing.JLabel default_joborder;
    private javax.swing.JLabel default_name;
    private javax.swing.JLabel default_print;
    private javax.swing.JLabel default_receipt;
    private javax.swing.JLabel default_remark;
    private com.toedter.calendar.JDateChooser dfrom;
    private javax.swing.JLabel dh;
    private javax.swing.JLabel dsc_rcp;
    private javax.swing.JLabel dsc_rcp1;
    private com.toedter.calendar.JDateChooser dto;
    private javax.swing.JComboBox dtr_name;
    private javax.swing.JTextField emp_ad;
    private javax.swing.JTextField emp_al;
    private javax.swing.JTextField emp_at;
    private javax.swing.JTextField emp_co;
    private com.toedter.calendar.JDateChooser emp_dh;
    private javax.swing.JTextField emp_fn;
    private javax.swing.JTextField emp_id;
    private javax.swing.JTextField emp_ph;
    private javax.swing.JTextField emp_pi;
    private javax.swing.JLabel emp_reason;
    private javax.swing.JTextField emp_sal;
    private javax.swing.JTextField emp_ss;
    private javax.swing.JComboBox emp_st;
    private javax.swing.JTextField esal;
    private javax.swing.JComboBox filter_est;
    private javax.swing.JTextField gr_ad;
    private javax.swing.JTextField gr_al;
    private javax.swing.JTextField gr_dr;
    private javax.swing.JTextField gr_lh;
    private javax.swing.JTextField gr_ot;
    private javax.swing.JTextField gr_sh;
    private javax.swing.JLabel id_lb;
    private javax.swing.JLabel id_lb1;
    private javax.swing.JTextField inactive_ser;
    private com.toedter.calendar.JDateChooser indret;
    private javax.swing.JTextField inponu;
    private javax.swing.JButton input_delete;
    private javax.swing.JButton input_new;
    private javax.swing.JButton input_save;
    private javax.swing.JButton input_update;
    private javax.swing.JTextField inputjo;
    private com.toedter.calendar.JDateChooser inrel;
    private javax.swing.JTextField inreleaseto;
    private javax.swing.JComboBox inremark;
    private javax.swing.JComboBox instab;
    private javax.swing.JTextField inunit;
    private javax.swing.JLabel inv_count;
    private javax.swing.JTextField inv_dsc;
    private javax.swing.JTextField inv_itm;
    private javax.swing.JTextField inv_ser;
    private javax.swing.JComboBox inv_typ;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private com.toedter.calendar.JDateChooser jDateChooser13;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable16;
    private javax.swing.JTable jTable17;
    private javax.swing.JTable jTable18;
    private javax.swing.JTable jTable19;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable20;
    private javax.swing.JTable jTable21;
    private javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jmdashboard;
    private javax.swing.JTextField jo_bill;
    private javax.swing.JTextField jo_com;
    private com.toedter.calendar.JDateChooser jo_date;
    private javax.swing.JButton jo_delete;
    private javax.swing.JTextField jo_num;
    private javax.swing.JTextField jo_unit;
    private javax.swing.JButton jo_update;
    private javax.swing.JLabel jobill;
    private javax.swing.JLabel jobill1;
    private javax.swing.JLabel jocomp;
    private javax.swing.JLabel jocomp1;
    private javax.swing.JLabel jodate;
    private javax.swing.JLabel jodate1;
    private javax.swing.JLabel jonum;
    private javax.swing.JLabel jonum1;
    private javax.swing.JTextField jopbill;
    private javax.swing.JTextField jopcomp;
    private com.toedter.calendar.JDateChooser jopdate;
    private javax.swing.JTextField jopnum;
    private javax.swing.JTextField jopunit;
    private javax.swing.JLabel jounit;
    private javax.swing.JLabel jounit1;
    private javax.swing.JPanel jpaccount;
    private javax.swing.JPanel jpemployee;
    private javax.swing.JPanel jpencode;
    private javax.swing.JPanel jpinventory;
    private javax.swing.JPanel jpjoborder;
    private javax.swing.JPanel jpjoborderprint;
    private javax.swing.JPanel jpjoprint;
    private javax.swing.JPanel jpjotable;
    private javax.swing.JPanel jplog;
    private javax.swing.JPanel jplogin;
    private javax.swing.JPanel jpmandatory;
    private javax.swing.JPanel jpmenu;
    private javax.swing.JPanel jpnewest;
    private javax.swing.JPanel jpporeq;
    private javax.swing.JPanel jpprint;
    private javax.swing.JPanel jpprintreceipt;
    private javax.swing.JPanel jpreceipt;
    private javax.swing.JPanel jpsalary;
    private javax.swing.JPanel jpsignup;
    private javax.swing.JPanel jpusertrans;
    private javax.swing.JTextField jtf15;
    private javax.swing.JTextField jtf16;
    private javax.swing.JTextField jtf17;
    private javax.swing.JTextField jtf19;
    private javax.swing.JTextField jtf20;
    private javax.swing.JTextField jtf21;
    private javax.swing.JTextField jtf22;
    private javax.swing.JTextField jtf23;
    private javax.swing.JTextField jtf24;
    private javax.swing.JTextField jtf25;
    private javax.swing.JTextField jtf26;
    private javax.swing.JTextField jtf27;
    private javax.swing.JLabel logcount;
    private javax.swing.JLabel loginatt;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField logsearch;
    private javax.swing.JLabel mand_tot;
    private javax.swing.JTextField mb_ot;
    private javax.swing.JTextField mb_ph;
    private javax.swing.JTextField mb_ph1;
    private javax.swing.JTextField mb_pi;
    private javax.swing.JTextField mb_pi1;
    private javax.swing.JRadioButton mb_rb;
    private javax.swing.JTextField mb_ss;
    private javax.swing.JTextField mb_ss1;
    private javax.swing.JLabel netsal;
    private javax.swing.JTextField new_add;
    private javax.swing.JTextField new_con;
    private javax.swing.JLabel new_count;
    private javax.swing.JButton new_delete;
    private javax.swing.JTextField new_desc;
    private javax.swing.JTextField new_est;
    private javax.swing.JTextField new_let;
    private javax.swing.JButton new_new;
    private javax.swing.JButton new_save;
    private javax.swing.JButton new_update;
    private javax.swing.JLabel newestabb;
    private javax.swing.JLabel none;
    private javax.swing.JLabel num_rcp;
    private javax.swing.JLabel num_rcp1;
    private javax.swing.JTextField ot_res;
    private javax.swing.JTextField p_bon;
    private javax.swing.JTextField p_des;
    private javax.swing.JTextField p_pos;
    private javax.swing.JTextField p_rat;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox position_cb;
    private javax.swing.JLabel potrans;
    private javax.swing.JComboBox print_cb;
    private javax.swing.JLabel print_estab;
    private javax.swing.JLabel print_po;
    private javax.swing.JTextField print_unit;
    private javax.swing.JLabel printpoform;
    private javax.swing.JTextField prt_amt;
    private javax.swing.JTextField prt_awrd;
    private com.toedter.calendar.JDateChooser prt_date;
    private javax.swing.JTextField prt_dsc;
    private javax.swing.JTextField prt_rct;
    private javax.swing.JTextField prt_rec;
    private javax.swing.JTextField prt_rep;
    private javax.swing.JTextField prt_unt;
    private javax.swing.JLabel ps1;
    private javax.swing.JLabel ps10;
    private javax.swing.JLabel ps11;
    private javax.swing.JLabel ps12;
    private javax.swing.JLabel ps13;
    private javax.swing.JLabel ps14;
    private javax.swing.JLabel ps15;
    private javax.swing.JLabel ps16;
    private javax.swing.JLabel ps17;
    private javax.swing.JLabel ps18;
    private javax.swing.JLabel ps19;
    private javax.swing.JLabel ps2;
    private javax.swing.JLabel ps20;
    private javax.swing.JLabel ps21;
    private javax.swing.JLabel ps22;
    private javax.swing.JLabel ps23;
    private javax.swing.JLabel ps24;
    private javax.swing.JLabel ps25;
    private javax.swing.JLabel ps26;
    private javax.swing.JLabel ps27;
    private javax.swing.JLabel ps28;
    private javax.swing.JLabel ps29;
    private javax.swing.JLabel ps3;
    private javax.swing.JLabel ps30;
    private javax.swing.JLabel ps31;
    private javax.swing.JLabel ps4;
    private javax.swing.JLabel ps5;
    private javax.swing.JLabel ps6;
    private javax.swing.JLabel ps7;
    private javax.swing.JLabel ps8;
    private javax.swing.JLabel ps9;
    private javax.swing.JComboBox psemp;
    private javax.swing.JComboBox pull_app;
    private javax.swing.JComboBox pull_emp;
    private javax.swing.JComboBox pull_itm;
    private javax.swing.JTextField pull_qty;
    private javax.swing.JTextField pull_rem;
    private javax.swing.JTextField pull_ser;
    private javax.swing.JTextField pull_sto;
    private javax.swing.JLabel pull_tot;
    private javax.swing.JComboBox pulllog;
    private javax.swing.JTextField rcp_amt;
    private javax.swing.JLabel rcp_count;
    private com.toedter.calendar.JDateChooser rcp_date;
    private javax.swing.JButton rcp_delete;
    private javax.swing.JTextField rcp_dsc;
    private javax.swing.JTextField rcp_num;
    private javax.swing.JTextField rcp_rec;
    private javax.swing.JTextField rcp_rep;
    private javax.swing.JTextField rcp_search;
    private javax.swing.JTextField rcp_unt;
    private javax.swing.JButton rcp_update;
    private javax.swing.JLabel rec_rcp;
    private javax.swing.JLabel rec_rcp1;
    private javax.swing.JLabel rep_rcp;
    private javax.swing.JLabel rep_rcp1;
    private javax.swing.JTextField sal_bs;
    private javax.swing.JComboBox sal_emp;
    private javax.swing.JTextField sal_id;
    private javax.swing.JTextField sal_pgib;
    private javax.swing.JTextField sal_phth;
    private javax.swing.JTextField sal_pos;
    private javax.swing.JTextField sal_sss;
    private javax.swing.JLabel salaryid;
    private javax.swing.JTextField signfn;
    private javax.swing.JPasswordField signpass;
    private javax.swing.JPasswordField signrepass;
    private javax.swing.JTextField signuser;
    private javax.swing.JTextField sss_count;
    private javax.swing.JLabel stat;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField stock_ser;
    private javax.swing.JComboBox stockinitem;
    private javax.swing.JTextField stockqty;
    private javax.swing.JTextField stockrem;
    private javax.swing.JTextField table_total;
    private javax.swing.JLabel test1;
    private javax.swing.JLabel test10;
    private javax.swing.JLabel test2;
    private javax.swing.JLabel test3;
    private javax.swing.JLabel test4;
    private javax.swing.JLabel test5;
    private javax.swing.JLabel test6;
    private javax.swing.JLabel test7;
    private javax.swing.JLabel test8;
    private javax.swing.JLabel test9;
    private javax.swing.JLabel tot_gross;
    private javax.swing.JTextField tot_sal;
    private javax.swing.JLabel total_stock;
    private javax.swing.JLabel transcount;
    private javax.swing.JLabel txt_account;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_time;
    private javax.swing.JTextField unitjo;
    private javax.swing.JLabel unt_rcp;
    private javax.swing.JLabel unt_rcp1;
    private javax.swing.JTextField user;
    private javax.swing.JPanel waste;
    private javax.swing.JPanel waste2;
    // End of variables declaration//GEN-END:variables

    private void showUsersInJTable(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Java_Get_Date_From_Jtable_TO_JDateChooser {

        public Java_Get_Date_From_Jtable_TO_JDateChooser() {
        }
    }
    private void seticon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logoprint.png")));
    }
    
}

