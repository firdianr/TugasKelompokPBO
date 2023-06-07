package KonversiMataUang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import KonversiMataUang.Model;

public class View2 extends JFrame implements ActionListener{
    int asal;
    int tujuan;
    JTextField textField;
    double AUang;
    double HUang;
    JButton button;
    int click;
    JLabel hasil;
    JPanel greyPanel;
    JPanel greyPanel1;
    JPanel whitePanel;
    JComboBox<String> comboBox;
    JComboBox<String> comboBox1;

    View2(){
        // LABEL

        ImageIcon image = new ImageIcon("logo.png");
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        JLabel label = new JLabel();
        label.setText("Pilih Konversi mata Uang");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0, 255, 0));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        label.setBackground(new Color(100,100, 100));
        label.setBorder(border);
        label.setOpaque(true);
        label.setBounds(20, 20, 760, 50); //set ukuran, dan letak Label

        hasil = new JLabel();
        hasil.setText("[ Hasil ]");
        hasil.setHorizontalAlignment(JLabel.CENTER);
        hasil.setVerticalAlignment(JLabel.CENTER);
        hasil.setForeground(new Color(0, 255, 0));
        hasil.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        hasil.setBackground(new Color(150,150, 150));
        hasil.setBorder(border);
        hasil.setOpaque(true);
        hasil.setBounds(420, 220, 300, 50);
        hasil.setVisible(true);

        // PANEl
        greyPanel = new JPanel();
        greyPanel.setBackground(new Color(150, 150, 150));
        greyPanel.setBorder(border);
        greyPanel.setBounds(20, 120, 200, 50);
        greyPanel.setLayout(new FlowLayout());
        greyPanel.setAlignmentX(CENTER_ALIGNMENT);
        greyPanel.setAlignmentY(CENTER_ALIGNMENT);

        greyPanel1 = new JPanel();
        greyPanel1.setBackground(new Color(150, 150, 150));
        greyPanel1.setBorder(border);
        greyPanel1.setBounds(420, 120, 200, 50);
        greyPanel1.setLayout(new FlowLayout());
        greyPanel1.setAlignmentX(CENTER_ALIGNMENT);
        greyPanel1.setAlignmentY(CENTER_ALIGNMENT);

        whitePanel = new JPanel();
        whitePanel.setBackground(new Color(150, 150, 150));
        whitePanel.setBorder(border);
        whitePanel.setBounds(20, 220, 240, 50);
        whitePanel.setLayout(new FlowLayout());
        whitePanel.setAlignmentX(CENTER_ALIGNMENT);
        whitePanel.setAlignmentY(CENTER_ALIGNMENT);

        // OPTION
        String[] option = {"Dolar","Rupiah","Riyal","Ringgit"};

        comboBox = new JComboBox<>(option);
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        comboBox.addActionListener(this);
        comboBox.setForeground(Color.GREEN);
        comboBox.setBackground(Color.GRAY);

        comboBox1 = new JComboBox<>(option);
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        comboBox1.addActionListener(this);
        comboBox1.setForeground(Color.GREEN);
        comboBox1.setBackground(Color.GRAY);

        // TEXT
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 35));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setForeground(Color.GREEN);
        textField.setBackground(Color.GRAY);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("0");

        // BUTTON
        button = new JButton();
        button.setBounds(280, 230, 100, 30);
        button.addActionListener(this);
        button.setText("Convert");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        button.setHorizontalAlignment(JLabel.CENTER);
        button.setVerticalAlignment(JLabel.CENTER);

        button.setEnabled(true);

        // FRAME
        this.setTitle("Konversi Mata Uang"); // set title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keluar aplikasi
        this.setSize(800, 800); // set ukuran windows
        this.setResizable(true);
        this.setVisible(true); // buat terlihat
        this.setLayout(null);

        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(50, 50, 50)); // set Background
        
        this.add(label);
        greyPanel.add(comboBox);
        greyPanel1.add(comboBox1);
        whitePanel.add(textField);
        this.add(greyPanel);
        this.add(greyPanel1);
        this.add(whitePanel);
        this.add(button);
        this.add(hasil);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==comboBox){
            asal = comboBox.getSelectedIndex();
            System.out.println("Asal : " + asal + " " + comboBox.getSelectedItem());
        }
        if(e.getSource()==comboBox1){
            tujuan = comboBox1.getSelectedIndex();
            System.out.println("Tujuan : " + tujuan + " " + comboBox1.getSelectedItem());
        }
        if(e.getSource()==button){
            AUang = this.getTextR();
            System.out.println("Uang : " + AUang);
            Model M = new Model();
            int Asal = this.getIndexAsal();
            int Tujuan = this.getIndexTujuan();

            if (Asal == 0 && Tujuan == 0){
                HUang = AUang;
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 0 && Tujuan == 1){
                HUang = M.USDtoRp(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 0 && Tujuan == 2){
                HUang = M.USDtoRiyal(AUang);
                this.setLabel(HUang, Tujuan); 
            }
            if (Asal == 0 && Tujuan == 3){
                HUang = M.USDtoRinggit(AUang);
                this.setLabel(HUang, Tujuan); 
            }
            if (Asal == 1 && Tujuan == 0){
                HUang = M.RptoUSD(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 1 && Tujuan == 1){
                HUang = AUang;
                this.setLabel(HUang, Tujuan); 
            }
            if (Asal == 1 && Tujuan == 2){
                HUang = M.RptoRiyal(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 1 && Tujuan == 3){
                HUang = M.RptoRinggit(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 0){
                HUang = M.RiyaltoUSD(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 1){
                HUang = M.RiyaltoRp(AUang);
                this.setLabel(HUang, Tujuan); 
            }
            if (Asal == 2 && Tujuan == 2){
                HUang = AUang;
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 3){
                HUang = M.RiyaltoRinggit(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 0){
                HUang = M.RinggittoUSD(AUang);
                this.setLabel(HUang, Tujuan); 
            }
            if (Asal == 3 && Tujuan == 1){
                HUang = M.RinggittoRp(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 2){
                HUang = M.RinggittoRiyal(AUang);
                this.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 3){
                HUang = AUang;
                this.setLabel(HUang, Tujuan);
            }
        }
    }

    int getIndexAsal(){
        return comboBox.getSelectedIndex();
    }

    int getIndexTujuan(){
        return comboBox1.getSelectedIndex();
    }

    double getTextR(){
        return Double.valueOf(textField.getText());
    }

    void setLabel(double Uang, int index){
        if(index == 0){
            hasil.setText(Uang + " US Dollar");
        }
        if(index == 1){
            hasil.setText(Uang + " Rupiah");
        }
        if(index == 2){
            hasil.setText(Uang + " Riyal Saudi");
        }
        if(index == 3){
            hasil.setText(Uang + " Ringgit");
        }
    }
}
