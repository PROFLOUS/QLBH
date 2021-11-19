
package Gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public class FrmTongQuan extends javax.swing.JPanel {
    public Timer tm;
    public int x = 0;
    public String[] list = {
        "src\\imgVSicon\\clark-street-mercantile-P3pI6xzovu0-unsplash.jpg",
        "src\\imgVSicon\\clark-street-mercantile-ydcMwcfY5E0-unsplash.jpg",
        "src\\imgVSicon\\clark-street-mercantile-S042liZk3A8-unsplash1.jpg"
    };
    public FrmTongQuan() {
        initComponents();
        Slider();
    }
    public void Slider() {
        SetImgSize(2);
        tm = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImgSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }
            }
        });
        pnl_ImgTQ.add(lbl_ImgTQ);
        tm.start();
    }
    public void SetImgSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
       Image newImg = img.getScaledInstance(1090,360 , Image.SCALE_DEFAULT);
        ImageIcon newImc = new ImageIcon(newImg);
        lbl_ImgTQ.setIcon(newImc);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_FormTongQuan = new javax.swing.JPanel();
        pnl_ImgTQ = new javax.swing.JPanel();
        lbl_ImgTQ = new javax.swing.JLabel();
        lbl_text = new javax.swing.JLabel();
        lbl_icon_TQ = new javax.swing.JLabel();
        pnl_profile1 = new javax.swing.JPanel();
        lbl_Img_profile1 = new javax.swing.JLabel();
        lbl_Name_profile1 = new javax.swing.JLabel();
        lbl_Title_profile1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_profile4 = new javax.swing.JPanel();
        lbl_Img_profile4 = new javax.swing.JLabel();
        lbl_Name_profile4 = new javax.swing.JLabel();
        lbl_Title_profile4 = new javax.swing.JLabel();
        pnl_profile5 = new javax.swing.JPanel();
        lbl_Img_profile5 = new javax.swing.JLabel();
        lbl_Name_profile5 = new javax.swing.JLabel();
        lbl_Title_profile5 = new javax.swing.JLabel();

        pnl_FormTongQuan.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormTongQuan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ImgTQ.setForeground(new java.awt.Color(255, 255, 255));

        lbl_text.setFont(new java.awt.Font("Constantia", 0, 120)); // NOI18N
        lbl_text.setForeground(new java.awt.Color(255, 255, 255));
        lbl_text.setText("Welcome");

        lbl_icon_TQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/Component 1.png"))); // NOI18N

        javax.swing.GroupLayout pnl_ImgTQLayout = new javax.swing.GroupLayout(pnl_ImgTQ);
        pnl_ImgTQ.setLayout(pnl_ImgTQLayout);
        pnl_ImgTQLayout.setHorizontalGroup(
            pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ImgTQLayout.createSequentialGroup()
                .addComponent(lbl_ImgTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ImgTQLayout.createSequentialGroup()
                    .addContainerGap(297, Short.MAX_VALUE)
                    .addComponent(lbl_text)
                    .addContainerGap(298, Short.MAX_VALUE)))
            .addGroup(pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ImgTQLayout.createSequentialGroup()
                    .addContainerGap(399, Short.MAX_VALUE)
                    .addComponent(lbl_icon_TQ, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(419, Short.MAX_VALUE)))
        );
        pnl_ImgTQLayout.setVerticalGroup(
            pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_ImgTQ, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ImgTQLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(lbl_text)
                    .addContainerGap(163, Short.MAX_VALUE)))
            .addGroup(pnl_ImgTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ImgTQLayout.createSequentialGroup()
                    .addContainerGap(208, Short.MAX_VALUE)
                    .addComponent(lbl_icon_TQ, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pnl_FormTongQuan.add(pnl_ImgTQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 360));

        pnl_profile1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Img_profile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/user2.jpg"))); // NOI18N

        lbl_Name_profile1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Name_profile1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Name_profile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Name_profile1.setText("Nguyễn Hoàng Anh");

        lbl_Title_profile1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Title_profile1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Title_profile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title_profile1.setText("19444531");

        javax.swing.GroupLayout pnl_profile1Layout = new javax.swing.GroupLayout(pnl_profile1);
        pnl_profile1.setLayout(pnl_profile1Layout);
        pnl_profile1Layout.setHorizontalGroup(
            pnl_profile1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Name_profile1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(lbl_Title_profile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_profile1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_profile1Layout.setVerticalGroup(
            pnl_profile1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profile1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Name_profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Title_profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_FormTongQuan.add(pnl_profile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 180, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("*Phát triển bởi:");
        pnl_FormTongQuan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 100, 30));

        pnl_profile4.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Img_profile4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/user1.jpg"))); // NOI18N

        lbl_Name_profile4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Name_profile4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Name_profile4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Name_profile4.setText("Lê Tấn Đăng");

        lbl_Title_profile4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Title_profile4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Title_profile4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title_profile4.setText("19526881");

        javax.swing.GroupLayout pnl_profile4Layout = new javax.swing.GroupLayout(pnl_profile4);
        pnl_profile4.setLayout(pnl_profile4Layout);
        pnl_profile4Layout.setHorizontalGroup(
            pnl_profile4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Name_profile4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(lbl_Title_profile4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_profile4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pnl_profile4Layout.setVerticalGroup(
            pnl_profile4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profile4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Name_profile4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Title_profile4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_FormTongQuan.add(pnl_profile4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 180, 250));

        pnl_profile5.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Img_profile5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/user3.jpg"))); // NOI18N

        lbl_Name_profile5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Name_profile5.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Name_profile5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Name_profile5.setText("Nguyễn Tiến Đạt");

        lbl_Title_profile5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Title_profile5.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Title_profile5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title_profile5.setText("19531201");

        javax.swing.GroupLayout pnl_profile5Layout = new javax.swing.GroupLayout(pnl_profile5);
        pnl_profile5.setLayout(pnl_profile5Layout);
        pnl_profile5Layout.setHorizontalGroup(
            pnl_profile5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Name_profile5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(lbl_Title_profile5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_profile5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_profile5Layout.setVerticalGroup(
            pnl_profile5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profile5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Img_profile5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Name_profile5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Title_profile5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl_FormTongQuan.add(pnl_profile5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 180, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormTongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormTongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_ImgTQ;
    private javax.swing.JLabel lbl_Img_profile1;
    private javax.swing.JLabel lbl_Img_profile4;
    private javax.swing.JLabel lbl_Img_profile5;
    private javax.swing.JLabel lbl_Name_profile1;
    private javax.swing.JLabel lbl_Name_profile4;
    private javax.swing.JLabel lbl_Name_profile5;
    private javax.swing.JLabel lbl_Title_profile1;
    private javax.swing.JLabel lbl_Title_profile4;
    private javax.swing.JLabel lbl_Title_profile5;
    private javax.swing.JLabel lbl_icon_TQ;
    private javax.swing.JLabel lbl_text;
    private javax.swing.JPanel pnl_FormTongQuan;
    private javax.swing.JPanel pnl_ImgTQ;
    private javax.swing.JPanel pnl_profile1;
    private javax.swing.JPanel pnl_profile4;
    private javax.swing.JPanel pnl_profile5;
    // End of variables declaration//GEN-END:variables
}
