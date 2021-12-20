/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import entity.NhaCC;
import entity.SanPham;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author RAVEN
 */
public class PanelSearch extends javax.swing.JPanel {

    private EventClick event;

    public void addEventClick(EventClick event) {
        this.event = event;
    }

    public PanelSearch() {
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }

    public void setDataSP(List<SanPham> data) {
        this.removeAll();
        for (SanPham d : data) {
            Search_Item item = new Search_Item(d);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    event.itemClick(d);
                }
            });

            this.add(item, "wrap");
        }
        repaint();
        revalidate();
       
    }
    
    public void setDataKh(List<KhachHang> data) {
        this.removeAll();
        for (KhachHang d : data) {
            Search_KhachHang kh = new Search_KhachHang(d);
            
            //  add event
            kh.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    event.itemClick(d);
                }
            });
            this.add(kh, "wrap");
        }
        repaint();
        revalidate();
    }
    
    public void setDataNcc(List<NhaCC> data) {
        this.removeAll();
        for (NhaCC d : data) {
            Search_NhaCC ncc = new Search_NhaCC(d);
            //  add event
            ncc.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                   
                    event.itemClick(d);
                }
            });

            this.add(ncc, "wrap");
        }
        repaint();
        revalidate();
    }

    public int getItemSize() {
        return getComponentCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
