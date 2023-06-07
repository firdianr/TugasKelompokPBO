package KonversiMataUang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Controller extends JFrame implements ActionListener {
    double AUang;
    double HUang;

    View2 V = new View2();

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==V.button){
            AUang = V.getTextR();
            System.out.println("Uang : " + AUang);
            Model M = new Model();
            int Asal = V.getIndexAsal();
            int Tujuan = V.getIndexTujuan();

            if (Asal == 0 && Tujuan == 0){
                HUang = AUang;
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 0 && Tujuan == 1){
                HUang = M.USDtoRp(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 0 && Tujuan == 2){
                HUang = M.USDtoRiyal(AUang);
                V.setLabel(HUang, Tujuan); 
            }
            if (Asal == 0 && Tujuan == 3){
                HUang = M.USDtoRinggit(AUang);
                V.setLabel(HUang, Tujuan); 
            }
            if (Asal == 1 && Tujuan == 0){
                HUang = M.RptoUSD(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 1 && Tujuan == 1){
                HUang = AUang;
                V.setLabel(HUang, Tujuan); 
            }
            if (Asal == 1 && Tujuan == 2){
                HUang = M.RptoRiyal(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 1 && Tujuan == 3){
                HUang = M.RptoRinggit(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 0){
                HUang = M.RiyaltoUSD(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 1){
                HUang = M.RiyaltoRp(AUang);
                V.setLabel(HUang, Tujuan); 
            }
            if (Asal == 2 && Tujuan == 2){
                HUang = AUang;
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 2 && Tujuan == 3){
                HUang = M.RiyaltoRinggit(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 0){
                HUang = M.RinggittoUSD(AUang);
                V.setLabel(HUang, Tujuan); 
            }
            if (Asal == 3 && Tujuan == 1){
                HUang = M.RinggittoRp(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 2){
                HUang = M.RinggittoRiyal(AUang);
                V.setLabel(HUang, Tujuan);
            }
            if (Asal == 3 && Tujuan == 3){
                HUang = AUang;
                V.setLabel(HUang, Tujuan);
            }
        }
    }

    
}
