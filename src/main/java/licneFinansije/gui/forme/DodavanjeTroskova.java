/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package licneFinansije.gui.forme;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import licneFinansije.KategorijaPrihodi;
import licneFinansije.KategorijaTrosak;
import licneFinansije.Serijalizacija;
import licneFinansije.korisnik.Korisnik;
import licneFinansije.transakcije.Trosak.Trosak;
import licneFinansije.transakcije.prihod.Prihod;

/**
 *
 * @author Strahinja
 */
public class DodavanjeTroskova extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DodavanjeTroskova.class.getName());

     private Korisnik korisnik;
    public DodavanjeTroskova(java.awt.Frame parent, boolean modal, Korisnik k) {
        super(parent, modal);
    initComponents();
    this.korisnik = k;
    setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        unosIznos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBKategorije = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOpis = new javax.swing.JTextArea();
        dugmeDodajTrosak = new javax.swing.JButton();
        dugmeOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DODAVANJE TROŠKOVA:");

        jLabel2.setText("Iznos:");

        jLabel3.setText("Kategorija:");

        CBKategorije.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HRANA I PIĆE", "ZABAVA", "TROŠKOVI ŽIVOTA", "POKLONI", "ŠTEDNJA", "OSTALO" }));

        jLabel4.setText("Opis (max 40 karaktera):");

        textAreaOpis.setColumns(20);
        textAreaOpis.setRows(5);
        jScrollPane1.setViewportView(textAreaOpis);

        dugmeDodajTrosak.setText("Dodaj trošak");
        dugmeDodajTrosak.addActionListener(this::dugmeDodajTrosakActionPerformed);

        dugmeOdustani.setText("Odustani");
        dugmeOdustani.addActionListener(this::dugmeOdustaniActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CBKategorije, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unosIznos, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dugmeDodajTrosak, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(dugmeOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(unosIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dugmeDodajTrosak, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dugmeOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dugmeDodajTrosakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dugmeDodajTrosakActionPerformed
        try{
            double iznos=Double.parseDouble(unosIznos.getText());
            LocalDateTime datum=LocalDateTime.now();
            String stringKategorije=CBKategorije.getSelectedItem().toString();
            stringKategorije=stringKategorije.replaceAll(" ", "_");
            KategorijaTrosak kategorija=KategorijaTrosak.valueOf(stringKategorije);
            String opis=textAreaOpis.getText();
            Trosak p=new Trosak(iznos, datum, opis, kategorija);
            korisnik.dodajTransakciju(p);
            List<Korisnik> lista = new LinkedList<>(Serijalizacija.deserijalizuj());
            lista.removeIf(k -> k.getUserName().equals(korisnik.getUserName()));
            lista.add(korisnik);
            Serijalizacija.serijalizuj(lista);
            int i=JOptionPane.showConfirmDialog(this,"Da li želite da dodate još neki trošak?","Pitanje",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
                    unosIznos.setText(null);
                    textAreaOpis.setText(null);
            }
            else if(i==JOptionPane.NO_OPTION){
                this.dispose();
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dugmeDodajTrosakActionPerformed

    private void dugmeOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dugmeOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_dugmeOdustaniActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBKategorije;
    private javax.swing.JButton dugmeDodajTrosak;
    private javax.swing.JButton dugmeOdustani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaOpis;
    private javax.swing.JTextField unosIznos;
    // End of variables declaration//GEN-END:variables
}
