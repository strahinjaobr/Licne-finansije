/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package licneFinansije.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import licneFinansije.KategorijaPrihodi;
import licneFinansije.korisnik.Korisnik;
import licneFinansije.transakcije.Transakcija;
import licneFinansije.transakcije.prihod.Prihod;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Strahinja
 */
public class PrihodiStranica extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrihodiStranica.class.getName());

    private Korisnik korisnik;
  public PrihodiStranica(Korisnik k) {
    initComponents();
      setResizable(false);
    this.korisnik = k;
    setLocationRelativeTo(null);
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
model.setRowCount(0);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
for(Prihod p : korisnik.vratiPrihode().reversed()) {
    model.addRow(new Object[]{
    p.getIznosTransakcije(),
    p.getVremeTransakcije().format(formatter),
    p.getKategorija().toString(),
    p.getOpis()
});
}
labelaUkupanPrihod.setText("Ukupan prihod:"+korisnik.izracunajPrihode(korisnik.vratiPrihode())+" rsd");
    DefaultPieDataset dataset = new DefaultPieDataset();
for(KategorijaPrihodi kat : KategorijaPrihodi.values()) {
    double ukupno = korisnik.vratiPrihode().stream()
        .filter(p -> p.getKategorija() == kat)
        .mapToDouble(p -> p.getIznosTransakcije())
        .sum();
    if(ukupno > 0)
        dataset.setValue(kat.toString(), ukupno);
}
JFreeChart chart = ChartFactory.createPieChart("Prihodi po kategoriji", dataset, true, true, false);
ChartPanel chartPanel = new ChartPanel(chart);
chartPanel.setPreferredSize(panelDijagram.getPreferredSize());
panelDijagram.setLayout(new java.awt.BorderLayout());
panelDijagram.add(chartPanel, java.awt.BorderLayout.CENTER);
panelDijagram.revalidate();
PiePlot plot = (PiePlot) chart.getPlot();
plot.setLabelGenerator(null);
plot.setBackgroundPaint(new java.awt.Color(247, 250, 254));
chart.setBackgroundPaint(new java.awt.Color(247, 250, 254));
chartPanel.setBackground(new java.awt.Color(247, 250, 254));
panelDijagram.setBackground(new java.awt.Color(247, 250, 254));
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        unosDatumOd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        unosDatumDo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        CBKategorije = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelaUkupanPrihod = new javax.swing.JLabel();
        panelDijagram = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(247, 250, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Analizirajte svoje prihode");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iznos", "Datum i vreme", "Kategorija", "Opis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Datum od:");

        unosDatumOd.addActionListener(this::unosDatumOdActionPerformed);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Datum do:");

        jButton1.setText("prikaži");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        CBKategorije.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATA", "POKLONI", "ŠTEDNJA", "STIPENDIJA", "KREDIT", "OSTALO" }));

        jButton2.setText("filtriraj");
        jButton2.setActionCommand("filtriraj za izabranu kategoriju");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Resetuj filtere");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        labelaUkupanPrihod.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        labelaUkupanPrihod.setText("jLabel4");

        javax.swing.GroupLayout panelDijagramLayout = new javax.swing.GroupLayout(panelDijagram);
        panelDijagram.setLayout(panelDijagramLayout);
        panelDijagramLayout.setHorizontalGroup(
            panelDijagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        panelDijagramLayout.setVerticalGroup(
            panelDijagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CBKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unosDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unosDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(labelaUkupanPrihod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(panelDijagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(unosDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(unosDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDijagram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelaUkupanPrihod)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jMenu1.setText("Početna");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Prihodi");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unosDatumOdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unosDatumOdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unosDatumOdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String datumTekst1=unosDatumOd.getText();
         String datumTekst2=unosDatumDo.getText();
        LocalDate datumOd=null;
        LocalDate datumDo=null;
        try {
        datumOd = LocalDate.parse(datumTekst1, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
        datumDo = LocalDate.parse(datumTekst2, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
}           catch(DateTimeParseException e) {
    JOptionPane.showMessageDialog(this, "Datum mora biti u formatu dd.MM.yyyy.","Greska",JOptionPane.ERROR_MESSAGE);
    return;
}
        List<Transakcija>lista=new LinkedList<>(korisnik.filtrirajPrihodeZaVremenskiInterval(datumOd, datumDo));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
model.setRowCount(0);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
for(Transakcija t : lista.reversed()) {
    Prihod p = (Prihod) t;
    model.addRow(new Object[]{
    p.getIznosTransakcije(),
    p.getVremeTransakcije().format(formatter),
    p.getKategorija().toString(),
    p.getOpis()
});
}
labelaUkupanPrihod.setText("Ukupan prihod:"+korisnik.izracunajPrihode(korisnik.filtrirajPrihodeZaVremenskiInterval(datumOd, datumDo))+" rsd");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String stringKategorije=CBKategorije.getSelectedItem().toString();
         KategorijaPrihodi kategorija=KategorijaPrihodi.valueOf(stringKategorije);
         List<Transakcija>lista=new LinkedList<>(korisnik.filtrirajPrihodePoKategoriji(kategorija));
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
model.setRowCount(0);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
for(Transakcija t : lista.reversed()) {
    Prihod p = (Prihod) t;
    model.addRow(new Object[]{
    p.getIznosTransakcije(),
    p.getVremeTransakcije().format(formatter),
    p.getKategorija().toString(),
    p.getOpis()
});}
labelaUkupanPrihod.setText("Ukupan prihod:"+korisnik.izracunajPrihode(korisnik.filtrirajPrihodePoKategoriji(kategorija))+" rsd");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
for(Prihod p : korisnik.vratiPrihode().reversed()) {
    model.addRow(new Object[]{
    p.getIznosTransakcije(),
    p.getVremeTransakcije().format(formatter),
    p.getKategorija().toString(),
    p.getOpis()
});
}
labelaUkupanPrihod.setText("Ukupan prihod:"+korisnik.izracunajPrihode(korisnik.vratiPrihode())+" rsd");
unosDatumDo.setText(null);
unosDatumOd.setText(null);

  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        
    new Home(korisnik).setVisible(true);
    this.dispose();

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new TroskoviStranica(korisnik).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBKategorije;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelaUkupanPrihod;
    private javax.swing.JPanel panelDijagram;
    private javax.swing.JTextField unosDatumDo;
    private javax.swing.JTextField unosDatumOd;
    // End of variables declaration//GEN-END:variables
}
