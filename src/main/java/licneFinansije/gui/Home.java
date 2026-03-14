/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package licneFinansije.gui;

import java.awt.Color;
import java.awt.Component;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import licneFinansije.Serijalizacija;
import licneFinansije.gui.forme.DodavanjePrihodaDijalog;
import licneFinansije.gui.forme.DodavanjeTroskova;
import licneFinansije.gui.forme.IzmenaPrihodaDijalog;
import licneFinansije.gui.forme.IzmenaTransakcijeDijalog;
import licneFinansije.korisnik.Korisnik;
import licneFinansije.transakcije.Transakcija;
import licneFinansije.transakcije.Trosak.Trosak;
import licneFinansije.transakcije.prihod.Prihod;

/**
 *
 * @author Strahinja
 */
public class Home extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());

    


    private Korisnik korisnik;

    public Home(Korisnik k) {
        initComponents();
        
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String tip = (String) table.getValueAt(row, 0);
        if(!isSelected) {
            if("Prihod".equals(tip))
                c.setBackground(new Color(200, 255, 200));
            else
                c.setBackground(new Color(255, 200, 200));
        } else {
            c.setBackground(table.getSelectionBackground());
        }
        return c;
    }
});
        this.korisnik=k;
        setLocationRelativeTo(null);
        labelaIme.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        labelaStanje.setText(korisnik.izracunajBilans(korisnik.getTransakcije())+" rsd");
        dugmePrikaziStanje.setVisible(false);
        labelaZadrzi.setVisible(false);
        osvezi();
        setResizable(false);
        
    }

   public void osvezi(){
    labelaStanje.setText(korisnik.izracunajBilans(korisnik.getTransakcije())+" rsd");
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
    for(Transakcija t : korisnik.getTransakcije().reversed()) {
        String kategorija = "";
        if(t instanceof Trosak)
            kategorija = ((Trosak)t).getKategorija().toString();
        else if(t instanceof Prihod)
            kategorija = ((Prihod)t).getKategorija().toString();
        
        model.addRow(new Object[]{
            t instanceof Prihod ? "Prihod" : "Trosak",
            t.getIznosTransakcije(),
            t.getVremeTransakcije().format(formatter),
            kategorija,
            t.getOpis()
        });
    }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelaIme = new javax.swing.JLabel();
        labelaStanje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBSakrijStanje = new javax.swing.JCheckBox();
        dugmePrikaziStanje = new javax.swing.JButton();
        labelaZadrzi = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        izmeniDugme = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        panelHome.setBackground(new java.awt.Color(247, 250, 254));
        panelHome.setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("vlasnik profila:");

        labelaIme.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        labelaIme.setText("jLabel2");

        labelaStanje.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        labelaStanje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaStanje.setText("IZNOS");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("STANJE");

        CBSakrijStanje.setBackground(new java.awt.Color(247, 250, 254));
        CBSakrijStanje.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        CBSakrijStanje.setText("sakrij iznos");
        CBSakrijStanje.addActionListener(this::CBSakrijStanjeActionPerformed);

        dugmePrikaziStanje.setBackground(new java.awt.Color(123, 173, 227));
        dugmePrikaziStanje.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dugmePrikaziStanje.setForeground(new java.awt.Color(255, 255, 255));
        dugmePrikaziStanje.setText("prikaži");
        dugmePrikaziStanje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dugmePrikaziStanjeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dugmePrikaziStanjeMouseReleased(evt);
            }
        });
        dugmePrikaziStanje.addActionListener(this::dugmePrikaziStanjeActionPerformed);

        labelaZadrzi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        labelaZadrzi.setText("* zadrži za prikaz");

        jButton1.setText("Dodaj prihod");
        jButton1.setPreferredSize(new java.awt.Dimension(124, 23));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Dodaj trošak");
        jButton2.setPreferredSize(new java.awt.Dimension(124, 23));
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "transakcija", "iznos", "datum i vreme", "kategorija", "opis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        izmeniDugme.setText("izmeni transakciju");
        izmeniDugme.addActionListener(this::izmeniDugmeActionPerformed);

        jButton3.setText("Obriši transakciju");
        jButton3.setPreferredSize(new java.awt.Dimension(124, 23));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaStanje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                                .addComponent(dugmePrikaziStanje)
                                .addGap(13, 13, 13)))
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelaZadrzi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBSakrijStanje, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(288, 288, 288))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHomeLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(izmeniDugme)
                                .addGap(67, 67, 67)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelHomeLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelaIme, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelaStanje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBSakrijStanje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dugmePrikaziStanje, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelaZadrzi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izmeniDugme, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelaIme))
                .addGap(77, 77, 77))
        );

        jMenu1.setText("Početna");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Prihodi");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Troškovi");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBSakrijStanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSakrijStanjeActionPerformed
        if(CBSakrijStanje.isSelected()){
        labelaStanje.setText("******");
        dugmePrikaziStanje.setVisible(true);
        labelaZadrzi.setVisible(true);}
        else{
        labelaStanje.setText(korisnik.izracunajBilans(korisnik.getTransakcije())+" rsd");
        dugmePrikaziStanje.setVisible(false);
        labelaZadrzi.setVisible(false);
        }
    }//GEN-LAST:event_CBSakrijStanjeActionPerformed

    private void dugmePrikaziStanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dugmePrikaziStanjeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dugmePrikaziStanjeActionPerformed

    private void dugmePrikaziStanjeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dugmePrikaziStanjeMousePressed
       labelaStanje.setText(korisnik.izracunajBilans(korisnik.getTransakcije())+" rsd");
    }//GEN-LAST:event_dugmePrikaziStanjeMousePressed

    private void dugmePrikaziStanjeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dugmePrikaziStanjeMouseReleased
        labelaStanje.setText("******");
    }//GEN-LAST:event_dugmePrikaziStanjeMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new DodavanjePrihodaDijalog(this, true, korisnik).setVisible(true);
        osvezi();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new DodavanjeTroskova(this, true, korisnik).setVisible(true);
        osvezi();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void izmeniDugmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmeniDugmeActionPerformed
        int selektovanRed = jTable1.getSelectedRow();
        if(selektovanRed == -1) {
        JOptionPane.showMessageDialog(this, "Morate izabrati transakciju!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        return;
}
        Transakcija t = korisnik.getTransakcije().get(selektovanRed);
        if(t instanceof Trosak)
            new IzmenaTransakcijeDijalog(this, true, korisnik, t).setVisible(true);
        else if(t instanceof Prihod)
            new IzmenaPrihodaDijalog(this, true, korisnik, t).setVisible(true);
        osvezi();
        
    }//GEN-LAST:event_izmeniDugmeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selektovanRed = jTable1.getSelectedRow();
        if(selektovanRed == -1) {
    JOptionPane.showMessageDialog(this, "Morate izabrati transakciju!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
    return;
        }
        Transakcija t = korisnik.getTransakcije().get(selektovanRed);
       int i= JOptionPane.showConfirmDialog(panelHome, "Da li ste sigurni da želite da obrišete izabranu transakciju?","Potvrda",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.NO_OPTION)
       {}
       else{
           try{
           List<Korisnik>listaKorisnika=new LinkedList<>(Serijalizacija.deserijalizuj());
           korisnik.obrisiTransakciju(t.getID());
            listaKorisnika.removeIf(k -> k.getUserName().equals(korisnik.getUserName()));
            listaKorisnika.add(korisnik);
           Serijalizacija.serijalizuj(listaKorisnika);
           osvezi();
           }
           catch(Exception e){}
           
       }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       
new PrihodiStranica(korisnik).setVisible(true);
this.dispose();

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new TroskoviStranica(korisnik).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CBSakrijStanje;
    private javax.swing.JButton dugmePrikaziStanje;
    private javax.swing.JButton izmeniDugme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelaIme;
    private javax.swing.JLabel labelaStanje;
    private javax.swing.JLabel labelaZadrzi;
    private javax.swing.JPanel panelHome;
    // End of variables declaration//GEN-END:variables
}
